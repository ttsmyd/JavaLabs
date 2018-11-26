public class SexComparator implements Comparator<Human> {
    public int compare(Human first, Human second) {
        return  (first.getSex().compareTo(second.getSex()));
    }
}
