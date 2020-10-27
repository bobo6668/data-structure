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
            // ÿһ�ˣ��ҵ���СԪ���ڵ�λ��pos
            int MinPosition = scanForMin(arr, i, N - 1);
            // ����СԪ�ŵ����򲿷ֵ�����棨��i�λ���ڵ�i��λ�ã�
            int temp = arr[i];
            arr[i] = arr[MinPosition];
            arr[MinPosition] = temp;
        }
    }
    private int scanForMin (int[] arr, int start, int end) {
        int pos = start;
        for (int i = start + 1; i <= end; i++) { // ע����ʼλ�ö��ǿɴ��
            if (arr[i] < arr[pos]) pos = i;
        }
        return pos; // ������СԪ���ڵ�λ��pos
    }
}
