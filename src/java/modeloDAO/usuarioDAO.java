/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloCONEXION.Conexion;
import modeloTDO.certificadoTDO;
import modeloTDO.personaTDO;
import modeloTDO.tipoCertificadoTDO;
import modeloTDO.usuarioTDO;
import utils.svchfuction;

/**
 *
 * @author ANI
 */
public class usuarioDAO {
    
    private static final Conexion con = Conexion.saberEstado();
    private static final svchfuction f= new svchfuction();
    
    public usuarioDAO(){
        
    }
    
    public usuarioTDO getUsuario(String usuario,String pass){
        PreparedStatement ps;
        ResultSet rs;
        usuarioTDO aux=null;
        String SQL = "select id_usuario,usser,password,id_persona,pernicion from usuario where usser='"+usuario+"' and password='"+pass+"'";
        try {
            ps = con.getConexion().prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next())
                aux=new usuarioTDO(rs.getInt("id_usuario"),rs.getString("usser"),rs.getString("password"),rs.getInt("id_persona"),rs.getString("pernicion"));
            con.cerrarConexion();
        } catch (Exception ex) {
            Logger lgr = Logger.getLogger(ex.getMessage());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return aux;
    }
    
    public boolean InsertUsuario(personaTDO persona){
        String ci=persona.getCi();
        String nombre=persona.getNombre();
        String paterno=persona.getPaterno();
        String materno=persona.getMaterno();
        String correo=persona.getCorreo();
        String celular=persona.getCelular();
        PreparedStatement ps;
        ResultSet rs;
        usuarioTDO aux;
        String SQL = "insert into persona (ci,nombre,paterno,materno,correo,celular) values ('"+ci+"','"+nombre+"','"+paterno+"','"+materno+"','"+correo+"','"+celular+"')";
        try {
            ps = con.getConexion().prepareStatement(SQL);
            if(ps.executeUpdate()>0){
                con.cerrarConexion();
                
                SQL="select id_persona from persona order by id_persona desc";
                ps = con.getConexion().prepareStatement(SQL);
                rs = ps.executeQuery();
                rs.next();            
                aux=new usuarioTDO(0,correo,f.getMD5(ci),rs.getInt("id_persona"),"1");
                con.cerrarConexion();
                
                SQL = "insert into usuario(usser,password,id_persona,pernicion) values ('"+aux.getUsser()+"','"+aux.getPassword()+"','"+aux.getId_persona()+"','"+aux.getPernicion()+"')";
                ps = con.getConexion().prepareStatement(SQL);
                ps.executeUpdate();
                con.cerrarConexion();
                return true;
            }else{
                con.cerrarConexion();
                return false;
            }
            
        } catch (Exception ex) {
            Logger lgr = Logger.getLogger(ex.getMessage());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;
    }
    
    public boolean InsertPersona(personaTDO persona){
        String ci=persona.getCi();
        String nombre=persona.getNombre();
        String paterno=persona.getPaterno();
        String materno=persona.getMaterno();
        String correo=persona.getCorreo();
        String celular=persona.getCelular();
        PreparedStatement ps;
        String SQL = "insert into persona (ci,nombre,paterno,materno,correo,celular) values ('"+ci+"','"+nombre+"','"+paterno+"','"+materno+"','"+correo+"','"+celular+"')";
        try {
            ps = con.getConexion().prepareStatement(SQL);
            if(ps.executeUpdate()>0){
                con.cerrarConexion();
                return true;
            }else{
                con.cerrarConexion();
                return false;
            }
            
        } catch (Exception ex) {
            Logger lgr = Logger.getLogger(ex.getMessage());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;
    }
    
    public void updatePersona(personaTDO persona){
        int id=persona.getId_persona();
        String ci=persona.getCi();
        String nombre=persona.getNombre();
        String paterno=persona.getPaterno();
        String materno=persona.getMaterno();
        String correo=persona.getCorreo();
        String celular=persona.getCelular();
        PreparedStatement ps;
        String SQL = "update persona set nombre='"+nombre+"',paterno ='"+paterno+"',materno='"+materno+"',correo='"+correo+"', celular='"+celular+"' where id_persona='"+id+"' ";
        try {
            ps = con.getConexion().prepareStatement(SQL);
            ps.executeUpdate();
            con.cerrarConexion();
            
        } catch (Exception ex) {
            Logger lgr = Logger.getLogger(ex.getMessage());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
    
    public boolean InsertTipoCertificado(String nombre){
        
        String SQL = "insert into tipocertificado (detalle) values ('"+nombre+"')";
        PreparedStatement ps;
        try {
            ps = con.getConexion().prepareStatement(SQL);
            if(ps.executeUpdate()>0){
                con.cerrarConexion();
                return true;
            }else{
                con.cerrarConexion();
                return false;
            }
            
        } catch (Exception ex) {
            Logger lgr = Logger.getLogger(ex.getMessage());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return false;
    }
    
    public void existe(personaTDO persona){
        PreparedStatement ps;
        ResultSet rs;
        String SQL = "select * from persona where ci = '"+persona.getCi()+"'";
        try {
            ps = con.getConexion().prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next())
                persona.setId_persona(rs.getInt("id_persona"));
            con.cerrarConexion();
        } catch (Exception ex) {
            Logger lgr = Logger.getLogger(ex.getMessage());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
    public void buscarP(String ci,LinkedList<personaTDO> lista){
        PreparedStatement ps;
        ResultSet rs;
        ci="%"+ci+"%";
        String SQL = "select * from persona where ci ilike '"+ci+"'";
        try {
            ps = con.getConexion().prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next())
                lista.add(new personaTDO(rs.getInt("id_persona"),rs.getString("ci"),rs.getString("nombre"),rs.getString("paterno"),rs.getString("materno"),rs.getString("correo"),rs.getString("celular")));
            con.cerrarConexion();
        } catch (Exception ex) {
            Logger lgr = Logger.getLogger(ex.getMessage());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
    public void getPerfil(personaTDO persona,LinkedList<certificadoTDO> certificado){
        PreparedStatement ps;
        ResultSet rs;    
        String SQL = "select * from persona where id_persona="+persona.getId_persona();
        try {
            ps = con.getConexion().prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                persona.setCi(rs.getString("ci"));
                persona.setNombre(rs.getString("nombre"));
                persona.setPaterno(rs.getString("paterno"));
                persona.setMaterno(rs.getString("materno"));
                persona.setCorreo(rs.getString("correo"));
                persona.setCelular(rs.getString("celular"));
            }
            con.cerrarConexion();
            
            SQL="select * from view_certificado where id_persona="+persona.getId_persona();
            ps = con.getConexion().prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next())
                certificado.add(new certificadoTDO(rs.getInt("id_certificado"),rs.getString("codex"),rs.getString("fecha"), rs.getString("detalle"), rs.getString("organiza"),rs.getString("pdf"),rs.getString("codex_comp"),rs.getString("codex_exper"),rs.getString("codex_cont"),rs.getString("hascodex")));
            con.cerrarConexion();
        } catch (Exception ex) {
            Logger lgr = Logger.getLogger(ex.getMessage());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
    public void getPerfil(personaTDO persona){
        PreparedStatement ps;
        ResultSet rs;    
        String SQL = "select * from persona where id_persona="+persona.getId_persona();
        try {
            ps = con.getConexion().prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                persona.setCi(rs.getString("ci"));
                persona.setNombre(rs.getString("nombre"));
                persona.setPaterno(rs.getString("paterno"));
                persona.setMaterno(rs.getString("materno"));
                persona.setCorreo(rs.getString("correo"));
                persona.setCelular(rs.getString("celular"));
            }
            con.cerrarConexion();
            
        } catch (Exception ex) {
            Logger lgr = Logger.getLogger(ex.getMessage());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
