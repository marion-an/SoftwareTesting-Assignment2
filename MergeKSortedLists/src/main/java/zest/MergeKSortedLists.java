package zest;

import java.util.List;
import java.util.PriorityQueue;


public class MergeKSortedLists {
    private int countNodes(ListNode[] lists) {
        int count = 0;
        for (ListNode node : lists) {
            count += countFinalNodes(node);
        }
        return count;
    }

    private int countFinalNodes(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    private boolean assertFinalNodeVals(ListNode node) {
        while (node != null) {
            if (node.val > 10000 || node.val < -10000) {
                return false;
            }
            node = node.next;
        }
        return true;
    }

    private boolean assertNodesVals(ListNode[] lists) {
        for (ListNode node : lists) {
            if (!assertFinalNodeVals(node)) {
                return false;
            }
        }
        return true;
    }

    private boolean listIsSorted(ListNode node) {
        while (node != null && node.next != null) {
            if (node.val > node.next.val) {
                return false;
            }
            node = node.next;
        }
        return true;
    }

    private boolean allListsAreSorted(ListNode[] lists) {
        for (ListNode node : lists) {
            if (!listIsSorted(node)) {
                return false;
            }
        }
        return true;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        assert lists.length >= 1  : "number of linkes lists has to be a positive integer";
        assert countNodes(lists) <= 10000 : "Too many nodes";
        assert assertNodesVals(lists) : "-10⁴<=node.value<=10⁴";
        assert allListsAreSorted(lists) : "lists need to be sorted in ascending order";

        int initialAmtOfNodes = countNodes(lists);

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null) {
                queue.add(tail.next);
            }
            assert tail != null : "Tail cannot be null";
        }

        assert countFinalNodes(dummy.next) == initialAmtOfNodes : "final list should have as many nodes as initially";
        assert listIsSorted(dummy.next) : "Merged list is not sorted";
        return dummy.next;
    }
}
