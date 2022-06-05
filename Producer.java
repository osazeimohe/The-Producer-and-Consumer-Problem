class Producer extends Thread {
    private static Queue buffer;
    private boolean flag = true;

    public Producer(Queue que) {
        buffer = que;
    }

    public void run() {
        int new_item = 1;
        while (flag) {
            // -- Create a new_item
            try {
                buffer.deposit(new_item);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void stopRun(){
        flag = false;
    }
    public static int Total_Produced(Queue que){
    return buffer.number_Produced;
    }

    public static void main(String args[]) throws InterruptedException {
        Queue buff1 = new Queue(100);
        Producer producer1 = new Producer(buff1);
        Consumer consumer1 = new Consumer(buff1);
        producer1.start();
        consumer1.start();
        sleep(1000);
        producer1.stopRun();
        consumer1.stopRun();
        // Your code here to show the correctness.
        System.out.println("The buffer has "+buff1.Size()+" elements");
        System.out.println("The producer produced: "+ Total_Produced(buff1)+ " elements");
        System.out.println("The Consumer consumed: "+ Consumer.Total_Consumed(buff1)+ " elements");
    }


}
