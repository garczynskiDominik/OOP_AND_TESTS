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
                for (int i = 3; i < tabCustomer.size(); i+=2) {
                    loyds.migrateAccountForCustomer(tabCustomer.get(1), tabCustomer.get(2), tabCustomer.get(i), new BigDecimal(tabCustomer.get(i+1)));
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
