package atrumblack.clinicaveterinaria;

import atrumblack.clinicaveterinaria.presentacion.SistemasTareasFx;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaveterinariaApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ClinicaveterinariaApplication.class, args);
		Application.launch(SistemasTareasFx.class, args);
	}

}
