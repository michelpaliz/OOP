package Tema08.EjerciciosTema8.Pila;

public class CircularQueue {
    // Defining the size of Circular Queue
    int SIZE = 5;
    int front, rear; //parte trasera y parte delantera
    int queue[] = new int[SIZE];

    // creating the constructor of the above class
    public CircularQueue() {
        front = -1;
        rear = -1;
    }

    // Implementing the 2 scenarios to check if the queue is full or not
    boolean isFullQueue() {
        if (front == 0 && rear == SIZE - 1) {
            return true;
        }
        if (front == rear + 1) {
            return true;
        }
        return false;
    }

    // Check if the queue is empty or not
    boolean isEmptyQueue() {
        if (front == -1)
            return true;
        else
            return false;
    }

    // Adding an element in the queue
    void enQueue(int value) {
        if (isFullQueue()) {
            System.out.println("Sorry !! Queue is full.. No more elements could be inserted in it");
        } else {
            // if there is no element in the queue
            if (front == -1)
                front = 0;
            // incrementing the rear position in circular manner using modulo operator
            rear = (rear + 1) % SIZE;
            // placing the value at the rear position
            queue[rear] = value;
            System.out.println("Element " + value + " is inserted successfully");
        }
    }

    // Deleting the element from the queue
    void deQueue() {
        int value;
        // checking of the queue is empty or not
        if (isEmptyQueue()) {
            System.out.println("Sorry !!The Queue is empty.. ");
        } else {
            value = queue[front];
            // if there is only one element in the queue
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                // Incrementing the front in a circular manner
                front = (front + 1) % SIZE;
            }
        }
    }

    // Displaying the elements of the Circular queue
    void displayQueue() {
        int i;
        if (isEmptyQueue()) {
            System.out.println("Sorry!! The Queue is Empty");
        } else {
            System.out.println("Position of Front:  " + front);
            System.out.println("Below given are the elements of the Queue");
            for (i = front; i != rear; i = (i + 1) % SIZE)
                System.out.print(queue[i] + " ");
            System.out.println(queue[i]);
            System.out.println("Position of Rear: " + rear);
        }
    }

    // Main function to drive the code
    public static void main(String[] args) {
        // creating the object of the class to call the methods
        CircularQueue que = new CircularQueue();
        // Queue is empty. No element is inserted as of now
        que.deQueue();
        que.enQueue(10);
        que.enQueue(24);
        que.enQueue(33);
        que.enQueue(67);
        que.enQueue(22);
        que.displayQueue();
        que.deQueue();
        que.displayQueue();
        que.enQueue(900);
        que.displayQueue();
        // Element cannot be inserted as the queue is full
        que.enQueue(867);
        que.deQueue();
        que.displayQueue();
    }
}
