package com.netcracker.lab.sorters;
import com.netcracker.lab.HumanRepository;
import com.netcracker.lab.comparators.Comparator;

public interface Sorter {
    public void sort(HumanRepository humanRepository, Comparator comparator);
}
