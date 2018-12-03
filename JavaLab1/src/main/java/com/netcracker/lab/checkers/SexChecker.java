package com.netcracker.lab.checkers;

import com.netcracker.lab.Human;

public class SexChecker implements Checker {
    public boolean check(Human human, Object object) {
        Enum ob = (Enum) object;
        return (human.getSex() == ob);
    }
}
