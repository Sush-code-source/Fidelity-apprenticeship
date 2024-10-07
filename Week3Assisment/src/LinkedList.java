import java.util.*;
public class LinkedList {
    Node head;
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        }else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    public void removeAti(int index){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        if(index == 0){
            head = head.next;
            return;
        }
        Node current = head;
        for (int i = 0; i < index-1; i++) {
            if(current.next == null){
                System.out.println("Cant remove, Index out of bounds");
                return;
            }
            current = current.next;
        }
        if(current.next == null){
            System.out.println("Cant remove, Index out of bounds");
            return;
        }
        current.next = current.next.next;

    }

    public void display(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while(current != null){
            System.out.println(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter four elements for list:");
        for (int i = 0; i < 4; i++) {
            int data = sc.nextInt();
            list.add(data);
        }
        System.out.println("Your LinkedList elements are:");
        list.display();

        System.out.println("Enter the index of your element to be removed(0 to 3):");
        int index = sc.nextInt();
        list.removeAti(index);

        System.out.println("Your LinkedList elements after removal");
        list.display();
        sc.close();
    }

}
