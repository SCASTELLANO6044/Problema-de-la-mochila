import java.util.*;


public class Main {

    public static void main(String[] args) {

        String[] nombresArchivos = {"D:\\Coding\\Github projects\\Problema-de-la-mochila\\Problema de la mochila en java\\input-files\\1.txt",
                "D:\\Coding\\Github projects\\Problema-de-la-mochila\\Problema de la mochila en java\\input-files\\2.txt",
                "D:\\Coding\\Github projects\\Problema-de-la-mochila\\Problema de la mochila en java\\input-files\\3.txt"};

        List<Backpack> backpackList = FileInputReader.find(nombresArchivos);

        int i = 1;
        for (Backpack backpack : backpackList){
            System.out.println("New Memoization Result in "+i+".txt : "+ Memoization.execute(backpack.getItems(), backpack.getCapacity(), backpack.getItems().size(), new HashMap<>()));
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