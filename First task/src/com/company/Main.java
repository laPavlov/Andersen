package com.company;

import com.company.arrayList.ArrayList;
import com.company.arrayList.ArrayListImpl;

import static com.company.arrayList.QuickSort.quicksort;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayListImpl<>();
        list.add(45);
        list.add(14);
        list.add(85);
        list.add(6);
        list.add(78);
        list.add(32);
        list.add(1);
        list.add(8);
        list.add(69);
        list.add(8);

        System.out.println(list.size());
        System.out.println(list);
        list = quicksort(list,0,list.size());


        System.out.println(list.size());
        System.out.println(list);
    }
}
