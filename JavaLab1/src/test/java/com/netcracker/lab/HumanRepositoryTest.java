package com.netcracker.lab;

import com.netcracker.lab.checkers.*;
import com.netcracker.lab.comparators.AgeComparator;
import com.netcracker.lab.comparators.DateOfBirthComparator;
import com.netcracker.lab.comparators.FirstNameComporator;
import com.netcracker.lab.comparators.LastNameComparator;
import com.netcracker.lab.sorters.BubbleSorter;
import com.netcracker.lab.sorters.InsertSorter;
import com.netcracker.lab.sorters.QuickSorter;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class HumanRepositoryTest {

  //  public static Logger logger = new Logger(HumanRepositoryTest.class);

    @Test
    public void addHuman() {
        List<Human> humans = Arrays.asList(
                new Human[]{new Human("f0", "n0", "o0", Sex.Male, "1999-04-12"),
                        new Human("f1", "n1", "o1", Sex.Female, "1993-06-11"),
                        new Human("f2", "n2", "o2", Sex.Male, "1995-03-14"),
                        new Human("f3", "n3", "o3", Sex.Male, "1993-07-17"),
                        new Human("f4", "n4", "o4", Sex.Female, "1983-06-13"),
                        new Human("f5", "n5", "o5", Sex.Male, "1992-02-13"),
                        new Human("f6", "n6", "o6", Sex.Male, "1993-08-16"),
                        new Human("f7", "n7", "o7", Sex.Male, "1992-09-18"),
                        new Human("f8", "n8", "o8", Sex.Female, "1991-05-19"),
                        new Human("f9", "n9", "o9", Sex.Male, "1991-03-13"),
                        new Human("f10", "n10", "o10", Sex.Male, "1991-03-13")});

        HumanRepository humanRepository = new HumanRepository();
        humans.forEach(human -> humanRepository.addHuman(human));
    }

    @Test
    public void addHuman1() {
    }

    @Test
    public void getHuman() {

    }

    @Test
    public void deleteHuman() {
    }

    @Test
    public void getRepository() {
    }

    @Test
    public void getIndexOfNextEmptyElement() {
    }

    @Test
    public void getLengthOfRepositoryWithoutEmptyElements() {
    }

    @Test
    public void sortHumanRepository() {
       // Human h0 = new Human("f0", "n0", "o0", Sex.Male, "1999-04-12");
       // Human h1 = new Human("f1", "n1", "o1", Sex.Female, "1993-06-11");
       // Human h2 = new Human("f2", "n2", "o2", Sex.Male, "1995-03-14");
       // Human h3 = new Human("f3", "n3", "o3", Sex.Male, "1993-07-17");
       // Human h4 = new Human("f4", "n4", "o4", Sex.Female, "1983-06-13");
       // Human h5 = new Human("f5", "n5", "o5", Sex.Male, "1992-02-13");
       // Human h6 = new Human("f6", "n6", "o6", Sex.Male, "1993-08-16");
       // Human h7 = new Human("f7", "n7", "o7", Sex.Male, "1992-09-18");
       // Human h8 = new Human("f8", "n8", "o8", Sex.Female, "1991-05-19");
       // Human h9 = new Human("f9", "n9", "o9", Sex.Male, "1991-03-13");
       // Human h10 = new Human("f10", "n10", "o10", Sex.Male, "1991-03-13");
       // HumanRepository humanRepository = new HumanRepository();
//
       // humanRepository.addHuman(h0);
       // humanRepository.addHuman(h1);
       // humanRepository.addHuman(h2);
       // humanRepository.addHuman(h3);
       // humanRepository.addHuman(h4);
       // humanRepository.addHuman(h5);
       // humanRepository.addHuman(h6);
       // humanRepository.addHuman(h7);
       // humanRepository.addHuman(h8);
       // humanRepository.addHuman(h9);
       // humanRepository.addHuman(h10);

        List<Human> humans = Arrays.asList(
                new Human[]{new Human("f0", "n0", "o0", Sex.Male, "1999-04-12"),
                        new Human("f1", "n1", "o1", Sex.Female, "1993-06-11"),
                        new Human("f2", "n2", "o2", Sex.Male, "1995-03-14"),
                        new Human("f3", "n3", "o3", Sex.Male, "1993-07-17"),
                        new Human("f4", "n4", "o4", Sex.Female, "1983-06-13"),
                        new Human("f5", "n5", "o5", Sex.Male, "1992-02-13"),
                        new Human("f6", "n6", "o6", Sex.Male, "1993-08-16"),
                        new Human("f7", "n7", "o7", Sex.Male, "1992-09-18"),
                        new Human("f8", "n8", "o8", Sex.Female, "1991-05-19"),
                        new Human("f9", "n9", "o9", Sex.Male, "1991-03-13"),
                        new Human("f10", "n10", "o10", Sex.Male, "1991-03-13")});

        HumanRepository humanRepository = new HumanRepository();
        humans.forEach(human -> humanRepository.addHuman(human));
        BubbleSorter bubbleSorter = new BubbleSorter();
        InsertSorter insertSorter = new InsertSorter();
        QuickSorter quickSorter = new QuickSorter();
        DateOfBirthComparator birthComparator = new DateOfBirthComparator();
        AgeComparator ageComparator = new AgeComparator();
        FirstNameComporator firstNameComporator = new FirstNameComporator();
        LastNameComparator lastNameComparator = new LastNameComparator();




        humanRepository.sortHumanRepository(humanRepository, bubbleSorter, ageComparator);
        for (int i = 0; i < 9; i++) {
            int first = humanRepository.getHuman(i).getAge();
            int second = humanRepository.getHuman(i + 1).getAge();
                    Assert.assertTrue(first <= second);
        }

        humanRepository.sortHumanRepository(humanRepository, insertSorter, firstNameComporator);
        for (int i = 0; i < 9; i++) {
            String firstFirstName = humanRepository.getHuman(i).getFirstName();
            String secondFirstName= humanRepository.getHuman(i + 1).getFirstName();

            Assert.assertTrue(firstFirstName. compareTo(secondFirstName) <= 0);
        }

        humanRepository.sortHumanRepository(humanRepository, insertSorter, firstNameComporator);
        for (int i = 0; i < 9; i++) {
            String firstFirstName = humanRepository.getHuman(i).getLastName();
            String secondFirstName= humanRepository.getHuman(i + 1).getLastName();
            Assert.assertTrue(firstFirstName.compareTo(secondFirstName) <= 0);
        }

        humanRepository.sortHumanRepository(humanRepository, insertSorter, birthComparator);
        for (int i = 0; i < 9; i++) {
            LocalDate firstDate = humanRepository.getHuman(i).getDateOfBirth();
            LocalDate secondDate = humanRepository.getHuman(i + 1).getDateOfBirth();
            Assert.assertTrue(firstDate.isBefore(secondDate) || firstDate.isEqual(secondDate));
        }

        humanRepository.sortHumanRepository(humanRepository, quickSorter, birthComparator);
        for (int i = 0; i < 9; i++) {
            LocalDate firstDate = humanRepository.getHuman(i).getDateOfBirth();
            LocalDate secondDate = humanRepository.getHuman(i + 1).getDateOfBirth();
            Assert.assertTrue(firstDate.isBefore(secondDate) || firstDate.isEqual(secondDate));
        }
    }

        @Test
        public void searchBy(){
            addHuman();
            List<Human> humans = Arrays.asList(
            new Human[]{new Human("f0", "n0", "o0", Sex.Male, "1999-04-12"),
                    new Human("f1", "n1", "o1", Sex.Female, "1993-06-11"),
                    new Human("f2", "n2", "o2", Sex.Male, "1995-03-14"),
                    new Human("f3", "n3", "o3", Sex.Male, "1993-07-17"),
                    new Human("f4", "n4", "o4", Sex.Female, "1983-06-13"),
                    new Human("f5", "n5", "o5", Sex.Male, "1992-02-13"),
                    new Human("f6", "n6", "o6", Sex.Male, "1993-08-16"),
                    new Human("f7", "n7", "o7", Sex.Male, "1992-09-18"),
                    new Human("f8", "n8", "o8", Sex.Female, "1991-05-19"),
                    new Human("f9", "n9", "o9", Sex.Male, "1991-03-13"),
                    new Human("f10", "n10", "o10", Sex.Male, "1991-03-13")});
            HumanRepository humanRepository = new HumanRepository();
            humans.forEach(human -> humanRepository.addHuman(human));
            List humanRepositoryList;
            Checker lastNameChecker = new LastNameChecker();
            for (int i = 0; i < 9; i++) {
                humanRepositoryList = humanRepository.searchBy(lastNameChecker, humanRepository.getHuman(i).getLastName());
                for (int j = 0; j < humanRepositoryList.size() - 1; j++) {
                    humanRepositoryList.get(j);
                    Assert.assertEquals(humanRepository.getHuman(i).getLastName(), humanRepositoryList.get(j));
                }
            }

            Checker firstNameChecker = new FirstNameChecker();
            for (int i = 0; i < 9; i++) {
                humanRepositoryList = humanRepository.searchBy(firstNameChecker, humanRepository.getHuman(i).getFirstName());
                for (int j = 0; j < humanRepositoryList.size() - 1; j++) {
                    humanRepositoryList.get(j);
                    Assert.assertEquals(humanRepository.getHuman(i).getFirstName(), humanRepositoryList.get(j));
                }
            }

            Checker ageChecker = new AgeChecker();
            for (int i = 0; i < 9; i++) {
                humanRepositoryList = humanRepository.searchBy(ageChecker, humanRepository.getHuman(i).getAge());
                for (int j = 0; j < humanRepositoryList.size() - 1; j++) {
                    humanRepositoryList.get(j);
                    Assert.assertEquals(humanRepository.getHuman(i).getAge(), humanRepositoryList.get(j));
                }
            }

            Checker dateOfBirthChecker= new DateOfBirthChecker();
            for (int i = 0; i < 9; i++) {
                humanRepositoryList = humanRepository.searchBy(dateOfBirthChecker, humanRepository.getHuman(i).getDateOfBirth());
                for (int j = 0; j < humanRepositoryList.size() - 1; j++) {
                    humanRepositoryList.get(j);
                    Assert.assertEquals(humanRepository.getHuman(i).getDateOfBirth(), humanRepositoryList.get(j));
                }
            }

            Checker sexChecker= new SexChecker();
            for (int i = 0; i < 9; i++) {
                humanRepositoryList = humanRepository.searchBy(sexChecker, humanRepository.getHuman(i).getSex());
                for (int j = 0; j < humanRepositoryList.size() - 1; j++) {
                    humanRepositoryList.get(j);
                    Assert.assertEquals(humanRepository.getHuman(i).getSex(), humanRepositoryList.get(j));
                }
            }

    }
}