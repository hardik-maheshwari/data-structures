import java.util.*;

class Node {
    int data;
    Node next;
}

public class StackUsingLinkedlist {
    static Node first, last, top, newNode;

    static int menu() {
        int n;
        System.out.println("\nEnter your choice");
        System.out.println("1: Push ");
        System.out.println("2: Pop");
        System.out.println("3: Peek");
        System.out.println("4: Print");
        System.out.println("5 : Exit");

        Scanner console = new Scanner(System.in);
        n = console.nextInt();
        return n;
    }

    static void push(int val) {
        System.out.println("this will insert " + val + " to the top of stack");
        newNode = new Node();
        newNode.data = val;
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    static public void pop() {
        Node pPrev, pLoc;
        pLoc = pPrev = first;
        if (first == null) {
            System.out.println(" Empty stack");
        } else if (first.next == null) {
            System.out.println(first.data + " This is the value popped");
            first = last = null;
        } else {
            while (pLoc.next != null) {
                pPrev = pLoc;
                pLoc = pLoc.next;
            }
            System.out.println(pLoc.data + " This is the value popped");
            last = pPrev;
            last.next = null;
        }
    }

    static void peek() {
        if (last == null)
            System.out.println(" Empty stack");
        else
            System.out.println(" This shows the topmost element of stack " + last.data);
    }

    static void printStack(Node start) {
        System.out.println("This prints stack");
        if (first == null)
            System.out.println("Empty stack");
        Node nodePrint;
        nodePrint = first;
        while (nodePrint != null) {
            System.out.print(nodePrint.data + " | ");
            nodePrint = nodePrint.next;
        }
    }

    public static void main(String[] args) {
        System.out.println("Stack tutorial");
        // Node newNode;
        int choice;
        Scanner console = new Scanner(System.in);
        do {
            choice = menu();
            if (choice == 1) {
                System.out.println("Enter the number to be pushed on the stack");

                int num;
                num = console.nextInt();
                push(num);

            } else if (choice == 2) {
                pop();
            } else if (choice == 3) {
                peek();
            } else if (choice == 4) {
                printStack(first);

            } else if (choice == 5) {
                System.out.println("thank you");
            }

        } while (choice != 5);

    }
}