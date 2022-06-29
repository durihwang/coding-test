import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void printNode(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public StringBuilder reverseNode(ListNode listNode) {
        StringBuilder stringBuilder = new StringBuilder();

        while (listNode != null) {
            stringBuilder.append(listNode.val);
            listNode = listNode.next;
        }

        return stringBuilder.reverse();
    }

    public ListNode addNode(ListNode listNode, ListNode newNode) {

        // 대상 노드가 비어있으면 새로운 노드를 그대로 넣어준다.
        if (listNode == null) {
            listNode = newNode;
        } else {

            // 대상 노드가 비어있지 않으면 가장 마지막 노드를 찾아준다.
            ListNode tempNode = listNode;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }

            // 가장 마지막 노드에 새로운 노드를 붙여준다.
            tempNode.next = newNode;
        }

        return listNode;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode listNode = null;
        int sum = 0;

        try {
            sum = Integer.parseInt(reverseNode(l1).toString()) + Integer.parseInt(
                reverseNode(l2).toString());
        } catch (Exception e) {
            return new ListNode(0);
        }

        String resultString = String.valueOf(sum);

        for (int i = resultString.length() - 1; i >= 0; i--) {
            Character c = resultString.charAt(i);
            int parseInt = Integer.parseInt(String.valueOf(c));

            ListNode newNode = new ListNode(parseInt);
            listNode = addNode(listNode, newNode);
        }

        printNode(listNode);

        return listNode;
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        /*ListNode listNode1 = new ListNode(9);
        ListNode listNode2 = new ListNode(1,
            new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));*/
        System.out.println(solution.addTwoNumbers(listNode1, listNode2));
    }
}
