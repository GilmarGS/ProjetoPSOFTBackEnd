package ajude.psoft.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import ajude.psoft.entidades.Comentario;

public interface ComentariosRepository<T, ID extends Serializable> extends JpaRepository<Comentario, Long> {

}
