/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.user;


import nebuleuse.ORM.sql.ReaderSQL;




/**
 * @author hugo
 */


public class UserSQL {
    
    
    public String list ( )
            throws Exception {
    
        String sql = "";                                 
        
        ReaderSQL readerSQL = new ReaderSQL("User");
        readerSQL.fileSQL = "select.sql";
        
        sql = readerSQL.getSQL( );
        
        return sql ;             
    }        
    
    

}




