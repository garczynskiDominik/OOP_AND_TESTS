package edu.domgie.sda.homework2;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class ReaderCustomerFromFile {

    public void readCustomerFromFile(Bank loyds, Path inputPath) throws IOException {
        List<String> lines = Files.readAllLines(inputPath, Charset.forName("UTF-8"));
        for (String line : lines) {
            List<String> tabCustomer = Arrays.asList(line.split("\\|"));
            loyds.createNewCustomer(tabCustomer.get(1), tabCustomer.get(2));
            if (tabCustomer.size() > 3) {
                loyds.addAccountToCustomerList(tabCustomer.get(1), tabCustomer.get(2), tabCustomer.get(3));
                if (tabCustomer.size() > 4) {
                    loyds.isDeposit(tabCustomer.get(1), tabCustomer.get(2), tabCustomer.get(3), BigDecimal.valueOf(Integer.parseInt(tabCustomer.get(4))));
                    if (tabCustomer.size() > 5) {
                        loyds.addAccountToCustomerList(tabCustomer.get(1), tabCustomer.get(2), tabCustomer.get(5));
                        if (tabCustomer.size() > 6) {
                            loyds.isDeposit(tabCustomer.get(1), tabCustomer.get(2), tabCustomer.get(5), BigDecimal.valueOf(Integer.parseInt(tabCustomer.get(6))));
                        }
                    }
                }
            }
        }
    }

    public void readCustomerFromFileV2(Bank loyds, Path inputPath) throws IOException {
        List<String> lines = Files.readAllLines(inputPath, Charset.forName("UTF-8"));
        for (int i = 0; i < lines.size(); i++) {
            List<String> tabCustomer = Arrays.asList(lines.get(i).split("\\|"));
           // loyds.createNewCustomer(tabCustomer.get(), )
        }


    }
}
