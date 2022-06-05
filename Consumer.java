class Consumer extends Thread {
    private boolean flag = true;
    private static Queue buffer;

    public Consumer(Queue que) {
        buffer = que;
    }

    public void run() {
        int stored_item;
        while (flag) {
                try {
                    stored_item = buffer.fetch();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            // -- Consume the stored_item
        }
    }
    public void stopRun(){
        flag = false;
    }
    public static int Total_Consumed(Queue que){
        return buffer.number_Consumed;
    }

}