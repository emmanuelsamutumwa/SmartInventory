package samztech.auth;


import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

import javax.naming.AuthenticationException;

public class AuthExceptionHandler implements ExceptionMapper<AuthenticationException> {

    @Override
    public Response toResponse(AuthenticationException exception) {
        return Response.status(Response.Status.UNAUTHORIZED)
                .entity(new ErrorResponse(exception.getMessage()))
                .build();
    }

    private static class ErrorResponse {
        private String message;

        public ErrorResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
