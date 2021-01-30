package edu.domgie.sda.varargs;

public class VarargsDemo {
    public static void main(String[] args) {
        VarargsDemo varargsDemo = new VarargsDemo();
        System.out.println(varargsDemo.demoVarPossibleEmpty());
        System.out.println(varargsDemo.demoVarPossibleEmpty(1));
        System.out.println(varargsDemo.demoVarPossibleEmpty(4, 6, 8, 4, 1));
        System.out.println(varargsDemo.sumAllPAssedAlwaysAvailable(6, 8, 5, 4));
    }

    /**
     * Varrargs pozwalaja przekazywac od 0 do wielu
     * wartosci tego samego typu
     *
     *
     */


    private int demoVarPossibleEmpty(int... values) {
        int result = 0;
        for (int value : values) {
            result +=value;
        }
        return result;
    }
    //varargs musi byc zawsze ostatnim parametrem metody
    public int sumAllPAssedAlwaysAvailable(int oneValue, int... followingValues){
        int result = oneValue;
        for (int followingValue : followingValues) {
            result+=followingValue;
        }
        return result;
    }
}
