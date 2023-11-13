package mk.finki.ukim.mk.wp1.service.impl;


import mk.finki.ukim.mk.wp1.model.Movie;
import mk.finki.ukim.mk.wp1.model.Production;
import mk.finki.ukim.mk.wp1.repository.MovieRepository;
import mk.finki.ukim.mk.wp1.repository.ProductionRepository;
import mk.finki.ukim.mk.wp1.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
         private final MovieRepository movieRepository;
         private final ProductionRepository productionRepository;

    public MovieServiceImpl(MovieRepository movieRepository, ProductionRepository productionRepository) {
        this.movieRepository = movieRepository;
        this.productionRepository = productionRepository;
    }

    @Override
    public List<Movie> listAll() {
        return this.movieRepository.listAll();
 }

    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Optional<Movie> findById(Long id) {
       return movieRepository.findById(id);
    }

    @Override
    public Optional<Movie> save(String title, String summary, double rating, Long production) {
        Production p= this.productionRepository.findById(production).orElseThrow(()->new RuntimeException("Production not found"));
        return this.movieRepository.save(title,summary,rating,p);
    }
}
