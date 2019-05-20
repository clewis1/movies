package com.movies.web;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovieTest {
    private Movie testMovie;
    private List<Comment> testComments;

    @BeforeEach
    void setUp() {
        testComments = Arrays.asList(new Comment("PeterPan", "I loved my film!", "2000-01-03", 109));
        testMovie = new Movie(1, "Titanic", "Sinking ship", "D Jones",
            true, "18", 100, testComments);
    }

    @Test
    void setGetMovieId() {
        final int expected = 1;

        testMovie.setMovieId(expected);
        assertThat(testMovie.getMovieId(), is(expected));
    }

    @Test
    void setGetTitle() {
        final String expected = "The Hobbit";

        testMovie.setTitle(expected);
        assertThat(testMovie.getTitle(), is(expected));
    }

    @Test
    void setGetDescription() {
        final String expected = "Little man";

        testMovie.setDescription(expected);
        assertThat(testMovie.getDescription(), is(expected));
    }

    @Test
    void setGetProducer() {
        final String expected = "C Lewis";

        testMovie.setProducer(expected);
        assertThat(testMovie.getProducer(), is(expected));
    }

    @Test
    void setGetAvailableIn3d() {
        final Boolean expected = false;

        testMovie.setAvailableIn3d(expected);
        assertThat(testMovie.getAvailableIn3d(), is(expected));
    }

    @Test
    void setGetAgeRating() {
        final String expected = "12R";

        testMovie.setAgeRating(expected);
        assertThat(testMovie.getAgeRating(), is(expected));
    }

    @Test
    void setGetLikes() {
        final int expected = 12;

        testMovie.setLikes(expected);
        assertThat(testMovie.getLikes(), is(expected));
    }

    @Test
    void setGetComments() {
        final List<Comment> expected = testComments;

        testMovie.setComments(expected);
        assertThat(testMovie.getComments(), is(expected));
    }
}
