/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.post;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import nebuleuse.ORM.postgres.Conexion;
import nebuleuse.ORM.xml.Global;

/**
 *
 * @author hugom_000
 */


public class PostRS  {
        
        Conexion conexion = new Conexion();
        Statement  statement ;
        ResultSet resultset;          
        Integer lineas = Integer.parseInt(new Global().getValue("lineasLista"));
        public Integer total_registros = 0;
        
        
        
    
    public PostRS ( ) throws IOException, SQLException  {
        conexion.conectar();  
        statement = conexion.getConexion().createStatement();              
    }
   
    
    
    public ResultSet  list (  ) throws Exception {

            statement = conexion.getConexion().createStatement();                  
            String sql = new PostSQL().list();            
            resultset = statement.executeQuery(sql);     

            conexion.desconectar();                
            return resultset;     
    }
    
    
}
