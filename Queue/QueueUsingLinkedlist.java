package Queue;

import java.util.*;

class Node {
    int data;
    Node next;
}

public class QueueUsingLinkedlist {
    static Node front, rear, newNode;
    static int size;

    static int menu() {
        int n;
        System.out.println("\nEnter your choice");
        System.out.println("1: enQueue ");
        System.out.println("2: deQueue");
        System.out.println("3: Show");
        System.out.println("4: Element at start of the  queue");
        System.out.println("5: Element at end of the queue");
        System.out.println("6: Count");
        System.out.println("7: Exit");

        Scanner console = new Scanner(System.in);
        n = console.nextInt();
        return n;
    }

    static public void enQueue() {
        System.out.println("\nThis adds element in the queue");
        int num;
        Scanner console = new Scanner(System.in);
        System.out.println("\nEnter data");
        num = console.nextInt();
        newNode = new Node();
        newNode.data = num;
        if (front == null) {
            front = newNode;
            rear = newNode;
             size++;
        } else {
            rear.next = newNode;
            rear = newNode;
            size++;
        }
    }

    static public void deQueue() {
        System.out.println("\nThis removes data from front");
        if (front == null && rear == null)
            System.out.println("\nempty Queue");
        else if (front.next == null && rear.next == null) {
            System.out.print("\nThis removes"+front.data+"from the queue");
            front = rear = null;
            size--;
        } else {
            System.out.print("\nThis removes " + front.data + " from the queue");

            front = front.next;
             size--;
        }
    }

    static public void show() {
        size = 0;
        System.out.println("\nThis prints the queue");
        if (front == null)
            System.out.println("\nEmpty Queue");
        else {
            Node printNode = front;
            while (printNode != rear) {
                System.out.print(printNode.data + " | ");
                printNode = printNode.next;
                size++;
            }
            System.out.print(rear.data + " | ");
            size++;
        }
    }

    public static void main(String[] args) {
        System.out.println("This is Queue Implementation");
        int choice;
        Scanner console = new Scanner(System.in);
        do {
            choice = menu();
            if (choice == 1) {
                enQueue();
            } else if (choice == 2) {
                deQueue();

            } else if (choice == 3) {
                System.out.println("\nthis will print the Queue\n");
                show();

            } else if (choice == 4) {
                if (size == 0)
                    System.out.println(" \nEmpty Queue");
                else
                    System.out.println("\nThe element at the start of the queue is " + front.data);

            } else if (choice == 5) {
                if (size == 0)
                    System.out.println("\n Empty Queue");
                else
                    System.out.println("\nThe element at the end of the queue is " + rear.data);

            } else if (choice == 6) {
                System.out.println("\nnumber of elements of the Queue is " + size);
            } else if (choice == 7) {
                System.out.println("thank you");
            }

        } while (choice != 7);
    }

}
