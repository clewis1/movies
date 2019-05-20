package com.movies.web;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovieHubTest {
    private MovieHub testMovieHub;
    private List<Movie> testMovies;

    @BeforeEach
    void setUp() {
        List<Comment> testComments = Arrays.asList(new Comment("PeterPan", "I loved my film!", "2000-01-03", 109));
        Movie testMovie = new Movie(1, "Titanic", "Sinking ship", "D Jones",
            true, "18", 100, testComments);
        testMovieHub = new MovieHub(Arrays.asList(testMovie));
        testMovies = Arrays.asList(testMovie);

    }

    @Test
    void setGetMovies() {
        final List<Movie> expected = testMovies;

        testMovieHub.setMovies(expected);
        assertThat(testMovieHub.getMovies(), is(expected));
    }
}
