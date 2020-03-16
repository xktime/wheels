package LeetCode;

/**
 * 725.
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 * 返回一个符合上述规则的链表的列表。
 * <p>
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 * 示例 1：
 * 输入:
 * root = [1, 2, 3], k = 5
 * 输出: [[1],[2],[3],[],[]]
 * 解释:
 * 输入输出各部分都应该是链表，而不是数组。
 * 例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
 * 第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
 * 最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
 */
public class SplitLinkedListInParts {
    public static void main(String[] args) {
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode tempNode = root;
        int num = 0;
        while (tempNode != null) {
            tempNode = tempNode.next;
            num++;
        }
        ListNode[] nodes = new ListNode[k];
        int mod = num % k;
        int size = num / k;
        for (int i = 0; i < k; i++) {
            nodes[0] = root;
            for (int j = 0; j < size - 1; j++) {
                root = root.next;
            }
            if (i < mod) {
                root = root.next;
            }
        }
        return nodes;
    }
}
