/**
 * Сохраняет, хранит, удаляет и предоставляет классы типа
 * @link Human
 * @author Tochilin Dmitry
 * @version 1.0
 */

public class HumanRepository {
    /** Свойство - список людей.
     Хранит все добавленные в класс данные
     */
    private Human[] repository = new Human[10];

    /** Свойство - номер следующего элемента, доступного к заполнению
     Хранит первое пустое поле в
     @link Human
     */
    private int indexOfNextEmptyElement = 0;

    /**Функция добавления элемента {@link HumanRepository#repository}
     */
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

    /**Функция добавления элемента {@link HumanRepository#repository}
     */
    public void addHuman(Human humanToAdd) {
        checkSizeMassiveToIncrease();
        repository[indexOfNextEmptyElement] = humanToAdd;
        indexOfNextEmptyElement++;
    }

    /** Функция получения элемента {@link HumanRepository#repository}
     * @return объект человека
     */
    public Human getHuman(int indexOfElement) {
        checkIndexToNotEmptyElementsInRepository(indexOfElement);
        return repository[indexOfElement];
    }

    /** Функция удаления элемента для массива {@link HumanRepository#repository}
     */
    public void deleteHuman(int indexOfElement) {
        checkIndexToNotEmptyElementsInRepository(indexOfElement);
        for (int i = indexOfElement; i < indexOfNextEmptyElement - 1; i++) {
            repository[i] = repository[i + 1];
        }
        indexOfNextEmptyElement--;
        repository[indexOfNextEmptyElement] = null;
        checkSizeMassiveToDecrease();
    }

    /** Функция проверки на запрос пустого элемента {@link HumanRepository#repository}
     * Функция проверяет, находится ли индекс запрашиваемого объекта в диапазоне текущих значений репозитория.
     * @throws ArrayIndexOutOfBoundsException
     */
    private void checkIndexToNotEmptyElementsInRepository(int indexOfElement) {
        if (indexOfElement > indexOfNextEmptyElement) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /** Функция проверки на необходимость увеличения для увеличения {@link HumanRepository#repository}
     */
    private void checkSizeMassiveToIncrease(){
        if (indexOfNextEmptyElement == (repository.length - 1)) {
            repository = increaseMassive();
        }
    }

    /** Функция проверки на необходимость уменьшения для массива {@link HumanRepository#repository}
     */
    private void checkSizeMassiveToDecrease() {
        if ((indexOfNextEmptyElement != 0) && (repository.length / indexOfNextEmptyElement >= 4)) {
            repository = decreaseMassive();
        }
    }

    /** Функция для увеличения массива {@link HumanRepository#repository}
     * @return Возвращает массив нового размера
     */
    private Human[] increaseMassive(){
        Human[] newRepository = new Human[repository.length*2];
        for (int i = 0; i < repository.length - 1; i++) {
            newRepository[i] = repository[i];
        }
        return newRepository;
    }

    /** Функция для уменьшения массива {@link HumanRepository#repository}
     * @return Возвращает массив нового размера
     */
    private Human[] decreaseMassive() {
        Human[] newRepository = new Human[indexOfNextEmptyElement];
        for (int i = 0; i < indexOfNextEmptyElement; i++) {
            newRepository[i] = repository[i];
        }
        return newRepository;
    }

    /** Функция для получения значения поля {@link HumanRepository#repository}
     * @return Возвращает массив со всеми людьми
     */
    public Human[] getRepository() {
        return repository;
    }

    /** Функция для получения значения поля {@link HumanRepository#indexOfNextEmptyElement}
     * @return Возвращает номер следующего элемента, доступного к заполнению
     */
    public int getIndexOfNextEmptyElement() {
        return indexOfNextEmptyElement;
    }

    public int getLengthOfRepositoryWithoutEmptyElements() {
        return indexOfNextEmptyElement;
    }

    public Human[] sortHumanRepository(HumanRepository humanRepository, Sorter sorter, Comparator comparator){
        return sorter.sort(humanRepository, comparator);

    }

    public void setRepository(Human[] repository) {
        this.repository = repository;
    }
}
