/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.post.comment;


import aplicacion.post.*;
import aplicacion.user.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import nebuleuse.ORM.Persistencia;
import nebuleuse.ORM.sql.ReaderSQL;




/**
 *
 * @author hugo
 */
public class CommentSQL {
    
    Persistencia persistencia = new Persistencia();
    
    
    public String list ( Integer postid )
            throws Exception {
    
        String sql = "";                         
        
        ReaderSQL readerSQL = new ReaderSQL("Comment");
        readerSQL.fileSQL = "select.sql";
        
        sql = readerSQL.getSQL(postid );        
        
        return sql ;             
    }        
    
    

}




