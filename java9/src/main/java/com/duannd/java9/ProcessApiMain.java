package com.duannd.java9;

public class ProcessApiMain {

    public static void main(String[] args) {
        Java9Utils.printHeader("Process API Improvements");
        processApi();
    }

    private static void processApi() {
        ProcessHandle currentProcess = ProcessHandle.current();
        System.out.println("Current Process Id: = " + currentProcess.pid());
    }

}
