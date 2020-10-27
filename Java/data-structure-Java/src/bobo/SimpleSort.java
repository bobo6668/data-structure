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
            if (i == 0) continue; // ��һ�����Ʋ�������
            int temp = arr[i]; // �ȼ�ס�ƵĴ�С
            for (j = i; j > 0 && arr[j - 1] > temp; j--) { // �Ӻ���ǰ����֪���ţ�����Ӧ����������
                arr[j] = arr[j - 1]; // �����Ƴ���λ
            }
            arr[j] = temp; // ������λ
        }
    }
}
