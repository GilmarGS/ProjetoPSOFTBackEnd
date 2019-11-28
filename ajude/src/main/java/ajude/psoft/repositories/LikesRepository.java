package ajude.psoft.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ajude.psoft.entidades.Curtir;

@Repository
public interface LikesRepository<T, ID extends Serializable> extends JpaRepository<Curtir, Long> {

}
