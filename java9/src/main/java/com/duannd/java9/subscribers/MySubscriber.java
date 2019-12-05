package com.duannd.java9.subscribers;

import com.duannd.java9.models.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Flow;

public class MySubscriber implements Flow.Subscriber<Employee> {

    private static final Logger log = LoggerFactory.getLogger(MySubscriber.class);
    private Flow.Subscription subscription;
    private int counter = 0;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        log.info("Subscribed");
        this.subscription = subscription;
        this.subscription.request(1); // n = 1...n
        log.info("onSubscribe requested 1 item");
    }

    @Override
    public void onNext(Employee item) {
        log.info("Processing employee: {}", item);
        this.counter++;
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        log.info("Some error happened");
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        log.info("All Processing Done");
    }

    public int getCounter() {
        return counter;
    }
}
