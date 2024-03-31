package Controller;

import java.util.concurrent.Semaphore;

public class ThreadCorredor extends Thread{

    Semaphore semaforo;
    int idPessoa;
    public ThreadCorredor(int idPessoa, Semaphore semaforo) {
        this.idPessoa = idPessoa;
        this.semaforo = semaforo;

    }


    public void run () {
        corredor();

        try {
            semaforo.acquire();
            porta();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaforo.release();
        }

    }
    private void corredor() {

        int corredorTam = 200;
        int corredorPercorrido = 0;

        while(corredorPercorrido < corredorTam) {
            System.out.println("Pessoa #" + idPessoa + " já caminhou " + corredorPercorrido + " Metros do corredor");
            corredorPercorrido = corredorPercorrido + ((int) (( Math.random() * 3) + 4));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void porta(){
        int tempoPorta = (int) (Math.random() * 2) + 1;
        System.out.println("Pessoa #" + idPessoa + " está atravessando a porta");
        try {
            sleep(tempoPorta * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Pessoa #" + idPessoa + " atravessou a porta");

    }

}
