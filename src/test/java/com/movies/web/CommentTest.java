package com.movies.web;



import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommentTest {
    private Comment testComment;

    @BeforeEach
    void setUp() {
        testComment = new Comment("PeterPan", "I loved my film!", "2000-01-03", 109);
    }

    @Test
    public void setGetUser() {
        final String expected = "Seth Rogan";

        testComment.setUser(expected);
        assertThat(testComment.getUser(), is(expected));
    }

    @Test
    public void setGetMessage() {
        final String expected = "I hated it.";

        testComment.setMessage(expected);
        assertThat(testComment.getMessage(), is(expected));
    }

    @Test
    public void setGetDateCreated() {
        final String expected = "1999-09-08";

        testComment.setDateCreated(expected);
        assertThat(testComment.getDateCreated(), is(expected));
    }

    @Test
    public void setGetLikes() {
        final int expected = 101;

        testComment.setLike(expected);
        assertThat(testComment.getLike(), is(expected));
    }

}
