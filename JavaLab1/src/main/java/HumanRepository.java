import java.util.Arrays;

public class HumanRepository {
    private Human[] repository = new Human[10];
    private int indexOfNextEmptyElement = 0;


    public  void addHuman(int indexOfElement, Human humanToAdd) {
        checkIndexToNotEmptyElementsInRepository(indexOfElement);
        if (indexOfElement == indexOfNextEmptyElement) {
            addHuman(humanToAdd);
        } else {
            checkSizeMassiveToIncrease();
            indexOfNextEmptyElement++;
            for(int i = indexOfNextEmptyElement; i > indexOfElement; i--) {
                repository[i] = repository[i-1];
            }
            repository[indexOfElement] = humanToAdd;
        }
    }

    public void addHuman(Human humanToAdd) {
        checkSizeMassiveToIncrease();
        repository[indexOfNextEmptyElement] = humanToAdd;
        indexOfNextEmptyElement++;
    }

    public Human getHuman(int indexOfElement) {
        checkIndexToNotEmptyElementsInRepository(indexOfElement);
        return repository[indexOfElement];
    }

    public void deleteHuman(int indexOfElement) {
        checkIndexToNotEmptyElementsInRepository(indexOfElement);
        for (int i = indexOfElement; i < indexOfNextEmptyElement - 1; i++) {
            repository[i] = repository[i + 1];
        }
        indexOfNextEmptyElement--;
        repository[indexOfNextEmptyElement] = null;
        checkSizeMassiveToDecrease();
    }


    private void checkIndexToNotEmptyElementsInRepository(int indexOfElement) {
        if (indexOfElement > indexOfNextEmptyElement) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void checkSizeMassiveToIncrease(){
        if (indexOfNextEmptyElement == (repository.length - 1)) {
            repository = increaseMassive();
        }
    }

    private void checkSizeMassiveToDecrease() {
        if ((indexOfNextEmptyElement != 0) && (repository.length / indexOfNextEmptyElement >= 4)) {
            repository = decreaseMassive();
        }
    }

    private Human[] increaseMassive(){
        Human[] newRepository = new Human[repository.length*2];
        for (int i = 0; i < repository.length - 1; i++) {
            newRepository[i] = repository[i];
        }
        return newRepository;
    }

    private Human[] decreaseMassive() {
        Human[] newRepository = new Human[indexOfNextEmptyElement];
        for (int i = 0; i < indexOfNextEmptyElement; i++) {
            newRepository[i] = repository[i];
        }
        return newRepository;
    }

    public Human[] getRepository() {
        return repository;
    }

    public int getIndexOfNextEmptyElement() {
        return indexOfNextEmptyElement;
    }
}
