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
        int D = 0; // D���

        for (D = N / 2; D > 0; D /= 2) { /* ϣ���������� */
            int i = 0;
            int j = 0;
            for (i = 0; i < N; i++) { // ��ע�⡿i++��Ҳ����˵����Ȼ�����D�����򣬵���������������һ�������һ��
                if (i < D) continue; // ��һ�����Ʋ������� // ��ע�⡿�ڲ�������Ļ����ϣ���1ΪD����-1Ϊ-D
                int temp = arr[i]; // �ȼ�ס�ƵĴ�С
                for (j = i; j >= D && arr[j - D] > temp; j -= D) { // �Ӻ���ǰ����֪���ţ�����Ӧ����������
                    arr[j] = arr[j - D]; // �����Ƴ���λ
                }
                arr[j] = temp; // ������λ
            }
        }
    }
}
