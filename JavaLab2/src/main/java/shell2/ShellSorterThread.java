package shell2;

import static shell2.Main.arr;

public class ShellSorterThread extends Thread {
    private int gap;
    private int index;

    //Поток принимает размер шага и крайний индекс элемента, с котторого начинает сравнение
    public ShellSorterThread(int gap, int index) {
        this.gap = gap;
        this.index = index;
    }

    //Происходит сортировка вставками
    @Override
    public void run() {
        int j;
            int tmp = arr[index];
            for(j = index; (j >= gap) && (tmp < arr[j - gap]); j = j - gap ) {
                arr[j] = arr[j - gap];
            }
            arr[j] = tmp;
    }
}
