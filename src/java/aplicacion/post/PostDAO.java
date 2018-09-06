/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.post;





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

public class PostDAO  {
        
    public Integer total_registros = 0;    
    private Persistencia persistencia = new Persistencia();      
    
        
    
    public PostDAO ( ) throws IOException  {

    }
       
      
    
    public List<Post>  list () {
                
        List<Post>  lista = null;
        
        try {                        
            
            PostRS rs = new PostRS();
            
            lista = new Coleccion<Post>().resultsetToList(
                    new Post(),
                    rs.list()
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
