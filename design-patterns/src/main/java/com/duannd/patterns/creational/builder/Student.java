package com.duannd.patterns.creational.builder;

import com.google.common.base.MoreObjects;

public class Student {

    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private String phoneNo;
    private String parent;
    private Double averagePoint;

    private Student(StudentBuilder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.address = builder.address;
        this.phoneNo = builder.phoneNo;
        this.parent = builder.parent;
        this.averagePoint = builder.averagePoint;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getParent() {
        return parent;
    }

    public Double getAveragePoint() {
        return averagePoint;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("firstName", firstName)
                .add("lastName", lastName)
                .add("age", age)
                .add("address", address)
                .add("phoneNo", phoneNo)
                .add("parent", parent)
                .add("averagePoint", averagePoint)
                .toString();
    }

    public static class StudentBuilder {

        private String id;
        private String firstName;
        private String lastName;
        private int age;
        private String address;
        private String phoneNo;
        private String parent;
        private Double averagePoint;

        public StudentBuilder id(String id) {
            this.id = id;
            return this;
        }

        public StudentBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public StudentBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StudentBuilder age(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder address(String address) {
            this.address = address;
            return this;
        }

        public StudentBuilder phoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public StudentBuilder parent(String parent) {
            this.parent = parent;
            return this;
        }

        public StudentBuilder averagePoint(Double averagePoint) {
            this.averagePoint = averagePoint;
            return this;
        }

        public Student build() {
            return new Student(this);
        }

    }
}
