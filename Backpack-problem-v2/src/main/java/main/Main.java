package main;

import dynamicprogramming.Memoization;
import dynamicprogramming.Tabulation;
import utils.AlphanumericSortComparator;
import utils.Backpack;
import utils.FileInputReader;
import utils.input.Switches;

import java.io.File;
import java.text.DecimalFormat;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        if (Switches.contains(args, "-h", "--help")) Switches.help();

        boolean tab = false;
        boolean mem = false;
        boolean both = false;

        if (Arrays.asList(args).contains("-check")) {
            both = true;
        } else if (Switches.contains(args, "-sm", "--memoization")) {
            mem = true;
        } else if (Switches.contains(args, "-st", "--tabulation" )) {
            tab = true;
        }else {
            Switches.help();
        }

        boolean isDirectory = false;
        String path = "";

        if (Switches.contains(args, "-d", "--directory")){
            isDirectory = true;
            path = args[Switches.indexOf(args, "-d", "--directory") + 1];
        } else if (Switches.contains(args, "-f", "--file")) {
            path = args[Switches.indexOf(args, "-f", "--file") + 1];
        }else {
            Switches.help();
        }

        DecimalFormat df = new DecimalFormat("#.000000");
        if (isDirectory){
            File f = new File(path);
            String[] files = f.list();
            Comparator<String> numericalOrder = AlphanumericSortComparator.NUMERICAL_ORDER;
            Arrays.sort(files, numericalOrder);
            for (String file : files){
                Backpack backpack = FileInputReader.find(path+file);
                if (both){
                    long startTime = System.currentTimeMillis();
                    Map<Memoization.Index, Integer> memo = new HashMap<>();
                    System.out.println("New Memoization Result in "+ file + " "+ Memoization.execute(backpack.getItems(),
                            backpack.getCapacity(), backpack.getItems().size(), memo, new Memoization.Index(0, 0)));
                    long finalTime = System.currentTimeMillis() - startTime;
                    System.out.println("Time: " + df.format(finalTime / 1000.0) + " s");
                    System.out.println("********************************************************************************\n");

                    startTime = System.currentTimeMillis();
                    System.out.println("New Tabulation Result in "+ file + " "+ Tabulation.execute(backpack.getItems(), backpack.getCapacity()));
                    finalTime = System.currentTimeMillis() - startTime;
                    System.out.println("Time: " + df.format(finalTime / 1000.0) + " s");
                    System.out.println("********************************************************************************\n");

                } else if (mem) {

                    long startTime = System.currentTimeMillis();
                    Map<Memoization.Index, Integer> memo = new HashMap<>();
                    System.out.println("New Memoization Result in "+file + " "+ Memoization.execute(backpack.getItems(),
                            backpack.getCapacity(), backpack.getItems().size(), memo, new Memoization.Index(0, 0)));
                    long finalTime = System.currentTimeMillis() - startTime;
                    System.out.println("Time: " + df.format(finalTime / 1000.0) + " s");
                    System.out.println("********************************************************************************\n");

                } else if (tab) {

                    long startTime = System.currentTimeMillis();
                    System.out.println("New Tabulation Result in "+file + " "+ Tabulation.execute(backpack.getItems(), backpack.getCapacity()));
                    long finalTime = System.currentTimeMillis() - startTime;
                    System.out.println("Time: " + df.format(finalTime / 1000.0) + " s");
                    System.out.println("********************************************************************************\n");

                }
            }
        }else {
            Backpack backpack = FileInputReader.find(path);
            if (both){
                long startTime = System.currentTimeMillis();
                Map<Memoization.Index, Integer> memo = new HashMap<>();
                System.out.println("New Memoization Result in "+path + " "+ Memoization.execute(backpack.getItems(),
                        backpack.getCapacity(), backpack.getItems().size(), memo, new Memoization.Index(0, 0)));
                long finalTime = System.currentTimeMillis() - startTime;
                System.out.println("Time: " + df.format(finalTime / 1000.0) + " s");
                System.out.println("********************************************************************************\n");

                startTime = System.currentTimeMillis();
                System.out.println("New Tabulation Result in "+path + " "+ Tabulation.execute(backpack.getItems(), backpack.getCapacity()));
                finalTime = System.currentTimeMillis() - startTime;
                System.out.println("Time: " + df.format(finalTime / 1000.0) + " s");
                System.out.println("********************************************************************************\n");

            } else if (mem) {

                long startTime = System.currentTimeMillis();
                Map<Memoization.Index, Integer> memo = new HashMap<>();
                System.out.println("New Memoization Result in "+path + " "+ Memoization.execute(backpack.getItems(),
                        backpack.getCapacity(), backpack.getItems().size(), memo, new Memoization.Index(0, 0)));
                long finalTime = System.currentTimeMillis() - startTime;
                System.out.println("Time: " + df.format(finalTime / 1000.0) + " s");
                System.out.println("********************************************************************************\n");

            } else if (tab) {

                long startTime = System.currentTimeMillis();
                System.out.println("New Tabulation Result in "+path + " "+ Tabulation.execute(backpack.getItems(), backpack.getCapacity()));
                long finalTime = System.currentTimeMillis() - startTime;
                System.out.println("Time: " + df.format(finalTime / 1000.0) + " s");
                System.out.println("********************************************************************************\n");

            }
        }
    }
}