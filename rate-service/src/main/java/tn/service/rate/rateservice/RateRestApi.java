package tn.service.rate.rateservice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RateRestApi {

    private RateService rateService;

    @GetMapping("/rates")
    public List<Rate> getAllRate(){
        return rateService.getAllRate();
    }

    @GetMapping("/rates/{id}")
    public Rate getOneRate(@PathVariable int id){
        return rateService.getOneRateById(id);
    }

    @PostMapping("/rates")
    public Rate addRate(@RequestBody Rate rate){
        return rateService.addRate(rate.getMovieId(), rate.getRate());
    }

    @DeleteMapping("/rates/{id}")
    public void deleteRate(@PathVariable int id){
        rateService.deleteRate(id);
    }

}
