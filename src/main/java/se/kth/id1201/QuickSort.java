package se.kth.id1201;

public class QuickSort{
    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void quickSort_array(int[] array) {
        if(array.length == 0) {
            return; 
        }
        quickSort_array(array,0,array.length-1); 
    }

    public static void quickSort_array(int[] array, int low, int high){
        // Ensure indices are in correct order
        if (low >= high || low < 0){
            return;
        } 

        // Partition the array and get the index of the pivot
        int pivotIndex = partition_array(array,low, high);
        
        // Sort the two partitions
        quickSort_array(array, low, pivotIndex - 1); // Left side of pivot
        quickSort_array(array, pivotIndex + 1, high); // Right side of pivot
    }

    // Divides array into two partitions
    public static int partition_array(int[] array, int low, int high){
        int pivot = array[high];
        // Temporary pivot index
        int i = low;

        for (int j = low; j< high; j++){
            // If the current element is less than or equal to the pivot
            if (array[j] <= pivot){
                // Swap the current element with the element at the temporary pivot index
                swap(array,i,j);
                // Move the temporary pivot index forward
                i = i + 1;
            } 
        } 
        // Move the pivot element to the correct pivot position (between the smaller and larger elements)
        swap(array,i,high);
        return i; // the pivot index

    }

    public static void quickSort_list(LinkedList l){
        if(l.first == l.last || l.first == null || l.last == null){
            return;
        }

        LinkedList.Node partition_node = partition_list(l);

        LinkedList.Node node = l.first;
        LinkedList.Node pre = null;
        while(node != partition_node){
            pre = node;
            node = node.next;
        }

        LinkedList before_partition_list;
        LinkedList after_partition_list;
        if(pre == null){
            before_partition_list = new LinkedList(null, null);
        }else{
            before_partition_list = new LinkedList(l.first, pre);
            pre.next = null;
        }

        if(partition_node.next == null){
            after_partition_list = new LinkedList(null, null);
        }else{
            after_partition_list = new LinkedList(partition_node.next, l.last);
            partition_node.next = null;

        }
        
        quickSort_list(before_partition_list);
        quickSort_list(after_partition_list);

        if(before_partition_list.first == null){
            l.first = partition_node;
            partition_node.next = after_partition_list.first;
            l.last = after_partition_list.last;
        }else if(after_partition_list.first == null) {
            l.first = before_partition_list.first;
            before_partition_list.last.next = partition_node;
            l.last = partition_node;
        }else{
            l.first = before_partition_list.first;
            before_partition_list.last.next = partition_node;
            partition_node.next = after_partition_list.first;
            l.last = after_partition_list.last;
        }
    }

    public static LinkedList.Node partition_list(LinkedList l){
        LinkedList.Node pivot = l.last;
        LinkedList.Node n = l.first;
        LinkedList.Node n_pre= null;
        while(n != pivot){
            if(n.val > pivot.val){
                if(n_pre == null){
                    l.first = n.next;
                    n.next = null;
                    l.last.next = n;
                    l.last = n; 
                    n = l.first;
                }
                else{
                    n_pre.next = n.next;
                    n.next = null;
                    l.last.next = n;
                    l.last = n;
                    n = n_pre.next;
                }
            }else{
                if(n_pre == null){
                    n_pre = l.first;
                    n = n.next;
                }else{
                    n = n.next;
                    n_pre = n_pre.next;
                }
            } 
        }
        return pivot;
    }
}