package org.example;
public class BackpackItemDTO {
    private final int index;
    private final int benefit;
    private final int weight;

    public BackpackItemDTO(int index, int benefit, int weight) {
        this.index = index;
        this.benefit = benefit;
        this.weight = weight;
    }

    public int getIndex() {
        return index;
    }

    public int getBenefit() {
        return benefit;
    }

    public int getWeight() {
        return weight;
    }
}
