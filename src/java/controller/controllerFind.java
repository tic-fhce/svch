/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modeloDAO.certificadoDAO;
import modeloDAO.usuarioDAO;
import modeloTDO.certificadoTDO;
import modeloTDO.findTDO;
import modeloTDO.personaTDO;
import modeloTDO.tipoCertificadoTDO;
import modeloTDO.usuarioTDO;

/**
 *
 * @author ANI
 */
@WebServlet(name = "controllerFind", urlPatterns = {"/controllerFind"})
public class controllerFind extends HttpServlet {
    certificadoDAO daoC= new certificadoDAO();
    usuarioDAO daoU = new usuarioDAO();

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
            String operacion = request.getParameter("find");
                switch (operacion) {
                    case "codex":
                        buscarCodex(request, response);
                        break;
                    case "cat":
                        buscarCat(request, response);
                        break;
                    case "codexfind":
                        buscarCodexfind(request, response);
                        break;
                    
                    default:
                        request.getRequestDispatcher("/error404.jsp").forward(request, response);
                        break;
                }
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
    
    private void buscarCodex(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String codex = request.getParameter("codex");
            findTDO aux=new findTDO(0,"","",0,codex.toUpperCase(),"","","","","","","","");
            daoC.buscarCodex(aux);
            if(aux.getId_certificado()==0){
                aux.setFecha("Certificado no Encontrado");
                aux.setId_tipocertificado("Verifique el numero de certificado");
                aux.setOrganiza("Si no recuerda el numero de certificado Realise la Busqueda por categorias");
            }
            request.setAttribute("pdf", aux);
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        }
    }
    
    private void buscarCodexfind(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String codex = request.getParameter("cout");
            findTDO aux=new findTDO(0,"","",0,codex.toUpperCase(),"","","","","","","","");
            daoC.buscarCodex(aux);
            if(aux.getId_certificado()==0){
                aux.setFecha("Certificado no Encontrado");
                aux.setId_tipocertificado("Verifique el numero de certificado");
                aux.setOrganiza("Si no recuerda el numero de certificado Realise la Busqueda por categorias");
            }
            request.setAttribute("pdf", aux);
            request.getRequestDispatcher("/result.jsp").forward(request, response);
        }
    }
    
    private void buscarCat(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String operacion = request.getParameter("categoria");
            switch (operacion) {
                case "ci":
                    buscarCi(request, response);
                    break;
                case "name":
                    buscarName(request, response);
                    break;
                case "evento":
                    buscarEvento(request, response);
                    break;
                case "fecha":
                    buscarFecha(request, response);
                    break;
            }            
        }
    }
    
    private void buscarCi(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String valor = request.getParameter("valor");
            LinkedList<findTDO> resultado=new LinkedList<findTDO>();            
            daoC.buscarCi(resultado,valor);            
            request.setAttribute("resultado", resultado);
            request.getRequestDispatcher("/resultfind.jsp").forward(request, response);
        }
    }
    private void buscarName(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String valor = request.getParameter("valor");
            LinkedList<findTDO> resultado=new LinkedList<findTDO>();            
            daoC.buscarName(resultado,valor);            
            request.setAttribute("resultado", resultado);
            request.getRequestDispatcher("/resultfind.jsp").forward(request, response);
        }
    }
    private void buscarFecha(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String valor = request.getParameter("valor");
            LinkedList<findTDO> resultado=new LinkedList<findTDO>();            
            daoC.buscarFecha(resultado,valor);            
            request.setAttribute("resultado", resultado);
            request.getRequestDispatcher("/resultfind.jsp").forward(request, response);
        }
    }
    private void buscarEvento(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String valor = request.getParameter("valor");
            LinkedList<findTDO> resultado=new LinkedList<findTDO>();            
            daoC.buscarEvento(resultado,valor);            
            request.setAttribute("resultado", resultado);
            request.getRequestDispatcher("/resultfind.jsp").forward(request, response);
        }
    }
}
