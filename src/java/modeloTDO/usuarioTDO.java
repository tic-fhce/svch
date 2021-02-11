/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloTDO;

/**
 *
 * @author ANI
 */
public class usuarioTDO {
    private int id_usuario;
    private String usser;
    private String password;
    private int id_persona;
    private String pernicion;

    public usuarioTDO(int id_usuario, String usser, String password, int id_persona, String pernicion) {
        this.id_usuario = id_usuario;
        this.usser = usser;
        this.password = password;
        this.id_persona = id_persona;
        this.pernicion = pernicion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsser() {
        return usser;
    }

    public void setUsser(String usser) {
        this.usser = usser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getPernicion() {
        return pernicion;
    }

    public void setPernicion(String pernicion) {
        this.pernicion = pernicion;
    }
    
    
    
}
