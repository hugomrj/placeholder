/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.post.comment;





import aplicacion.post.Post;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import nebuleuse.ORM.Persistencia;


/**
 * REST Web Service
 *
 * @author hugo
 */


@Path("comments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)


public class CommentWS {

    @Context
    private UriInfo context;
    private Persistencia persistencia = new Persistencia();   
    private Gson gson = new Gson();    
    
    Comment comentario = new Comment();   
    JsonElement jsonElement ;


    public CommentWS() {
      //  post.setUserid(new User());
    }

    
    	
    
    @GET    
    public Response list ( @QueryParam("postId") Integer postId  ) {

        try {               
                        
        CommentDAO dao = new CommentDAO();

        List<Comment> lista = dao.list(postId);                
        String json = gson.toJson( lista );        
                
        return Response
                .status(Response.Status.OK)
                .entity(json)
                .build();                                         
        }     
        
        catch (Exception ex) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ex.getMessage())
                    .build();                                        
        }      
    }    
    
    
    
    
    
    
    
    @GET
    @Path("/{id}")
    public Response get(                 
            @PathParam ("id") Integer id ) {
                     
        try 
        {      
            comentario = (Comment) persistencia.filtrarId(comentario, id);  

            return Response
                    .status(Response.Status.OK)
                    .entity(comentario)                        
                    .build();       
        }     
        catch (Exception ex) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ex.getMessage())                    
                    .build();                                        
        }  
    }    
      
       
    
    
    
 
    @POST
    public Response add(             
            String strJson   )  {            
       
        try {                    
            
            jsonElement = new JsonParser().parse(strJson); 
            Integer postid = this.getIdForanea("postid");
            this.setObjetoPrimario(postid);
            
            comentario = (Comment) persistencia.insert(comentario);

            return Response
                    .status(Response.Status.OK)
                    .entity(comentario)
                    .build();       
            
        }     
        catch (Exception ex) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ex.getMessage())                    
                    .build();                                        
        }  
    }    
 
          
    

    
    
    @PUT    
    @Path("/{id}")    
    public Response edit (
            @PathParam ("id") Integer id,
            String strJson  ) {
            
        try {                    
           
            jsonElement = new JsonParser().parse(strJson); 
            Integer postid = this.getIdForanea("postid");
            this.setObjetoPrimario(postid);
                        
            Response.Status httpcode = Response.Status.OK;
            
            comentario.setId(id);
            comentario =  (Comment) persistencia.update(comentario);

            return Response
                    .status(Response.Status.OK)
                    .entity(comentario)                        
                    .build();       
        }     
        catch (Exception ex) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ex.getMessage())                    
                    .build();                        
        }        
    }    
    
    
    
    
    
        
    
    @DELETE  
    @Path("/{id}")    
    public Response delete ( @PathParam ("id") Integer id ) {
            
        try {                    
                
                comentario = (Comment) persistencia.filtrarId(comentario, id);
                comentario = (Comment) persistencia.delete(comentario);                

                return Response
                        .status(Response.Status.OK)
                        .entity(null)                        
                        .build();                       

        }     
        catch (Exception ex) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(ex.getMessage())                    
                    .build();                    
        }        
    }    
        
    
    
    

    
    private Integer getIdForanea (String campoid){        
        
        Integer id = jsonElement.getAsJsonObject().get( campoid ).getAsInt();
        jsonElement.getAsJsonObject().remove( campoid );             
        return id;
    }
        
       
    
    
    private void  setObjetoPrimario (Integer postid){        
        
            comentario = gson.fromJson(jsonElement, Comment.class);
            comentario.setPostid(new Post());
            comentario.getPostid().setId(postid);  
    }
        

    
}
