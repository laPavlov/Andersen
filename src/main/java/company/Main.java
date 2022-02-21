package company;


import company.arrayList.ArrayList;
import company.arrayList.Com;
import company.arrayList.People;
import company.arrayList.QuickSort;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<People> list = new ArrayList<>();

        People people1 = new People(96, "Artem");
        People people2 = new People(8, "Gtg");
        People people3 = new People(75, "gFtt");
        People people4 = new People(68, "gFtt");
        People people5 = new People(42, "gFtt");
        list.add(people1);
        list.add(people2);
        list.add(people3);
        list.add(people4);
        list.add(people5);

        Com comparator = new Com();
        list.sort(comparator);



        System.out.println(list.get(0).getId() + " " + list.get(0).getName());
        System.out.println(list.get(1).getId() + " " + list.get(1).getName());
        System.out.println(list.get(2).getId() + " " + list.get(2).getName());
        System.out.println(list.get(3).getId() + " " + list.get(3).getName());
        System.out.println(list.get(4).getId() + " " + list.get(4).getName());


    }
}
