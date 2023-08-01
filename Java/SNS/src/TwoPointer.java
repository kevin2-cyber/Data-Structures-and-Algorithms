public class TwoPointer {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 6, 7, 11, 13, 14};
        int target = 9;

        int[] result = findTwoNumbers(nums,target);

        if (result.length == 2) {
            System.out.println("Two numbers found: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No pair of numbers found.");
        }

    }

    public static int[] findTwoNumbers(int[] nums, int target){
        int left = 0; // Pointer at the start of the array
        int right = nums.length - 1; // Pointer at the end of the array

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                // Return the two numbers that add up to the target
                return new int[]{nums[left], nums[right]};
            } else if (sum < target) {
                // Move the left pointer to increase the sum
                left++;
            } else {
                // Move the right pointer to increase the sum
                right--;
            }
        }

        // If no such pair is found, return an empty array
        return new int[0];
    }
}
