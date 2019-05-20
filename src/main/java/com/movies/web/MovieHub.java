package com.movies.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class MovieHub {

    private List<Movie> movies;

    public MovieHub() {
    }

    /**
     * @param movies   List of movies
     */
    @JsonCreator
    public MovieHub(@JsonProperty("movies") final List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(final List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof MovieHub)) {
            return false;
        }

        final MovieHub movieHub = (MovieHub) o;

        return new EqualsBuilder().append(movies, movieHub.movies).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(movies).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("movies", movies)
            .toString();
    }
}
