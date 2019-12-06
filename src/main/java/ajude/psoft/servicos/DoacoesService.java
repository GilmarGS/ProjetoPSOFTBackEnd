package ajude.psoft.servicos;

import org.springframework.stereotype.Repository;

import ajude.psoft.entidades.Doacao;
import ajude.psoft.repositories.DoacoesRepository;

@Repository
public class DoacoesService {
	DoacoesRepository<Doacao, Long> doacoesRepository;

	public DoacoesService(DoacoesRepository<Doacao, Long> doacoesRepository) {
		this.doacoesRepository = doacoesRepository;
	}

	public Doacao adicionaDoacao(Doacao doacao) {
		return this.doacoesRepository.save(doacao);
	}
}
