import java.util.List;

public class Backpack {
    private Integer capacity;
    private List<BackpackItem> items;

    public Backpack(Integer capacity, List<BackpackItem> items) {
        this.capacity = capacity;
        this.items = items;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public List<BackpackItem> getItems() {
        return items;
    }
}
