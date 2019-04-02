package com.mazon.pokabola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
//@EnableWebMvc
@EntityScan(basePackageClasses = {PokabolaApplication.class, Jsr310JpaConverters.class})
public class PokabolaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokabolaApplication.class, args);
	}

}
