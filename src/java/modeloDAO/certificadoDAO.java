/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import java.nio.charset.Charset;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloCONEXION.Conexion;
import modeloTDO.certificadoTDO;
import modeloTDO.findTDO;
import modeloTDO.personaTDO;
import modeloTDO.tipoCertificadoTDO;

/**
 *
 * @author ANI
 */
public class certificadoDAO {
    private static final Conexion con = Conexion.saberEstado();
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final Charset ISO = Charset.forName("ISO-8859-1");
     
    public boolean insert(certificadoTDO certificado, String idpersona){
        boolean res = false;
        String SQL = "INSERT INTO certificado(codex,fecha,id_tipocertificado,organiza,pdf,codex_comp,codex_exper,codex_cont,hascodex) VALUES ('"+certificado.getCodex()+"','"+certificado.getFecha()+"','"+certificado.getId_tipocertificado()+"','"+certificado.getOrganiza()+"','"+certificado.getPdf()+"','"+certificado.getCodex_comp()+"','"+certificado.getCodex_exper()+"','"+certificado.getCodex_cont()+"','"+certificado.getHascodex()+"')";
        try {
            PreparedStatement ps;
            ps = con.getConexion().prepareStatement(SQL);
            if(ps.executeUpdate()>0){
                con.cerrarConexion();
                SQL="insert into persona_certificado values ('"+certificado.getCodex()+"','"+idpersona+"')";
                ps = con.getConexion().prepareStatement(SQL);
                ps.executeUpdate();
                res = true;
            }
            con.cerrarConexion();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(certificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(certificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.cerrarConexion();
            } catch (Exception ex) {
                Logger.getLogger(tipoCertificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return res;
    }
    
    public void updateCertificado(certificadoTDO certificado){
        String o=certificado.getOrganiza();
        certificado.setOrganiza(new String(o.getBytes(ISO), UTF_8));        
        String SQL = "update certificado set fecha='"+certificado.getFecha()+"',id_tipocertificado='"+certificado.getId_tipocertificado()+"',organiza='"+certificado.getOrganiza()+"',codex_exper='"+certificado.getCodex_comp()+"',codex_cont='"+certificado.getCodex_cont()+"', hascodex='"+certificado.getHascodex()+"' where id_certificado='"+certificado.getId_certificado()+"'";
        try {
            PreparedStatement ps;
            ps = con.getConexion().prepareStatement(SQL);
            ps.executeUpdate();
            con.cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(certificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(certificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.cerrarConexion();
            } catch (Exception ex) {
                Logger.getLogger(tipoCertificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    
    public void updateCertificado(String pdf, int id_certificado){
        
        String SQL = "update certificado set pdf='"+pdf+"' where id_certificado='"+id_certificado+"'";
        try {
            PreparedStatement ps;
            ps = con.getConexion().prepareStatement(SQL);
            ps.executeUpdate();
            con.cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(certificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(certificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.cerrarConexion();
            } catch (Exception ex) {
                Logger.getLogger(tipoCertificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    
    public void incertUpcertificado(int id_certificado,String fecha,String pdf){
        
        String SQL = "insert into upcertificado values ('"+id_certificado+"','"+fecha+"','"+pdf+"')";
        try {
            PreparedStatement ps;
            ps = con.getConexion().prepareStatement(SQL);
            ps.executeUpdate();
            con.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(certificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(certificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.cerrarConexion();
            } catch (Exception ex) {
                Logger.getLogger(tipoCertificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    
    public void buscarCodex(certificadoTDO certificado){
        PreparedStatement ps;
        ResultSet rs;
        String SQL = "select * from certificado where codex='"+certificado.getCodex()+"'";
        try {
            ps = con.getConexion().prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                certificado.setId_certificado(rs.getInt("id_certificado"));
            }
            con.cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(certificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(certificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.cerrarConexion();
            } catch (Exception ex) {
                Logger.getLogger(tipoCertificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void buscarCodex(findTDO certificado){
        PreparedStatement ps;
        ResultSet rs;
        String SQL = "select * from view_find where codex='"+certificado.getCodex()+"'";
        try {
            ps = con.getConexion().prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){                
                certificado.setId_persona(rs.getInt("id_persona"));                
                certificado.setCi(rs.getString("ci"));
                certificado.setNombre(rs.getString("nombre")+" "+rs.getString("paterno")+" "+rs.getString("materno"));
                certificado.setId_certificado(rs.getInt("id_certificado"));
                certificado.setFecha(rs.getString("fecha"));
                certificado.setId_tipocertificado(rs.getString("detalle"));
                certificado.setOrganiza(rs.getString("organiza"));
                certificado.setPdf(rs.getString("pdf"));
                certificado.setCodex_comp(rs.getString("codex_comp"));
                certificado.setCodex_cont(rs.getString("codex_cont"));
                certificado.setCodex_exper(rs.getString("codex_exper"));
                certificado.setHascodex(rs.getString("hascodex"));
            }
            con.cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(certificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(certificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.cerrarConexion();
            } catch (Exception ex) {
                Logger.getLogger(tipoCertificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void buscarCi(LinkedList<findTDO> resultado,String ci){
        PreparedStatement ps;
        ResultSet rs;
        ci="%"+ci+"%";
        String SQL = "select * from view_find where ci ilike '"+ci+"'";
        try {
            ps = con.getConexion().prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                String nombre=rs.getString("nombre")+" "+rs.getString("paterno")+" "+rs.getString("materno");
                resultado.add(new findTDO(rs.getInt("id_persona"), rs.getString("ci"), nombre.toUpperCase(),rs.getInt("id_certificado"), rs.getString("codex"),rs.getString("fecha"), rs.getString("detalle"), rs.getString("organiza"), rs.getString("pdf"),rs.getString("codex_comp"),rs.getString("codex_exper"),rs.getString("codex_cont"),rs.getString("hascodex")));    
            }
            con.cerrarConexion();            
        } catch (SQLException ex) {
            Logger.getLogger(certificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(certificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.cerrarConexion();
            } catch (Exception ex) {
                Logger.getLogger(tipoCertificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void buscarName(LinkedList<findTDO> resultado,String name){
        PreparedStatement ps;
        ResultSet rs;
        name=name.replace(" ","%");
        name="%"+name+"%";
        String SQL = "select * from view_find where nombre ilike '"+name+"' or paterno ilike '"+name+"' or materno ilike '"+name+"'";
        try {
            ps = con.getConexion().prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                String nombre=rs.getString("nombre")+" "+rs.getString("paterno")+" "+rs.getString("materno");
                resultado.add(new findTDO(rs.getInt("id_persona"), rs.getString("ci"), nombre.toUpperCase(),rs.getInt("id_certificado"), rs.getString("codex"),rs.getString("fecha"), rs.getString("detalle"), rs.getString("organiza"), rs.getString("pdf"),rs.getString("codex_comp"),rs.getString("codex_exper"),rs.getString("codex_cont"),rs.getString("hascodex")));    
            }
            con.cerrarConexion();            
        } catch (SQLException ex) {
            Logger.getLogger(certificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(certificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.cerrarConexion();
            } catch (Exception ex) {
                Logger.getLogger(tipoCertificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void buscarFecha(LinkedList<findTDO> resultado,String fecha){
        PreparedStatement ps;
        ResultSet rs;
        fecha=fecha.replace(" ","%");
        fecha="%"+fecha+"%";
        String SQL = "select * from view_find where fecha ilike '"+fecha+"'";
        try {
            ps = con.getConexion().prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                String nombre=rs.getString("nombre")+" "+rs.getString("paterno")+" "+rs.getString("materno");
                resultado.add(new findTDO(rs.getInt("id_persona"), rs.getString("ci"), nombre.toUpperCase(),rs.getInt("id_certificado"), rs.getString("codex"),rs.getString("fecha"), rs.getString("detalle"), rs.getString("organiza"), rs.getString("pdf"),rs.getString("codex_comp"),rs.getString("codex_exper"),rs.getString("codex_cont"),rs.getString("hascodex")));    
            }
            con.cerrarConexion();            
        } catch (SQLException ex) {
            Logger.getLogger(certificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(certificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.cerrarConexion();
            } catch (Exception ex) {
                Logger.getLogger(tipoCertificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void buscarEvento(LinkedList<findTDO> resultado,String evento){
        PreparedStatement ps;
        ResultSet rs;
        evento=evento.replace(" ","%");
        evento="%"+evento+"%";
        System.out.print(evento);
        String SQL = "select * from view_find where organiza ilike '"+evento+"'";
        try {
            ps = con.getConexion().prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                String nombre=rs.getString("nombre")+" "+rs.getString("paterno")+" "+rs.getString("materno");
                resultado.add(new findTDO(rs.getInt("id_persona"), rs.getString("ci"), nombre.toUpperCase(),rs.getInt("id_certificado"), rs.getString("codex"),rs.getString("fecha"), rs.getString("detalle"), rs.getString("organiza"), rs.getString("pdf"),rs.getString("codex_comp"),rs.getString("codex_exper"),rs.getString("codex_cont"),rs.getString("hascodex")));    
            }
            con.cerrarConexion();            
        } catch (SQLException ex) {
            Logger.getLogger(certificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(certificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.cerrarConexion();
            } catch (Exception ex) {
                Logger.getLogger(tipoCertificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void getCertificado(findTDO certificado){
        PreparedStatement ps;
        ResultSet rs;
        String SQL = "select * from view_find where id_certificado='"+certificado.getId_certificado()+"'";
        try {
            ps = con.getConexion().prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){                
                certificado.setId_persona(rs.getInt("id_persona"));
                certificado.setCi(rs.getString("ci"));
                certificado.setNombre(rs.getString("nombre")+" "+rs.getString("paterno")+" "+rs.getString("materno"));
                certificado.setId_certificado(rs.getInt("id_certificado"));
                certificado.setCodex(rs.getString("codex"));
                certificado.setFecha(rs.getString("fecha"));
                certificado.setId_tipocertificado(rs.getString("detalle"));
                certificado.setOrganiza(rs.getString("organiza"));
                certificado.setPdf(rs.getString("pdf"));
                certificado.setCodex_comp(rs.getString("codex_comp"));
                certificado.setCodex_cont(rs.getString("codex_cont"));
                certificado.setCodex_exper(rs.getString("codex_exper"));
                certificado.setHascodex(rs.getString("hascodex"));
            }
            con.cerrarConexion();
            
        } catch (SQLException ex) {
            Logger.getLogger(certificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(certificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.cerrarConexion();
            } catch (Exception ex) {
                Logger.getLogger(tipoCertificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
