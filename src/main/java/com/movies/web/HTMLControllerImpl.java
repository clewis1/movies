package com.movies.web;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HTMLControllerImpl implements HTMLController{

    private RestTemplate restTemplate;

    private String apiUrl;
    private String movieHubUrl = "/movieHub";

    public HTMLControllerImpl() {

    }

    @Autowired
    public HTMLControllerImpl(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @Value("${api.server.url}")
    public void setApiUrl(String url) {
        apiUrl = url;
    }

    @Override
    @GetMapping("/")
    public String startUp() {
        populateMovieList();
        return "redirect:/landingPage";
    }

    @Override
    @GetMapping("/landingPage")
    public String landingPage() {

        return "landingPage";
    }

    @Override
    @GetMapping("/movieCentre")
    public String movieCentre(Model model) {

        return "movieCentre";
    }

    @Override
    @GetMapping("/allMovies")
    public String allMovies(Model model) {

        String allMoviesUrl = apiUrl + movieHubUrl + "/allMovies";

        ResponseEntity<MovieHub> response =
            restTemplate.exchange(allMoviesUrl, HttpMethod.GET, null, MovieHub.class);
        List<Movie> movies = Objects.requireNonNull(response.getBody()).getMovies();

        model.addAttribute("movies", movies);

        return "allMovies";
    }

    @Override
    @GetMapping("/mostComments")
    public String mostComments(Model model) {

        String mostCommentsUrl = apiUrl + movieHubUrl + "/mostComments";

        ResponseEntity<String> response =
            restTemplate.exchange(mostCommentsUrl, HttpMethod.GET, null, String.class);

        String mostCommentedUser = Objects.requireNonNull(response.getBody());
        model.addAttribute("mostCommentedUser", mostCommentedUser);

        return "mostComments";
    }

    @Override
    @GetMapping("/mostLikes")
    public String mostLikes(Model model) {

        String mostLikesUrl = apiUrl + movieHubUrl + "/mostLikes";

        ResponseEntity<String> response =
            restTemplate.exchange(mostLikesUrl, HttpMethod.GET, null, String.class);

        String mostLikes = Objects.requireNonNull(response.getBody());
        model.addAttribute("mostLikes", mostLikes);

        return "mostLikes";
    }

    @Override
    @PostMapping("/populateMovieList")
    public void populateMovieList() {

        String populateMovieListUrl = apiUrl + movieHubUrl + "/populateMovieList";
        restTemplate.exchange(populateMovieListUrl, HttpMethod.POST, null, MovieHub.class);
    }
}
