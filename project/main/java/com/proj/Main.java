package com.artem;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SQLException {
        TableParser parser = new TableParser();
        SqlGenerator sql = new SqlGenerator();

//        for (Base value : parser.bases)
//            sql.generateString(value);

        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (var countFloors = 1; 28 >= countFloors; countFloors++) {
            int count = Exercises.firstTask(countFloors, sql.connection);
            map.put(countFloors, count);
        }

        var dataset = new DefaultCategoryDataset();
        for (var entry : map.entrySet())
            dataset.setValue(entry.getValue(), ":", entry.getKey());

        JFreeChart chart = ChartFactory.createBarChart("", "Количество этажей", "Количествово зданий", dataset);

        try {
            ChartUtils.saveChartAsPNG(new File("graph.png"), chart, 1400, 700);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nЗадача 1");
        for (var entry : map.entrySet())
            System.out.println(entry.getKey() + ":" + entry.getValue());

        System.out.println("\nЗадача 2\n" + Exercises.secondTask(sql.connection));
        System.out.println("\nЗадача 3\n" + Exercises.thirdTask(sql.connection));
    }
}
