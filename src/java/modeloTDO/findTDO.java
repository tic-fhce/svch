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
public class findTDO extends certificadoTDO  {
    private int id_persona;
    private String ci;
    private String nombre;
    
    public findTDO (String codex){
        super(0, codex, "","", "", "", "", "","", "");
        this.id_persona=0;
        this.ci="";
        this.nombre="";
    }
    
    public findTDO (int id_certificado){
        super(id_certificado, "", "","", "", "", "", "","", "");
        this.id_persona=0;
        this.ci="";
        this.nombre="";
    }

    public findTDO(int id_persona, String ci, String nombre, int id_certificado, String codex, String fecha, String id_tipocertificado, String organiza, String pdf, String codex_comp, String codex_exper, String codex_cont, String hascodex) {
        super(id_certificado, codex, fecha, id_tipocertificado, organiza, pdf, codex_comp, codex_exper, codex_cont, hascodex);
        this.id_persona = id_persona;
        this.ci = ci;
        this.nombre = nombre;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
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
}
