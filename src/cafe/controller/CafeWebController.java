package cafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cafe.interfaces.iOrmMethods;
import cafe.model.dao.CafeOrm;
import cafe.model.entities.Supplier;

@RestController
@EnableAutoConfiguration
@ImportResource("classpath:beans.xml")
public class CafeWebController {
	@Autowired
	iOrmMethods cafe;
	
	// what is this for
	static RestTemplate restTemplate = new RestTemplate();
	static String url = "http://localhost:8080/";
	
	@RequestMapping(value = "getSupplier/{id}", method = RequestMethod.GET)
	public Supplier getSupplierById(@PathVariable int id) {
		return cafe.getSupplierById(id);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CafeWebController.class, args);

	}

}
