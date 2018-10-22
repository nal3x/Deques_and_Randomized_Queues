public class TestDeque {

    private static void dequeAsStack() { // pushing popping from beginning, LIFO
        Deque<Integer> myStackDeque = new Deque<>();

        for (int i = 0; i < 10; i++) {
            System.out.println("Pushed " + i);
            myStackDeque.addFirst(i);

        }
        System.out.println("Size is " + myStackDeque.size());
        for (int i = 0; i < 10; i++) {
            System.out.println("Popped " + myStackDeque.removeFirst());
        }
        System.out.println("Size is " + myStackDeque.size());

    }

    private static void dequeAsReversedStack() { // pushing popping from end, LIFO
        Deque<Integer> myStackDeque = new Deque<>();

        for (int i = 0; i < 10; i++) {
            System.out.println("Pushed " + i);
            myStackDeque.addLast(i);

        }
        System.out.println("Size is " + myStackDeque.size());
        for (int i = 0; i < 10; i++) {
            System.out.println("Popped " + myStackDeque.removeLast());
        }
        System.out.println("Size is " + myStackDeque.size());

    }

    private static void dequeAsQueue() { // FIFO. Enqueue at end, dequeue from beginning
        Deque<Integer> myQueueDeque = new Deque<>();

        for (int i = 0; i < 10; i++) {
            System.out.println("Enqueued " + i);
            myQueueDeque.addLast(i);
        }
        System.out.println("Size is " + myQueueDeque.size());
        for (int i = 0; i < 10; i++) {
            System.out.println("Dequeued " + myQueueDeque.removeFirst());
        }
        System.out.println("Size is " + myQueueDeque.size());

    }

    private static void dequeAsReverseQueue() { // FIFO, enqueue at begin, dequeue from end
        Deque<Integer> myQueueDeque = new Deque<>();

        for (int i = 0; i < 10; i++) {
            System.out.println("Enqueued " + i);
            myQueueDeque.addFirst(i);
        }
        System.out.println("Size is " + myQueueDeque.size());
        for (int i = 0; i < 10; i++) {
            System.out.println("Dequeued " + myQueueDeque.removeLast());
        }
        System.out.println("Size is " + myQueueDeque.size());

    }


    public static void main(String[] args) {
        // dequeAsStack();
        // dequeAsQueue();
        // dequeAsReversedStack();
        dequeAsReverseQueue();
    }
}
