package com.company;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;
public class CSVParse{
    public void test(String filename) {
        try {
            CSV csvtest = new CSV();

            List<String> lines = Files.readAllLines(Paths.get(filename));
            for (int i = 1; i < lines.size(); i++) {
                csvtest.CalculateData(lines.get(i));
            }
            csvtest.printData();
        }
        catch (Exception e) {
            System.out.println("#error");
        }
    }
}
