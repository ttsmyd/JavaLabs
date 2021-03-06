package com.netcracker.lab.comparators;
import com.netcracker.lab.Human;

public class IdComparator implements Comparator<Human> {
    public int compare(Human first, Human second) {
        return first.getId().compareTo(second.getId());
    }
}
