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
public class mesageTDO {
    private int id=0;
    private String mensage;

    public mesageTDO(String mensage) {
        this.mensage = mensage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensage() {
        return mensage;
    }

    public void setMensage(String mensage) {
        this.mensage = mensage;
    }
    
    
}
