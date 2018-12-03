package com.netcracker.lab.checkers;

import com.netcracker.lab.Human;

public class IdChecker implements Checker {
    public boolean check(Human human, Object ob) {
        Integer ob1 = (Integer) ob;
        return (human.getId() == ob);
    }
}
