package sneltransport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(basePackageClasses = { SnelTransport.class, Jsr310JpaConverters.class })  
@SpringBootApplication
public class SnelTransport extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SnelTransport.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(SnelTransport.class, args);
	}
}
