package com.Queue;

import com.Stack.Stack;

import java.util.Scanner;

public class QueueMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue myQueue = new Queue();

        int choice;

        while (true) {
            System.out.println("Choose an option: ");
            System.out.println("1: Enqueue      2: Dequeue      3: Print   4: Peek   5: Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter a number to Push: ");
                    int num = sc.nextInt();
                    myQueue.enqueue(num);
                    break;

                case 2:
                    if (myQueue.isEmpty()) {
                        System.out.println("Stack is Empty!");
                    }
                    myQueue.dequeue();
                    break;

                case 3:
                    myQueue.printQueue();
                    break;

                case 4:
                    System.out.println(myQueue.peek());
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}

