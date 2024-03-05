package sort;

import java.util.Arrays;

/**
 * 从数组的第一个元素开始，比较相邻的两个元素。
 * 如果前一个元素大于后一个元素（升序排序），则交换它们的位置。
 * 步骤1和步骤2，直到遍历整个数组。
 * 上步骤，每次遍历都将最大的元素“冒泡”到数组的末尾。
 * 复以上步骤，但不包括已排序的最大元素，直到整个数组排序完成。
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,7,4,3,6,2};
        bubbleSort(arr);
        System.out.println("冒泡排序完的数组："+Arrays.toString(arr));

    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        //外部循环控制排序的趟数。冒泡排序的每一趟会将最大的元素"冒泡"到数组的末尾，因此需要执行 n-1 趟，其中 n 是元素的总数
        for (int i = 0; i < n - 1; i++) {
            //内循环控制每趟比较的次数。由于每一趟都会将一个最大的元素沉到数组末尾，所以内循环次数逐渐减小。
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换arr[j]和arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"趟："+ Arrays.toString(arr));
        }
    }

}
