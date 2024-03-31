package View;

import Controller.ThreadCorredor;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Semaphore semaforo = new Semaphore(1);

        for(int i = 0; i < 4; i++) {
            Thread tCorredor = new ThreadCorredor(i, semaforo);
            tCorredor.start();

        }

    }
}
