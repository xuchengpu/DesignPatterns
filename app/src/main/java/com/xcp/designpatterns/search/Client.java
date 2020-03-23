package com.xcp.designpatterns.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 许成谱 on 2019/7/4 12:00.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class Client {
    public static void main(String[] args) {
        int[] arr = new int[]{-47, -22, 11, 11, 11, 26, 35, 100, 120};
//        List<Integer> search = linearSearch(arr, 11);
//        List<Integer> search = binarySearch(arr, 0, arr.length - 1, 11);
        List<Integer> search = insertValSearch(arr, 0, arr.length - 1, -417);
        System.out.println("找到的数据为search=：" + search);
    }

    /**
     * 线性查找,简单，没什么可说的
     *
     * @param arr
     * @param target
     * @return 索引下标
     */
    public static List<Integer> linearSearch(int[] arr, int target) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                temp.add(i);
            }
        }
        return temp;
    }

    /**
     * 二分查找，要求查找的序列必须是有序的
     *
     * @param arr
     * @param left
     * @param right
     * @param target
     * @return 索引下标
     */
    public static List<Integer> binarySearch(int[] arr, int left, int right, int target) {
        //5、如果查找的索引左指针大于索引右指针结束递归
        if (left > right) {
            return new ArrayList<>();
        }
        //1、找到中间值的下标
        int mid = (left + right) / 2;

        if (arr[mid] > target) {
            //2、如果中间值比目标值大，则递归查找左边
            binarySearch(arr, left, mid - 1, target);
        } else if (arr[mid] < target) {
            //3、如果中间值比目标值小，则递归查找右边
            binarySearch(arr, mid + 1, right, target);
        } else {
            //4、如果正好相等，则循环向左右查找，直到与目标值值不相等，相等的都一起加入到集合里返回
            List<Integer> temp = new ArrayList<>();
            int index = mid - 1;
            while (index >= 0 && arr[index] == target) {
                temp.add(0,index);
                index--;
            }
            temp.add(mid);
            index = mid + 1;
            while (index <= arr.length - 1 && arr[index] == target) {
                temp.add(index);
                index++;
            }
            return temp;
        }
        return new ArrayList<Integer>();
    }
    /**
     * 插值查找，二分查找的一种优化变种，要求查找的序列必须是有序的。采用中间值自适应目标值的方式，
     * 对数据量大且关键字分布比较均匀的查找效率较高
     *
     * @param arr
     * @param left
     * @param right
     * @param target
     * @return 索引下标
     */
    public static List<Integer> insertValSearch(int[] arr, int left, int right, int target) {
        //5、如果查找的索引左指针大于索引右指针结束递归  注意后边这两个||必须要有，不仅提高效率，提前结束还能防止由于target过大导致的arr[mid]越界
        if (left > right||arr[left]>target||arr[right]<target) {
            return new ArrayList();
        }
        //1、找到中间值的下标
        int mid = left+(right-left )*(target-arr[left]) / (arr[right]-arr[left]);

        if (arr[mid] > target) {
            //2、如果中间值比目标值大，则递归查找左边
            binarySearch(arr, left, mid - 1, target);
        } else if (arr[mid] < target) {
            //3、如果中间值比目标值小，则递归查找右边
            binarySearch(arr, mid + 1, right, target);
        } else {
            //4、如果正好相等，则循环向左右查找，直到与目标值值不相等，相等的都一起加入到集合里返回
            List<Integer> temp = new ArrayList<>();
            int index = mid - 1;
            while (index >= 0 && arr[index] == target) {
                temp.add(0,index);
                index--;
            }
            temp.add(mid);
            index = mid + 1;
            while (index <= arr.length - 1 && arr[index] == target) {
                temp.add(index);
                index++;
            }
            return temp;
        }
        return new ArrayList();
    }
}
