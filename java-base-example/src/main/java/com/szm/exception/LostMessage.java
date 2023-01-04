package com.szm.exception;

public class LostMessage {

    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();     //抛出VeryImportantException
            } finally {
                lm.dispose();   //抛出HoHumException
            }
        } catch (Exception e) {
            System.out.println(e);  //输出HoHumException的信息，
                                    // 会导致抛出VeryImportantException异常丢失
        }
    }
}

class VeryImportantException extends Exception {
    public String toString() {
        return "A very important exception!";
    }
}

class HoHumException extends Exception {
    public String toString() {
        return "A trivial exception";
    }
}