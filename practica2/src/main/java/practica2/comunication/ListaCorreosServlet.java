package practica2.comunication;

import com.fasterxml.jackson.databind.ObjectMapper;
import practica2.modelo.BDUsuario;
import practica2.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/P2")
public class ListaCorreosServlet {

    @Autowired
    private BDUsuario bDUsuario;

    @RequestMapping(value = "/ListaCorreosServlet", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<List<Usuario>> add(@RequestParam(value="action", required=false, defaultValue="World") String action, HttpServletRequest request) throws IOException, ServerSideException {

        if (action.equals("listarUsuarios")) {
            List<Usuario> usuarioList = bDUsuario.getTodosLosUsuarios();

            if (usuarioList != null) {
                return new ResponseEntity<List<Usuario>>(usuarioList, HttpStatus.OK);
            } else {
                throw new ServerSideException("Lista de Usuarios returned null", HttpStatus.INTERNAL_SERVER_ERROR);
            }


        } else if (action.equals("aniadirUsuario")) {
            if (request.getParameterMap().containsKey("nombre") &&
                    request.getParameterMap().containsKey("apellido") &&
                    request.getParameterMap().containsKey("email")) {
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String email = request.getParameter("email");
                bDUsuario.addUser(nombre, apellido, email);
            } else {
                throw new ServerSideException("nombre, apellido and email rquired in parameters", HttpStatus.BAD_REQUEST);
            }
        } else if (action.equals("eliminarUsuario")) {
            if (request.getParameterMap().containsKey("email")) {
                String email = request.getParameter("email");
                Usuario usuario = bDUsuario.findByEmail(email);
                if (null != usuario) {
                    if (bDUsuario.remove(usuario)) {
                        return new ResponseEntity<List<Usuario>>(HttpStatus.OK);
                    } else {
                        throw new ServerSideException("could not remove " + request.getParameter("email"), HttpStatus.INTERNAL_SERVER_ERROR);
                    }
                }
            } else {
                throw new ServerSideException("must specify user to remove", HttpStatus.BAD_REQUEST);
            }
        }
        return null;
    }

    @ExceptionHandler(ServerSideException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(ServerSideException ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(ex.getErrorCode());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
    }

    public BDUsuario getBdUsuario() {
        return bDUsuario;
    }

    public void setBdUsuario(BDUsuario bdUsuario) {
        this.bDUsuario = bdUsuario;
    }
}
