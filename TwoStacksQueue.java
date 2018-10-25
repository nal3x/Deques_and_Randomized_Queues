import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdRandom;
import java.util.NoSuchElementException;

/**
 *  Implementation of a queue using two stacks, one for enqueuing items and the other for dequeuing.
 *  An enqueue pushes items to enqStack and a dequeue pops items from deqStack if not empty. If
 *  empty then we pop items from enqStack and push to deqStack, which reverses their order. On
 *  average a series of N queue operation requires 2N stack operations.
 */

public class TwoStacksQueue<Item> {

    private Stack<Item> enqStack;
    private Stack<Item> deqStack;
    private int pops;
    private int pushes;

    public TwoStacksQueue() {
        enqStack = new Stack<>();
        deqStack = new Stack<>();
    }

    public void enque(Item item) {
        enqStack.push(item);
        pushes++;
    }

    public Item deque() {
        if (deqStack.isEmpty()) {
            while (!enqStack.isEmpty()) {
                Item item = enqStack.pop();
                deqStack.push(item);
                pops++; pushes++;
            }
        }
        pops++;
        return deqStack.pop();
    }

    public int getPops() {
        return pops;
    }

    public int getPushes() {
        return pushes;
    }

    public static void main(String[] args) {

        int trials = 1000;
        TwoStacksQueue<String> twoStacksQueue = new TwoStacksQueue<>();
        for (int i = 0; i < trials; i++) {
            int trial = StdRandom.uniform(2);
            if (trial == 0) {
                twoStacksQueue.enque("item");
            } else {
                try {
                    System.out.println("Dequeued " + twoStacksQueue.deque());
                } catch (NoSuchElementException e) {
                    System.out.println("Deque stack was found empty");
                }
            }
        }
        System.out.println("Pop operations: " + twoStacksQueue.getPops());
        System.out.println("Push operations: " + twoStacksQueue.getPushes());
    }


}
