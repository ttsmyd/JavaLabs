public class PatronymicComparator implements Comparator<Human>{
    public int compare(Human first, Human second) {
        return first.getLastName().compareTo(second.getLastName());
    }
}
