package sort;

/**
 * Created by zhengmk on 2018/8/10 0010.
 */
public class Sort {

    public static void main(String[] args) {
        int[] a = {9, 5, 7, 52, 3, 4, 7, 17, 64, 10};
        //maopao(a);
        //HeapSort(a);
        //insertSort(a);
        //mergeSort(a, 0, a.length - 1, new int[a.length]);
        //quickSort(a, 0, a.length - 1);
        //selectSort(a);
        shellSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    /**
     * 希尔排序
     *
     * @param a
     */
    private static void shellSort(int[] a) {
        for (int i = (a.length - 1) / 2; i > 0; i = i / 2) {
            for (int j = 0; j < i; j++) {
                for (int k = i + j; k < a.length; k++) {
                    if (a[k] < a[k - i]) {
                        swap(a, k, k - i);
                    }
                }
            }
        }
    }

    /**
     * 选择排序
     *
     * @param a
     */
    private static void selectSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                }
            }
        }
    }

    /**
     * 快速排序
     *
     * @param a
     */
    private static void quickSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = a[start];
        int i = start, j = end;
        while (i < j) {
            while (temp < a[j] && i < j) {
                j--;
            }
            if (i < j) {
                swap(a, i, j);
                i++;
            }
            while (temp > a[i] && i < j) {
                i++;
            }
            if (i < j) {
                swap(a, i, j);
                j--;
            }

        }
        quickSort(a, start, i - 1);
        quickSort(a, i + 1, end);
    }

    /**
     * 冒泡排序
     *
     * @param a
     */
    private static void maopao(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    swap(a, i, j);
                }
            }
        }
    }

    /**
     * 堆排序
     *
     * @param a
     */
    private static void HeapSort(int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            buildMaxHeap(a, 0, i);
            swap(a, 0, i);
        }
    }

    /**
     * 构建最大堆
     *
     * @param a
     * @param start
     * @param end
     */
    private static void buildMaxHeap(int[] a, int start, int end) {
        for (int i = (start + end - 1) / 2; i >= 0; i--) {
            int cur = i;
            while (cur * 2 + 1 <= end) {
                int index = cur * 2 + 1;
                if (cur * 2 + 2 <= end) {
                    if (a[index] < a[index + 1]) {
                        index = index + 1;
                    }
                }
                if (a[cur] < a[index]) {
                    swap(a, cur, index);
                    cur = index;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 直接插入排序
     *
     * @param a
     */
    private static void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[j + 1] >= a[j]) {
                    break;
                } else {
                    swap(a, j, j + 1);
                    //j--;
                }
            }
        }
    }

    /**
     * 归并排序
     *
     * @param a
     */
    private static void mergeSort(int[] a, int start, int end, int[] tmp) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(a, start, mid, tmp);
            mergeSort(a, mid + 1, end, tmp);
            merge(a, start, mid, end, tmp);
        }

    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左序列的开始索引
        int j = mid + 1;//右序列的开始索引
        int k = 0;//合并临时数组的开始索引
        while (i <= mid && j <= right) {//左右序列上的 数字  排序到 temp上，直到左右子序列 一个循环完
            if (arr[i] <= arr[j]) {//说明j所在的序列的值大
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }

        }
        while (i <= mid) {//说明j所在序列排序完毕了
            temp[k++] = arr[i++];
        }
        while (j <= right) {//说明i所在序列排序完毕了
            temp[k++] = arr[j++];
        }
        k = 0;
        while (left <= right) {//将两个子序列 归到arr数组中
            arr[left++] = temp[k++];
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
