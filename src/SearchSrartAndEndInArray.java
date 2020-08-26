import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSrartAndEndInArray {
    public static void main(String[] args){
        int[] nums = new int[]{2,3,4,5};
        int target = 6;
        SolutionSSAEI solutionSSAEI = new SolutionSSAEI();
        List<Integer> res = solutionSSAEI.finStartAndEnd(nums, target);
        System.out.println(res);
    }
}

class SolutionSSAEI{
    public List<Integer> finStartAndEnd(int[] nums, int target){
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target && (mid == 0 || nums[mid - 1] != target)){
                res.add(mid);
                break;
            }
            else if(nums[mid] >= target){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        left = 0;
        right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] != target)){
                res.add(mid);
                break;
            }
            else if(nums[mid] <= target){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        if(res.isEmpty()){
            res.addAll(Arrays.asList(-1, -1));
        }
        return res;
    }
}
