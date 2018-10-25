import java.util.Iterator;

public class TestDeque {

    private static final int ITEMS = 6;

    private static void dequeAsStack() { // pushing popping from beginning, LIFO
        Deque<Integer> myStackDeque = new Deque<>();

        for (int i = 0; i < ITEMS; i++) {
            System.out.println("Pushed " + i);
            myStackDeque.addFirst(i);

        }
        System.out.println("Size is " + myStackDeque.size());
        for (int i = 0; i < ITEMS; i++) {
            System.out.println("Popped " + myStackDeque.removeFirst());
        }
        System.out.println("Size is " + myStackDeque.size());

    }

    private static void dequeAsReversedStack() { // pushing popping from end, LIFO
        Deque<Integer> myStackDeque = new Deque<>();

        for (int i = 0; i < ITEMS; i++) {
            System.out.println("Pushed " + i);
            myStackDeque.addLast(i);

        }
        System.out.println("Size is " + myStackDeque.size());
        for (int i = 0; i < ITEMS; i++) {
            System.out.println("Popped " + myStackDeque.removeLast());
        }
        System.out.println("Size is " + myStackDeque.size());

    }

    private static void dequeAsQueue() { // FIFO. Enqueue at end, dequeue from beginning
        Deque<Integer> myQueueDeque = new Deque<>();

        for (int i = 0; i < ITEMS; i++) {
            System.out.println("Enqueued " + i);
            myQueueDeque.addLast(i);
        }
        System.out.println("Size is " + myQueueDeque.size());
        for (int i = 0; i < ITEMS; i++) {
            System.out.println("Dequeued " + myQueueDeque.removeFirst());
        }
        System.out.println("Size is " + myQueueDeque.size());

    }

    private static void dequeAsReverseQueue() { // FIFO, enqueue at begin, dequeue from end
        Deque<Integer> myQueueDeque = new Deque<>();

        for (int i = 0; i < ITEMS; i++) {
            System.out.println("Enqueued " + i);
            myQueueDeque.addFirst(i);
        }
        System.out.println("Size is " + myQueueDeque.size());
        for (int i = 0; i < ITEMS; i++) {
            System.out.println("Dequeued " + myQueueDeque.removeLast());
        }
        System.out.println("Size is " + myQueueDeque.size());

    }

    private static void iteratorTest() {
        Deque<Integer> myDequeu = new Deque<>();
        for (int i = 0; i < ITEMS; i++) { // filling zero to ITEMS -1
            myDequeu.addLast(i);
        }
        for (int i : myDequeu) { // iterating over nodes
            System.out.println(i);
        }
        for (int i = 0; i < ITEMS - 1; i++) { // removing all but first node
            myDequeu.removeLast();
        }
        for (int i : myDequeu) {
            System.out.println(i); // we get the first item, 0
        }
        Iterator iterator = myDequeu.iterator();
        System.out.println("Iterator has next? " + iterator.hasNext()); // true as 1 node remains
        myDequeu.removeFirst(); // removes last element
        System.out.println("Is deque empty? " + myDequeu.isEmpty()); // should be true
        Iterator iterator2 = myDequeu.iterator();
        System.out.println(iterator2.hasNext()); // should be false since we removed last node

        for (int i : myDequeu) {
            System.out.println(i); // no more items to return
        }
    }

    public static void main(String[] args) {
        // dequeAsStack();
        // dequeAsQueue();
        // dequeAsReversedStack();
        // dequeAsReverseQueue();
        iteratorTest();
    }
}
