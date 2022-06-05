// Queue
// This class implements a circular queue for storing int
// values. It includes a constructor for allocating and
// initializing the queue to a specified size. It has
// synchronized methods for inserting values into and
// removing values from the queue.
public class Queue {
    int number_Produced;
    int number_Consumed;
    private int[] que;
    private int nextIn,
            nextOut,
            filled,
            queSize;

    public Queue(int size) {
        que = new int[size+1];
        filled = 0;
        nextIn = 1;
        nextOut = 1;
        queSize = size;
    } // ** end of Queue constructor

    public synchronized void deposit(int item)
            throws InterruptedException {
        try {
            while (filled == queSize){
                wait();
            }
            que[nextIn] = item;
            nextIn = (nextIn % queSize) + 1;
            filled++;
            number_Produced++;
            notifyAll();
        } // ** end of try clause
        catch (InterruptedException e) {
        }
    } // ** end of deposit method

    public synchronized int fetch()
            throws InterruptedException {
        int item = 0;
        try {
            while (filled == 0)
                wait();
            item = que[nextOut];
            nextOut = (nextOut % queSize) + 1;
            filled--;
            number_Consumed++;
            notifyAll();
        } // ** end of try clause
        catch (InterruptedException e) {
        }
        return item;
    } // ** end of fetch method

    /*returns current number of items in the buffer*/
    public int Size(){
        return filled;
    }

} // ** end of Queue class