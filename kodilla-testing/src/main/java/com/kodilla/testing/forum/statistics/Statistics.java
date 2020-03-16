package com.kodilla.testing.forum.statistics;

import java.util.List;

public interface Statistics {
    public List<String> usersNames();

    public int postsCount();

    public int commentsCount();
}