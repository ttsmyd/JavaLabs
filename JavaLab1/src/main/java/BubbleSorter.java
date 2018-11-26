public class BubbleSorter implements Sorter {
    public Human[] sort(HumanRepository humanRepository, Comparator comparator) {
        int n = humanRepository.getLengthOfRepositoryWithoutEmptyElements();
        Human[] humanMassive = humanRepository.getRepository();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(humanMassive[j], humanMassive[j + 1]) == 1) {
                    // swap temp and arr[i]
                    Human temp = humanMassive[j];
                    humanMassive[j] = humanMassive[j + 1];
                    humanMassive[j + 1] = temp;
                }
            }
        }


        return humanMassive;
    }
}
