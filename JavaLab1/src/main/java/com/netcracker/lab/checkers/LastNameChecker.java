package com.netcracker.lab.checkers;

import com.netcracker.lab.Human;

public class LastNameChecker implements Checker {
    public boolean check(Human human, Object object) {
        String ob = (String) object;
        return human.getLastName().equals(ob);
    }
}
