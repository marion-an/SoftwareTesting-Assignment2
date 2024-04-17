package zest;

import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.Size;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


class MergeKSortedListsTest {

    MergeKSortedLists merge = new MergeKSortedLists();
    ListNode tail = new ListNode();

    private ListNode createSortedLinkedList(int min, int max){
        ListNode head = new ListNode();
        ListNode tail = head;
        for(int i = min; i< max; i++){
            ListNode newNode = new ListNode(i);
            tail.next = newNode;
            tail = tail.next;
        }
        return head.next;
    }

    private ListNode createUnsortedLinkedList(int amtOfNode){
        ListNode head = new ListNode();
        ListNode tail = head;
        for(int i = 0; i< amtOfNode; i++){
            int val1 = (int) (Math.random() *(10));
            int val2 = (int) (Math.random() * (-10));
            ListNode newNode1 = new ListNode(val1);
            ListNode newNode2 = new ListNode(val2);
            tail.next = newNode1;
            newNode1.next = newNode2;
            tail = newNode2;
        }
        return head.next;
    }

    private boolean listIsSorted(ListNode head){
        if (head == null)
            return true;

        for (ListNode t = head; t.next != null; t = t.next)
            if (t.val > t.next.val)
                return false;
        return true;
    }

    private int countNodes(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;

    }

    private ListNode generateLinkedList(List<Integer> list) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        for (Integer i : list) {
            tail.next = new ListNode(i);
            tail = tail.next;
        }
        return dummy.next;
    }

    @Test
    void listsIsNull(){
        ListNode[] list = null;
        NullPointerException thrown = assertThrows(
                NullPointerException.class, () -> merge.mergeKLists(list)
        );

    }

    @Test
    void listsIsEmpty(){
        ListNode[] list = new ListNode[0];
        AssertionError thrown = assertThrows(
                AssertionError.class, () -> merge.mergeKLists(list)
        );

        assertTrue(thrown.getMessage().contains("number of linkes lists has to be a positive integer"));
    }

    @Test
    void listsLengthOneAndValidInput(){
        ListNode[] list = new ListNode[1];
        list[0] = createSortedLinkedList(-1, 1);
        ListNode head = merge.mergeKLists(list);
        assertTrue(listIsSorted(head));
    }

    @Test
    void listsLengthOneNotSorted(){
        ListNode[] list = new ListNode[1];
        list[0] = createUnsortedLinkedList(5);
        AssertionError thrown = assertThrows(
                AssertionError.class, () -> merge.mergeKLists(list)
        );

        assertTrue(thrown.getMessage().contains("lists need to be sorted in ascending order"));
    }

    @Test
    void listsLengthLargerOneWithValidInput(){
        ListNode[] list = new ListNode[2];
        list[0] = createSortedLinkedList(-1, 1);
        list[1] = createSortedLinkedList(2, 5);
        ListNode head = merge.mergeKLists(list);
        assertTrue(listIsSorted(head));
    }

    @Test
    void listsLengthLargerOneWithNodeValueLarger10000(){
        ListNode[] list = new ListNode[2];
        list[0] = createSortedLinkedList(9999, 10005);
        list[1] = createSortedLinkedList(2, 5);

        AssertionError thrown = assertThrows(
                AssertionError.class, () -> merge.mergeKLists(list)
        );

        assertTrue(thrown.getMessage().contains("-10⁴<=node.value<=10⁴"));
    }

    @Test
    void listsLengthLargerOneWitNodeValueSmallerMinus10000(){
        ListNode[] list = new ListNode[2];
        list[0] = createSortedLinkedList(-10005, -9999);
        list[1] = createSortedLinkedList(2, 5);

        AssertionError thrown = assertThrows(
                AssertionError.class, () -> merge.mergeKLists(list)
        );

        assertTrue(thrown.getMessage().contains("-10⁴<=node.value<=10⁴"));
    }

    @Test
    void listLengthOneWith10001Nodes(){
        ListNode[] list = new ListNode[1];
        list[0] = createSortedLinkedList(0, 10001);

        AssertionError thrown = assertThrows(
                AssertionError.class, () -> merge.mergeKLists(list)
        );

        assertTrue(thrown.getMessage().contains("Too many nodes"));
    }

    @Test
    void listLengthOneWith10000Nodes(){
        ListNode[] list = new ListNode[1];
        list[0] = createSortedLinkedList(0, 10000);
        ListNode head = merge.mergeKLists(list);
        assertTrue(listIsSorted(head));
    }

    @Test
    void listLengthLargerOneWith10000Nodes(){
        ListNode[] list = new ListNode[2];
        list[0] = createSortedLinkedList(0, 9999);
        list[1] = createSortedLinkedList(9999, 10000);
        ListNode head = merge.mergeKLists(list);
        assertTrue(listIsSorted(head));
    }

    @Test
    void listLengthLargerOneWith10001Nodes(){
        ListNode[] list = new ListNode[2];
        list[0] = createSortedLinkedList(0, 9999);
        list[1] = createSortedLinkedList(9999, 10001);

        AssertionError thrown = assertThrows(
                AssertionError.class, () -> merge.mergeKLists(list)
        );

        assertTrue(thrown.getMessage().contains("Too many nodes"));
    }


    @Test
    void listsLengthLargerOneContainsListNotSorted(){
        ListNode[] list = new ListNode[2];
        list[0] = createUnsortedLinkedList(10);
        list[1] = createSortedLinkedList(2, 5);

        AssertionError thrown = assertThrows(
                AssertionError.class, () -> merge.mergeKLists(list)
        );

        assertTrue(thrown.getMessage().contains("lists need to be sorted in ascending order"));
    }

    @Test
    void listsLengthLargerOneValidInputWithDuplicates(){
        ListNode[] list = new ListNode[2];
        list[0] = createSortedLinkedList(-5, 5);
        list[1] = createSortedLinkedList(-3, 2);
        ListNode head = merge.mergeKLists(list);
        assertTrue(listIsSorted(head));
    }

    @Test
    void finalAmountOfNodesSameAsInitial(){
        ListNode[] list = new ListNode[2];
        list[0] = createSortedLinkedList(0, 5);
        list[1] = createSortedLinkedList(0, 2);
        ListNode head = merge.mergeKLists(list);
        int expected = 7;
        int actual = countNodes(head);
        assertEquals(expected, actual);

    }

    @Property
    void validInput(
        @ForAll
        @Size(min = 1, max = 100)
        List<@Size(min = 1, max = 100)
        List<@IntRange(min = -10000, max = 10000) Integer>> list) {
            for(List<Integer> innerList: list){
                Collections.sort(innerList);
            }

            ListNode[] lists = new ListNode[list.size()];

            for(int i = 0; i<list.size(); i++){
                List<Integer> temp = list.get(i);
                lists[i] = generateLinkedList(temp);
            }

            ListNode head = merge.mergeKLists(lists);
            assertTrue(listIsSorted(head));

    }

    private ListNode[] generateLists(List<List<Integer>> list){
        for(List<Integer> innerList: list){
            Collections.sort(innerList);
        }

        ListNode[] lists = new ListNode[list.size()];

        for(int i = 0; i<list.size(); i++){
            List<Integer> temp = list.get(i);
            lists[i] = generateLinkedList(temp);
        }
        return lists;
    }

    private boolean isSorted(List<Integer> list){
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private ListNode[] generateListsNotSorted(List<List<Integer>> list){

        ListNode[] lists = new ListNode[list.size()];

        for(int i = 0; i<list.size(); i++){
            List<Integer> temp = list.get(i);
            lists[i] = generateLinkedList(temp);
        }
        return lists;
    }

    @Property
    void invalidInput(
        @ForAll
        @Size(min = 1, max = 100)
        List<@Size(min = 1, max = 100)
        List<@IntRange(min = 10001, max = 30000) Integer>> listValuesTooLarge,
        @ForAll
        @Size(min = 1, max = 100)
        List<@Size(min = 1, max = 100)
        List<@IntRange(min = -30000, max = -10001) Integer>> listValuesTooSmall,
        @ForAll
        @Size(min = 1, max = 100)
        List<@Size(min = 20, max = 100)
        List<@IntRange(min = -10000, max = 10000) Integer>> listValuesNotSorted
    ){

        ListNode [] listsValuesTooLarge = generateLists(listValuesTooLarge);
        ListNode [] listsValuesTooSmall = generateLists(listValuesTooSmall);
        ListNode [] listsNotSorted = generateListsNotSorted(listValuesNotSorted);



        assertThrows(AssertionError.class, () -> {merge.mergeKLists(listsValuesTooSmall);});
        assertThrows(AssertionError.class, () -> {merge.mergeKLists(listsValuesTooLarge);});
        assertThrows(AssertionError.class, () -> {merge.mergeKLists(listsNotSorted);});

    }
}