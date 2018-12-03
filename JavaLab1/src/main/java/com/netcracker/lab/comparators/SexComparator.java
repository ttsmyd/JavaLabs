package com.netcracker.lab.comparators;
import com.netcracker.lab.Human;

public class SexComparator implements Comparator<Human> {
    public int compare(Human first, Human second) {
        if(first.getSex().equals("Male")) {
            return 1;
        }
        if(first.getSex().equals("Female")) {
            return 0;
        }
            return -1;
    }
}
