package queue.basic;

public class DequeueArray {
    int front, rear, size;
    int capacity;
    int[] arr;

    public DequeueArray(int capacity) {
        this.capacity = capacity;
        front = -1;
        rear = -1;
        this.size = capacity;
        this.arr = new int[capacity];
    }

    boolean isFull() {
        return (front == 0 && rear == size - 1) || front == rear + 1;
    }

    boolean isEmpty() {
        return front == -1;
    }

    void enqueueRear(int val) {
        if (isFull()) {
            System.out.println("Queue Overflow");
        } else {
            if (front == -1) {
                front = 0;
                rear = 0;
            } else if (rear == size - 1)
                rear = 0;
            else
                rear++;
            arr[rear] = val;
        }
    }

    void enqueueFront(int val) {
        if (isFull())
            System.out.println("Queue Overflow");
        else {
            if (front == -1) {
                front = 0;
                rear = 0;
            } else if (front == 0) {
                front = size - 1;
            } else {
                front--;
            }
            arr[front] = val;
        }
    }

    void dequeueFront() {
        if (isEmpty())
            System.out.println("Queue Underflow");
        else {
            System.out.println("Removed" + arr[front]);
            if (front == rear) {
                front = -1;
                rear = -1;
            } else if (front == size - 1)
                front = 0;
            else front++;
        }
    }

    void dequeueRear() {
        if (isEmpty())
            System.out.println("Queue Underflow");
        else {
            System.out.println("Removed " + arr[rear]);
            if (front == rear) {
                front = -1;
                rear = -1;
            } else if (rear == 0) {
                rear = size - 1;
            } else rear--;

        }
    }

    void front() {
        if (isEmpty())
            System.out.println("Queue Underflow");
        else {
            System.out.println("Front " + arr[front]);
        }
    }

    void rear() {
        if (isEmpty())
            System.out.println("Queue Underflow");
        else System.out.println("Rear " + arr[rear]);
    }


    public static void main(String[] args) {
        DequeueArray queue = new DequeueArray(10);
        queue.enqueueFront(5);
        queue.enqueueFront(6);
        queue.enqueueFront(12);
        queue.enqueueRear(4);
        queue.dequeueFront();
        queue.dequeueRear();
    }


}

