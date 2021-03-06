import java.util.Iterator;

/**
 *  Linked list deque implementation with constant worst-case time for all operations. The
 *  removeLast operation requires knowledge of the previous node in order to avoid iteration over
 *  all nodes to check which node is previous from last. Use of previous Node makes the deque a
 *  double-linked list. Memory requirement for ~48 N bytes requirement is satisfied.
 *  Keeping track of the size of the deque satisfies the worst-case performance requirement
 *  for all operations.
 */



public class Deque<Item> implements Iterable<Item> {

    private Node first, last;
    private int size;

    private class Node {
        Item item;
        Node previous;
        Node next;
    }

    public Deque() { // construct an empty deque
    }

    public boolean isEmpty() { // is the deque empty?
        return (first == null);
    }

    public int size() { // return the number of items on the deque
        return size;
    }

    public void addFirst(Item item) { // add the item to the front
        if (item == null) throw new IllegalArgumentException();
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst; // becomes null for a previously empty deque
        first.previous = null; // redundant
        if (first.next == null) { // oldfirst was null, ie we had an empty deque
            last = first;
        } else {
            oldfirst.previous = first;
        }
        size++;
    }

    public Item removeFirst() { // remove and return the item from the front, like stack pop/dequeue
        if (isEmpty()) throw new java.util.NoSuchElementException();
        Item item = first.item;
        first = first.next; // correctly becomes null for if deque contained one node
        if (isEmpty()) { // see above
            last = null;
        } else {
            first.previous = null;
        }
        size--;
        return item;
    }

    public void addLast(Item item) { // add the item to the end, like enqueue
        if (item == null) throw new IllegalArgumentException();
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null; // redundant
        last.previous = oldLast; // correctly becomes null for an empty deque as oldLast is null
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public Item removeLast() { // remove and return the item from the end
        if (isEmpty()) throw new java.util.NoSuchElementException();
        Item item = last.item;
        last = last.previous; // becomes null if deque contained one node only
        if (last == null) {
            first = null;
        } else {
            last.next = null; // old last can be GC collected, avoids loitering
        }
        size--;
        return item;
    }

    public Iterator<Item> iterator() { // return an iterator over items in order from front to end
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current != null; // false after current has moved from last node
        }

        @Override
        public Item next() {
            if (current == null) throw new java.util.NoSuchElementException();
            Item item = current.item;
            current = current.next; // current == null when last item is returned
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    public static void main(String[] args) { // test client (optional)
        Deque<Integer> myDeque = new Deque<>();

        myDeque.addFirst(2);
        myDeque.addFirst(1);
        myDeque.addLast(3); // 1, 2, 3...
        System.out.println("Size is " + myDeque.size());
        System.out.println(myDeque.first.next);
        System.out.println(myDeque.last.previous); // same
        System.out.println(myDeque.first.previous); // null
        System.out.println(myDeque.last.next); // null

        System.out.println(myDeque.first);
        System.out.println(myDeque.last.previous.previous); // same

        System.out.println(myDeque.last);
        System.out.println(myDeque.first.next.next); // same

        System.out.println("---------------------");

        System.out.println("Removed " + myDeque.removeLast() + " from last"); // 3 is gone. 1, 2
        System.out.println("Size is " + myDeque.size());
        System.out.println(myDeque.last.next); // should be null
        System.out.println(myDeque.first.previous); // null
        System.out.println(myDeque.last);
        System.out.println(myDeque.first.next); // same as above
        System.out.println(myDeque.last.previous);
        System.out.println(myDeque.first); // same as above

        System.out.println("---------------------");

        System.out.println(myDeque.removeLast()); // 1 is gone, 2 remains. Check removeLast also
        System.out.println("Size is " + myDeque.size());
        System.out.println(myDeque.first);
        System.out.println(myDeque.last);
        System.out.println(myDeque.first.previous); // null
        System.out.println(myDeque.last.next); // null also

        System.out.println("---------------------");

        System.out.println(myDeque.removeLast()); // 2 is gone, we are empty! Check removeLast also
        System.out.println("Size is " + myDeque.size());
        System.out.println(myDeque.first);
        System.out.println(myDeque.last);

    }
}
