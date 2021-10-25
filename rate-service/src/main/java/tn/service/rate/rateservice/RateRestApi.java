package tn.service.rate.rateservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateRestApi {

    @RequestMapping("/hello")
    public String sayHello() {
        return "test";
    }

}
