package com.netcracker.lab.checkers;

import com.netcracker.lab.Human;

public class FirstNameChecker implements Checker {
    public boolean check(Human human, Object object) {
        String ob = (String) object;
        return human.getFirstName().equals(ob);
    }
}
