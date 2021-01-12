package bobo;

import dsa.Queue;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 8, 6, 7, 19, 11};
        System.out.println(Arrays.toString(nums));

        QuickSort quickSort = new QuickSort();
        quickSort.sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] nums, int left, int right) {
        if (left < right) { //【√】
            int mid = partition(nums, left, right);
            sort(nums, left, mid - 1);
            sort(nums, mid + 1, right);
        }
    }
    private int partition(int[] nums, int left, int right) {
        int value = nums[left]; //【√】
        int i = left, j = right; //【√】
        while (i < j) { //【√】
            while (nums[j] >= value && j > i) j--; //【√】
            while (nums[i] <= value && i < j) i++;
            if (i < j) swap(nums, i, j);
        }
        swap(nums, left, i); //【√】
        return i;
    }
    private void swap(int[] arr, int i, int j) { //【√】
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
