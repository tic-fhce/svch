/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modeloDAO.certificadoDAO;
import modeloDAO.tipoCertificadoDAO;
import modeloTDO.certificadoTDO;
import modeloTDO.tipoCertificadoTDO;
import utils.svchfuction;

/**
 *
 * @author ANI
 */
@WebServlet(name = "controllerCert", urlPatterns = {"/admins/controllerCert"})
@MultipartConfig
public class controllerCert extends HttpServlet {
    svchfuction funtions= new svchfuction();
    certificadoDAO daoC= new certificadoDAO();
    tipoCertificadoDAO daoCT = new tipoCertificadoDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");        
        try (PrintWriter out = response.getWriter()) {
            
            String idpersona=request.getParameter("id");
            String codex=request.getParameter("codex");
            String fecha=request.getParameter("fecha");
            String organiza= request.getParameter("organiza");
            String tipo=request.getParameter("tipo");
            Part apdf =request.getPart("pdf");
            String pdf=idpersona+codex+".pdf";
            String codex_comp=funtions.getMD5(codex);
            String codex_exper=funtions.getMD5(idpersona+tipo+codex);
            String codex_cont=funtions.getMD5(fecha+organiza);
            String hascodex="";            
            for(int i=0;i<32;i+=2)
            {
                hascodex+=codex_comp.subSequence(i, i+2);
                hascodex+=codex_exper.subSequence(i, i+2);
            }
            
            certificadoTDO aux= new certificadoTDO(0,codex.toUpperCase(),fecha,tipo,organiza,pdf,codex_comp,codex_exper,codex_cont,hascodex); 
            daoC.buscarCodex(aux);
            if(aux.getId_certificado()==0)
            {                
                String dir=request.getServletContext().getRealPath("/pdf");
                dir=dir.replace("\\","/");
                System.out.print("Aplicaion ="+dir);
                InputStream pdf_is=apdf.getInputStream();
                File pdf_file= new File(dir+"/"+pdf);
                FileOutputStream pdf_out = new FileOutputStream(pdf_file);
                int dato = pdf_is.read();
                while(dato!=-1)
                {
                    pdf_out.write(dato);
                    dato=pdf_is.read();
                }
                pdf_out.close();
                pdf_is.close();


                if (pdf_file.exists()) {
                    if(daoC.insert(aux, idpersona)){                    
                        request.getRequestDispatcher("/admins/controllerUser?op=perfil&id="+idpersona).forward(request, response);
                    }
                }
                else{
                    System.out.print("eror");
                    LinkedList<tipoCertificadoTDO>lista=daoCT.readAll();                        
                    request.setAttribute("idpersona",idpersona);
                    request.setAttribute("tipocertificado",lista);
                    request.setAttribute("respuesta", "Error al Subir el Archivo");
                    request.getRequestDispatcher("/admins/form_certificado.jsp").forward(request, response);

                }
            }
            else{
                
                LinkedList<tipoCertificadoTDO>lista=daoCT.readAll();
                request.setAttribute("idpersona",idpersona);
                request.setAttribute("tipocertificado",lista);
                request.setAttribute("respuesta", "El Certificado : "+aux.getCodex()+" Se encuentra Registrado en el Sistema");
                request.getRequestDispatcher("/admins/form_certificado.jsp").forward(request, response);
            }
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
