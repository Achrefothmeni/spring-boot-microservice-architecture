package tn.service.rate.rateservice;

import java.util.List;

public class RateService {

    private final RateRepository rateRepository;

    public RateService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    public Rate addRate(int movieId,float rate){
        return rateRepository.save(new Rate(movieId,rate));
    }

    public List<Rate> getAllRate(){
        return rateRepository.findAll();
    }

    public Rate getOneRateById(int id){
        return rateRepository.findById(id);
    }

    public void deleteRate(int id){
        if(getOneRateById(id)!=null){
            rateRepository.delete(getOneRateById(id));
        }
    }

    public void updateRate(Rate rate){
        if(getOneRateById(rate.getId())!=null){
            Rate rate1 = getOneRateById(rate.getId());
            rate1.setMovieId(rate.getMovieId());
            rate1.setRate(rate.getRate());
            rateRepository.save(rate1);
        }
    }
}
