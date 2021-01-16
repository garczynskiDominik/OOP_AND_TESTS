package edu.domgie.sda.tests;

public class Utils {
    public static void main(String[] args) {
        Utils utils = new Utils();
        char[] tab = {'1', '2', '3', '4'};
        System.out.println(utils.everyNthChar(tab, 2));

    }

    public char[] everyNthChar(char[] sourceArray, int n) {
        if (sourceArray == null || sourceArray.length < n) {
            return sourceArray;
        }
        int returnedLength = sourceArray.length / n;
        char[] resultArray = new char[returnedLength];
        int index = 0;
        for (int i = n - 1; i < sourceArray.length; i += n) {
            resultArray[index] = sourceArray[i];
            index++;

        }
        return resultArray;
    }

    public String removePairs(String source) {
        if (source.length() < 2) {
            return source;
        }

        StringBuilder stringBuilder = new StringBuilder();
        char[] string = source.toCharArray();

        for (int i = 0; i < string.length - 1; i++) {
            System.out.println(string[i]);
            if (string[i] != string[i + 1]) {
                stringBuilder.append(string[i]);
            }

        }
        System.out.println(string[string.length - 1]);
        stringBuilder.append(string[string.length - 1]);
        return stringBuilder.toString();
    }
}
