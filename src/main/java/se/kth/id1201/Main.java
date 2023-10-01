package se.kth.id1201;

import java.util.Random;
import java.util.Arrays;

/**
 *
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        benchmark();
    }

    public static void benchmark(){
        int repetition = 100;
        int[] unsorted_array;
        LinkedList linked_list;

        long min_array_time;
        long min_list_time;
        long start_time;
        long end_time;

        System.out.printf("# sorting an array of length n, time in ns\n");
        System.out.printf("#%12s%12s%12s%12s\n", "n", "Array", "Linked list", "Ratio");
        for(int length = 2; length < 200000; length*=2){
            unsorted_array = unsortedArray(length);
            min_array_time = Long.MAX_VALUE;
            min_list_time = Long.MAX_VALUE;
            for(int rep = 0; rep < repetition; rep++){
                start_time = System.nanoTime();
                QuickSort.quickSort_array(Arrays.copyOf(unsorted_array, length));
                end_time = System.nanoTime();

                if(end_time - start_time < min_array_time){
                    min_array_time = end_time - start_time;
                }

                linked_list = new LinkedList(unsorted_array);
                start_time = System.nanoTime();
                QuickSort.quickSort_list(linked_list);
                end_time = System.nanoTime();

                if(end_time - start_time < min_list_time){
                    min_list_time = end_time - start_time;
                }
            }
            System.out.printf("%13d", length);
            System.out.printf("%12d", min_array_time);
            System.out.printf("%12d", min_list_time);
            System.out.printf("%12.2f", (double)min_array_time/min_list_time);
            System.out.println();
        }

    }

    public static int[] unsortedArray(int n){
        Random r = new Random();
        int[] array = new int[n];
        for(int i = 0;i < n; i++){
            array[i] = r.nextInt(100000000);
        }
        return array;
    }
}
