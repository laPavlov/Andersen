package company.arrayList;

import java.util.*;

/**
 * Реализация ArrayList (динамического массива) интерфейса List.
 */

public class ArrayList<T> implements List {

    private static final int DEFAULT_SIZE = 10;
    private static final Object[] SIZE_CREATE = {};

    private T[] elements;
    private int size;


    public ArrayList() {
        this.elements = (T[]) SIZE_CREATE;
        this.size = 0;
    }

    /**
     * Метод для получения значения по индексу.
     *
     * @param index - индекс интересующего числа
     * @return - возвращает null при условии, что входной индекс > размера массива с действительными значениями;
     * Если индекс внутри размера массива, возвращает объект под индексом.
     */
    @Override
    public T get(int index) {
        if (index > size) return null;
        return elements[index];
    }

    /**
     * Замена объекта под индексом.
     *
     * @param index   - индекс ячейки замены.
     * @param element - заменяющий объект
     * @return - возвращает true - замена прошла успешно; false - индекс вышел за пределы массива.
     */
    @Override
    public T set(int index, Object element) {
        if (index > size) return null;
        T oldValue = elements[index];
        elements[index] = (T) element;
        return oldValue;
    }

    /**
     * Проверка массива на наличие объектов в нем
     *
     * @return - возвращает true - массив пуст; false - массив не пуст.
     */
    @Override
    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    /**
     * Добавление объекта в конец массива.
     *
     * @param object - добавляемый объект
     * @return - возвращает true - объект добавлен.
     */
    @Override
    public boolean add(Object object) {
        if (size == 0) {
            increase();
        }
        this.elements[size] = (T) object;
        size++;
        return true;
    }

    @Override
    public void add(int index, Object element) {

    }

    /**
     * Добавление коллекции объектов в конец массива.
     *
     * @param collection - добавляемая коллекция объектов.
     * @return - возвращает true - объект добавлен.
     */
    public boolean addAll(ArrayList collection) {
        if (elements.length == 0) increase();
        for (int i = 0; i < collection.size(); i++) {
            this.elements[size] = (T) collection.get(i);
            size++;
            if (size == elements.length - 1) {
                increase();
            }
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    /**
     * Размер массива.
     *
     * @return - возвращает размер массива действительных объектов.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Удалить значение по индексу (первый индекс равен 1).
     *
     * @param index - индекс удаляемого объекта.
     */
    @Override
    public Object remove(int index) {
        if (index < 0 || index > elements.length) return null;
        T oldValue = elements[index];
        System.arraycopy(this.elements, index, this.elements, index - 1, size - index);
        size -= 1;
        return oldValue;
    }

    private void increase() {
        if (size == 0) {
            this.elements = (T[]) new Object[DEFAULT_SIZE];
        } else {
            T[] oldElements = this.elements;
            this.elements = (T[]) new Object[oldElements.length * 3 / 2 + 1];
            System.arraycopy(oldElements, 0, this.elements, 0, size);
        }
    }

    /**
     * Удаление всех элементов массива
     */
    @Override
    public void clear() {
        this.elements = (T[]) SIZE_CREATE;
        size = 0;
    }

    /**
     * Проверка наличие объекта в списке
     *
     * @param o - передаваемый параметр.
     * @return - возвращает true - объект есть в списке, falser - объекта нет в списке.
     */
    @Override
    public boolean contains(Object o) {
        if (size == 0) return false;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) return true;
        }
        return false;
    }

    /**
     * Сортировка ArrayList
     *
     * @param comparator - принимает компаратор, по которому производится сортировка
     */
    public void sort(Comparator comparator) {
        Arrays.sort((T[]) elements, 0, size, comparator);
    }

    /**
     * Вывод массива.
     *
     * @return - возвращает Массив + его объекты.
     */
    @Override
    public String toString() {
        return "ArrayList =" + Arrays.toString(elements);
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



