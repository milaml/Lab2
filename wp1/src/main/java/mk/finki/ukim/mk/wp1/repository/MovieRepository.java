package mk.finki.ukim.mk.wp1.repository;


import mk.finki.ukim.mk.wp1.bootstrap.DataHolder;
import mk.finki.ukim.mk.wp1.model.Movie;
import mk.finki.ukim.mk.wp1.model.Production;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MovieRepository {
    public List<Movie> listAll(){
    return DataHolder.movies;
}

  public void deleteById(Long id) {
         DataHolder.movies.removeIf(r->r.getId().equals(id));
   }
  public Optional<Movie> findById(Long id) {
        return DataHolder.movies.stream().filter(r->r.getId().equals(id)).findFirst();
   }
  public Optional<Movie> save(String title, String summary, Double rating, Production production)  {
        if(production==null) {
            throw new RuntimeException("Production not found!");
        }
        else{
            Movie movie = new Movie(title,summary,rating,production);
            DataHolder.movies.add(movie);
            return Optional.of(movie);
        }
   }

    }

