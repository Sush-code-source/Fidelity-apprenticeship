import java.util.Scanner;
class Node5 {
    int data;
    Node5 next;

    public Node5(int data) {
        this.data = data;
        this.next = null;

    }
}
class LinkedList5 {
    Node5 head;
    public LinkedList5() {
        head=null;
    }
    public void insertAtTail(int data) {
        Node5 newNode = new Node5(data);
        if(head==null) {
            head = newNode;
        } else {
            Node5 temp = head;
            while(temp.next!=null) {
                temp = temp.next;
            }
            temp.next = newNode;


        }
    }
    public void reverseList() {
        Node5 prev = null;
        Node5 current = head;
        Node5 next = null;

        while(current !=null) {

            next=current.next;
            current.next=prev;
            prev=current;
            current=next;

        }
        head=prev;
    }
    public void printList() {
        Node5 temp = head;
        while(temp != null) {
            System.out.print(temp.data+" ");
            temp=temp.next;

        }
        System.out.println();
    }
}
class ReverseLinkedList5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList5 linkedList5 = new LinkedList5();

        int n=5;
        for(int i=0; i<n; i++) {
            int value=scanner.nextInt();
            linkedList5.insertAtTail(value);
        }
        linkedList5.reverseList();
        linkedList5.printList();
        scanner.close();

    }
}
