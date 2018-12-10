package com.netcracker.lab.comparators;
import com.netcracker.lab.Human;
import com.netcracker.lab.Sex;

public class SexComparator implements Comparator<Human> {
    public int compare(Human first, Human second) {
        if(first.getSex() == Sex.Male) {
            return 1;
        }
        if(first.getSex() == Sex.Female) {
            return 0;
        }
            return -1;
    }
}
