/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestion;

import beans.HistoricoBean;
import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Consultas {
    
    String sql;
    List<HistoricoBean> historicos;

    
    public Consultas() {
        
        historicos= new ArrayList<HistoricoBean>();
        
        
    }
    
    
    public void completarHistorico() throws SQLException{
        
        
        Conexion objCon = new Conexion();

        objCon.conectar();
        
         sql = "select idPais as pais,idCategoria as portal,estado as estadoP,date(now()) as fecha\n" +
"  from db_todobusco_prod.mod_aviso_aviso";

         PreparedStatement stm = objCon.getCon().prepareStatement(sql);

        ResultSet rs = stm.executeQuery();
         
         
         while (rs.next()) {
             
           HistoricoBean h= new HistoricoBean();
             
           
           String pais,portal,estadoP,fecha="";
           
           
           int idPais=rs.getInt("pais");
           int idCategoria=rs.getInt("portal");
           int estado= rs.getInt("estadoP");
           fecha= rs.getString("fecha");
           
             if (idPais==1) {
                 pais="Nicaragua";
             }else if (idPais==38) {
                 pais="Costa Rica";
             }else   {
                 pais="No Definido";
             }
             
             if (idCategoria==1) {
                 portal="Casa Busco";
             }else if (idCategoria==2) {
                 portal="Carro Busco";
             }else if (idCategoria>=3 && idCategoria<=25 )  {
                 portal="Venta Busco";
             }else{
                 portal="No Definido";
             }
             
             
                if (estado == 0) {
                estadoP = "Despublicado";
            } else if (estado == 1) {
                estadoP = "Publicado";
            } else if (estado == 2) {
                estadoP = "Caducado";
            } else if (estado == 3) {
                estadoP = "Eliminado";
            } else if (estado == 4) {
                estadoP = "Pendiente de Pago";
            } else if (estado == 5) {
                estadoP = "Moderado";
            } else if (estado == 6) {
                estadoP = "De Baja";
            } else if (estado == 7) {
                estadoP = "Vendido";
            } else if (estado == 8) {
                estadoP = "Pendiente de Publicacion";
            } else {
                estadoP = "No Definido";
            }
             
           
             h.setPais(pais);
             h.setPortal(portal);
             h.setEstadoP(estadoP);
             h.setFecha(fecha);
             
             
             historicos.add(h);
             
          
         }
        
           for (HistoricoBean historico: historicos) {
                 
                 System.out.println(historico.getPais()+";"+historico.getPortal()+
                         ";"+historico.getEstadoP()+";"+ historico.getFecha() );
                 
                 
             }
        
        
        
        
        objCon.desconectar();
        
    }
    
    
    
    
    
    
    
    
    
}
