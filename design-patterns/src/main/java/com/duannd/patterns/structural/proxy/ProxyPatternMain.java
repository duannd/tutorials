package com.duannd.patterns.structural.proxy;

public class ProxyPatternMain {

    public static void main(String[] args) {
        CommandExecutor executor = new CommandExecutorProxy("admin", "admin");
        try {
            executor.runCommand("docker ps -a");
            executor.runCommand(" rm -rf abc.pdf");
        } catch (Exception e) {
            System.out.println("Exception Message::" + e.getMessage());
        }
    }

}
