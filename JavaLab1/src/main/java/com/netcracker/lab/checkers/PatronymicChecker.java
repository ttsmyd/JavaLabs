package com.netcracker.lab.checkers;

import com.netcracker.lab.Human;

public class PatronymicChecker implements Checker {
    public boolean check(Human human, Object object) {
            String ob = (String) object;
            return human.getPatronymic().equals(ob);
    }
}
