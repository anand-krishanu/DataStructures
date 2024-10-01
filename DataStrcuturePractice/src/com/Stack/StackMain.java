package com.Stack;

import java.util.Scanner;

public class StackMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack myStack = new Stack();

        int choice;
        
        while (true) {
            System.out.println("Choose an option: ");
            System.out.println("1: Push      2: Pop      3: Print   4: Peek   5: Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter a number to Push: ");
                    int num = sc.nextInt();
                    myStack.push(num);
                    break;

                case 2:
                    if(myStack.isEmpty()) {
                        System.out.println("Stack is Empty!");
                    }
                    myStack.pop();
                    break;

                case 3:
                    myStack.printStack();
                    break;

                case 4:
                    System.out.println(myStack.peek());
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}
