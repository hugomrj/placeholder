/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nebuleuse.ORM.sql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author hugo
 */
public class ReaderSQL {
    
    private String sql ="";
    private String path ="";
    private File file ;
    public String fileSQL;
    private String nombreClass = "";
    
        
    public ReaderSQL(){   
    }
    
    public ReaderSQL(String nombre_class){    
        nombreClass = nombre_class;
    }

    
    public String getSQL( Object ...args ) 
            throws FileNotFoundException, IOException {

        
        path =  this.getClass().getResource("/").getPath().replaceAll("classes", "sql/"+nombreClass);                           
        file = new File(path+fileSQL);            
        
        String cadena;
        FileReader f = new FileReader(file);
        BufferedReader b = new BufferedReader(f);
        
        while((cadena = b.readLine())!=null) {              
            sql += cadena;
        }
        b.close();                 
        
        for (int i=0; i < args.length; i++)
        {            
            if (args[i].getClass().getSimpleName().trim().equals("Integer")){
                sql = sql.replaceAll("v"+i, args[i].toString());                        
            }
            
            if (args[i].getClass().getSimpleName().trim().equals("String")){
                sql = sql.replaceAll("v"+i, args[i].toString().trim());                        
            }            
            
        }
        
        return sql;
        
            
    }
        
    
}