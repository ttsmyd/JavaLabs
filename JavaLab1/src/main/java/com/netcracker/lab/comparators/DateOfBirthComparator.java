package com.netcracker.lab.comparators;
import com.netcracker.lab.Human;

public class DateOfBirthComparator implements Comparator<Human> {
    public int compare(Human first, Human second) {
      if(first.getDateOfBirth().isAfter(second.getDateOfBirth())) {
          return 1;
      }
      if(first.getDateOfBirth().isBefore(second.getDateOfBirth())) {
          return -1;
      } else {
          return 0;
      }
    }
}
