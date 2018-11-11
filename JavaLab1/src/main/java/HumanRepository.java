import java.util.Arrays;

public class HumanRepository {
    private Human[] repository = new Human[10];
    private int indexOfNextEmptyElement = 0;


    public  void addHuman(int indexOfElement, Human humanToAdd) {
        if (indexOfElement == indexOfNextEmptyElement) {
            addHuman(humanToAdd);
        } else {
            indexOfNextEmptyElement++;
            for(int i = indexOfNextEmptyElement; i > indexOfElement; i--) {
                repository[i] = repository[i-1];
            }
            repository[indexOfElement] = humanToAdd;
        }
    }

    public void addHuman(Human human) {
        if (indexOfNextEmptyElement == (repository.length - 1)) {
            repository = increaseMassive();
        }
        repository[indexOfNextEmptyElement] = human;
        indexOfNextEmptyElement++;
    }

    public Human getHuman(int indexOfElement) {
        return repository[indexOfElement];
    }

    public void deleteHuman(int indexOfElement) {
        for (int i = indexOfElement; i < indexOfNextEmptyElement - 1; i++) {
            repository[i] = repository[i + 1];
        }
        indexOfNextEmptyElement--;
        repository[indexOfNextEmptyElement] = null;

        if (repository.length/indexOfNextEmptyElement >= 2) {
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

    @Override
    public String toString() {
        return "HumanRepository{" +
                "repository=" + Arrays.toString(repository) +
                ", indexOfNextEmptyElement=" + indexOfNextEmptyElement +
                '}';
    }
}
