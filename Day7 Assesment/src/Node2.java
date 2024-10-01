import java.util.Scanner;
class Node2 {
    int data;
    Node2 next;

    public Node2(int data) {
        this.data = data;
        this.next = null;
    }
}
class LinkedList2 {
    Node2 head;
    public LinkedList2() {
        head = null;
    }
    public void insertAtHead(int data) {
        Node2 newNode = new Node2(data);
        newNode.next = head;
        head = newNode;
    }

    public void printList() {
        Node2 temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
            if (temp != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println("-> NULL");
    }
}
class LinkedListInsertionAtHead {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList2 list = new LinkedList2();
        int n= scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            list.insertAtHead(value);
        }
        list.printList();
        scanner.close();
    }

}
