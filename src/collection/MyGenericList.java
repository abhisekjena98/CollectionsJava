package collection;

import java.util.Iterator;

public class MyGenericList<T> implements Iterable {

    private T[] items;
    private int size;

    public MyGenericList() {
        size = 0;
        items = (T[]) new Object[100];
    }

    public void add(T item){
        items[size++] = item;
    }
    public T getItemAtIndex(int index){
        return items[index];
    }

    @Override
    public Iterator iterator() {

        return new MyGenericListIterator(this);

    }

    private class MyGenericListIterator implements Iterator<T>
    {

        private MyGenericList<T> list;
        private int index = 0;
        public MyGenericListIterator(MyGenericList<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {

            return index < list.size;
        }

        @Override
        public T next() {
            return list.items[index++];
        }
    }
}
