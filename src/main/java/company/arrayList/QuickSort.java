package company.arrayList;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Быстрая сортировка массива
 */
public class QuickSort {

//public class QuickSort<T> {
//    public ArrayList<T> quicksort(ArrayList<T> arr, int min, int max) {
//        int pivot = (min + max) / 2;
//        if (arr.size() <= 1) {
//            return arr;
//        } else {
//            ArrayList<T> less = new ArrayList<>();
//            ArrayList<T> greater = new ArrayList<>();
//            ArrayList<T> all = new ArrayList<>();
//            Integer a = arr.size() - 1;
//            for (int i = 0; a >= i; i++) {
//                if (pivot != i) {
//                    if (arr.get(i).hashCode() < arr.get(pivot).hashCode()) {
//                        less.add(arr.get(i));
//                    } else {
//                        greater.add(arr.get(i));
//                    }
//                }
//            }
//
//            less = quicksort(less, 0, less.size());
//            greater = quicksort(greater, 0, greater.size());
//
//            all.addAll(less);
//            all.add(arr.get(pivot));
//            all.addAll(greater);
//            return all;
//        }
//    }
//}
}