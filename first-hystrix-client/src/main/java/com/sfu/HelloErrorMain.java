package com.sfu;

public class HelloErrorMain {
    public static void main(String[] args){
        String normalUrl = "http://localhost:8080/errorHello";
        HelloCommand command = new HelloCommand(normalUrl);
        String result = command.execute();
        System.out.println(result);
    }
}
