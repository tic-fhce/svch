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
public class certificadoTDO {
    private int id_certificado ;
    private String codex;
    private String fecha;
    private String id_tipocertificado;
    private String organiza;
    private String pdf;
    private String codex_comp;
    private String codex_exper;
    private String codex_cont;
    private String hascodex;
    
    public certificadoTDO(int id_certificado){
        this.id_certificado = id_certificado;
        this.codex = "";
        this.fecha = "";
        this.id_tipocertificado = "";
        this.organiza = "";
        this.pdf="";
        this.codex_comp = "";
        this.codex_exper = "";
        this.codex_cont = "";
        this.hascodex = "";
    }

    public certificadoTDO(int id_certificado, String codex, String fecha, String id_tipocertificado, String organiza,String pdf ,String codex_comp, String codex_exper, String codex_cont, String hascodex) {
        this.id_certificado = id_certificado;
        this.codex = codex;
        this.fecha = fecha;
        this.id_tipocertificado = id_tipocertificado;
        this.organiza = organiza;
        this.pdf=pdf;
        this.codex_comp = codex_comp;
        this.codex_exper = codex_exper;
        this.codex_cont = codex_cont;
        this.hascodex = hascodex;
    }

    public int getId_certificado() {
        return id_certificado;
    }

    public void setId_certificado(int id_certificado) {
        this.id_certificado = id_certificado;
    }

    public String getCodex() {
        return codex;
    }

    public void setCodex(String codex) {
        this.codex = codex;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getId_tipocertificado() {
        return id_tipocertificado;
    }

    public void setId_tipocertificado(String id_tipocertificado) {
        this.id_tipocertificado = id_tipocertificado;
    }

    public String getOrganiza() {
        return organiza;
    }

    public void setOrganiza(String organiza) {
        this.organiza = organiza;
    }

    public String getCodex_comp() {
        return codex_comp;
    }

    public void setCodex_comp(String codex_comp) {
        this.codex_comp = codex_comp;
    }

    public String getCodex_exper() {
        return codex_exper;
    }

    public void setCodex_exper(String codex_exper) {
        this.codex_exper = codex_exper;
    }

    public String getCodex_cont() {
        return codex_cont;
    }

    public void setCodex_cont(String codex_cont) {
        this.codex_cont = codex_cont;
    }

    public String getHascodex() {
        return hascodex;
    }

    public void setHascodex(String hascodex) {
        this.hascodex = hascodex;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }
    
}
