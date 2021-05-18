package com.xcp.designpatterns.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 许成谱 on 2019/7/1 15:34.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class ClientSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        System.out.println(Arrays.toString(arr));
        long before = System.currentTimeMillis();
//        bubbleSort(arr);
//        selectSort(arr);
//        insertSort(arr);
//        shellSort(arr);
//        quickSort(arr, 0, arr.length - 1);
        quickSort2(arr, 0, arr.length - 1);
//        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
//        bucketSort(arr);
        long after = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        System.out.println("排序耗时:" + (after - before) + " ms");
//        isPalindrome(new ListNode(0, new ListNode(0, null)));
//        System.out.println(isHappy(19));
    }
    private static void quickSort2(int[] arr,int left,int right){

        if(left>right){
            return;
        }
        int i=left;int j=right;
        int base=arr[left];
        int temp;
        //满足条件就要一直比较下去
        while(left<right){
            //先挪右边
            while (arr[right]>=base&&left<right){
                right--;
            }
            while (arr[left]<=base&&left<right){
                left++;
            }
            //满足条件就交换
            if(left<right){
                temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }

        }
        //归位基数
        arr[i]=arr[left];
        arr[left]=base;
        //递归
        quickSort2(arr,i,left-1);
        quickSort2(arr,left+1,j);

    }

    /**
     * 冒泡排序
     *
     * 核心思想：不断的把最大的往后边挪，外层代表轮数，内层代表每轮需要挪动的次数
     *
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp=new ListNode(curr.val,pre) ;
            pre=temp;
            curr=curr.next;
        }
        while (pre != null && head != null) {
            if (pre.val != head.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        if (pre == null && head == null) {
            return true;
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
    }

    public static boolean isHappy(int n) {
        List<Integer> list = new ArrayList();
        while (n / 10 > 0) {
            list.add(n % 10);
            n = n / 10;
        }
        list.add(n);
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += Math.pow(list.get(i), 2);
        }
        if (sum == 1) {
            return true;
        } else {
            return isHappy(sum);
        }
    }

    /**
     * 选择排序
     *
     * @param arr
     */
    private static void selectSort(int[] arr) {
        //核心思想：不断从剩下的中找出最小的放前面
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    index = j;
                    min = arr[j];
                }
            }
            if (index != i) {//说明发生了变动
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    private static void insertSort(int[] arr) {
        //核心思想：从第二位开始，与前面有序队列进行比较找位置
        for (int i = 1; i < arr.length; i++) {
            int target = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && arr[insertIndex] > target) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = target;
        }
    }

    /**
     * 希尔排序移位法
     *
     * @param arr
     */
    private static void shellSort(int[] arr) {
        //分组，每次组数为上次的一半 缩小增量，使用插入排序使每个子数组变的有序
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //分组后分别进行插入排序
            for (int i = gap; i < arr.length; i++) {
                //内部来一次插入排序
                int index = i;
                int target = arr[i];
                while (index - gap >= 0 && target < arr[index - gap]) {
                    arr[index] = arr[index - gap];
                    index = index - gap;
                }
                arr[index] = target;
            }
        }
    }

    /**
     * 快速排序
     *
     * @param arr
     * @param left
     * @param right
     */
    private static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(l + r) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //避免死循环
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        //防止栈溢出
        if (l == r) {
            l++;
            r--;
        }
        //左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

    /**
     * 归并排序
     *
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        //采用先分治再合并的思想
        int l = left;
        int r = right;
        int mid = (left + right) / 2;//中间位置，即第一组的末尾
        //分组
        if (l < r) {
            //向左递归
            mergeSort(arr, l, mid, temp);
            //向右递归
            mergeSort(arr, mid + 1, right, temp);
            //合并
            merge(arr, l, r, temp);
        }
    }

    private static void merge(int[] arr, int left, int right, int[] temp) {
        int i = left;//左边数组的指针
        int mid = (left + right) / 2;//中间位置，即第一组的末尾
        int j = mid + 1;//右边数组的指针
        int t = 0;//临时数组的指针

        //1、左右指针一直循环相互比较大小，谁小就拿出来填充到临时数组中,指针后移,直到一方没有了为止
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        //2、把剩余一组的数据都复制到临时数组中
        //左边剩余
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }
        //3、把临时数组的数都拷贝到原数组中
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            tempLeft++;
            t++;
        }
    }

    /**
     * 基数排序  典型的拿空间换时间的排序操作，算法稳定，速度快
     * 数组有负数的时候不能直接这么用，需要对代码改进一下
     *
     * @param arr
     */
    private static void bucketSort(int[] arr) {

        //5、找到数组的最大值
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //1、新建一个容器桶，用来装数据.二维数组：一个维度表示0-9号桶，另个维度表示桶将要容纳的数据
        int[][] bucket = new int[10][arr.length];
        //2、新建一个数组，用来标志每个桶装了多少数据.0-9号桶
        int[] elementCount = new int[10];
        //6、进行长度-1轮布置到桶里再拿回来的操作,每次取的标志数字不同（个位或者十位、百位等）
        int length = (max + "").length();
        for (int k = 0, n = 1; k < length; k++, n *= 10) {
            //3、把每个数据按标志数字（个位或者十位、百位等）放入桶内
            for (int i = 0; i < arr.length; i++) {
                int digitOfElement = arr[i] / n % 10;
                bucket[digitOfElement][elementCount[digitOfElement]] = arr[i];
                elementCount[digitOfElement]++;
            }

            //4、从桶内依次取出数据
            int index = 0;
            for (int i = 0; i < elementCount.length; i++) {
                if (elementCount[i] != 0) {
                    for (int j = 0; j < elementCount[i]; j++) {
                        //从桶内依次拿出来赋值给arr
                        arr[index] = bucket[i][j];
                        index++;
                    }
                    //拿出来后清空，为下一次做准备
                    elementCount[i] = 0;
                }
            }
        }

    }
}
