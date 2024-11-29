package gerardo.sn.DemoCrudConApi.repository;

//public class UsuarioRepository {
//}


import gerardo.sn.DemoCrudConApi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}