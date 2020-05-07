package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;

public class StreamMainMovieStore {

    public static void main(String[] args) {
        String result = new MovieStore().getMovies().values().stream()
                .flatMap(movieTitles -> movieTitles.stream())
                .collect(Collectors.joining(" ! "));
        System.out.println(result);
    }
}
