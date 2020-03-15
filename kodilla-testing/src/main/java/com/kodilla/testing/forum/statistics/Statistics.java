package com.kodilla.testing.forum.statistics;

import java.util.List;

public interface Statistics {
    public List<String> usersNames(); // list of users names

    public int postsCount();          // total quantity of forum posts

    public int commentsCount();       // total quantity of forum comments
}