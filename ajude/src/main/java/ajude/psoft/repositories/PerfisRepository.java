package ajude.psoft.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import ajude.psoft.entidades.Perfil;

public interface PerfisRepository<T, ID extends Serializable> extends JpaRepository<Perfil, Long>{

}
