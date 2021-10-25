package tn.service.actors.actorsservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorRestApi {
	
private String title = "Hello ms";
	
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(this.title);
		return this.title;
	}

}
