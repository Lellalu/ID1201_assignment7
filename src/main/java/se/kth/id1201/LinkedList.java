package se.kth.id1201;

public class LinkedList {

    public class Node{ 
        int val; 
        Node next;

        Node(int val, Node n){
             this.val=val; 
             this.next=n; 
        }
    }

    public class StackEmptyException extends RuntimeException {};

    public Node first;
    public Node last;

    public LinkedList(int[] array){
        Node[] nodes = new Node[array.length];
        for(int i = 0; i < array.length; i++){
            nodes[i] = new Node(array[i], null);
        }

        for(int i = 0; i < array.length - 1; i++){
            nodes[i].next = nodes[i+1];
        }

        first = nodes[0];
        last = nodes[array.length-1];
    }

    public LinkedList(Node first, Node last){
        this.first = first;
        this.last = last;
    }
}
