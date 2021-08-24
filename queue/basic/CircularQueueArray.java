package queue.basic;

import java.util.Arrays;

public class CircularQueueArray {
    int front, rear, size;
    int[] arr;

    public CircularQueueArray(int size) {
        this.size = size;
        front = -1;
        rear = -1;
        arr = new int[size];
    }

    boolean isFull() {
        return ((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1)));
    }

    boolean isEmpty() {
        return front == -1;
    }

    void enqueue(int val) {
        if (isFull())
            System.out.println("Queue Overflow");
        else {
            if (front == -1) {
                rear = 0;
                front = 0;
            } else if (rear == size - 1 && front != 0) {
                rear = 0;
            } else
                rear++;
            arr[rear] = val;
        }

    }

    void dequeue() {
        if (isEmpty())
            System.out.println("Queue Underflow");
        else {
            System.out.println("Element Removed : " + arr[front]);
            if (front == rear) {
                front = -1;
                rear = -1;
            } else if (front == size - 1) {
                front = 0;
            } else
                front++;
        }
    }

    void display() {
        if (isEmpty())
            System.out.println("Queue Empty");
        else {
            if (rear >= front) {
                for (int i = front; i <= rear; i++) {
                    System.out.print(arr[i] + " ");
                }
            } else {
                for (int i = front; i < size; i++) {
                    System.out.print(arr[i] + " ");
                }
                for (int i = 0; i < rear; i++) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularQueueArray queue = new CircularQueueArray(10);
        queue.enqueue(6);
        queue.enqueue(8);
        queue.enqueue(3);
        queue.dequeue();
        queue.display();
        queue.enqueue(23);
        queue.dequeue();
        queue.display();
        queue.dequeue();
        queue.display();
        queue.enqueue(2);
        queue.enqueue(56);
        queue.display();
        queue.enqueue(23);
        System.out.println(Arrays.toString(queue.arr));
        queue.dequeue();
    }

}
