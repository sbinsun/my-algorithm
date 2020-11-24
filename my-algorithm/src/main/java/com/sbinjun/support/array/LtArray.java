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
//        System.out.println(ltArray.threeSum1(new int[]{-1,0,1,2,-1,-4}));
    }

    public List<List<Integer>> threeSum1(int[] nums) {// 总时间复杂度：O(n^2)
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) return ans;

        Arrays.sort(nums); // O(nlogn)

        for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
            if (nums[i] > 0) break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去掉重复情况
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    left++; right--; // 首先无论如何先要进行加减操作
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {  // nums[left] + nums[right] > target
                    right--;
                }
            }
        }
        return ans;
    }
}
