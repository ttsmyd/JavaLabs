package sorters;

public class BubbleSorter implements Sorter {
    public void sort(HumanRepository humanRepository, Comparator comparator) {
        int n = humanRepository.getLengthOfRepositoryWithoutEmptyElements();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(humanRepository.getHuman(j), humanRepository.getHuman(j+1)) == 1) {
                    // swap temp and arr[i]
                    Human temp = humanRepository.getHuman(j);
                    humanRepository.replaceHuman(j, humanRepository.getHuman(j+1));
                    humanRepository.replaceHuman(j + 1, temp);
                }
            }
        }
    }
}
