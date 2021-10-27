package tn.service.bookings.bookingsservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingRestApi {

	private String title = "Hello ms";

	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(this.title);
		return this.title;
	}

}
