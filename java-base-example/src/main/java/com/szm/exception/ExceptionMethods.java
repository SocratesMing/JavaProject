package com.szm.exception;


public class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            System.out.println("Caught Exception");
            System.out.println("getMessage():" + e.getMessage());   //打印信息
            System.out.println("getLocalizedMessage():" + e.getLocalizedMessage()); //重写此方法可以打印详细的信息
            System.out.println("toString():" + e);
            System.out.println("printStackTrace():");
            e.printStackTrace(System.out);  //默认是System.err
        }
    }
}
