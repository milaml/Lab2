package mk.finki.ukim.mk.wp1.web.controller;

import mk.finki.ukim.mk.wp1.model.Movie;
import mk.finki.ukim.mk.wp1.model.Production;
import mk.finki.ukim.mk.wp1.service.MovieService;
import mk.finki.ukim.mk.wp1.service.ProductionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;
    private final ProductionService productionService;


    public MovieController(MovieService movieService, ProductionService productionService) {
        this.movieService = movieService;
        this.productionService = productionService;
    }

    @GetMapping
    public String getMoviesPage(@RequestParam(required = false) String error, Model model){
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("errors", error);
        }
        List<Movie> movies = this.movieService.listAll();
        model.addAttribute("movies", movies);
        return "listMovies";

    }
    @GetMapping("edit-form/{movieId}")
    public String editMovie(@PathVariable Long movieId, Model model){

        if (this.movieService.findById(movieId).isPresent()) {
            Movie movies = this.movieService.findById(movieId).get();
            List<Production> productions = this.productionService.findAll();
            model.addAttribute("productions", productions);
            model.addAttribute("movies", movies);
            return "add-movie";
        }
        return "redirect:/movies?error=MovieNotFound";
    }
    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id){
        this.movieService.deleteById(id);
        return "redirect:/movies";

    }
    @GetMapping("/add-form")
    public String addMoviePage(Model model) {
        List<Production> productions = this.productionService.findAll();
        model.addAttribute("productions", productions);
        return "add-movie";
    }
    @PostMapping("/add")
    public String saveMovie(@RequestParam String title,
                            @RequestParam String summary,
                            @RequestParam Double rating,
                            @RequestParam Long productions){
        this.movieService.save(title,summary,rating,productions);
        System.out.println(title);
        System.out.println(summary);

        System.out.println(rating);

        System.out.println(productions);

        return "redirect:/movies";

    }

}
