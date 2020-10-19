/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.awt.Dimension;
import java.awt.Point;
import objetos.Disco;
import objetos.Torre;
import java.util.LinkedList;
import javax.swing.JComponent;

/**
 *
 * @author samuelson
 */
public class Juego {

    LinkedList<Torre> torres = new LinkedList<>();

    public Juego() {
        instanciarTorres();
    }

    public void instanciarTorres() {
        for (int i = 0; i < 3; i++) {
            int posicion = ((300) * (i));
            Torre torre = new Torre();
            torre.setPosicion(posicion);
            torres.add(torre);

        }
    }

    public void iniciar(JComponent component, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            Dimension dimension = new Dimension((300 - (30 * i)), 40);
            Disco disco = new Disco(dimension, (i + 1));
            component.add(disco);
            disco.setTorre(torres.get(0));
            disco.setJuego(this);
            torres.get(0).add(disco);
        }
        torres.get(0).ubicar();
        component.updateUI();
    }

    public void transferirDisco(Disco disco, int index) {
        if (torres.get(index).isEmpty() || disco.getNumero() >= torres.get(index).getLast().getNumero()) {
            disco.getTorre().removeLast();
            torres.get(index).add(disco);
            torres.get(index).ubicar();
            disco.setTorre(torres.get(index));
        } else {
            disco.regresarAUltimaPosicionCorrecta();
        }
    }

    public LinkedList<Torre> getTorres() {
        return torres;
    }

    public void setTorres(LinkedList<Torre> torres) {
        this.torres = torres;
    }

}
