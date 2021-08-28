public class RemoveDuplicates {
  public static int solution(int[] nums) {
    if(nums.length == 0) {
      return 0;
    }
    int point1 = 0;
    for(int i = 1; i < nums.length;i++) {
        if(nums[point1] != nums[i]) {
            point1++;
            nums[point1] = nums[i];
        }
    }
    return point1+1;
  }
}
