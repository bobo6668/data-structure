package bobo;

import java.util.Arrays;

public class Sort {
    // 0. 交换数值
    protected void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // 1. 选择排序
    // 从数组中选择最小元素，将它与数组的第一个元素交换位置。
    // 再从数组剩下的元素中选择出最小的元素，将它与数组的第二个元素交换位置。
    // 不断进行这样的操作，直到将整个数组排序
    protected void selection(int[] nums, int size) {
        int min;
        for (int i = 0; i < size - 1; i++) {
            min = i;
            for (int j = i + 1; j < size; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            // 把min换到i位置
            if (min != i) {
                swap(nums, min, i);
            }
        }
    }

    // 2. 冒泡排序
    // 从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
    // 在一轮循环中，如果没有发生交换，那么说明数组已经是有序的，此时可以直接退出。
    protected void bubble(int[] nums, int size) {
        for (int i = 0; i < size; i++) {
            boolean swapped = false;
            for (int j = 0; j < size - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // 3. 归并排序
    // 分而治之: 将数组分为两个子数组分别排序，并将有序的子数组归并使得整个数组排序
    // 图解 https://www.cnblogs.com/chengxiao/p/6194356.html
    protected void merge(int[] nums, int size) {
        int left = 0, right = size - 1;
        int[] tmp = new int[size]; // 临时数组
        mergeHelper(nums, left, right, tmp);
    }

    private void mergeHelper(int[] nums, int left, int right, int[] tmp) {
        if (left >= right) return;
        // 递归
        int mid = (left + right) / 2;
        mergeHelper(nums, left, mid, tmp);
        mergeHelper(nums, mid + 1, right, tmp);
        // 归并
        // ① 先填到tmp
        int p1 = left, p2 = mid + 1, pt = p1;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) tmp[pt++] = nums[p1++];
            else tmp[pt++] = nums[p2++];
        }
        while (p1 <= mid) tmp[pt++] = nums[p1++]; // 把左侧数组剩余的元素都填进tmp
        while (p2 <= right) tmp[pt++] = nums[p2++]; // 把右侧数组剩余的元素都填进tmp
        // ② 再填回原数组
        for (int i = left; i <= right; i++) {
            nums[i] = tmp[i];
        }
    }

    // 4. 快速排序
    // 通过一个切分元素将数组分为两个子数组
    // 左子数组小于等于切分元素，右子数组大于等于切分元素
    // 将这两个子数组排序也就将整个数组排序了
    protected void quick(int[] nums, int size) {
        int left = 0, right = size - 1;
        quickHelper(nums, left, right);
    }

    private void quickHelper(int[] nums, int left, int right) {
        System.out.println("【排序】 left = " + left + " right = " + right);
        if (left < right) { // 也指出了递归出口
            int mid = partition(nums, left, right); // 选取切分元素，并分成左右两个数组
            quickHelper(nums, left, mid - 1);
            quickHelper(nums, mid + 1, right);
        }
    }

    // 切分方法1：交换
    private int partition(int[] nums, int left, int right) {
        int value = nums[left]; // 选择切分元素
        System.out.println("切分元素：" + value);
        int i = left, j = right; // 两个指针向中间搜索
        while (i < j) {
            // 从数组的右端向左扫描找到第一个小于它的元素 // 【√】先从右边开始可以保证i,j相等的时候，arr[i] = arr[j] 小于基准值
            while (nums[j] >= value && j > i) j--; // 【√】注意这里要用>=，这样才会跳过left
            // 从数组的左端向右扫描直到找到第一个大于它的元素
            while (nums[i] <= value && i < j) i++;
            if (i < j) {
                System.out.println(" i = " + i + ", j = " + j);
                swap(nums, i, j); // 交换元素
                System.out.println("中间交换：" + Arrays.toString(nums));
            }
        }
        System.out.println(" left = " + left + ", i = " + i + ", j = " + j);
        swap(nums, left, i); // 【√】把切分元素从左边换到中间
        System.out.println("切分后：" + Arrays.toString(nums));
        return i;
    }
    // 切分方法2：覆盖
//    protected int partition(int[] nums, int left, int right) {
//        int value = nums[left]; // 选择切分元素
//        // System.out.println("切分元素：" + value);
//        int i = left, j = right; // 两个指针向中间搜索
//        while (i < j) {
//            while (nums[j] > value && j > i) j--; // 先右指针
//            if (i < j) {
//                nums[i] = nums[j]; // 覆盖到左边去 // 第一次被覆盖的是 i = left，已经存到value里，后面可以恢复
//                i++;
//            }
//            while (nums[i] < value && i < j) i++; // 再左指针
//            if (i < j) {
//                nums[j] = nums[i]; // 覆盖到右边去
//                j--;
//            }
//        }
//        nums[i] = value; // 退出循环时 i = j，最后再把切分元素恢复回来
//        // System.out.println("切分后：" + Arrays.toString(nums));
//        return i;
//    }
    // 改良版本，弃用，有点乱
//    protected void quickHelper(int[] nums, int left, int right) {
//        // 【】递归终止条件 <= 两个数 因为后面有 right - 2 之类的情况？
//        if (left + 1 >= right) return;
//        // 选切分元素
//        int pivot = median3(nums, left, right); // 注意pivot是暂时放在 right - 1 位置
////        System.out.println(pivot);
//        // 调一下顺序，让左子数组小于等于切分元素，右子数组大于等于切分元素
//        int i = left + 1, j = right - 2; // 只需要考虑 nums[left + 1] ... nums[right - 2]
//        while (true) {
//            while (nums[i] < pivot) i++; // && i < right
//            while (nums[j] > pivot) j--; // && j > left
//            if (i < j) swap(nums, i, j);
//            else break;
//        }
//        swap(nums, right - 1, i); // 把切分元素放回去数组中间
//
////        System.out.println(Arrays.toString(nums));
//        // 分别排序
//        quickHelper(nums, left, i - 1);
//        quickHelper(nums, i + 1, right);
//    }
//    protected int median3(int[] nums, int left, int right) {
//        int mid = (left + right) / 2;
//        if (nums[left] > nums[mid]) swap(nums, left, mid);
//        if (nums[left] > nums[right]) swap(nums, left, right); // 左边放最小的数字
//        if (nums[mid] > nums[right]) swap(nums, mid, right); // 右边放最大的数字
//        // 现在满足 nums[left] <= nums[mid] <= nums[right]
//        swap(nums, mid, right - 1); // 藏到右边
//        // 只需要考虑 nums[left + 1] ... nums[right - 2]
//        return nums[right - 1];
//    }

    public static void main(String[] args) {
//        int[] numsTest = {10, 7, 2, 3, 8, 4, 5};
//        int[] numsTest = {10, 10, 10, 3, 8, 4, 5};
        int[] numsTest = {5, 7, 2, 3, 8, 4, 10};
        System.out.println("原数组：" + Arrays.toString(numsTest)); // 打印

        Sort sort = new Sort();
        sort.quick(numsTest, numsTest.length); // 选择排序算法
        System.out.println("排序后：" + Arrays.toString(numsTest)); // 打印
    }
}