package com.kodilla.testing.forum.statistics;

public class StatisticsCalculations {
    private int usersCount;
    private int postsCount;
    private int commentCount;
    private double averagePostsPerUsers;
    private double averageCommentsPerUsers;
    private double averageCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        usersCount = statistics.usersNames().size();
        postsCount = statistics.postsCount();
        commentCount = statistics.commentsCount();
        averagePostsPerUsers = postsCount / usersCount;
        averageCommentsPerUsers = commentCount / usersCount;
        averageCommentsPerPost = commentCount / postsCount;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public double getAveragePostsPerUsers() {
        return averagePostsPerUsers;
    }

    public double getAverageCommentsPerUsers() {
        return averageCommentsPerUsers;
    }

    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }

    public String showStatistics() {
        return "User count: " + usersCount + "\nPosts count: " + postsCount + "\nComment count: " + commentCount + "\nPost per User average: " + averagePostsPerUsers + "\nComment per User average: " + averageCommentsPerUsers + "\nComments per Post average: " + averageCommentsPerPost;
    }
}
