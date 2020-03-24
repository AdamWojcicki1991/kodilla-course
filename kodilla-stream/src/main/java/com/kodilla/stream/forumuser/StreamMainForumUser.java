package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMainForumUser {
    public static void main(String[] args) {
        Forum forum = new Forum();
        Map<Integer, Object> resultMapOfForumUsers = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getGender() == 'M')
                .filter(forumUser -> forumUser.getBirthDate().getYear() < LocalDate.now().getYear() - 20)
                .filter(forumUser -> forumUser.getPublishedPosts() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserID, forumUser -> forumUser));

        System.out.println("# elements: " + resultMapOfForumUsers.size());
        resultMapOfForumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}
