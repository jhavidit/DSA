package binarySeachTree.importantProblems;

public class SortedListToAVL {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int d) {
            val = d;
            next = null;
        }
    }

    ListNode head;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode root;

    SortedListToAVL(int val) {
        root = new TreeNode(val);
    }

    SortedListToAVL() {
        root = null;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.val);
        if (slow == head)
            return node;
        prev.next = null;
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(slow.next);
        return node;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(-10);
        list.next = new ListNode(-3);
        list.next.next = new ListNode(0);
        list.next.next.next = new ListNode(5);
        list.next.next.next.next = new ListNode(9);
        SortedListToAVL obj = new SortedListToAVL();
        System.out.println(obj.sortedListToBST(list));

    }

}
