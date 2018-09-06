/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.post;


import nebuleuse.ORM.Persistencia;


/**
 *
 * @author hugo
 */
public class PostSQL {
    
    Persistencia persistencia = new Persistencia();
    
    
    public String list ( )
            throws Exception {
    
        String sql = "";                                 
        sql = persistencia.selectSQL(new Post(), "");        
        return sql ;             
    }        
    
    

}




