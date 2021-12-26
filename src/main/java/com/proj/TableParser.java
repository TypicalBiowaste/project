package com.artem;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TableParser {
    public List<Base> bases = new ArrayList<>();

    public TableParser() {
        try (CSVReader reader = new CSVReader(new FileReader("base.csv"))) {
            String[] strings;
            reader.readNext();
            if ((strings = reader.readNext()) != null) {
                do {
                    Base base = new Base(strings[0], strings[1], strings[3], strings[4], strings[5], strings[8]);
                    bases.add(base);
                } while ((strings = reader.readNext()) != null);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}