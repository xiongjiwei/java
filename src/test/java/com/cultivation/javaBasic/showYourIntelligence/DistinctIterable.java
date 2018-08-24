package com.cultivation.javaBasic.showYourIntelligence;

import java.util.*;

public class DistinctIterable<T> implements Iterable<T> {
    private Iterable<T> iterable;

    public DistinctIterable(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    @Override
    public Iterator<T> iterator() {
        return new DistinctIterator<>(iterable.iterator());
    }

    public List<T> toList() {
        ArrayList<T> result = new ArrayList<>();
        this.forEach(result::add);
        return result;
    }
}

class DistinctIterator<E> implements Iterator<E> {
    // TODO: Implement the class to pass the test. Note that you cannot put all items into memory or you will fail.
    // <--start
    private Set<E> tmpSet = new HashSet<>();
    private E lastReturn = null;

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final Iterator<E> iterator;

    DistinctIterator(Iterator<E> iterator) {
        this.iterator = iterator;
        if (iterator.hasNext()) {
            E next = iterator.next();
            tmpSet.add(next);
            lastReturn = next;
        }
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public E next() {
        while (hasNext()) {
            E next = iterator.next();
            if (!tmpSet.contains(next)) {
                tmpSet.add(next);
                return next;
            }
        }

        return lastReturn;
    }
    // --end->
}