package com.company.arrayList;

import java.util.*;

/**
 * Реализация ArrayList (динамического массива) интерфейса List.
 */

public class ArrayListImpl<T> implements ArrayList {

    private static final int DEFAULT_SIZE = 10;

    private T[] element;
    private int size;


    public ArrayListImpl() {
        this.element = (T[]) new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    /**
     * Метод для получения значения по индексу.
     *
     * @param index индекс интересующего числа
     * @return возвращает null при условии, что входной индекс > размера массива с действительными значениями;
     * Если индекс внутри размера массива, возвращает объект под индексом.
     */
    @Override
    public T get(int index) {
        if (index > size) return null;
        return element[index];
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    /**
     * Замена объекта под индексом.
     *
     * @param index индекс интересующего числа
     * @param value заменяющий объект
     * @return возвращает true - замена прошла успешно; false - индекс вышел за пределы массива.
     */
    @Override
    public boolean setObj(int index, Object value) {
        if (index + 1 > size) return false;
        element[index] = (T) value;
        return true;
    }

    /**
     * Проверка массива на наличие объектов в нем
     *
     * @return возвращает true - массив пуст; false - массив не пуст.
     */
    @Override
    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    /**
     * Добавление объектов в массив.
     *
     * @param value добавляемый объект
     * @return возвращает true - объект добавлен.
     */
    @Override
    public boolean add(Object value) {
        if (size == element.length - 1) {
            increase();
        }

        this.element[size] = (T) value;
        size++;
        return true;
    }

    /**
     * Добавление коллекции объектов в массив.
     *
     * @param c добавляемая коллекция объектов.
     * @return возвращает true - объект добавлен.
     */
    @Override
    public boolean addAlls(ArrayList c) {
        for (int i = 0; i < c.size(); i++) {
            this.element[size] = (T) c.get(i);
            size++;
            if (size == element.length - 1) {
                increase();
            }
        }
        return true;
    }

    private void increase() {
        T[] oldElements = this.element;
        this.element = (T[]) new Object[oldElements.length * 3 / 2 + 1];
        if (size >= 0) System.arraycopy(oldElements, 0, this.element, 0, size);
    }

    /**
     * Размер массива.
     *
     * @return возвращает размер массива действительных объектов.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Удалить значение по индексу.
     *
     * @param index индекс удаляемого объекта.
     */
    @Override
    public void removeAt(int index) {
        for (int i = index; i < element.length; i++) {
            element[index] = element[index + 1];
        }
        size -= 1;
    }

    /**
     * Вывод массива.
     *
     * @return возвращает Массив + его объекты.
     */
    @Override
    public String toString() {
        return "ArrayList =" + Arrays.toString(element);
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

}



