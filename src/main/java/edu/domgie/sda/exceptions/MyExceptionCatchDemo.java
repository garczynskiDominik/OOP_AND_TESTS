package edu.domgie.sda.exceptions;

public class MyExceptionCatchDemo {
    private void myExceptionCatcher(int par) {
        int a = par;
        String b = "AAA";
        if (a == 1) {
            b = "C";
            throw new MyException(b);
        }
        throw new MyException();

    }

    public void myExceptionPasser(int par) {
        myExceptionCatcher(par);
    }

    public static void main(String[] args) {
        MyExceptionCatchDemo demo = new MyExceptionCatchDemo();
        demo.myExceptionPasser(1);
    }
}
