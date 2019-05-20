package com.movies.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Movie {

    private Integer movieId;
    private String title;
    private String description;
    private String producer;
    private Boolean availableIn3d;
    private String ageRating;
    private Integer likes;
    private List<Comment> comments;

    public Movie() {

    }

    /**
     * @param movieId       e.g. 4.
     * @param title         movie title
     * @param description   description
     * @param producer      producer's name
     * @param availableIn3d available in 3D
     * @param ageRating     age rating
     * @param likes         number of likes
     * @param comments      user comments
     */
    @JsonCreator
    public Movie(@JsonProperty("movie_id") final Integer movieId, @JsonProperty("title") final String title, @JsonProperty("description") final String description,
        @JsonProperty("producer") final String producer, @JsonProperty("available_in_3d") final Boolean availableIn3d, @JsonProperty("age_rating") final String ageRating,
        @JsonProperty("likes") final Integer likes, @JsonProperty("comments") final List<Comment> comments) {
        this.movieId = movieId;
        this.title = title;
        this.description = description;
        this.producer = producer;
        this.availableIn3d = availableIn3d;
        this.ageRating = ageRating;
        this.likes = likes;
        this.comments = comments;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(final Integer movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(final String producer) {
        this.producer = producer;
    }

    public Boolean getAvailableIn3d() {
        return availableIn3d;
    }

    public void setAvailableIn3d(final Boolean availableIn3d) {
        this.availableIn3d = availableIn3d;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(final String ageRating) {
        this.ageRating = ageRating;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(final Integer likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(final List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Movie)) {
            return false;
        }

        final Movie movie = (Movie) o;

        return new EqualsBuilder().append(movieId, movie.movieId).append(title, movie.title)
            .append(description, movie.description).append(producer, movie.producer)
            .append(availableIn3d, movie.availableIn3d).append(ageRating, movie.ageRating)
            .append(likes, movie.likes).append(comments, movie.comments).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(movieId).append(title).append(description)
            .append(producer).append(availableIn3d).append(ageRating).append(likes).append(comments)
            .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("movieId", movieId)
            .append("title", title).append("description", description).append("producer", producer)
            .append("availableIn3d", availableIn3d).append("ageRating", ageRating)
            .append("likes", likes).append("comments", comments).toString();
    }
}
