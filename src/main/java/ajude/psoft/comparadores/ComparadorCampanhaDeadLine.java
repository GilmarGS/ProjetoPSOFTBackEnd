package ajude.psoft.comparadores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

import org.springframework.stereotype.Service;

import ajude.psoft.entidades.Campanha;

@Service
public class ComparadorCampanhaDeadLine implements Comparator<Campanha> {
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public int compare(Campanha c1, Campanha c2) {
		Date data1 = null;
		try {
			data1 = (Date) formato.parse(c1.getDeadlineArrecadacao());
		} catch (ParseException e) {			
			e.printStackTrace();
		}
		Date data2 = null;
		try {
			data2 = (Date) formato.parse(c2.getDeadlineArrecadacao());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return data1.compareTo(data2);
	}

}
