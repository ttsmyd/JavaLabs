/** Класс служит для запуска приложения
 * @autor Tochilin Dmitry
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) {
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

        Human replaceForH3 = new Human("FReplace3", "NReplace3", "PReplace3", Sex.Male, "1991-03-13");


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
        InsertSorter insertSorter = new InsertSorter();
        DateOfBirthComparator birthComparator = new DateOfBirthComparator();

     //   humanRepository.setRepository(humanRepository.sortHumanRepository(humanRepository, bubbleSorter, birthComparator));
     //   humanRepository.setRepository(humanRepository.sortHumanRepository(humanRepository, insertSorter, birthComparator));

        humanRepository.setRepository(humanRepository.sortHumanRepository(humanRepository, insertSorter, birthComparator));

        for(int i = 0; i < 9; i++) {
            System.out.println(humanRepository.getHuman(i).getDateOfBirth());
           System.out.println(humanRepository.getHuman(i).getDateOfBirth().isBefore(humanRepository.getHuman(i+1).getDateOfBirth()));
        }


        System.out.println("Текущий размер массива в humanRepository по заполнения всех элементов массива = " + humanRepository.getRepository().length);
        System.out.println("\n\n\nВыведем весь репозиторий на экран:");
        writeOutForHumanRepository(humanRepository);

        System.out.println("\n\nИзначально объектом Human с индексом 3 был объект h3:");
        System.out.println(humanRepository.getHuman(3).toString());
        System.out.println("Добавим на его место объект replaceForH3");
        humanRepository.addHuman(3, replaceForH3);
        System.out.println("Был добавлен Human с индексом 3. Теперь на месте элемента с индексом 3:");
        System.out.println(humanRepository.getHuman(3).toString());
        System.out.println("\n\n\nВыведем весь репозиторий на экран:");
        writeOutForHumanRepository(humanRepository);

        System.out.println("\nУдалим новый объект Human находящийся под индексом 3");
        humanRepository.deleteHuman(3);
        System.out.println("\n\n\nВыведем весь репозиторий на экран:");
        writeOutForHumanRepository(humanRepository);
    }


    private static void writeOutForHumanRepository(HumanRepository humanRepository) {
       for(int i = 0; i < humanRepository.getIndexOfNextEmptyElement(); i++) {
           System.out.println(i + "ый элемент репозитория:");
           System.out.println(humanRepository.getHuman(i).toString());
       }
    }
}
