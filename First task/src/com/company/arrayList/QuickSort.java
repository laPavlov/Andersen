package com.company.arrayList;

/**
 * Быстрая сортировка целочисленных значений массива
 */

public class QuickSort {

    /**
     * Метод быстрой сортировки.
     */
    public static ArrayList<Integer> quicksort(ArrayList<Integer> arr, int min, int max) {
        int pivot = (min + max) / 2;
        if (arr.size() <= 1) {
            return arr;
        } else {
            ArrayList<Integer> less = new ArrayListImpl<>();
            ArrayList<Integer> greater = new ArrayListImpl<Integer>();
            ArrayList<Integer> all = new ArrayListImpl<>();
            Integer a = arr.size() - 1;
            for (int i = 0; a >= i; i++) {
                if (pivot != i) {
                    if (arr.get(i) < arr.get(pivot)) {
                        less.add(arr.get(i));
                    } else {
                        greater.add(arr.get(i));
                    }
                }
            }

            less = quicksort(less, 0, less.size());
            greater = quicksort(greater, 0, greater.size());

            all.addAlls(less);
            all.add(arr.get(pivot));
            all.addAlls(greater);
            return all;
        }
    }
}