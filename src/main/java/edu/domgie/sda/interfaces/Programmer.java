package edu.domgie.sda.interfaces;

public class Programmer implements OOPCoding{

    @Override
    public void codeOOP(String language) {
        System.out.println("Its Obj Oriented lang");
    }
    @Override
    public void code(String language){
        System.out.println("i am coding in " + language);
    }
}
