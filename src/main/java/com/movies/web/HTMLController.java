package com.movies.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public interface HTMLController {

    @GetMapping("/")
    String startUp();

    @GetMapping("/landingPage")
    String landingPage();

    @GetMapping("/movieCentre")
    String movieCentre(Model model);

    @GetMapping("/allMovies")
    String allMovies(Model model);

    @GetMapping("/mostComments")
    String mostComments(Model model);

    @GetMapping("/mostLikes")
    String mostLikes(Model model);

    void setApiUrl(String url);

    void populateMovieList();
}
