public class SearchInSwitchedArray {

    public static void main(String[] args){
        int[] nums = new int[]{4,5,6,1,2,3};
        int target = 7;
        SolutionSIS solutionSIS = new SolutionSIS();
        int res = solutionSIS.findIndex(nums, target);
        System.out.println(res);


    }
}

class SolutionSIS{
    public int findIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[left] == target) {
                return left;
            }
            else if(nums[right] == target){
                return right;
            }
            else if(nums[mid] > target){
                if(nums[left] > target){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
            else{
                if(nums[right] < target){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }

            }
        }
        return -1;
    }
}
