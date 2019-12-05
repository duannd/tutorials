package com.duannd.java9.subscribers;

import com.duannd.java9.models.Freelancer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Flow;

public class FreelancerSubscriber implements Flow.Subscriber<Freelancer> {

    private static final Logger log = LoggerFactory.getLogger(FreelancerSubscriber.class);

    private int counter;
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        log.info("Subscribed for FreelancerSubscriber");
        this.subscription = subscription;
        this.subscription.request(1);
        log.info("onSubscribe requested 1 item for FreelancerSubscriber");
    }

    @Override
    public void onNext(Freelancer item) {
        log.info("Processing Freelancer: {}", item);
        this.counter++;
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        log.info("Some error happened in FreelancerSubscriber");
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        log.info("All Processing Done for FreelancerSubscriber");
    }

    public int getCounter() {
        return counter;
    }
}
