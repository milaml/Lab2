package mk.finki.ukim.mk.wp1.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.wp1.model.Movie;
import mk.finki.ukim.mk.wp1.model.Production;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Movie> movies = null;
    public static List<Production> productions = null;
@PostConstruct
    public void init() {
    movies = new ArrayList<>();
    productions=new ArrayList<>();

    productions.add(new Production("Castle Rock Entertainment","USA","9169 West Sunset Boulevard"));
    productions.add(new Production("Paramount Pictures","USA","5555 Melrose Avenue, Hollywood, California"));
    productions.add(new Production("Marvel Studios","USA","500 South Buena Vista Street, Burbank, California"));
    productions.add(new Production("Warner Bros. Pictures","USA","4000 Warner Boulevard, Burbank, California"));
    productions.add(new Production("Marvel Studios","USA","500 South Buena Vista Street, Burbank, California"));

    movies.add(new Movie("The Conjuring", "Scary movie", 10, productions.get(0)));
    movies.add(new Movie("Harry Potter", "Fictional movie", 8, productions.get(1)));
    movies.add(new Movie("The Godfather", "Thriller", 10, productions.get(2)));
    movies.add(new Movie("Fight Club", "Action", 9, productions.get(3)));
    movies.add(new Movie("The Matrix", "Thriler-action", 7.7, productions.get(4)));


}
}
