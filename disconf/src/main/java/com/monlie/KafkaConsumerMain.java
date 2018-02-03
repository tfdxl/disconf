package com.monlie;

import java.util.*;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class KafkaConsumerMain {

    public static void main(String[] args) {

        final int numOfConsumers = 3;
        final String groupId = "test-consumer-group";
        final List<String> topics = Arrays.asList("test");
        final ExecutorService executorService = Executors.newFixedThreadPool(numOfConsumers);

        final List<ConsumerLoop> consumerLoops = new ArrayList<>();
        for (int i = 0; i < numOfConsumers; i++) {
            final ConsumerLoop consumerLoop = new ConsumerLoop(i, groupId, topics);
            consumerLoops.add(consumerLoop);
            executorService.execute(consumerLoop);
        }
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {

            for (ConsumerLoop consumerLoop : consumerLoops) {
                consumerLoop.shutdown();
            }

            executorService.shutdown();
            try {
                executorService.awaitTermination(5000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
    }
}
