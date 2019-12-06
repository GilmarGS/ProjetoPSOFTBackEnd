package ajude.psoft.comparadores;

import java.util.Comparator;

import org.springframework.stereotype.Service;

import ajude.psoft.entidades.Campanha;

@Service
public class ComparadorCampanhaLikes implements Comparator<Campanha>{

	@Override
	public int compare(Campanha c1, Campanha c2) {
		if(c1.getLikes().size() < c2.getLikes().size()) {
			return -1;
		}else if(c1.getLikes().size() < c2.getLikes().size()) {
			return 1;
		}
	return 0;
	}

}
