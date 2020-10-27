package bobo;

import java.util.Arrays;

public class SimpleSort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SimpleSort simpleSort = new SimpleSort();
        simpleSort.sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] arr, int N) {
        int i = 0;
        int j = 0;
        for (i = 0; i < N; i++) {
            if (i == 0) continue; // 第一次摸牌不用排序
            int temp = arr[i]; // 先记住牌的大小
            for (j = i; j > 0 && arr[j - 1] > temp; j--) { // 从后往前看已知的排，看看应该排在哪里
                arr[j] = arr[j - 1]; // 往后移出空位
            }
            arr[j] = temp; // 新牌落位
        }
    }
}
