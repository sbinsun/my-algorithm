package com.sbinjun.support.search;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
//        int[] a = new int[]{1, 2, 4, 4, 5, 6,7,8};
//        System.out.println("result: " + binary(a,8,8));
//        System.out.println("result: " + binary1(a,8,8));
//        System.out.println("result: " + binary2(a,8,8));
//        System.out.println("result: " + binary3(a,8,4));
//        System.out.println("result: " + binary4(a,8,7));

        int[] a = new int[]{5,1,3};
        System.out.println("result: " + binarySearch.search(a,1));

    }

    private int binary(int[] a, int n, int value) {
        int low = 0;
        int high = n -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println("min index : " + mid + " , mid value : " + a[mid]);
            if (a[mid] == value) {
                return mid;
            }else if (a[mid] < value){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return -1;
    }

    // 查找第一个值等于给定值的元素
    private int binary1(int[] a, int n, int value) {
        int low = 0;
        int high = n -1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            System.out.println("min index : " + mid + " , mid value : " + a[mid]);
            if (a[mid] > value) {
                high = mid - 1;
            }else if (a[mid] < value) {
                low = mid +1;
            }else {
                if (mid == 0 || a[mid - 1] != value) {
                    return mid;
                }else {
                    high = mid -1;
                }
            }
        }
        return -1;
    }

    // 查找最后一个值等于给定值的元素
    private int binary2(int[] a, int n, int value) {
        int low = 0;
        int high = n -1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            System.out.println("min index : " + mid + " , mid value : " + a[mid]);
            if (a[mid] > value) {
                high = mid -1;
            }else if (a[mid] < value){
                low = mid + 1;
            }else {
                if (mid == (n - 1) || a[mid + 1] !=value) {
                    return mid;
                }else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    // 查找第一个大于等于给定值的元素
    private int binary3(int[] a, int n, int value) {
        int low = 0;
        int high = n -1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            System.out.println("min index : " + mid + " , mid value : " + a[mid]);
            if (a[mid] >= value) {
                if (mid == 0 || a[mid - 1] < value){
                    return mid;
                }else {
                    high = mid -1;
                }
            }else if (a[mid] < value){
                low = mid + 1;
            }
        }
        return -1;
    }

    // 查找最后一个小于等于给定值的元素
    private int binary4(int[] a, int n, int value) {
        int low = 0;
        int high = n -1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            System.out.println("min index : " + mid + " , mid value : " + a[mid]);
            if (a[mid] <= value) {
                if (mid == (n - 1) || a[mid + 1] > value) return mid;
                else low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int left = 0,right= nums.length - 1;

        while (nums[left] > nums[right]) {
            left++;
            right--;
        }

        int maxindex = right;
        System.out.println(maxindex);
        if (nums[0] <= target && target <= nums[maxindex]) {
            return binaryD(nums,0,maxindex,target);
        }else {
            return binaryD(nums,maxindex + 1,nums.length -1,target);
        }
    }

    public int binaryD(int[] nums,int low,int high,int target){

        while (low <= high){
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target) {
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }

        return -1;
    }

}
