package ajude.psoft.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import ajude.psoft.entidades.Like;

public interface LikesRepositories<T, ID extends Serializable> extends JpaRepository<Like, Long> {

}
