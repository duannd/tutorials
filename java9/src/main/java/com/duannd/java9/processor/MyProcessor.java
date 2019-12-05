package com.duannd.java9.processor;

import com.duannd.java9.models.Employee;
import com.duannd.java9.models.Freelancer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

public class MyProcessor extends SubmissionPublisher<Freelancer> implements Flow.Processor<Employee, Freelancer> {

    private static final Logger log = LoggerFactory.getLogger(MyProcessor.class);

    private Function<Employee, Freelancer> function;
    private Flow.Subscription subscription;

    public MyProcessor() {
        this.function = em -> new Freelancer(em.getId(), em.getName(), em.getId() + 100);
    }


    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        log.info("Subscribed for MyProcessor");
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(Employee item) {
        log.info("Processor convert employee to freelancer");
        submit(function.apply(item));
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        log.error("Some error in My Processor", throwable);
    }

    @Override
    public void onComplete() {
        log.info("DONE");
    }
}
