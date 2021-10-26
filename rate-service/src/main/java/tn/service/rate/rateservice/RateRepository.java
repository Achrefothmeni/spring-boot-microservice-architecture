package tn.service.rate.rateservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RateRepository extends JpaRepository<Rate, Integer> {

    Rate findById(int id);
}
