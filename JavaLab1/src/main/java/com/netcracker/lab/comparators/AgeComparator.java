package com.netcracker.lab.comparators;
import com.netcracker.lab.Human;

public class AgeComparator implements Comparator<Human> {
    public int compare(Human first, Human second) {
        if(first.getAge() > second.getAge()) {
            return 1;
        }
        if(first.getAge() < second.getAge()) {
            return -1;
        } else {
            return 0;
        }
    }
}
