package ajude.psoft.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import ajude.psoft.entidades.Doacao;

public interface DoacoesRepository<T, ID extends Serializable> extends JpaRepository<Doacao, Long>{

}
