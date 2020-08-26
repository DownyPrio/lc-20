public class DivSearch {
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,5,7,8,10};
        int target =0;
        SolutionDS solutionDS = new SolutionDS();
        int res = solutionDS.findIndex(nums, target);
        System.out.println(res);
    }
}

class SolutionDS{
    public int findIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        if(right < 0 || target > nums[right]){
            return left;
        }
        else{
            return right;
        }

    }
}
