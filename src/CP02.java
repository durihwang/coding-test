import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CP02 {

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

    public ListNode solution() {

        ListNode l1 = addLastNode(new ListNode(), 1);
        l1 = addLastNode(l1, 3);
        l1 = addLastNode(l1, 9);

        ListNode l2 = addLastNode(new ListNode(), 3);
        l2 = addLastNode(l2, 5);
        l2 = addLastNode(l2, 2);

        printNode(l1);
        printNode(l2);

        ListNode listNode = new ListNode(0);
        ListNode resultNode = listNode;
        int carry = 0;

        while (l1 != null || l2 != null) {

            // 이전 while문에서 carry 값이 넘어오면 sum에 먼저 더해준다.
            int sum = carry;

            // 첫번째 노드가 null이 아니면 sum에 더해준다.
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // 두번째 노드가 null이 아니면 sum에 더해준다.
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // sum 값이 10을 넘어가면 carry의 값을 1로 변경하고 sum-10을 다음 노드의 값으로 넣어준다.
            // 10을 넘지 않으면 그대로 다음 노드의 값으로 넣어준다.
            if (sum >= 10) {
                listNode.next = new ListNode(sum - 10);
                carry = 1;
            } else {
                listNode.next = new ListNode(sum);
                carry = 0;
            }

            listNode = listNode.next;
            System.out.println();
        }

        // 마지막 계산에서 carry 값이 있다면 다음 노드 하나를 더 추가해서 1을 넣어준다.
        if (carry == 1) {
            listNode.next = new ListNode(carry);
        }

        printNode(resultNode);

        return resultNode.next;

    }

    public void printFistNodeToList(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode != null) {
            list.add(listNode.val);
        }
        while (listNode.next != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public void printNode(ListNode listNode) {
        while (listNode.next != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode addLastNode(ListNode listNode, int val) {
        ListNode newNode = new ListNode(val);
        if (listNode == null) {
            listNode = newNode;
        } else {
            listNode.next = newNode;
            listNode = newNode;
        }
        return listNode;
    }

    public ListNode addFirstNode(ListNode listNode, int val) {
        if (listNode == null) {
            return new ListNode(val);
        }
        ListNode newNode = new ListNode(val);
        newNode.next = listNode;
        return newNode;
    }

    public static void main(String[] args) throws IOException {
        CP02 solution = new CP02();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        System.out.println(solution.solution());
    }
}
