package Queue;

import java.util.*;

public class CircularQueueUsingStaticArrays {
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

    static int queue[] = new int[5];
    static int front = -1, rear = -1, size;

    static public void enQueue() {
        if ((rear + 1) % 5 == front)
            System.out.println(" Queue Full");
        else {
            System.out.println(" This adds data to queue ");
            Scanner console = new Scanner(System.in);
            System.out.print(" Enter num ");
            int num = console.nextInt();
            if (front == -1 && rear == -1) {
                front = rear = 0;
                queue[rear] = num;
                size++;
            } else {
                rear = (rear + 1) % 5;
                queue[rear] = num;

                size++;
            }

            // System.out.println("debug: This is the value of rear after insertion " +
            // rear);
            // System.out.println("debug: This is the value of queuerear after insertion " +
            // queue[rear]);

        }

    }

    static public int deQueue() {
        if (front == -1 && rear == -1) {
            System.out.println("Empty Queue");
            return 0;
        } else if (front == rear) {
            System.out.println(" Exactly one element was present in the queue");
            size--;
            int temp = front;
            front = rear = 0;
            return queue[temp];

        } else {
            int data = queue[front];
            size--;
            front = ((front + 1) % 5);
            return data;
        }
    }

    static public void show() {
        if (size == 0)
            System.out.println("empty Queue");
        else {
            int i = front;
            while (i != rear) {
                System.out.print(queue[i] + " | ");
                i=(i+1)%5;
            }
            System.out.print(queue[rear]);
            // do
            // {
            //     System.out.print(queue[i] + " | ");
            //     i=(i+1)%5;
            // }while(i!=rear);
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
                System.out.println(" this is the value removed from Queue :" + deQueue());

            } else if (choice == 3) {
                System.out.println("this will print the Queue");
                show();

            } else if (choice == 4) {
                if (size == 0)
                    System.out.println(" Empty Queue");
                else
                    System.out.println("The first element of Queue is " + queue[front]);
            } else if (choice == 5) {
                if (size == 0)
                    System.out.println(" Empty Queue");
                else
                    System.out.println("The last element of Queue is " + queue[rear]);

            } else if (choice == 6) {
                System.out.println("number of elements of the Queue is " + size);
            } else if (choice == 7) {
                System.out.println("thank you");
            }

        } while (choice != 7);

    }
}