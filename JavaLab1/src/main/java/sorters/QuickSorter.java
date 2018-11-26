package sorters;

public class QuickSorter implements Sorter {
    private HumanRepository humanRepository;
    private Comparator comparator;

    public void sort(HumanRepository humanRepository, Comparator comparator) {
        int low = 0;
        int high = humanRepository.getLengthOfRepositoryWithoutEmptyElements() - 2;

        this.humanRepository = humanRepository;
        this.comparator = comparator;
        quickSort(low, high);
    }

    private void quickSort(int low, int high) {

        int middle = low + (high - low) / 2;
        Human pivot = humanRepository.getHuman(middle);
        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (comparator.compare(humanRepository.getHuman(i), pivot) == -1) {
                i++;
            }

            while (comparator.compare(humanRepository.getHuman(j), pivot) == 1) {
                j--;
            }

            if (i <= j) {
                Human temp = humanRepository.getHuman(i);
                humanRepository.replaceHuman(i, humanRepository.getHuman(j));
                humanRepository.replaceHuman(j, temp);
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(low, j);
        }
        if (i < high) {
            quickSort(i, high);
        }


    }
}
