public class QuickSorter implements Sorter {
    public Human[] sort(HumanRepository humanRepository, Comparator comparator) {
        Human[] humanMassive = humanRepository.getRepository();
        int low = 0;
        int high = humanRepository.getLengthOfRepositoryWithoutEmptyElements() - 1;

        return quickSort(humanMassive, low, high, comparator);
    }

    private Human[] quickSort(Human[] human, int low, int high, Comparator comparator) {
        if (human == null || human.length == 0)
            throw new NullPointerException();

        if (low >= high)
            throw new ArrayIndexOutOfBoundsException();

        int middle = low + (high - low) / 2;
        Human pivot = human[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j) {
            while (comparator.compare(human[i], pivot) == -1) {
                i++;
            }

            while (comparator.compare(human[i], pivot) == 1) {
                j--;
            }

            if (i <= j) {
                Human temp = human[i];
                human[i] = human[j];
                human[j] = temp;
                i++;
                j--;
            }
        }
        return human;
    }
}
