/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.user;

import com.google.gson.Gson;
import java.util.List;
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


@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)


public class UserWS {

    @Context
    private UriInfo context;
    private Persistencia persistencia = new Persistencia();   
    private Gson gson = new Gson();    


    public UserWS() {
    }

    
    @GET    
    public Response list (  ) {

        try {                    

        UserDAO dao = new UserDAO();

        List<User> lista = dao.list();                
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
    public Response getUser(                 
            @PathParam ("id") Integer id ) {
                     
        try 
        {      
            User user = new User();
            user = (User) persistencia.filtrarId(user, id);  


            return Response
                    .status(Response.Status.OK)
                    .entity(user)                        
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
    public Response addUser(             
            User userReq )  {
        
        try {                    
            
            User user = new User();
            user = (User) persistencia.insert(userReq);

            return Response
                    .status(Response.Status.OK)
                    .entity(user)
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
    public Response editUsuario (
            @PathParam ("id") Integer id,
            User userReq ) {
            
        try {                    
           
            userReq.setId(id);
            User user = new User();

            user =  (User) persistencia.update(userReq);

            return Response
                    .status(Response.Status.OK)
                    .entity(user)                        
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
    public Response deleteUsuario (                        
            @PathParam ("id") Integer id) {
            
        try {                    

                
                User user = new User();
                user = (User) persistencia.filtrarId(user, id);
                user = (User) persistencia.delete(user);                

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
        
    
        
    
    
}
