package com.netcracker.lab.sorters;

import com.netcracker.lab.Human;
import com.netcracker.lab.HumanRepository;
import com.netcracker.lab.comparators.Comparator;
import org.apache.log4j.Logger;

public class InsertSorter implements Sorter {
    private static Logger logger = Logger.getLogger(InsertSorter.class);

    public void sort(HumanRepository humanRepository, Comparator comparator) {
        if(logger.isDebugEnabled()) {
            logger.debug("Start sorting in public void sort");
        }
        int lengthHumanMassive = humanRepository.getLengthOfRepositoryWithoutEmptyElements();

        Human[] destinationArray = new Human[lengthHumanMassive];
        int destinationSize = 0;
        for (int n = 0; n < lengthHumanMassive; n++) {
            int insertIndex = 0;
            if (destinationSize > 0) {
                while ((insertIndex < destinationSize)
                        && (comparator.compare(destinationArray[insertIndex], humanRepository.getHuman(n)) == -1)) {
                    insertIndex++;
                }
            }
            for (int m = destinationSize - 1; m >= insertIndex; m--) {
                destinationArray[m + 1] = destinationArray[m];
            }
            destinationArray[insertIndex] = humanRepository.getHuman(n);
            if(logger.isDebugEnabled()) {
                logger.debug("destinationArray[" + insertIndex + "] = " + destinationArray[insertIndex]);
            }
            destinationSize++;
        }


        if(logger.isDebugEnabled()) {
            logger.debug("Replacing elements");
        }

        for (int i = 0; i < destinationArray.length; i++) {
            humanRepository.replaceHuman(i, destinationArray[i]);
            if(logger.isDebugEnabled()) {
                logger.debug("destinationArray[" + i + "] = " + destinationArray[i]);
            }
        }
        if(logger.isDebugEnabled()) {
            logger.debug("End of sorting");
        }
    }
}
