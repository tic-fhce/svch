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
public class tipoCertificadoTDO {
    private int idtipocertificado;
    private String detalle;

    public tipoCertificadoTDO(int idtipocertificado, String detalle) {
        this.idtipocertificado = idtipocertificado;
        this.detalle = detalle;
    }

    public int getIdtipocertificado() {
        return idtipocertificado;
    }

    public void setIdtipocertificado(int idtipocertificado) {
        this.idtipocertificado = idtipocertificado;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
