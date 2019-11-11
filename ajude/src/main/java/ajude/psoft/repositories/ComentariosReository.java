package ajude.psoft.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import ajude.psoft.entidades.Comentario;

public interface ComentariosReository<T, ID extends Serializable> extends JpaRepository<Comentario, Long> {

}
