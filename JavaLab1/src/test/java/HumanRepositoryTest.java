import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HumanRepositoryTest {

    @Test
    public void addHuman() {
        Human h0 = new Human("f0", "n0", "o0", Sex.Male, "1999-04-12");
        Human h1 = new Human("f1", "n1", "o1", Sex.Female, "1993-06-11");
        Human h2 = new Human("f2", "n2", "o2", Sex.Male, "1995-03-14");
        Human h3 = new Human("f3", "n3", "o3", Sex.Male, "1993-07-17");
        Human h4 = new Human("f4", "n4", "o4", Sex.Female, "1983-06-13");
        Human h5 = new Human("f5", "n5", "o5", Sex.Male, "1992-02-13");
        Human h6 = new Human("f6", "n6", "o6", Sex.Male, "1993-08-16");
        Human h7 = new Human("f7", "n7", "o7", Sex.Male, "1992-09-18");
        Human h8 = new Human("f8", "n8", "o8", Sex.Female, "1991-05-19");
        Human h9 = new Human("f9", "n9", "o9", Sex.Male, "1991-03-13");
        Human h10 = new Human("f10", "n10", "o10", Sex.Male, "1991-03-13");
        HumanRepository humanRepository = new HumanRepository();
        humanRepository.addHuman(h0);
        humanRepository.addHuman(h1);
        humanRepository.addHuman(h2);
        humanRepository.addHuman(h3);
        humanRepository.addHuman(h4);
        humanRepository.addHuman(h5);
        humanRepository.addHuman(h6);
        humanRepository.addHuman(h7);
        humanRepository.addHuman(h8);
        humanRepository.addHuman(h9);
        humanRepository.addHuman(h10);
        //assertEquals();
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
        Human h0 = new Human("f0", "n0", "o0", Sex.Male, "1999-04-12");
        Human h1 = new Human("f1", "n1", "o1", Sex.Female, "1993-06-11");
        Human h2 = new Human("f2", "n2", "o2", Sex.Male, "1995-03-14");
        Human h3 = new Human("f3", "n3", "o3", Sex.Male, "1993-07-17");
        Human h4 = new Human("f4", "n4", "o4", Sex.Female, "1983-06-13");
        Human h5 = new Human("f5", "n5", "o5", Sex.Male, "1992-02-13");
        Human h6 = new Human("f6", "n6", "o6", Sex.Male, "1993-08-16");
        Human h7 = new Human("f7", "n7", "o7", Sex.Male, "1992-09-18");
        Human h8 = new Human("f8", "n8", "o8", Sex.Female, "1991-05-19");
        Human h9 = new Human("f9", "n9", "o9", Sex.Male, "1991-03-13");
        Human h10 = new Human("f10", "n10", "o10", Sex.Male, "1991-03-13");
        HumanRepository humanRepository = new HumanRepository();

        humanRepository.addHuman(h0);
        humanRepository.addHuman(h1);
        humanRepository.addHuman(h2);
        humanRepository.addHuman(h3);
        humanRepository.addHuman(h4);
        humanRepository.addHuman(h5);
        humanRepository.addHuman(h6);
        humanRepository.addHuman(h7);
        humanRepository.addHuman(h8);
        humanRepository.addHuman(h9);
        humanRepository.addHuman(h10);
        BubbleSorter bubbleSorter = new BubbleSorter();
        DateOfBirthComparator birthComparator = new DateOfBirthComparator();


        humanRepository.setRepository(humanRepository.sortHumanRepository(humanRepository, bubbleSorter, birthComparator));

        for(int i = 0; i < 9; i++) {
            Assert.assertTrue(humanRepository.getHuman(i).getDateOfBirth().isBefore(humanRepository.getHuman(i+1).getDateOfBirth()));
        }
    }
}