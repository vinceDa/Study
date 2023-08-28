package com.ohyoung.leetcode.hash.pic;

/**
 * 141. 环形链表
 *
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 *  <a href="https://leetcode-cn.com/problems/linked-list-cycle/"></a>
 *
 * @author vince 2023/8/21 10:06
 */
public class HasCycle141 {
    public static void main(String[] args) {
        HasCycle141 hasCycle141 = new HasCycle141();
        ListNode head = hasCycle141.new ListNode(3);
        head.next = hasCycle141.new ListNode(2);
        head.next.next = hasCycle141.new ListNode(0);
        head.next.next.next = hasCycle141.new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(hasCycle141.hasCycle(head));

        head = hasCycle141.new ListNode(1);
        head.next = hasCycle141.new ListNode(2);
        head.next.next = head;
        System.out.println(hasCycle141.hasCycle(head));

        head = hasCycle141.new ListNode(1);
        head.next = hasCycle141.new ListNode(2);
        head.next.next = hasCycle141.new ListNode(3);
        System.out.println(hasCycle141.hasCycle(head));

        head = hasCycle141.new ListNode(1);
        head.next = hasCycle141.new ListNode(2);
        System.out.println(hasCycle141.hasCycle(head));

        head = hasCycle141.new ListNode(1);
        System.out.println(hasCycle141.hasCycle(head));

    }

    public boolean hasCycle(ListNode head) {
        // 链表为空或者只有一个元素时
        if (head == null || head.next == null) {
            return false;
        }

        // 利用快慢指针, 如果存在环则快慢指针一定会相遇
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != null && fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    /**
     * 方法1的判断条件略显臃肿, 可以使用slow!=fast为判断条件
     */
    public boolean hasCycle2(ListNode head) {
        // 链表为空或者只有一个元素时
        if (head == null || head.next == null) {
            return false;
        }

        // 利用快慢指针, 如果存在环则快慢指针一定会相遇
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
