import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  Resizable array implementation of randomized queue. Constant amortized time for non-iterator
 *  operations, linear in # of items time for iterator constructor, constant worst-case time for
 *  other iterator operations. Non-iterator and per iterator memory use linear in # of items.
 *  The iterator returns the items in uniformly random order. The order of two or more
 *  iterators to the same randomized queue are mutually independent; each iterator maintains its own
 *  random order.
 */

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int n = 0;

    public RandomizedQueue() { // construct an empty randomized queue
        items = (Item[]) new Object[1];
    }

    public boolean isEmpty() { // is the randomized queue empty?
        return n == 0;
    }

    public int size() { // return the number of items on the randomized queue
        return n;
    }


    public int itemsSize() { // used only for testing resizing of array
        return items.length;
    }

    public void enqueue(Item item) { // add the item
        if (item == null) throw new IllegalArgumentException();
        items[n++] = item;
        if (n == items.length) {
            resize(2 * items.length);
        }
    }

    public Item dequeue() { // remove and return a random item
        if (isEmpty()) throw new NoSuchElementException();
        int randomIndex = StdRandom.uniform(n); // 0 to n-1
        Item item = items[randomIndex];
        items[randomIndex] = items[--n]; // decrease n and move last item to randomIndex position
        items[n] = null; // remove last item
        if (n > 0 && n == items.length/4) { // resize if array has shrinked to 25%
            resize(items.length/2);
        }
        return item;
    }

    public Item sample() { // return a random item (but do not remove it)
        if (isEmpty()) throw new NoSuchElementException();
        return items[StdRandom.uniform(n)];
    }

    @Override
    public Iterator<Item> iterator() { // return an independent iterator over items in random order
        return new RQIterator();
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = items[i];
        }
        items = copy;
    }

    private class RQIterator implements Iterator<Item> {

        private Item[] shuffledArray;
        private int index;

        public RQIterator() { // inner class constructor
            shuffledArray = (Item[]) new Object[size()];
            for (int i = 0; i < size(); i++) {
                shuffledArray[i] = items[i]; // array copy to achieve independence of iterators
            }
            StdRandom.shuffle(shuffledArray); // Knuth shuffle, linear time
        }
        @Override
        public boolean hasNext() {
            return index < shuffledArray.length;
        }

        @Override
        public Item next() {
            if (index == shuffledArray.length) {
                throw new NoSuchElementException();
            }
            return shuffledArray[index++];
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
