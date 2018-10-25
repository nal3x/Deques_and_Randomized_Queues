import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;

/**
 *  Permutation.java takes an integer k as a command-line argument, reads in a sequence of strings
 *  from standard input using StdIn.readString() and prints exactly k of them, uniformly at random.
 *  Each item from the sequence is printed at most once. Running time: linear in the size of the
 *  input. Uses only a constant amount of memory plus one RandomizedQueue object of maximum size at
 *  most n.
 */

public class Permutation {

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> randQueue = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            randQueue.enqueue(StdIn.readString());
        }
        Iterator<String> randQueueIterator = randQueue.iterator();
        for (int i = 0; i < k; i++) {
            if (randQueueIterator.hasNext()) {
                System.out.println(randQueueIterator.next());
            }
        }

    }
}
