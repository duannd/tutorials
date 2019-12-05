package com.duannd.java9;

import com.duannd.java9.models.Employee;
import com.duannd.java9.models.EmployeeHelper;
import com.duannd.java9.processor.MyProcessor;
import com.duannd.java9.subscribers.FreelancerSubscriber;

import java.util.concurrent.SubmissionPublisher;

public class MessageTransformationMain {

    public static void main(String[] args) throws Exception {
        Java9Utils.printHeader("Message Transformation");
        // Step 1: Initial publishers, subscribers
        System.out.println("Initial employeePublisher, processor, freelancerSubscriber");
        // initial employee publisher
        var employeePublisher = new SubmissionPublisher<Employee>();
        // initial processor to subscribe employeePublisher then publish to freelancerSubscriber
        var processor = new MyProcessor();
        // subscribe to employeePublisher
        employeePublisher.subscribe(processor);
        // initial freelancerSubscriber to subscribe processor
        var freelancerSubscriber = new FreelancerSubscriber();
        // subscribe to processor
        processor.subscribe(freelancerSubscriber);

        // Step 2: Publish employee
        System.out.println("Publishing Items to Subscriber");
        var employees = EmployeeHelper.getEmployees();
        employees.forEach(employeePublisher::submit);

        // Logic to wait for messages processing to finish
        while (employees.size() != freelancerSubscriber.getCounter()) {
            Thread.sleep(100);
        }

        // Closing publishers
        employeePublisher.close();
        processor.close();

        System.out.println("Exiting the app");

    }
}
