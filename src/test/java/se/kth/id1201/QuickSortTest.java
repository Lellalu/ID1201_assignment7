package se.kth.id1201;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class QuickSortTest 
{
    @Test
    public void quickSort_listSuccess1Test()
    {
        int[] arr = {21,2,354,42,23,6,52,243,8,84};
        int[] sorted_arr = {2,6,8,21,23,42,52,84,243,354};
        LinkedList l = new LinkedList(arr);
        QuickSort.quickSort_list(l);
        LinkedList.Node n = l.first;
        for(int i = 0; i < sorted_arr.length; i++){
            assertEquals(sorted_arr[i], n.val);
            n = n.next;
        }
    }

    @Test
    public void quickSort_listSuccess2Test()
    {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int[] sorted_arr = {1,2,3,4,5,6,7,8,9};
        LinkedList l = new LinkedList(arr);
        QuickSort.quickSort_list(l);
        LinkedList.Node n = l.first;
        for(int i = 0; i < sorted_arr.length; i++){
            assertEquals(sorted_arr[i], n.val);
            n = n.next;
        }
    }

    @Test
    public void quickSort_listSuccess3Test()
    {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        int[] sorted_arr = {1,2,3,4,5,6,7,8,9,10};
        LinkedList l = new LinkedList(arr);
        QuickSort.quickSort_list(l);
        LinkedList.Node n = l.first;
        for(int i = 0; i < sorted_arr.length; i++){
            assertEquals(sorted_arr[i], n.val);
            n = n.next;
        }
    }

    @Test
    public void partitionTest()
    {
        int[] arr = {5,4,3,2,1};
        LinkedList l = new LinkedList(arr);
        LinkedList.Node pivot = QuickSort.partition_list(l);
        LinkedList.Node after = pivot.next;
        while(after != null){
            assertTrue(after.val > pivot.val);
            after = after.next;
        }
        LinkedList.Node before = l.first;
        while(before != pivot){
            assertTrue(before.val < pivot.val);
            before = before.next;
        }
        int length = 0;
        LinkedList.Node node = l.first;
        while(node != null){
            length += 1;
            node = node.next;
        }
        assertEquals(arr.length, length);
    }
}
