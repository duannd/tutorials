package com.duannd.java9;

import com.duannd.java9.models.Employee;
import com.duannd.java9.models.EmployeeHelper;
import com.duannd.java9.subscribers.MySubscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.SubmissionPublisher;

public class ReactiveStreamMain {

    private static final Logger log = LoggerFactory.getLogger(ReactiveStreamMain.class);

    public static void main(String[] args) throws Exception {
        Java9Utils.printHeader("Reactive Stream examples");
        var publisher = new SubmissionPublisher<Employee>();
        var subscriber = new MySubscriber();
        publisher.subscribe(subscriber);
        log.info("Counter: {}", subscriber.getCounter());
        var employees = EmployeeHelper.getEmployees();
        // Publish items
        log.info("Publishing Items to Subscriber");
        employees.forEach(publisher::submit);

        // logic to wait till processing of all messages are over
        while (employees.size() != subscriber.getCounter()) {
            Thread.sleep(10);
        }
        // close the Publisher
        publisher.close();
        log.info("Exiting the app");
    }
}
