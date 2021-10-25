package tn.service.rate.rateservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Rate implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private int movieId;
    private float rate;

    public Rate(int id, int movieId, float rate) {
        this.id = id;
        this.movieId = movieId;
        this.rate = rate;
    }

    public Rate() {
    }

    public int getId() {
        return id;
    }

    public int getMovieId() {
        return movieId;
    }

    public float getRate() {
        return rate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
