package com.netcracker.lab.sorters;

import com.netcracker.lab.Human;
import com.netcracker.lab.HumanRepository;
import com.netcracker.lab.comparators.Comparator;
import org.apache.log4j.Logger;

public class QuickSorter implements Sorter {
    private HumanRepository humanRepository;
    private Comparator comparator;
    private Logger logger = Logger.getLogger(QuickSorter.class);

    public void sort(HumanRepository humanRepository, Comparator comparator) {
        if(logger.isDebugEnabled()) {
            logger.debug("Start sorting in public void sort");
        }
        int low = 0;
        int high = humanRepository.getLengthOfRepositoryWithoutEmptyElements() - 2;

        this.humanRepository = humanRepository;
        this.comparator = comparator;
        quickSort(low, high);
    }

    private void quickSort(int low, int high) {
        if(logger.isDebugEnabled()) {
            logger.debug("Start new method of quck sorting. Low = " + low + "high + " + high);
        }
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

        if(logger.isDebugEnabled()) {
            logger.debug("End of quick sort");
        }
    }
}
