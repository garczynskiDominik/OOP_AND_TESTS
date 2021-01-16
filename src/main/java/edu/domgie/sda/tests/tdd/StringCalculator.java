package edu.domgie.sda.tests.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String text) {

        if (text.isEmpty()) {
            return 0;
        }


        List<String> listNumbersFromString = new ArrayList<>();
        Pattern p = Pattern.compile("(-|)[\\d]+");
        Matcher m = p.matcher(text);

        while (m.find()) {
            listNumbersFromString.add(m.group());
        }

        List<Integer> negativeNumbersFromString = new ArrayList<>();
        int result = 0;
        for (String s : listNumbersFromString) {
            if (Integer.parseInt(s) < 0) {
                negativeNumbersFromString.add(Integer.parseInt(s));
            }
            if (Integer.parseInt(s) <= 1000) {
                result += Integer.parseInt(s);
            }
        }
        if (negativeNumbersFromString.size() == 1) {
            throw new NegativeNumbersException("negatives not allowed");
        } else if (negativeNumbersFromString.size() > 1) {
            throw new NegativeNumbersException("multiples negatives: " + negativeNumbersFromString.toString());
        }
        return result;
    }
}


