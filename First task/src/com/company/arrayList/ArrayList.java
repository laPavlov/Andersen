package com.company.arrayList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Интерфейс
 */

public interface ArrayList<T> extends List<T> {

    @Override
    int size();

    @Override
    boolean isEmpty();

    @Override
    boolean contains(Object o);

    @Override
    Iterator<T> iterator();

    @Override
    Object[] toArray();

    @Override
    <T1> T1[] toArray(T1[] a);

    @Override
    boolean add(T t);

    @Override
    boolean remove(Object o);

    @Override
    boolean containsAll(Collection<?> c);

    @Override
    boolean addAll(Collection<? extends T> c);

    boolean addAlls(ArrayList c);

    @Override
    boolean addAll(int index, Collection<? extends T> c);

    @Override
    boolean removeAll(Collection<?> c);

    @Override
    boolean retainAll(Collection<?> c);

    @Override
    void clear();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();

    @Override
    T get(int index);

    @Override
    T set(int index, T element);

    boolean setObj(int index, T element);

    @Override
    void add(int index, T element);

    @Override
    T remove(int index);

    @Override
    int indexOf(Object o);

    @Override
    int lastIndexOf(Object o);

    @Override
    ListIterator<T> listIterator();

    @Override
    ListIterator<T> listIterator(int index);

    @Override
    List<T> subList(int fromIndex, int toIndex);

    void removeAt(int index);
}
