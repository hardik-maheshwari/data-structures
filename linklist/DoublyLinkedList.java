import java.util.*;

class NodeX {
    int data;
    NodeX next;
    NodeX prev;
}

public class DoublyLinkedList {
    static NodeX first, last, newNode;
    static int count;

    static int menu() {
        int n;
        System.out.println("\nEnter your choice");
        System.out.println("1: Insert ");
        System.out.println("2: Delete");
        System.out.println("3: Print");
        System.out.println("4: Reverse");
        System.out.println("5 : Delete at n");
        System.out.println("6:exit");
        Scanner console = new Scanner(System.in);
        n = console.nextInt();
        return n;
    }

    static int insertMenu() {
        int n;
        System.out.println("\nEnter your choice");
        System.out.println("1: Insert at beginning ");
        System.out.println("2: Insert at end");
        System.out.println("3: Insert after specific number");
        System.out.println("4: Insert before specific number");
        System.out.println("5: Insert at nth posiion");
        System.out.print("please enter your choice  ");
        Scanner console = new Scanner(System.in);
        n = console.nextInt();
        return n;
    }

    static int insert() {
        int insertChoice;
        Scanner console = new Scanner(System.in);
        insertChoice = insertMenu();
        if (insertChoice == 1) {
            System.out.println("enter number");
            int num = console.nextInt();

            insertAtBeginning(num);
        }
        if (insertChoice == 2) {
            System.out.println("enter number");
            int num = console.nextInt();

            insertAtEnd(num);
        }
        if (insertChoice == 3) {
            System.out.println("enter number");
            int num = console.nextInt();
            System.out.println("enter number after which number is to be entered");
            int numAfter = console.nextInt();
            insertAfter(num, numAfter);
        }
        if (insertChoice == 4) {
            System.out.println("enter number");
            int num = console.nextInt();
            System.out.println("enter number before which number is to be entered");
            int numBefore = console.nextInt();
            insertBefore(num, numBefore);
        }
        if (insertChoice == 5) {
            System.out.println("enter node at which number is to be inserted");
            int num = console.nextInt();
            insertAtPosition(num);
        }
        return insertChoice;
    }

    static void insertAtBeginning(int num) {
        System.out.println("this will insert " + num + " at the beginning of list");
        NodeX newNode;
        newNode = new NodeX();
        newNode.data = num;
        if (first == null) {
            first = last = newNode;
            count++;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
            count++;
        }
    }

    static void insertAtEnd(int num) {
        System.out.println("this will insert " + num + " at the end of list");

        NodeX newNode;
        newNode = new NodeX();
        newNode.data = num;
        if (first == null) {
            first = newNode;
            last = newNode;
            count++;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
            count++;
        }
    }

    static void insertAfter(int num, int afterNum) {
        System.out.println("this will insert " + num + "  after  " + afterNum);
        NodeX newNode;
        newNode = new NodeX();
        newNode.data = num;
        if (first == null) {
            System.out.println("Empty link list");
        } else if (last.data == afterNum) {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
            count++;
            System.out.println("bebug this prints data of first " + first.data);
            System.out.println("debug o this prints data of last: " + last.data);
        } else if (first.next == null && first.data == afterNum) {
            first.next = newNode;
            newNode.prev = first;
            count++;
            System.out.println("bebug  this prints data of first" + first.data);
            System.out.println("debug o this prints data of last: " + last.data);
        } else {
            NodeX pLoc = first;
            while (pLoc.data != afterNum && pLoc.next != null) {
                pLoc = pLoc.next;
            }
            if (pLoc.data != afterNum)
                System.out.println(" Number not found in list");
            else {
                newNode.next = pLoc.next;
                newNode.prev = pLoc;
                pLoc.next.prev = newNode;
                pLoc.next = newNode;
                count++;
                System.out.println("bebug this prints data of first " + first.data);
                System.out.println("debug o this prints data of last: " + last.data);
            }
        }

    }

    static void insertBefore(int num, int beforeNum) {
        System.out.println("this will insert  " + num + "  before  " + beforeNum);
        NodeX newNode;
        newNode = new NodeX();
        newNode.data = num;
        if (first == null) {
            System.out.println("Empty link list");
        } else if (first.data == beforeNum) {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
            count++;
            System.out.println("bebug this prints data of first" + first.data);
            System.out.println("debug o this prints data of last: " + last.data);
        } else if (last.data == beforeNum) {
            newNode.next = last;
            newNode.prev = last.prev;
            last.prev.next = newNode;
            last.prev = newNode;
            count++;
            System.out.println("bebug this prints data of first " + first.data);
            System.out.println("debug o this prints data of last: " + last.data);
        } else {
            NodeX pLoc = first;
            while (pLoc.data != beforeNum && pLoc.next != null) {
                pLoc = pLoc.next;
            }
            if (pLoc.data != beforeNum)
                System.out.println("Number not found in the list");
            else {
                newNode.next = pLoc;
                newNode.prev = pLoc.prev;
                pLoc.prev.next = newNode;
                pLoc.prev = newNode;
                count++;
                System.out.println("bebug this prints data of first " + first.data);
                System.out.println("debug o this prints data of last: " + last.data);
            }
        }
    }

    static void insertAtPosition(int num) {
        int ins;
        if (count == 0) {
            System.out.println("Empty list");
        } else if (num == count + 1) {
            System.out.println("Enter data to be inserted in new node");
            Scanner console = new Scanner(System.in);
            int num1 = console.nextInt();
            insertAtEnd(num1);

        } else if (num > count) {
            System.out.println("Out of scope");
        } else if (first.next == null) {
            System.out.println("Enter data of the new node");
            Scanner console = new Scanner(System.in);
            int num1 = console.nextInt();
            insertAtEnd(num1);
        } else {
            NodeX pLoc = first;
            for (int i = 0; i < num - 1; i++)
                pLoc = pLoc.next;
            ins = pLoc.data;
            System.out.println("Enter data of the new node");
            Scanner console = new Scanner(System.in);
            int num1 = console.nextInt();
            insertBefore(num1, ins);
        }
    }

    static void printLinklist() {
        NodeX pTraverse = first;
        while (pTraverse != null) {
            System.out.print(pTraverse.data + " | ");
            pTraverse = pTraverse.next;
        }
    }

    static void reverse(NodeX p) {
        NodeX pTraverse = last;
        System.out.println("debug o this prints data of last: " + last.data);
        System.out.println("debug 1: this prints data of last.prev :" + last.prev.data);
        System.out.println("debug 2: this prints data of last .prev.prev:" + last.prev.prev.data);
        while (pTraverse != first) {
            System.out.print(pTraverse.data + " | ");
            pTraverse = pTraverse.prev;
        }
        System.out.print(first.data + " |");
        // if(p==null)
        // return;
        // else
        // {
        // reverse(p.next);
        // System.out.print(p.data + " | ");
        // }
    }

    static void delete(int num) {
        System.out.println(" This will delete " + num + " from the list if it is present");
        if (first == null) {
            System.out.println(" empty list");
        } else if (first.next == null && first.data == num) {
            System.out.println("Last element of list");
            first = last = null;
            count--;
        } else if (last.data == num) {
            last = last.prev;
            last.next = null;
            count--;
        } else {
            NodeX pLoc = first;
            while (pLoc.data != num && pLoc.next != null) {
                pLoc = pLoc.next;
            }
            if (pLoc.data != num) {
                System.out.println("number not found in list");
            } else {
                pLoc.prev.next = pLoc.next;
                count--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(" Double Link list tutorial");
        // Node newNode;
        int choice;
        Scanner console = new Scanner(System.in);
        do {
            choice = menu();
            if (choice == 1) {
                insert();
            } else if (choice == 2) {
                int number;
                System.out.println("enter number to be deleted ");
                number = console.nextInt();
                delete(number);
            } else if (choice == 3) {
                System.out.println("this will print the linked list");
                // System.out.println("debug 3:" + first.data);
                printLinklist();
            } else if (choice == 4) {
                System.out.println("reversing the list ");
                reverse(first);
            } else if (choice == 5) {
                System.out.println("Enter node to be deleted");
                int number;
                number = console.nextInt();
                // deleteAtn(number);
            } else if (choice == 6) {
                System.out.println("thank you");
            }

        } while (choice != 6);

    }
}