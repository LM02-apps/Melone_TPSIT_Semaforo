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
public class ConsumaDato extends Thread {

    Semaforo pieno;
    Semaforo vuoto;
    int dato;

    public ConsumaDato(Semaforo s1, Semaforo s2) {
        pieno = s1;
        vuoto = s2;
    }

    public void run() {
        while (true) {
            pieno.P();
            dato = ProdConsSem.buffer; //consuma un numero
            System.out.println("Lettore:dato letto" + dato);
            vuoto.V();
        }
    }//fine run
}
