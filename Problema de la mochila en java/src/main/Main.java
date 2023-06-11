package main;

import dynamicprogramming.Memoization;
import dynamicprogramming.Tabulation;
import utils.Backpack;
import utils.FileInputReader;
import utils.input.Switches;

import java.util.*;


public class Main {

    public static void main(String[] args) {

//        String[] nombresArchivos = {"D:\\Coding\\Github projects\\Problema-de-la-mochila\\Problema de la mochila en java\\input-files\\1.txt",
//                "D:\\Coding\\Github projects\\Problema-de-la-mochila\\Problema de la mochila en java\\input-files\\2.txt",
//                "D:\\Coding\\Github projects\\Problema-de-la-mochila\\Problema de la mochila en java\\input-files\\3.txt",
//                "D:\\Coding\\Github projects\\Problema-de-la-mochila\\Problema de la mochila en java\\input-files\\4.txt"};


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

        String[] nombresArchivos = {"C:\\GitHubProjects\\Problema-de-la-mochila\\Problema de la mochila en java\\input-files\\5.txt"};

        List<Backpack> backpackList = FileInputReader.find(nombresArchivos);
        Map<Memoization.Index, Integer> memo = new HashMap<>();
        int i = 1;
        for (Backpack backpack : backpackList){
            System.out.println("New Memoization Result in "+i+".txt : "+ Memoization.execute(backpack.getItems(), backpack.getCapacity(), backpack.getItems().size(), memo, new Memoization.Index(0, 0)));
            System.out.println("********************************************************************************\n");
            i++;
        }

        for (Backpack backpack : backpackList){
            System.out.println("New Tabulation Result in "+i+".txt : "+ Tabulation.execute(backpack.getItems(), backpack.getCapacity()));
            System.out.println("********************************************************************************\n");
            i++;
        }


    }
}