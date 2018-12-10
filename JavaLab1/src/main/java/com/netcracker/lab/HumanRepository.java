package com.netcracker.lab;

import com.netcracker.lab.checkers.AgeChecker;
import com.netcracker.lab.checkers.Checker;
import com.netcracker.lab.comparators.Comparator;
import com.netcracker.lab.sorters.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Сохраняет, хранит, удаляет и предоставляет классы типа
 * @link com.netcracker.lab.Human
 * @author Tochilin Dmitry
 * @version 1.0
 */

public class HumanRepository {
    /** Свойство - список людей.
     Хранит все добавленные в класс данные
     */
    private static final Logger logger = Logger.getLogger(Human.class);

    private Human[] repository = new Human[10];

    /** Свойство - номер следующего элемента, доступного к заполнению
     Хранит первое пустое поле в
     @link com.netcracker.lab.Human
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
                if(logger.isDebugEnabled()) {
                    logger.debug("repository[" + i + "] = " + repository[i]);
                }
            }
            repository[indexOfElement] = humanToAdd;
        }
        if(logger.isInfoEnabled()) {
            logger.info("Human" + indexOfElement +  "was added");
        }
    }

    /**Функция добавления элемента {@link HumanRepository#repository}
     */
    public void addHuman(Human humanToAdd) {
        checkSizeMassiveToIncrease();
        repository[indexOfNextEmptyElement] = humanToAdd;
        indexOfNextEmptyElement++;
        if(logger.isInfoEnabled()) {
            logger.info("New human was added");
        }
    }

    public void replaceHuman(int indexOfElement, Human humanToReplace) {
        repository[indexOfElement] = humanToReplace;
        if(logger.isInfoEnabled()) {
            logger.info("Human " + indexOfElement + " was replaced");
        }
    }
    /** Функция получения элемента {@link HumanRepository#repository}
     * @return объект человека
     */
    public Human getHuman(int indexOfElement) {
        checkIndexToNotEmptyElementsInRepository(indexOfElement);
        if(logger.isInfoEnabled()) {
            logger.info("Human " + indexOfElement + " was getted");
        }
        return repository[indexOfElement];
    }

    /** Функция удаления элемента для массива {@link HumanRepository#repository}
     */
    public void deleteHuman(int indexOfElement) {
        checkIndexToNotEmptyElementsInRepository(indexOfElement);
        for (int i = indexOfElement; i < indexOfNextEmptyElement - 1; i++) {
            repository[i] = repository[i + 1];
            if(logger.isDebugEnabled()) {
                logger.debug("repository[" + i + "] = " + repository[i]);
            }
        }
        indexOfNextEmptyElement--;
        repository[indexOfNextEmptyElement] = null;
        checkSizeMassiveToDecrease();
        if(logger.isInfoEnabled()) {
            logger.info("Human with index " + indexOfElement + " was deleted");
        }
    }

    /** Функция проверки на запрос пустого элемента {@link HumanRepository#repository}
     * Функция проверяет, находится ли индекс запрашиваемого объекта в диапазоне текущих значений репозитория.
     * @throws ArrayIndexOutOfBoundsException
     */
    private void checkIndexToNotEmptyElementsInRepository(int indexOfElement) {
        if (indexOfElement > indexOfNextEmptyElement) {
            ArrayIndexOutOfBoundsException error = new ArrayIndexOutOfBoundsException();
            logger.error("Sorry, something wrong! ArrayIndexOutOfBoundsException: ", error);
            throw error;
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

    public void sortHumanRepository(HumanRepository humanRepository, Sorter sorter, Comparator comparator){
        if(logger.isInfoEnabled()) {
            logger.info("Sorting elements start");
        }
        sorter.sort(humanRepository, comparator);
        if(logger.isInfoEnabled()) {
            logger.info("Sorting elements ends");
        }
    }

    public List searchBy(Checker checker, Object value) {
        if(logger.isInfoEnabled()) {
            logger.info("Searching elements start");
        }
        ArrayList results = new ArrayList();
        for(int i = 0; i < indexOfNextEmptyElement - 1; i++) {
            if (checker.check(repository[i], value)) {
                results.add(value);
                if(logger.isDebugEnabled()) {
                    logger.debug("Results #" + i + " = " + results.toString());
                }
            }
        }
        logger.info("Results of searching was checked");
        logger.info(results.toString());
        return results;
    }


}
