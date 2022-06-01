package movies.server.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @CrossOrigin
    @PostMapping("/movies")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>(movie.toString(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/movies")
    public ResponseEntity<List<Movie>> getMovies() {
        List<Movie> movies = movieService.findAll();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

}
