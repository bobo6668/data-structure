package bobo;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] arr, int N) {
        for (int i = 0; i < N; i++) {
            // 每一趟，找到最小元所在的位置pos
            int MinPosition = scanForMin(arr, i, N - 1);
            // 把最小元放到有序部分的最后面（第i次会放在第i个位置）
            int temp = arr[i];
            arr[i] = arr[MinPosition];
            arr[MinPosition] = temp;
        }
    }
    private int scanForMin (int[] arr, int start, int end) {
        int pos = start;
        for (int i = start + 1; i <= end; i++) { // 注意起始位置都是可达的
            if (arr[i] < arr[pos]) pos = i;
        }
        return pos; // 返回最小元所在的位置pos
    }
}
