package shell2;

public class ShellSorter {
    public static void shellsort(int[] arr) {
        //подсчет размера шага для сравнения
        for(int gap = arr.length / 2; gap > 0; gap = gap/2) {
            //подсчет количества потоков, сравнивающих элементы через шаг
            int countOfThreads = arr.length - gap;
            ShellSorterThread[] shellSorterThreads = new ShellSorterThread[countOfThreads];
            //запуск потоков
            for (int i = 0; i < countOfThreads; i++) {
                shellSorterThreads[i] = new ShellSorterThread(gap, gap + i);
                shellSorterThreads[i].start();
            }

            try {
                for (final ShellSorterThread shellSorterThread : shellSorterThreads)
                    shellSorterThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
