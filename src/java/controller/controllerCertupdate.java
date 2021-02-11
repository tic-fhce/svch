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
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modeloDAO.certificadoDAO;
import modeloTDO.certificadoTDO;

/**
 *
 * @author ANI
 */
@WebServlet(name = "controllerCertupdate", urlPatterns = {"/admins/controllerCertupdate"})
@MultipartConfig
public class controllerCertupdate extends HttpServlet {

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
            Date a = new Date();
            String b=a.toString();
            b=b.substring(0,12)+" "+a.getYear();
            b=b.replace(" ","");
            
            String id_certificado=request.getParameter("id_certificado");
            String idpersona=request.getParameter("id");
            String codex=request.getParameter("codex");
            Part apdf =request.getPart("pdf");
            
            String pdf=idpersona+codex+"-"+b+".pdf";
            
            String auxpdf=idpersona+codex+".pdf";
                        
            String dir=request.getServletContext().getRealPath("/pdf");
            dir=dir.replace("\\","/");
            
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
            
            certificadoDAO certificado= new certificadoDAO();
            certificado.updateCertificado(pdf, Integer.parseInt(id_certificado));
            certificado.incertUpcertificado(Integer.parseInt(id_certificado), a.toString(), auxpdf);
            
            response.sendRedirect(request.getContextPath() + "/admins/controllerUser?op=perfilcertificado&id="+codex);
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
