package com.netcracker.lab;

import org.joda.time.Period;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class HumanTest {

    @Test
    public void getAge() {
        List<Human> humans = Arrays.asList(
                new Human[]{new Human("f0", "n0", "o0", Sex.Male, "1999-04-12"),
                        new Human("f1", "n1", "o1", Sex.Female, "1993-06-11"),
                        new Human("f2", "n2", "o2", Sex.Male, "1995-03-14"),
                        new Human("f3", "n3", "o3", Sex.Male, "1993-07-17"),
                        new Human("f4", "n4", "o4", Sex.Female, "1983-06-13"),
                        new Human("f5", "n5", "o5", Sex.Male, "1992-02-13"),
                        new Human("f6", "n6", "o6", Sex.Male, "1993-08-16"),
                        new Human("f7", "n7", "o7", Sex.Male, "1992-09-18"),
                        new Human("f8", "n8", "o8", Sex.Female, "1991-05-19"),
                        new Human("f9", "n9", "o9", Sex.Male, "1991-03-13"),
                        new Human("f10", "n10", "o10", Sex.Male, "1991-03-13")});

        HumanRepository humanRepository = new HumanRepository();
        humans.forEach(human -> humanRepository.addHuman(human));

        for (int i = 0; i < 9; i++) {
            org.joda.time.LocalDate now = new org.joda.time.LocalDate();
            Period period = new Period(humanRepository.getHuman(i).getDateOfBirth(), now);

            Assert.assertEquals(period.getYears(), humanRepository.getHuman(i).getAge());
        }
    }

}
