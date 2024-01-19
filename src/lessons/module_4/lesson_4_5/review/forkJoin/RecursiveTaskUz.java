package lessons.module_4.lesson_4_5.review.forkJoin;

import java.util.concurrent.RecursiveTask;

public class RecursiveTaskUz<I extends Number> extends RecursiveTask<Integer> {
    private int[] nums;
    private int fromIndex;
    private int toIndex;

    public RecursiveTaskUz(int[] nums, int fromIndex, int toIndex) {
        this.nums = nums;
        this.fromIndex = fromIndex;
        this.toIndex = toIndex;
    }

    @Override
    protected Integer compute() {
        int result=-1;
        if(toIndex-fromIndex<=10){
            int maks=nums[fromIndex];
            for (int i = fromIndex+1; i <toIndex ; i++) {
                if(nums[i]>maks){
                    maks=nums[i];
                }
            }
            result=maks;
        }else {
            RecursiveTaskUz<Number> recursiveTaskUz = new RecursiveTaskUz<Number>(nums, fromIndex, (toIndex + fromIndex) / 2);
            RecursiveTaskUz<Number> recursiveTaskUz1 = new RecursiveTaskUz<Number>(nums,  (toIndex + fromIndex) / 2, toIndex);
            recursiveTaskUz.join();
            recursiveTaskUz1.join();
            result = recursiveTaskUz.compute()+recursiveTaskUz1.compute();
        }
        return result;
    }
}
