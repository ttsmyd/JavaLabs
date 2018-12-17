package com.netcracker.lab.checkers;

import com.netcracker.lab.Human;
import org.joda.time.LocalDate;

public class DateOfBirthChecker implements Checker {

    public boolean check(Human human, Object object) {
        LocalDate ob = (LocalDate) object;
        return human.getDateOfBirth().isEqual(ob);
    }
}
