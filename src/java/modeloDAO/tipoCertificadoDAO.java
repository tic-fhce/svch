/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloCONEXION.Conexion;
import modeloTDO.tipoCertificadoTDO;

/**
 *
 * @author ANI
 */
public class tipoCertificadoDAO {
    private static final Conexion con = Conexion.saberEstado();
    
    public tipoCertificadoDAO(){
        
    }
    
    public boolean insert(tipoCertificadoTDO i){
        boolean res = false;
        String SQL = "INSERT INTO tipocertificado(detalle) VALUES (?);";
        try {
            PreparedStatement ps;
            ps = con.getConexion().prepareStatement(SQL);
            ps.setString(1,i.getDetalle()); 
            if(ps.executeUpdate()>0)
                res = true;
            con.cerrarConexion();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(tipoCertificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(tipoCertificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.cerrarConexion();
            } catch (Exception ex) {
                Logger.getLogger(tipoCertificadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return res;
    }
    public LinkedList<tipoCertificadoTDO> readAll() {
        PreparedStatement ps;
        ResultSet rs;
        LinkedList<tipoCertificadoTDO>lista= new LinkedList<tipoCertificadoTDO>();
        String SQL = "select * from tipocertificado";
        try {
            ps = con.getConexion().prepareStatement(SQL);
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new tipoCertificadoTDO(rs.getInt("id_tipocertificado"),rs.getString("detalle")));
            }
            con.cerrarConexion();
        } catch (Exception ex) {
            Logger lgr = Logger.getLogger(ex.getMessage());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        return lista;
    }
    
}
