package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> forumUsers = new ArrayList<>();

    public Forum() {
        forumUsers.add(new ForumUser(1, "Dylan Murphy", 'M', 1991, 4, 19, 1));
        forumUsers.add(new ForumUser(2, "Phoebe Pearson", 'M', 2012, 6, 29, 31));
        forumUsers.add(new ForumUser(3, "Morgan Walsh", 'M', 2001, 12, 06, 42));
        forumUsers.add(new ForumUser(4, "Aimee Murphy", 'F', 2010, 8, 10, 43));
        forumUsers.add(new ForumUser(5, "Ryan Talley", 'M', 2007, 9, 22, 25));
        forumUsers.add(new ForumUser(6, "Madelynn Carson", 'F', 2007, 12, 23, 66));
        forumUsers.add(new ForumUser(7, "Giancarlo Guerrero", 'M', 2009, 3, 23, 99));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(forumUsers);
    }
}
