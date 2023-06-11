package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputReader {

    private FileInputReader (){
        throw new IllegalStateException("Utility class");
    }

    public static List<Backpack> find(String[] nombresArchivos){
        List<Backpack> backpackList = new ArrayList<>(nombresArchivos.length);
        for (String nombreArchivo : nombresArchivos) {
            List<BackpackItem> filesData = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
                String linea = br.readLine();
                String[] valores = linea.split(" ");
                int numItems = Integer.parseInt(valores[0]);
                int pesoMaximo = Integer.parseInt(valores[1]);
                for (int i = 0; i < numItems; i++) {
                    linea = br.readLine();
                    valores = linea.split(" ");
                    int valor = Integer.parseInt(valores[0]);
                    int peso = Integer.parseInt(valores[1]);
                    filesData.add(new BackpackItem(peso, valor, numItems-i));
                }
                backpackList.add(new Backpack(pesoMaximo, filesData));
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        return backpackList;
    }
}
