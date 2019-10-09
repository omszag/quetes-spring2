package com.wildcodeschool.queteJavaSpring2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SpringBootApplication
public class QueteJavaSpring2Application {

	public static void main(String[] args) {
		SpringApplication.run(QueteJavaSpring2Application.class, args);
	}
	
	@RequestMapping("/doctors/{number}")
	@ResponseBody
	public String doctors(@PathVariable int number) {
		
		Doctors doctor9 = new Doctors("Christopher Eccleston", 9);
		Doctors doctor10 = new Doctors("David Tennant", 10);
		Doctors doctor11 = new Doctors("Matt Smith", 11);
		Doctors doctor12 = new Doctors("Peter Capaldi", 12);
		Doctors doctor13 = new Doctors("Jodie Whittaker", 13);
	
		if (number >= 0 && number <= 8) {
			throw new ResponseStatusException(HttpStatus.SEE_OTHER, "Choisir un autre numéro");
		}  
			if(number < 1 || number > 13) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation" + number) ;
		} 
		else {
			if(number == 9) {
				return "number : "+ doctor9.getNumber() + " name : "+ doctor9.getName();
			}
			if(number == 10) {
				return "number : "+ doctor10.getNumber() + " name : "+ doctor10.getName();
			}
			if(number == 11) {
				return "number : "+ doctor11.getNumber() + " name : "+ doctor11.getName();
			}
			if(number == 12) {
				return "number : "+ doctor12.getNumber() + " name : "+ doctor12.getName();
			}
			if(number == 13) {
				return "number : "+ doctor13.getNumber() + " name : "+ doctor13.getName();
			}
		}
	
		
		return null;
	
	
	}
	


}

