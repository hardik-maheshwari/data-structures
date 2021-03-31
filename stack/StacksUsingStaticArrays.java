import java.util.*;

public class StacksUsingStaticArrays {
    static int stack[] = new int[5];
    static int top = 0;
    static int count = 0;

    static public void push(int data) {
        if (top == 5)
            System.out.println(" Stack full");
        else {
            stack[top] = data;
            top++;
            count++;
        }
    }

    static int menu() {
        int n;
        System.out.println("\nEnter your choice");
        System.out.println("1: Push ");
        System.out.println("2: Pop");
        System.out.println("3: Show");
        System.out.println("4: Peek");
        System.out.println("5: Count");
        System.out.println("6: Size");
        System.out.println("7: Exit");
        Scanner console = new Scanner(System.in);
        n = console.nextInt();
        return n;
    }

    static public void getData() {
        Scanner console = new Scanner(System.in);
        int num;
        System.out.println("Enter data to be pushed to stack ");
        num = console.nextInt();
        push(num);

    }

    static public int pop() {
        if (top == 0) {
            System.out.println(" underflow");
            return 0;
        } else {
            int data;
            top--;
            data = stack[top];
            stack[top] = 0;
            return data;
        }

    }

    static public int peek() {
        int data;
        if (top == 0) {
            System.out.println("underflow");
            return 0;
        } else {
            data = stack[top - 1];
            System.out.println("this is the topmost element of stack ");
            return data;
        }

    }

    static public void show() {
        for (int i = 0; i < count; i++)
            System.out.print(stack[i] + " | ");
    }

    static public int Size() {
        return top;
    }

    public static void main(String[] args) {
        System.out.println("Stack tutorial");
        // Node newNode;
        int choice;
        Scanner console = new Scanner(System.in);
        do {
            choice = menu();
            if (choice == 1) {
                getData();
            } else if (choice == 2) {
                pop();

            } else if (choice == 3) {
                System.out.println("this will print the stack");
                show();

            } else if (choice == 4) {
                System.out.println(peek());
            } else if (choice == 5) {
                System.out.println("number of elements of the stack is " + count);
            } else if (choice == 6) {
                Size();
            } else if (choice == 7) {
                System.out.println("thank you");
            }

        } while (choice != 7);

    }
}