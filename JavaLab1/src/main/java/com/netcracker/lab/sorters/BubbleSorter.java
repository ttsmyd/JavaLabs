package com.netcracker.lab.sorters;
import com.netcracker.lab.*;
import com.netcracker.lab.comparators.Comparator;
import org.apache.log4j.Logger;

public class BubbleSorter implements Sorter {
    private  static  Logger logger = Logger.getLogger(BubbleSorter.class);

    public void sort(HumanRepository humanRepository, Comparator comparator) {
        if(logger.isDebugEnabled()) {
            logger.debug("Start sorting in public void sort");
        }
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
            if(logger.isDebugEnabled()) {
                logger.debug("HumanRepository i element " + humanRepository.getHuman(i));
            }
        }
        if(logger.isDebugEnabled()) {
            logger.debug("End sorting in public void sort");
        }
    }
}
