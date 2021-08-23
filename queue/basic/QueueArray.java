package queue.basic;

public class QueueArray {
    int front, rear, size;
    int capacity;
    int[] arr;

    public QueueArray(int capacity) {
        this.capacity = capacity;
        this.front = this.size = 0;
        this.rear = capacity - 1;
        this.arr = new int[capacity];
    }

    boolean isFull() {
        return capacity == size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void enqueue(int val) {
        if (isFull())
            System.out.println("Queue Overflow");
        else {
            rear = (rear + 1) % capacity;
            arr[rear] = val;
            size++;
        }
    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
        } else {
            System.out.println("Popped " + arr[front]);
            front = (front + 1) % capacity;
            size--;
        }
    }

    void display() {
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        QueueArray queue = new QueueArray(100);
        queue.enqueue(6);
        queue.dequeue();
        queue.enqueue(8);
        queue.enqueue(10);
        queue.display();
        queue.enqueue(12);
        queue.enqueue(24);
        queue.display();
        queue.dequeue();
        queue.enqueue(36);
        queue.display();
        queue.dequeue();
    }

}