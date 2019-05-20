package com.movies.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Comment {

    private String user;
    private String message;
    private String dateCreated;
    private Integer like;

    /**
     * @param user        e.g. David Jones.
     * @param message        user message
     * @param dateCreated   date of comment
     * @param like      number of comment likes
     */
    @JsonCreator
    public Comment(@JsonProperty("user") final String user, @JsonProperty("message") final String message, @JsonProperty("date_created") final String dateCreated,
        @JsonProperty("like") final Integer like) {
        this.user = user;
        this.message = message;
        this.dateCreated = dateCreated;
        this.like = like;
    }

    public Comment() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(final String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(final String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(final Integer like) {
        this.like = like;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Comment)) {
            return false;
        }

        final Comment comment = (Comment) o;

        return new EqualsBuilder().append(user, comment.user).append(message, comment.message)
            .append(dateCreated, comment.dateCreated).append(like, comment.like).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(user).append(message).append(dateCreated)
            .append(like).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("user", user)
            .append("message", message).append("dateCreated", dateCreated).append("like", like)
            .toString();
    }
}
