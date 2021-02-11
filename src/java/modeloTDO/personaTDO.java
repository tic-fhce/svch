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
public class personaTDO {
    private int Id_persona;
    private String ci;
    private String nombre;
    private String paterno;
    private String materno;
    private String correo;
    private String celular;

    public personaTDO(int Id_persona, String ci,String nombre, String paterno, String materno, String correo, String celular) {
        this.Id_persona = Id_persona;
        this.ci = ci;
        this.nombre=nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.correo = correo;
        this.celular = celular;
    }

    public int getId_persona() {
        return Id_persona;
    }

    public void setId_persona(int Id_persona) {
        this.Id_persona = Id_persona;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    
}
