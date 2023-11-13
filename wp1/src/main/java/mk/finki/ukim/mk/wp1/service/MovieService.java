package mk.finki.ukim.mk.wp1.service;

import mk.finki.ukim.mk.wp1.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
        List<Movie> listAll();
        Optional<Movie> findById(Long id);
        void deleteById(Long id);
        Optional<Movie> save(String title, String summary, double rating, Long production);

}
