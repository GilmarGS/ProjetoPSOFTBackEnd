

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import ajude.psoft.filtros.FiltroToken;

@SpringBootApplication
public class DemojwtApplication {
	@Bean
	public FilterRegistrationBean<FiltroToken> filterJwt() {
		FilterRegistrationBean<FiltroToken> filterRB = new FilterRegistrationBean<FiltroToken>();
		filterRB.setFilter(new FiltroToken());
		filterRB.addUrlPatterns("", "");
		return filterRB;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemojwtApplication.class, args);
	}

}