package samztech.auth;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import samztech.auth.model.User;

import javax.naming.AuthenticationException;

@Path("/auth")
public class AuthResource {

    @Inject
    AuthService authService;

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(User loginUser) throws AuthenticationException {
        String jwt = authService.authenticateUser(loginUser);
        return Response.ok(new JwtResponse(jwt)).build();
    }

}
