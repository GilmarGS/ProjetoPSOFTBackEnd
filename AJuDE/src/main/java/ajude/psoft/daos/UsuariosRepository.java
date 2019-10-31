package ajude.psoft.daos;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ajude.psoft.entidades.Usuario;



@Repository
public interface UsuariosRepository<T, ID extends Serializable> extends JpaRepository<Usuario, String> {

}