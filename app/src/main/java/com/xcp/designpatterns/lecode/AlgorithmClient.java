package com.xcp.designpatterns.lecode;

/**
 * Created by 许成谱 on 2019/7/19 11:45.
 * qq:1550540124
 * 热爱生活每一天！
 * 力扣算法练习
 */
public class AlgorithmClient {
    public static void main(String[] args) {


    }

    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
          for(int j = i; j < nums.length; j++) {
            if(nums[i]+nums[j]==target) {
                return new int[]{i,j};
            }
          }
        }
        return null;
    }
}


