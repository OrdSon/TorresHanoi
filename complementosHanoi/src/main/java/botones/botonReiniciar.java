/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botones;

import Juego.EndScreen;
import Juego.Interfaz;
import Juego.Menu;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author samuelson
 */
public class botonReiniciar extends ActionButton{
        Interfaz interfaz;
        EndScreen endScreen;
    public botonReiniciar(Interfaz interfaz) {
        super();
        this.interfaz = interfaz;
        super.iconorReinicia();
    }
    public botonReiniciar(EndScreen endScreen) {
        super();
        this.endScreen = endScreen;
        super.iconorReinicia();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int confirm = JOptionPane.showConfirmDialog(interfaz, "¿Quiere reiniciar el juego?");
        if (confirm == 0 && interfaz != null) {
            interfaz.dispose();
            Menu menu = new Menu();
            menu.setVisible(true);
        }else if (confirm == 0 && endScreen != null) {
            endScreen.dispose();
            Menu menu = new Menu();
            menu.setVisible(true);
        }
        
    }

}
