package company.arrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName(value = "ArrayList is working when")
class ArrayListTest {
    ArrayList<People> testList = new ArrayList<>();


    @ParameterizedTest
    @ValueSource(ints = {5, 4, 8, 9, 8})
    void addElement(int number) {
        assertTrue(testList.add(number));
    }


    @Test
    void get() {
        People people1 = new People(96, "Artem");
        testList.add(people1);

        People expected = testList.get(0);

        assertEquals(expected, people1);
    }

    @Test
    void set() {
        People people1 = new People(96, "Artem");
        People people2 = new People(54, "Maksim");
        People test1 = testList.set(5500, people1);
        testList.add(people1);
        People test2 = testList.set(0, people2);
        assertNull(test1);
        assertEquals(test2, people1);
    }

    @Test
    void isEmpty() {
        assertTrue(testList.isEmpty());
        People people1 = new People(96, "Artem");
        testList.add(people1);
        assertFalse(testList.isEmpty());
    }

    @Test
    void add() {
        People people1 = new People(96, "Artem");
        assertTrue(testList.add(people1));
    }

    @Test
    void addAll() {
        People people1 = new People(96, "Artem");
        People people2 = new People(8, "Gtg");
        ArrayList<People> arrayList = new ArrayList<>();
        arrayList.add(people1);
        arrayList.add(people2);
        assertTrue(testList.addAll(arrayList));


    }

    @Test
    void size() {
        People people1 = new People(96, "Artem");
        People people2 = new People(8, "Gtg");
        People people3 = new People(75, "gFtt");
        People people4 = new People(68, "gFtt");
        People people5 = new People(42, "gFtt");
        testList.add(people1);
        testList.add(people2);
        testList.add(people3);
        testList.add(people4);
        testList.add(people5);
        assertEquals(5, testList.size());
    }

    @Test
    void remove() {
        People people1 = new People(96, "Artem");
        People people2 = new People(54, "Maksim");
        People test1 = testList.set(5500, people1);
        testList.add(people1);
        People test2 = testList.set(0, people2);
        assertNull(test1);
        assertEquals(test2, people1);
    }

    @Test
    void contains() {
        People people1 = new People(96, "Artem");
        People people2 = new People(54, "Maksim");
        testList.add(people1);
        assertTrue(testList.contains(people1));
        assertFalse(testList.contains(people2));
    }

    @Test
    void sort() {
        People people1 = new People(96, "Artem");
        People people2 = new People(8, "Gtg");
        People people3 = new People(75, "gFtt");
        People people4 = new People(68, "gFtt");
        People people5 = new People(42, "gFtt");
        ArrayList<People> arrayList = new ArrayList<>();
        arrayList.add(people1);
        arrayList.add(people2);
        arrayList.add(people3);
        arrayList.add(people4);
        arrayList.add(people5);
        arrayList.sort(new Com());
        testList.add(people2);
        testList.add(people5);
        testList.add(people4);
        testList.add(people3);
        testList.add(people1);
        assertEquals(testList.get(0), arrayList.get(0));
        assertEquals(testList.get(1), arrayList.get(1));
        assertEquals(testList.get(2), arrayList.get(2));
        assertEquals(testList.get(3), arrayList.get(3));
        assertEquals(testList.get(4), arrayList.get(4));
        assertNotEquals(testList.get(4), arrayList.get(3));

    }
}