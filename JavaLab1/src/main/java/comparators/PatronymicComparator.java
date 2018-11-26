package comparators;

import comparators.Comparator;

public class PatronymicComparator implements Comparator<Human> {
    public int compare(Human first, Human second) {
        int i = first.getPatronymic().compareTo(second.getPatronymic());
        if (i < 0) {
            return -1;
        }
        if (i > 0) {
            return 1;
        }
        return 0;
    }
}
