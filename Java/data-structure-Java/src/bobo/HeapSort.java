package bobo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {1, 10, 9, 8, 7, 7, 6, 5, 4, 3, 2, 1};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

//    private void sort(int[] arr, int N) {
//        Queue<Integer> heap = new PriorityQueue<>(); // ��Java�����ȶ��н�����
//        for (int i = 0; i < N; i++) {
//            heap.add(arr[i]); // Ĭ����С����
//        }
//        for (int i = 0; i < N; i++) {
//            arr[i] = heap.remove(); // ����ӶѶ�����
//        }
//    }

    private void sort(int[] arr, int N) {
        final int DEFAULT_INITIAL_CAPACITY = 10;
        Queue<Integer> heap = new PriorityQueue<>(DEFAULT_INITIAL_CAPACITY, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }); // ��Java�����ȶ��н�����
        for (int i = 0; i < N; i++) {
            heap.add(arr[i]); // �󶥶�
        }
        for (int i = 0; i < N; i++) {
            arr[i] = heap.remove(); // ����ӶѶ�������������������������Ӵ�С��
        }
    }

}
