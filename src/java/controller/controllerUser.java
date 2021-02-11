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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import modeloDAO.certificadoDAO;
import modeloDAO.tipoCertificadoDAO;
import modeloDAO.usuarioDAO;
import modeloTDO.certificadoTDO;
import modeloTDO.findTDO;
import modeloTDO.mesageTDO;
import modeloTDO.personaTDO;
import modeloTDO.tipoCertificadoTDO;
import modeloTDO.usuarioTDO;
import utils.svchfuction;

/**
 *
 * @author ANI
 */
@WebServlet(name = "controllerUser", urlPatterns = {"/admins/controllerUser"})
public class controllerUser extends HttpServlet {
    usuarioDAO daoU = new usuarioDAO();
    tipoCertificadoDAO daoC = new tipoCertificadoDAO();
    certificadoDAO daoTc=new certificadoDAO();
    
    svchfuction funtions= new svchfuction();

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
            
            if (request.getParameter("op") == null)
                admin(request, response);
            else{
                String operacion = request.getParameter("op");
                switch (operacion) {
                    case "index":
                        request.getRequestDispatcher("/admins/admin.jsp").forward(request, response);
                        break;
                    case "new":
                        request.getRequestDispatcher("/admins/form_usuario.jsp").forward(request, response);
                        //listar(request, response);
                        break;
                    case "ok":
                        request.getRequestDispatcher("/admins/ok.jsp").forward(request, response);
                        //listar(request, response);
                        break;
                    case "error":
                        request.getRequestDispatcher("/admins/error.jsp").forward(request, response);
                        //listar(request, response);
                        break;
                    case "certificado":
                        request.getRequestDispatcher("/admins/usuariofind.jsp").forward(request, response);
                        break;
                    
                    case "createuser":
                        createUser(request,response);
                        //listar(request, response);
                        break;
                    case "newcreateuser":
                        createNewUser(request,response);
                        //listar(request, response);
                        break;
                    
                    case "buscarP":
                        buscarP(request,response);                        
                        break;
                    case "perfil":
                        perfil(request,response);                        
                        break;
                    // UPDATES 
                    case "updateperfil": // redirecciona al formuario de Actualizacion 
                        updatePerfil(request,response);
                        break;
                    case "updatecertificado": // redirecciona la formulario de Actualizacion 
                        updateCertificado(request,response);
                        break;
                    case "updateuser": // realiza la actualizacion
                        updateUser(request,response);
                        break;
                    case "updatecertific": // realiza la actualizacion
                        updateCertific(request,response);
                        break;
                        
                    case "formcertificado":
                        LinkedList<tipoCertificadoTDO>lista=daoC.readAll();                        
                        request.setAttribute("idpersona",request.getParameter("id"));
                        request.setAttribute("tipocertificado",lista);
                        request.setAttribute("respuesta", "nada");
                        request.getRequestDispatcher("/admins/form_certificado.jsp").forward(request, response);                        
                        break;
                        
                    case "perfilcertificado":
                        System.out.print("en perfilcertificado");
                        String codex=request.getParameter("id");
                        findTDO certificado=new findTDO(codex);
                        daoTc.buscarCodex(certificado);
                        request.setAttribute("certificado",certificado);
                        request.getRequestDispatcher("/admins/perfilcertificado.jsp").forward(request, response);                        
                        break;
                        
                        
                    case "createtc":
                        LinkedList<tipoCertificadoTDO>listae=daoC.readAll();                                                
                        request.setAttribute("tipocertificado",listae);                        
                        request.getRequestDispatcher("/admins/form_tc.jsp").forward(request, response);                        
                        break;
                    case "tccreate":
                        tcCreate(request, response);                        
                        break;
                    
                    case "cerrarSesion":
                        cerrarSesion(request,response);
                        break;
                    default:
                        request.getRequestDispatcher("/error404.jsp").forward(request, response);
                        break;
                }
            } 
        }
        catch(ServletException s){
            System.out.print(s.getMessage());
            PrintWriter out; out = response.getWriter();
            response.setContentType("text/html");
            out.println("");
            out.println("");
            out.println("");
            out.println("Inicia Sesion");
            out.println("");
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
    
    private void admin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String usuario = request.getParameter("usuario");
            String pass = request.getParameter("pass");
            String passLog = pass;
            pass = funtions.getMD5(pass);
            usuarioTDO aux = daoU.getUsuario(usuario, pass);
            
            if(aux!=null){
                HttpSession session = request.getSession();
                session.setAttribute("SesionUsuario", aux);
                request.getRequestDispatcher("/admins/admin.jsp").forward(request, response);
            }
            else
            {
                response.sendRedirect(request.getContextPath() + "/admins/errorsecion.jsp");
            }
        }
    }
    
    private void createUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String ci = request.getParameter("ci");
            String nombre = request.getParameter("nombre");
            String paterno= request.getParameter("paterno");
            String materno= request.getParameter("materno");
            String correo= request.getParameter("correo");
            String celular=request.getParameter("celular");
            
            personaTDO persona=new personaTDO(0,ci,nombre,paterno,materno,correo,celular);
            if (daoU.InsertUsuario(persona)) {
                request.getSession().setAttribute("exito", "Se agrego al Usuario correctamente");
                // request.setAttribute("usuario", u);// modificacion reciente
                response.sendRedirect(request.getContextPath() + "/admins/controllerUser?op=ok");
            } else {
                request.getSession().setAttribute("fracaso", "No se pudo registrar al usuario en este momento");
                response.sendRedirect(request.getContextPath() + "/admins/controllerUser?op=error");
            }
        }
    }
    
    private void tcCreate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                        
            String nombre = request.getParameter("nombre");
            if (daoU.InsertTipoCertificado(nombre)) {
                response.sendRedirect(request.getContextPath() + "/admins/controllerUser?op=createtc");
            } else {
                 response.sendRedirect(request.getContextPath() + "/admins/controllerUser?op=error");
            }
        }
    }
    
    private void createNewUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String ci = request.getParameter("ci");
            String nombre = request.getParameter("nombre");
            String paterno= request.getParameter("paterno");
            String materno= request.getParameter("materno");
            String correo= request.getParameter("correo");
            String celular=request.getParameter("celular");
            
            personaTDO persona=new personaTDO(0,ci.toUpperCase(),nombre.toUpperCase(),paterno.toUpperCase(),materno.toUpperCase(),correo,celular);
            daoU.existe(persona);
            if(persona.getId_persona()==0){
                if (daoU.InsertPersona(persona)) {                    
                    LinkedList<personaTDO> listaP= new LinkedList<personaTDO>();
                    daoU.buscarP(ci, listaP);
                    request.setAttribute("lista", listaP);
                    request.getRequestDispatcher("/admins/listaP.jsp").forward(request, response);
                } else {
                    request.getSession().setAttribute("fracaso", "No se pudo Registrar al Usuario en este momento");
                    response.sendRedirect(request.getContextPath() + "/admins/controllerUser?op=error");
                }
            }
            else
            {
                mesageTDO mensage=new mesageTDO("El Numero "+ci+" se encuentra registrado"); 
                mensage.setId(1);
                String m= "El Numero "+ci+" se encuentra registrado";
                request.setAttribute("mensage",m);
                request.getRequestDispatcher("/admins/form_new.jsp").forward(request,response);
            }
            
        }
    }
    
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String id=request.getParameter("id");
            String nombre = request.getParameter("nombre");
            String paterno= request.getParameter("paterno");
            String materno= request.getParameter("materno");
            String correo= request.getParameter("correo");
            String celular=request.getParameter("celular");
            personaTDO persona=new personaTDO(Integer.parseInt(id),"",nombre.toUpperCase(),paterno.toUpperCase(),materno.toUpperCase(),correo,celular);
            daoU.updatePersona(persona);
            response.sendRedirect(request.getContextPath() + "/admins/controllerUser?op=perfil&id="+persona.getId_persona());
            
        }
    }
    
    
    private void buscarP(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String ci = request.getParameter("ci");
            LinkedList<personaTDO> listaP= new LinkedList<personaTDO>();
            daoU.buscarP(ci, listaP);
            request.setAttribute("lista", listaP);
            request.getRequestDispatcher("/admins/listaP.jsp").forward(request, response);
        }
    }
    
    private void perfil(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String id_persona = request.getParameter("id");
            personaTDO persona= new personaTDO(Integer.parseInt(id_persona),"","","","","","");
            LinkedList<certificadoTDO> listaC= new LinkedList<certificadoTDO>();
            daoU.getPerfil(persona, listaC);
            request.setAttribute("persona", persona);
            request.setAttribute("certificados", listaC);            
            //request.getRequestDispatcher("/admins/error.jsp").forward(request, response);
            request.getRequestDispatcher("/admins/perfil.jsp").forward(request, response);
        }
    }
    
    private void updatePerfil(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String id_persona = request.getParameter("id");
            personaTDO persona= new personaTDO(Integer.parseInt(id_persona),"","","","","","");
            daoU.getPerfil(persona);
            request.setAttribute("persona", persona);            
            request.getRequestDispatcher("/admins/form_updateUsuario.jsp").forward(request, response);
        }
    }
    
    private void updateCertificado(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String id_certificado = request.getParameter("id");
            findTDO certificado= new findTDO(Integer.parseInt(id_certificado));
            daoTc.getCertificado(certificado);
            LinkedList<tipoCertificadoTDO>listae=daoC.readAll();                                                
            
            request.setAttribute("tipocertificado",listae);  
            request.setAttribute("certificado", certificado);
            request.getRequestDispatcher("/admins/form_certificadoUpdate.jsp").forward(request, response);
        }
    }
    
    private void updateCertific(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String id_certificado=request.getParameter("id_certificado");
            String idpersona=request.getParameter("id_persona");
            String codex=request.getParameter("codex");
            String fecha=request.getParameter("fecha");
            String organiza= request.getParameter("organiza");
            String tipo=request.getParameter("tipo");
            String codex_comp=funtions.getMD5(codex);
            String codex_exper=funtions.getMD5(idpersona+tipo+codex);
            String codex_cont=funtions.getMD5(fecha+organiza);
            String hascodex="";            
            for(int i=0;i<32;i+=2)
            {
                hascodex+=codex_comp.subSequence(i, i+2);
                hascodex+=codex_exper.subSequence(i, i+2);
            }
            
            certificadoTDO aux= new certificadoTDO(Integer.parseInt(id_certificado),codex.toUpperCase(),fecha,tipo,organiza,"",codex_comp,codex_exper,codex_cont,hascodex);
            daoTc.updateCertificado(aux);            
            response.sendRedirect(request.getContextPath() + "/admins/controllerUser?op=perfilcertificado&id="+aux.getCodex());            
        }
    }
        
    private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession sesion = request.getSession();
            sesion.removeAttribute("SesionUsuario");
            sesion.invalidate();
            response.sendRedirect("/svch");
        } catch (IOException ex) {
            Logger.getLogger(controllerUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
