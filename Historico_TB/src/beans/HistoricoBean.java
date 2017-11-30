/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 *
 * @author user
 */
public class HistoricoBean {
    
    String pais,portal,estadoP,fecha;

    public HistoricoBean() {
    }

    public HistoricoBean(String pais, String portal, String estadoP, String fecha) {
        this.pais = pais;
        this.portal = portal;
        this.estadoP = estadoP;
        this.fecha = fecha;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPortal() {
        return portal;
    }

    public void setPortal(String portal) {
        this.portal = portal;
    }

    public String getEstadoP() {
        return estadoP;
    }

    public void setEstadoP(String estadoP) {
        this.estadoP = estadoP;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    

    
}
