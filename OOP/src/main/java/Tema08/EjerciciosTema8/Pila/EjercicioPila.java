package Tema08.EjerciciosTema8.Pila;

import java.util.Random;

public class EjercicioPila {

    Random r = new Random(5);
    Pila p = new Pila(10);

    public Pila generatorPila() {
        // System.out.println(p);
        for (int i = 0; i < 5; i++) {
            p.push(r.nextInt(10));
            System.out.println(p);
        }
        // devolver datos de la pila
        for (int i = 0; i < 5; i++) {
            System.out.println(p.pop());
        }
        return p;
    }

    public void circularQueue() {
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

    public EjercicioPila() {
        // generatorPila();
        circularQueue();

    }
}
