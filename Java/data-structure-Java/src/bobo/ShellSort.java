package bobo;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] arr = {10, 9, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        shellSort.sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    private void sort (int[] arr, int N) {
        int D = 0; // D间隔

        for (D = N / 2; D > 0; D /= 2) { /* 希尔增量序列 */
            int i = 0;
            int j = 0;
            for (i = 0; i < N; i++) { // 【注意】i++。也就是说，虽然间隔着D在排序，但并不是完整排完一组才排下一组
                if (i < D) continue; // 第一次摸牌不用排序 // 【注意】在插入排序的基础上，改1为D、改-1为-D
                int temp = arr[i]; // 先记住牌的大小
                for (j = i; j >= D && arr[j - D] > temp; j -= D) { // 从后往前看已知的排，看看应该排在哪里
                    arr[j] = arr[j - D]; // 往后移出空位
                }
                arr[j] = temp; // 新牌落位
            }
        }
    }
}
