package basic.basiccrud;

import basic.basiccrud.entity.Member;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class BasicCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicCrudApplication.class, args);
	}


}
