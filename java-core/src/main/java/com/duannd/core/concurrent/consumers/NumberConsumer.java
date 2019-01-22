package com.duannd.core.concurrent.consumers;

import java.util.concurrent.BlockingQueue;

/**
 * Created By duan.nd@senseinfosys.com at 1/21/2019 11:43 AM
 */
public class NumberConsumer implements Runnable {

    private BlockingQueue<Integer> queue;
    private final int poisonPill;

    public NumberConsumer(BlockingQueue<Integer> queue, int poisonPill) {
        this.queue = queue;
        this.poisonPill = poisonPill;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer number = queue.take();
                if (number.equals(poisonPill)) {
                    return;
                }
                System.out.println(Thread.currentThread().getName() + " result: " + number);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
