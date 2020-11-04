/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Movimientos.Limite;
import java.awt.Dimension;
import java.awt.Point;
import objetos.Disco;
import objetos.Torre;
import java.util.LinkedList;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author samuelson
 */
public class Juego {

    LinkedList<Torre> torres = new LinkedList<>();
    Interfaz interfaz;
    JLabel label;
    int movimientos = 0;
    int movimientosMinimos;
    int cantidad;
    Limite limite = new Limite();

    public Juego(Interfaz interfaz) {
        this.interfaz = interfaz;
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
            this.cantidad = cantidad;
            Dimension dimension = new Dimension((300 - (20 * i)), 30);
            Disco disco = new Disco(dimension, (i + 1));
            disco.setTorreActual(0);
            component.add(disco);
            disco.setTorre(torres.get(0));
            disco.setJuego(this);
            torres.get(0).add(disco);
            movimientosMinimos = limite.calcular(cantidad);
        }
        torres.get(0).getLast().agregarMovimiento();
        torres.get(0).ubicar();
        component.updateUI();
    }

    public void transferirDisco(Disco disco, int index) {
        if (torres.get(index).isEmpty() || disco.getNumero() >= torres.get(index).getLast().getNumero()) {
            Torre torreAntigua = disco.getTorre();
            torreAntigua.removeLast();

            if (!torreAntigua.isEmpty()) {
                torreAntigua.getLast().agregarMovimiento();
            }
            if (!torres.get(index).isEmpty()) {
                torres.get(index).getLast().eliminarMovimiento();
            }
            if (disco.getTorreActual() != index) {
                disco.setTorreActual(index);
                movimientos++;
                setMovementCount();
            }
            torres.get(index).add(disco);
            torres.get(index).ubicar();
            if (!verificarDerrota()) {
                verificarVictoria();
            }
            disco.setTorre(torres.get(index));
        } else {
            disco.regresarAUltimaPosicionCorrecta();
        }
    }

    private boolean verificarDerrota() {
        if (movimientos > movimientosMinimos) {
            EndScreen derrota = new EndScreen();
            derrota.Derrota();
            derrota.setVisible(true);
            interfaz.dispose();
            return true;
        }
        return false;
    }

    private boolean verificarVictoria() {
            System.out.println(torres.get(2).size()+" , "+cantidad);
        if (torres.get(2).size() == cantidad) {
            
            interfaz.dispose();
            EndScreen endScreen = new EndScreen();
            endScreen.victoria();
            endScreen.setVisible(true);
            return true;
        }
        return false;
    }

    public void setMovementCount() {
        label.setText(movimientos + "");
        label.updateUI();
    }

    public LinkedList<Torre> getTorres() {
        return torres;
    }

    public void setTorres(LinkedList<Torre> torres) {
        this.torres = torres;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

}
