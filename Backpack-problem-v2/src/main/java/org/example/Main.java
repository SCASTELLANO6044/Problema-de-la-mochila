package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Main {


    public static void main(String[] args) {

        BackpackItemDTO backpackItemDTO = new BackpackItemDTO(0, 3, 2);
        BackpackItemDTO backpackItemDTO1 = new BackpackItemDTO(1, 4, 3);
        BackpackItemDTO backpackItemDTO2 = new BackpackItemDTO(2, 5, 4);
        BackpackItemDTO backpackItemDTO3 = new BackpackItemDTO(3, 6, 5);

        List<BackpackItemDTO> backpack = new ArrayList<>();
        backpack.add(backpackItemDTO);
        backpack.add(backpackItemDTO1);
        backpack.add(backpackItemDTO2);
        backpack.add(backpackItemDTO3);

        int maximumCapacity = 5;
        Map<BackpackItemDTO, Integer> memory = new HashMap<>();
        Integer result = memoization(backpack, backpack.size()-1, maximumCapacity, memory);
        System.out.println(result);
    }

    public static Integer memoization (List<BackpackItemDTO> backpack, int index, int maximumCapacity, Map<BackpackItemDTO, Integer> memory){

        BackpackItemDTO backpackItemDTO = backpack.get(index);
        if (memory.containsKey(backpackItemDTO)){
            return memory.get(backpackItemDTO);
        }

        if (backpackItemDTO.getWeight() > maximumCapacity){
            return memoization(backpack, index - 1, maximumCapacity, memory);
        }

        if (backpackItemDTO.getIndex() <= 0){
            memory.put(backpackItemDTO, backpackItemDTO.getBenefit());
            return backpackItemDTO.getBenefit();
        }

        Integer taken = memoization(backpack, index-1, maximumCapacity- backpackItemDTO.getBenefit(), memory)
                + backpackItemDTO.getBenefit();
        Integer notTaken = memoization(backpack, index-1, maximumCapacity, memory);
        Integer result = Integer.max(taken, notTaken);
        memory.put(backpackItemDTO, result);
        return result;
    }
}