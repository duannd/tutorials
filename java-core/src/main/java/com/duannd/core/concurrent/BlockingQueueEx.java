package com.duannd.core.concurrent;

import com.duannd.core.concurrent.consumers.NumberConsumer;
import com.duannd.core.concurrent.producers.NumberProducer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created By duan.nd@senseinfosys.com at 1/21/2019 10:50 AM
 */
public class BlockingQueueEx {

    public static void main(String[] args) {
        int bound = 10;
        int nProducers = 2;
        int nConsumers = Runtime.getRuntime().availableProcessors();
        System.out.println("Number consumers: " + nConsumers);
        int poisonPill = Integer.MAX_VALUE;
        int poisonPillPerProducer = nConsumers / nProducers;
        int mod = nConsumers % nProducers;

        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(bound);

        for (int i = 1; i < nProducers; i++) {
            new Thread(new NumberProducer(queue, poisonPill, poisonPillPerProducer)).start();
        }

        for (int j = 0; j < nConsumers; j++) {
            new Thread(new NumberConsumer(queue, poisonPill)).start();
        }

        new Thread(new NumberProducer(queue, poisonPill, poisonPillPerProducer + mod))
                .start();

    }

}
