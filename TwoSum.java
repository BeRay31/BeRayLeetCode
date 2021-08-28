
class TwoSum {
	public static int[] solution(int[] nums, int target) {
		for(int i = 0; i < nums.length; i++) {
			if(
				(nums[i] > target && target > 0) ||
				(nums[i] < target && target < 0)
			) {
				continue;
			} else {
				int indexSearch = indexOf(nums, target-nums[i]); 
				if(indexSearch != -1 && indexSearch != i) {
					return new int[]{i, indexSearch};
				}
			}
		}
		return null;
	}
	public static int indexOf(int[] arr, int target) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == target) {
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] test = new int[]{2,7,11,15};
		int[] sol = solution(test, 26);
		for(int i = 0; i<sol.length; i++) {
			System.out.print(sol[i]);
		}
	}
}