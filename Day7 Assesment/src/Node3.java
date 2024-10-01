import java.util.Scanner;

public class Node3 {
    int data;
    Node3 next;

    public Node3(int data) {
        this.data = data;
        this.next = null;
    }
}
class LinkedList3
{
    Node3 head;
    public LinkedList3(){
        head = null;
    }
    public void insertAtTail(int data){
        Node3 newNode = new Node3(data);
        if(head == null){
            head = newNode;
        } else {
            Node3 temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    public void insertAtPosition(int data, int position){
        Node3 newNode = new Node3(data);
        if(position == 1){
            newNode.next = head;
            head = newNode;
        } else {
            Node3 temp = head;
            for(int i = 1; i < position-1 && temp!=null; i++){
                temp = temp.next;
            }
            if(temp != null){
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
    }
    public void printList(){
        Node3 temp = head;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

}
class LinkedListInsertionPosition {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        LinkedList3 list = new LinkedList3();

        list.insertAtTail(25);
        list.insertAtTail(10);
        list.insertAtTail(5);

        int dataToInsert = 1;
        int position = 2;

        list.insertAtPosition(dataToInsert, position);

        list.printList();
        scanner.nextLine();
    }
}
