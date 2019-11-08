package ajude.psoft.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ajude.psoft.entidades.Campanha;
import ajude.psoft.entidades.Comentario;

@Repository
public interface CamapanhasRepository<T, ID extends Serializable> extends JpaRepository<Campanha, Long> {
	
}
