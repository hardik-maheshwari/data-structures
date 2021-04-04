import java.util.*;

class Node {
    int data;
    Node next;
}

public class LinkedList {
    static Node first, last, newNode;
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

    // static int getCount() {
    // int count = 0;
    // Node pCount = first;
    // while (pCount.next != null) {
    // pCount = pCount.next;
    // count++;
    // }
    // System.out.println("number of nodes in link list: "+count);
    // return count;
    // }

    static void insertBefore(int num, int beforeNum) {
        System.out.println("this will insert  " + num + "  before  " + beforeNum);
        Node newNode;
        newNode = new Node();
        newNode.data = num;
        if (first == null) {
            System.out.println("list is empty ");
        } else if (first.next == null) {
            newNode.next = first;
            first = newNode;
            count++;
        } else if (first.data == beforeNum) {
            newNode.next = first;
            first = newNode;
            count++;
        } else {
            Node pLoc, pPrev;
            pLoc = first;
            pPrev = null;
            while (pLoc.data != beforeNum && pLoc.next != null) {
                pPrev = pLoc;
                pLoc = pLoc.next;
            }
            if (pLoc.data != beforeNum) {
                System.out.println("number not found in list");
            } else {
                newNode.next = pLoc;
                pPrev.next = newNode;
                count++;
            }
        }

    }

    static void insertAfter(int num, int afterNum) {
        System.out.println("this will insert " + num + "  after  " + afterNum);
        Node newNode;
        newNode = new Node();
        newNode.data = num;
        if (first == null) {
            System.out.println("list is empty ");
        } else if (last.data == afterNum) {
            last.next = newNode;
            last = newNode;
            count++;
        } else {
            Node pLoc;
            pLoc = first;
            while (pLoc.data != afterNum && pLoc.next != null) {
                pLoc = pLoc.next;
            }
            // System.out.println("debug "+pLoc.data);
            if (pLoc.data != afterNum) {
                System.out.println("number not found in list");
            } else {
                newNode.next = pLoc.next;
                pLoc.next = newNode;
                count++;
            }
        }

    }

    static void insertAtEnd(int num) {
        System.out.println("this will insert " + num + " at the end of list");

        Node newNode;
        newNode = new Node();
        newNode.data = num;
        if (first == null) {
            first = newNode;
            last = newNode;
            count++;
        } else {
            // last = first;
            // while (last.next != null) {
            // last = last.next;
            // }
            last.next = newNode;
            last = newNode;
            count++;
        }

    }

    static void insertAtBeginning(int num) {
        System.out.println("this will insert " + num + " at the beginning of list");
        Node newNode;
        newNode = new Node();
        newNode.data = num;
        if (first == null) {
            first = newNode;
            last = newNode;
            count++;
        } else {
            newNode.next = first;
            first = newNode;
            count++;
        }

    }

    static void delete(int num) {
        System.out.println("this will delete " + num);
        Node pDelete, pPrev;
        pDelete = first;
        if (first == null)
            System.out.println("Empty linkn list");
        else {
            pPrev = null;
            /// int count;
            // count = getCount();
            if (first.next == null) {
                System.out.println(" Last element of list ");
                if (first.data == num) {
                    first = null;
                    count--;
                } else
                    System.out.println("number not found");
            } else {
                while (pDelete.data != num && pDelete.next != null) {
                    pPrev = pDelete;
                    pDelete = pDelete.next;
                }
                if (pDelete.data != num) {
                    System.out.println("number not found in list");
                } else if (pDelete.next == null) {
                    pPrev.next = null;
                    count--;
                } else if (first == pDelete) {
                    first = pDelete.next;
                    count--;
                } else {
                    pPrev.next = pDelete.next;
                    count--;
                }
            }
        }
    }

    static void printLinklist(Node start) {
        System.out.println("This prints linked list");
        if (start == null)
            System.out.println("Empty link list ");
        Node nodePrint;
        nodePrint = start;
        while (nodePrint != null) {
            System.out.print(nodePrint.data + " | ");
            nodePrint = nodePrint.next;
        }
    }

    static void Reverse(Node p) {
        if (p.next == null) {
            first = p;
            System.out.print(p.data + " | ");
            return;
        } else {
            Reverse(p.next);

        }
        System.out.print(p.data + " | ");
    }

    static void insertAtPosition(int num) {
        Node newNode;
        newNode = new Node();
        System.out.println("Enter data");
        Scanner console = new Scanner(System.in);
        int num1 = console.nextInt();
        newNode.data = num1;
        if(count==0)
        {
            System.out.println("Empty list");
        }
       else if (num > count) {
            System.out.println(" Out of scope");
        } else if (num == 1) {

            if (first == null) {
                first = newNode;
                last = newNode;
                count++;
            } else {
                newNode.next = first;
                first = newNode;
                count++;
            }
        } else {
            int count1 = 0;
            Node pLoc, pPrev;
            pLoc = first;
            pPrev = null;
            while (pLoc.next != null) {
                pPrev = pLoc;
                pLoc = pLoc.next;
                count1++;
                if (num == count1)
                    break;
            }
            pPrev.next = newNode;
            newNode.next = pLoc;
            count++;
        }

    }

    static void deleteAtn(int num) {
        int del;
        if (count == 0)
            System.out.println(" Empty link list");
        else if (num > count)
            System.out.println("Out of scope");
        else if (num == 1 && count==1) {
            System.out.println(" Last element of list ");
                first = null;
            count--;
        } 
        else if(num==count)
        {
            Node pPrev;
            pPrev=first;
            while(pPrev.next!=last)
            {
                pPrev=pPrev.next;
            }
            pPrev.next=null;
            count--;
        }
        else {
            int count1 = 0;
            Node pTraverse, pPrev;
            pTraverse = first;
            pPrev = null;
            while (pTraverse.next != null) {
                pPrev = pTraverse;
                pTraverse = pTraverse.next;
                count1++;
                if (num == count1)
                    break;
            }
            del = pPrev.data;
            delete(del);
        }
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

    public static void main(String[] args) {
        System.out.println("Link list tutorial");
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
                printLinklist(first);
            } else if (choice == 4) {
                System.out.println("reversing the list ");
                Reverse(first);
            } else if (choice == 5) {
                System.out.println("Enter node to be deleted");
                int number;
                number = console.nextInt();
                deleteAtn(number);
            } else if (choice == 6) {
                System.out.println("thank you");
            }

        } while (choice != 6);

    }

}
