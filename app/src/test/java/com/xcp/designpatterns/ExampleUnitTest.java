package com.xcp.designpatterns;

import static com.xcp.designpatterns.lecode.LeetCodeAlgorithm.searchRange;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        int[] nums=new int[]{5,7,7,8,8,10};
        searchRange(nums,8);
//        assertEquals(4, 2 + 2);
    }
}