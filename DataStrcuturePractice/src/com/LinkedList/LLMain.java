package com.LinkedList;

import java.util.Scanner;

public class LLMain {
    public static void main(String[] args) {
        LinkedList myLL = new LinkedList();
        Scanner sc = new Scanner(System.in);

        int value;
        int index;

        while (true) {
            System.out.println("Choose an option: ");
            System.out.println("1: Insert Node at the end   2: Insert Node at the start   3: Insert   4: Delete First Node   5: Delete Last Node   6: Delete   7: Print LinkedList  8: End Code");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter value to Insert at the end: ");
                    value = sc.nextInt();
                    myLL.append(value);
                    break;
                case 2:
                    System.out.println("Enter value to Insert at the start: ");
                    value = sc.nextInt();
                    myLL.prepend(value);
                    break;
                case 3:
                    System.out.println("Enter the index: ");
                    index = sc.nextInt();
                    System.out.println("Enter the value to insert: ");
                    value = sc.nextInt();
                    myLL.insert(index, value);
                    break;
                case 4:
                    myLL.removeFirst();
                    break;
                case 5:
                    myLL.removeLast();
                    break;
                case 6:
                    System.out.println("Enter index to delete Node: ");
                    index = sc.nextInt();
                    myLL.remove(index);
                    break;
                case 7:
                    myLL.printList();
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }
}
