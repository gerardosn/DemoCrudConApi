package gerardo.sn.DemoCrudConApi.service;

//public class UsuarioService {
//}
import gerardo.sn.DemoCrudConApi.model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> obtenerUsuarios();
    void guardarUsuario(Usuario usuario);
}
