package ajude.psoft.comparadores;

import java.util.Comparator;

import org.springframework.stereotype.Service;

import ajude.psoft.entidades.Campanha;

@Service
public class ComparadorCampanhaMeta implements Comparator<Campanha>{
	
	
	@Override
	public int compare(Campanha c1, Campanha c2) {
		if(c1.diferencaMeta() < c2.diferencaMeta()) {
			return -1;
		}else if(c1.diferencaMeta() > c2.diferencaMeta()) {
			return 1;
		}
		return 0;
	}
		
}
