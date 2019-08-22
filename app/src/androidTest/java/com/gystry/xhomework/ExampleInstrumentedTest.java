package com.gystry.xhomework;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    Random random = new Random();

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
//        int[] nums = new int[]{0, 3, 6, 4, 7, 8, 9};
//        int[] ints = twoSum(nums, 9);
//        ListNode listNode = new ListNode(2);
//        listNode.next = new ListNode(4);
//        listNode.next.next = new ListNode(3);
//        ListNode listNode2 = new ListNode(5);
//        listNode2.next = new ListNode(6);
//        listNode2.next.next = new ListNode(4);
//        ListNode listNode1 = addTwoNumbers(listNode, listNode2);
//        Log.e("ExampleInstrumentedTest", "useAppContext: " + listNode1);
        randommm();
    }

    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        out:
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Log.e("useAppContext", "twoSum: " + i + ":" + j);
                if (nums[i] + nums[j] == target) {
                    results[0] = i;
                    results[1] = j;
                    break out;
                }
            }
        }
        return results;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode current = listNode;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return listNode.next;
    }

    private void randommm() {
        for (int i = 0; i < 10; i++) {
            Log.e("ExampleInstrumentedTest", "randommm: " + random.nextInt(10));
        }
    }
}
