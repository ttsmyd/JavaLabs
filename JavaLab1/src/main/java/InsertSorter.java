public class InsertSorter implements Sorter {
    public Human[] sort(HumanRepository humanRepository, Comparator comparator) {
        Human[] humanMassive = humanRepository.getRepository();
        int lengthHumanMassive = humanRepository.getLengthOfRepositoryWithoutEmptyElements();

        Human[] destinationArray = new Human[lengthHumanMassive];
        int destinationSize = 0;
        for (int n = 0; n < lengthHumanMassive; n++) {
            int insertIndex = 0;
            if (destinationSize > 0) {
                while ((insertIndex < destinationSize)
                        && (comparator.compare(destinationArray[insertIndex], humanMassive[n]) == -1)) {
                    insertIndex++;
                }
            }
            for (int m = destinationSize - 1; m >= insertIndex; m--) {
                destinationArray[m + 1] = destinationArray[m];
            }
            destinationArray[insertIndex] = humanMassive[n];
            destinationSize++;
        }

      //  for (int i = 0; i < humanMassive.length; i++) {
      //      humanMassive[i] = destinationArray[i];
      //  }

        for (int i = 0; i < destinationArray.length; i++) {
            humanMassive[i] = destinationArray[i];
        }

        return humanMassive;
    }
}
