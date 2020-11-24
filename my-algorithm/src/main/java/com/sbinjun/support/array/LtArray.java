package com.sbinjun.support.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LtArray {

    // https://leetcode-cn.com/problems/3sum  三树之和
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);

        for (int left = 0; left < nums.length -2; left++){
            if (nums[left] > 0) break;
            if (left > 0 && nums[left] == nums[left -1]) {
                continue;
            }

            int target = -nums[left];
            int mid = left + 1;
            int right = nums.length -1;
            while (mid < right){
                if (nums[mid] + nums[right] == target) {
                    res.add(Arrays.asList(nums[left],nums[mid],nums[right]));
                    mid++;right--;
                    while (mid < right && nums[mid] == nums[mid -1]) {
                        mid++;
                    }
                    while (mid < right && nums[right] == nums[right +1]) {
                        right--;
                    }
                }else if (nums[mid] + nums[right] < target) {
                    mid++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LtArray ltArray= new LtArray();
        System.out.println(ltArray.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
