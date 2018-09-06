/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.post.comment;





import aplicacion.post.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nebuleuse.ORM.Coleccion;
import nebuleuse.ORM.Persistencia;


/**
 *
 * @author hugom_000
 */

public class CommentDAO  {
        
    public Integer total_registros = 0;    
    private Persistencia persistencia = new Persistencia();      
    
        
    
    public CommentDAO ( ) throws IOException  {

    }
       
      
    
    public List<Comment>  list (Integer postId) {
                
        List<Comment>  lista = null;
        
        try {                        
            
            CommentRS rs = new CommentRS();
            
            lista = new Coleccion<Comment>().resultsetToList(
                    new Comment(),
                    rs.list(postId)
            );            
            
        }         
        catch (Exception ex) {            
            
            System.out.println(ex.getMessage());
            throw new Exception(ex);
        }
        finally
        {
            return lista ;          
        }
    }      
      

      
      
        
}
