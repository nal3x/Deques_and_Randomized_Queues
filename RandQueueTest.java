public class RandQueueTest {
    public static void main(String[] args) {
        // initializeTest();
        // increaseSizeTest(4);
        // dequeTest(4);
        // decreaseSizeTest();
        // iteratorTest(10);
        multipleIteratorTest(10);
        // sampleTest(4);
    }

    private static void initializeTest() {
        RandomizedQueue<String> randQueue = new RandomizedQueue<>();
        System.out.println("Number of items = " + randQueue.size());
        System.out.println("Array size = " + randQueue.itemsSize());
        System.out.println("isEmpty? " + randQueue.isEmpty());
        randQueue.enqueue("cat");
        System.out.println("Array size = " + randQueue.itemsSize());
        System.out.println(randQueue.dequeue());
        System.out.println("isEmpty? " + randQueue.isEmpty());
        System.out.println("Array size = " + randQueue.itemsSize());
    }

    private static void increaseSizeTest(int numberOfEnqueues) {
        RandomizedQueue<Integer> randQueue = new RandomizedQueue<>();
        for (int i = 0; i < numberOfEnqueues; i++) {
            randQueue.enqueue(i);
            System.out.println("Enqued " + i);
        }
        System.out.println("Number of items = " + randQueue.size());
        System.out.println("Array size = " + randQueue.itemsSize());
    }

    private static void dequeTest(int numberOfEnqueues) {
        RandomizedQueue<Integer> randQueue = new RandomizedQueue<>();
        for (int i = 0; i < numberOfEnqueues; i++) {
            randQueue.enqueue(i);
            System.out.println("Enqued " + i);
        }
        System.out.println("Number of items = " + randQueue.size());
        System.out.println("Array size = " + randQueue.itemsSize());
        for (int i = 0; i < numberOfEnqueues; i++) {
            System.out.println("Dequeued " + randQueue.dequeue());
        }
        System.out.println("Number of items = " + randQueue.size());
        System.out.println("Array size = " + randQueue.itemsSize());
    }

    private static void decreaseSizeTest() {
        int numberOfItems = 32;
        System.out.println("Start enquing " + numberOfItems +  " to reach size " + 2 * numberOfItems);
        RandomizedQueue<Integer> randQueue = new RandomizedQueue<>();
        for (int i = 0; i < numberOfItems; i++) {
            randQueue.enqueue(i);
            System.out.println("Enqued " + i);
        }
        System.out.println("Number of items = " + randQueue.size());
        System.out.println("Array size = " + randQueue.itemsSize());
        for (int i = 0; i < numberOfItems * 3 / 4; i++) { // removing 75% of items
            System.out.println("Dequeued " + randQueue.dequeue());
        }
        System.out.println("Number of items = " + randQueue.size());
        System.out.println("Array size = " + randQueue.itemsSize());
    }

    private static void iteratorTest(int numberOfItems) {
        RandomizedQueue<Integer> randQueue = new RandomizedQueue<>();
        System.out.println("Enqueuing " + numberOfItems + " items.");
        for (int i = 0; i < numberOfItems; i++) {
            randQueue.enqueue(i);
            System.out.println("Enqued " + i);
        }
        int iteratorItems = 0;
        for (Integer i : randQueue) {
            System.out.println(i);
            iteratorItems++;
        }
        System.out.println("Items contained in iterator = " + iteratorItems);
    }

    private static void multipleIteratorTest(int numberOfItems) {
        RandomizedQueue<Integer> randQueue = new RandomizedQueue<>();
        System.out.println("Enqueuing " + numberOfItems + " items.");
        for (int i = 0; i < numberOfItems; i++) {
            randQueue.enqueue(i);
            System.out.println("Enqued " + i);
        }
        int firstIteratorItems = 0, secondIteratorItems = 0;
        for (Integer i : randQueue) {
            System.out.println("Iterator 1 " + i);
            firstIteratorItems++;
            for (Integer j : randQueue) {
                System.out.println("Iterator 2 " + j);
                secondIteratorItems++;

            }
        }
        System.out.println("Items contained in 1st iterator = " + firstIteratorItems);
        System.out.println("Items contained in 2nd iterator = " + secondIteratorItems);
    }

    private static void sampleTest(int numberOfItems) {
        RandomizedQueue<Integer> randQueue = new RandomizedQueue<>();
        System.out.println("Enqueuing " + numberOfItems + " items.");
        for (int i = 0; i < numberOfItems; i++) {
            randQueue.enqueue(i);
            System.out.println("Enqued " + i);
        }
        int sample = randQueue.sample();
        System.out.println("Randomly chosen item: " + sample);
        System.out.println("Checking items to see if sample still there.");
        boolean found = false;
        for (int i = 0; i < numberOfItems; i++) {
            if (sample == randQueue.dequeue()) {
                found = true;
            }
        }
        System.out.println("Item found: " + found);
    }

}
