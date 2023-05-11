import java.util.*;

public class Memoization {

    public static Integer execute(List<BackpackItem> backpackItemList, Integer capacity, Integer positionIterator,
                                  Map<Memoization.Index, Integer> memo, Memoization.Index previousIndex){
        Memoization.Index index = new Index(positionIterator, capacity);
        if (memo.containsKey(index)){
            return memo.get(index);
        }
        Integer result;
        int currentPositionToEvaluate = backpackItemList.size() - positionIterator;
        if (positionIterator == 0){
            return 0;
        }
        if (backpackItemList.get(currentPositionToEvaluate).getWeight() > capacity) {
            positionIterator --;
            result = execute(backpackItemList ,capacity, positionIterator, memo, index);
        }else {
            BackpackItem itemEvaluated = backpackItemList.get(currentPositionToEvaluate);
            positionIterator --;
            Integer takenItem = execute(backpackItemList, capacity - itemEvaluated.getWeight(),positionIterator, memo, index) + itemEvaluated.getBenefit();
            Integer notTakenItem = execute(backpackItemList, capacity, positionIterator, memo, index);
            previousIndex.setI(positionIterator);
            if(takenItem > notTakenItem){
                previousIndex.setW(capacity - itemEvaluated.getWeight());
                result = takenItem;
            }else {
                previousIndex.setW(capacity);
                result = notTakenItem;
            }
        }
        index.setPreviousIndex(previousIndex);
        memo.put(index, result);
        return result;
    }

//    private static Integer maximum(Integer a, Integer b){
//        if (a > b){
//            return a;
//        }
//        return b;
//    }

    public static class Index {
        private int i;
        private int w;
        private Index previousIndex;
        public Index(int i, int w){
            this.i = i;
            this.w = w;
        }
        public void setI(int i) {
            this.i = i;
        }
        public void setW(int w) {
            this.w = w;
        }
        public void setPreviousIndex(Index previousIndex) {
            this.previousIndex = previousIndex;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Memoization.Index index = (Memoization.Index) o;
            return i == index.i && w == index.w;
        }
    }
}
