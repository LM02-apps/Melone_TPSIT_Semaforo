/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package melone_semaforo;

/**
 *
 * @author Melone
 */
public class ProduciDato extends Thread {

    Semaforo pieno;
    Semaforo vuoto;
    int tanti = 5;          //numero di elementi da produrre
    final int attesa = 500; //tempo di riposo/attesa

    public ProduciDato(Semaforo s1, Semaforo s2) {
        pieno = s1;
        vuoto = s2;
    }

    public void run() {
        for (int k = 0; k < tanti; k++) {   //per tutti i dati da produrre
            vuoto.P();
            ProdConsSem.buffer = k;         //produce un numero
            System.out.println("Scrittore: dato scritto:" + k);
            pieno.V();
            try {
                Thread.sleep(attesa);
            } catch (Exception e) {
            }
        }
        System.out.println("Scrittore: termine scrittura dati.");
    }//fine run
}
