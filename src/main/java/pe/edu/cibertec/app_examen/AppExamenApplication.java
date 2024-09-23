package pe.edu.cibertec.app_examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AppExamenApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppExamenApplication.class, args);
	}

}
