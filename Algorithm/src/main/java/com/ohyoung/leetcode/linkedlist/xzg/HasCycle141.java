package com.ohyoung.leetcode.linkedlist.xzg;

import com.ohyoung.leetcode.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，
 * 评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 * 提示：
 * 链表中节点的数目范围是 [0, 104]
 * -105 <= Node.val <= 105
 * pos 为 -1 或者链表中的一个 有效索引 。
 *
 * 进阶：你能用 O(1)（即，常量）内存解决此问题吗？
 *
 * 链接：<a href="https://leetcode.cn/problems/linked-list-cycle">...</a>
 * @author ohYoung
 * @date 2021/7/1 22:25
 */
public class HasCycle141 {

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next =  new ListNode(-4);
        head.next.next.next.next = head.next.next;
        System.out.print("hasCycle: " + hasCycle(head));

    }

    /**
     * 快慢指针，如果存在环，快慢指针会一直在环里移动，由于快指针每次都比慢指针多走一步，所以
     * 一定存在某个时刻，快指针会在N圈后追到慢指针，也就是fast==slow，这就是判断条件；
     * 假如不存在环，快指针一定先一步或者和慢指针同时走完链表
     * 边界条件：
     *      1、当链表为null时直接返回false
     *      2、当链表头节点的next为null时返回false（一个节点的链表肯定不是环）
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode soft = head;
        ListNode fast = head.next;
        while (soft != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            soft = soft.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 用Set存储节点，如果添加失败则表示已经添加过，证明当前链表是个环
     */
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

}
