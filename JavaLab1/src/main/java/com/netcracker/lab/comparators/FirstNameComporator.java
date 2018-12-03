package com.netcracker.lab.comparators;
import com.netcracker.lab.Human;

public class FirstNameComporator implements Comparator<Human> {
    public int compare(Human first, Human second) {
        int i = first.getFirstName().compareTo(second.getFirstName());
                if (i < 0) {
                    return -1;
                }
                if (i > 0) {
                    return 1;
                }
                    return 0;
    }
}
