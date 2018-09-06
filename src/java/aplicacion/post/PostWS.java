/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.post;


import aplicacion.post.comment.Comment;
import aplicacion.post.comment.CommentDAO;
import aplicacion.user.User;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import nebuleuse.ORM.Persistencia;


/**
 * REST Web Service
 *
 * @author hugo
 */


@Path("posts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)


public class PostWS {

    @Context
    private UriInfo context;
    private Persistencia persistencia = new Persistencia();   
    private Gson gson = new Gson();    
    
    Post post = new Post();   
    JsonElement jsonElement ;


    public PostWS() {
      
    }

    
    @GET    
    public Response list (  ) {

        try {               
                        
            PostDAO dao = new PostDAO();

            List<Post> lista = dao.list();                
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
    @Path("/{postId}/comments")
    public Response list ( @PathParam ("postId") Integer postId  ) {

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
            post = (Post) persistencia.filtrarId(post, id);  

            return Response
                    .status(Response.Status.OK)
                    .entity(post)                        
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
            Integer userid = this.getIdForanea("userid");
            this.setObjetoPrimario(userid);
            
            post = (Post) persistencia.insert(post);

            return Response
                    .status(Response.Status.OK)
                    .entity(post)
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
            Integer userid = this.getIdForanea("userid");
            this.setObjetoPrimario(userid);
            
            
            Response.Status httpcode = Response.Status.OK;
            
            post.setId(id);
            post =  (Post) persistencia.update(post);

            return Response
                    .status(Response.Status.OK)
                    .entity(post)                        
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
    public Response delete (                        
            @PathParam ("id") Integer id) {
            
        try {                    
                
                Post post = new Post();
                post = (Post) persistencia.filtrarId(post, id);
                post = (Post) persistencia.delete(post);                

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
        
    
    private void  setObjetoPrimario (Integer userid){        
        
            post = gson.fromJson(jsonElement, Post.class);
            post.setUserid(new User());
            post.getUserid().setId(userid);        
        
    }
        
    
    
}
