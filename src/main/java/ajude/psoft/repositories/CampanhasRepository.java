package ajude.psoft.repositories;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ajude.psoft.entidades.Campanha;


@Repository
public interface CampanhasRepository<T, ID extends Serializable> extends JpaRepository<Campanha, Long> {

}
