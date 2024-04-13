/*
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting?

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        createHeap(nums);
    
        for(int i=0; i<k; i++){
            delete(nums, i);
        }
        return nums[nums.length-k];
    }

    private void createHeap(int[] nums){
        for(int i=1; i<nums.length; i++){
            insert(nums, i);
        }
    } 

    private void insert(int[] nums, int i){
        int t = nums[i];
        int pi = i%2 != 0 ? i/2 : (i/2) - 1;
        while(i != 0 && t > nums[pi]){
            nums[i] = nums[pi];
            i = pi;
            pi = i%2 != 0 ? i/2 : (i/2) - 1;
        }
        nums[i] = t;
    }

    private void delete(int[] nums, int k){
        int t = nums[0];
        int l = nums.length - 1-k;
        nums[0] = nums[l];
        int i = 0;
        int j = 1;
        while(j < l){
            if(nums[j] < nums[j+1])
                j++;
            if(nums[i] < nums[j]){
                int t2 = nums[j];
                nums[j] = nums[i];
                nums[i] = t2;
                i = j;
                j = (i*2)+1;
            }
            else
                break;
        }
        nums[l] = t;
    }
}
