/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.complementoshanoi;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

/**
 *
 * @author phily
 */
public class Disco extends JLabel implements MouseListener, MouseMotionListener{            
    private Dimension dimension;//Esto dependerá del número de disco que sea...
    private Point puntoTorre;//ESte será el ultimo punto en el cual fue colocado correctamente el disco... será cambiado HASTA QUE pase la verificación...
    private Point puntoPantalla;//Es la ubicación correspondiente a la pantalla de la computadora
    private Point puntoFrame;//Es la posición dentro del frame, donde se dearrollará el juego...
    //estas 2 var de arriba sirven para mover al disco dentro del área de juego en cuestión, sin importar dónde se encuentre posicionada la ventana...
    private Point puntoActual;     
    private int numero;//Este numero será recibido al ser creado por el método correspondiente, donde el dico con > valor será el de >tamaño...  
    private int torreActual=1;//siempre se van a colocar los discos en la primer torre [la que está más a la izq...]
    private static boolean permiso;
    //al iniciar, debería asignar cada uno de los discos a la torre inicial... por lo tanto     

    public Disco( ){        
        //se inician propiedades de objeto
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));        
        this.setSize(new Dimension(300, 50));
        this.setPreferredSize(new Dimension(300, 50));      
        this.setIcon( new ImageIcon("1.png") ); 
        this.setText("");
        this.setVisible( true );
        this.setLocation( new Point(0, 0) );
        //se agregan los listener
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        
    }
    public Disco(Dimension dimension, Point point){        
        //se inician propiedades de objeto
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));        
        this.setSize(dimension);
        this.setPreferredSize(dimension);      
        this.setIcon( new ImageIcon("1.png") ); 
        this.setText("");
        this.setVisible( true );
        this.setLocation( new Point(0, 0) );
        //se agregan los listener
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        
    }
    public Disco(int alto, int ancho, int x ,int y) {
        this.setSize(ancho, alto);
        establecerNuevaPosicionCorrecta(x, y);
    }
        
    public void setAtributos(Dimension size, int numeroDisco, int puntoX, int puntoY){
        this.setSize(size);
        numero = numeroDisco;
        puntoTorre = new Point(puntoX, puntoY);
    }
    
    public void setTamaño(Dimension size){
        this.setSize(size);
    }
    
    public void establecerNuevaPosicionCorrecta(int posX, int posY){
        this.setLocation(posX, posY);
    }    
    

    /**
     *Método encargado de recibir el número de la 
     * torre en la que se enuantra actualmente, donde
     * dicha numeració comienza desde 1...
     * @param nuevaTorre
     */
    public void cambiarTorreActual(int nuevaTorre){
       torreActual = nuevaTorre;//para hacer el cambio en el arreglo nada más tendrías que restarle 1...
    }
    
    /**empleado por el método de verificación 
     * luego de haber revisado que no PUEDE ser
     * colocado en esa torre
     *
     */
    public void regresarAUltimaPosicionCorrecta(){
        this.setLocation(puntoTorre.x, puntoTorre.y);
    }
    
    public int getAncho(){
        return dimension.width;
    }
    
    public double getAlto(){
        return dimension.getHeight();
    }
    
    /**
     * El número depende del tamanio
     * el cual es correspondiente al 
     * > o < valor...
     * @return
     */
    public int getNumeroDisco(){
        return numero;
    }
    
    public int getTorreActual(){
        return torreActual;
    }

    public int getNumeroTorrePartida(){
        return torreActual;
    }
    /**
     * reestablece el último punto correcto
     * relativo a una torre [el cual es útil
     * para regresar a la última pos buena]
     * pero no mueve al disco...
     * @param posicionNuevaUbicacion
     */
    public void setPosicionTorreActual(Point posicionNuevaUbicacion){//Este valor dependerá de la torre a la cuál se dirigirá... práctiamente esos valores son fijos, puesto que siempre estarán en los mismo lugares dichas estructuras...
        puntoTorre= posicionNuevaUbicacion;
    }

    /**
     * método empleado para mandar
     * al disco a una posción de 
     * manera directa...
     * @param posX
     * @param posY
     */
            
            
    @Override
    public void mouseClicked(MouseEvent arg0) {}

    
    //Estos métodos son solo para mover el objeto... los cuales podrán ser afectados si 
    //el método de verificación encuentra que no puede ser colocado en ese lugar...
    @Override
    public void mousePressed(MouseEvent evento) {
       this.puntoPantalla = getPosicionPantalla(evento);
       this.puntoFrame = this.getLocation();//Esta variable poseerá el valor de la torre en la que haya sido bien posicionado...
       System.out.println("");
    }
    
    @Override
    public void mouseReleased(MouseEvent arg0) {}

    /**
     * enmarca el objeto seleccionado
     * @param arg0
     */
    @Override
    public void mouseEntered(MouseEvent arg0) {
         this.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255,204,204), 2));   
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
          this.setBorder( null );  
    }

    @Override
    public void mouseDragged(MouseEvent evento) {//método por medio del cual se cambia la posición del disco...
      Point actual = this.getPosicionPantalla(evento);
      int x = ((int) actual.getX() - (int) puntoPantalla.getX());
      int y = ((int) actual.getY() - (int) puntoPantalla.getY());
      
      puntoActual = new Point(x,y);//Esto es para calcular la distancia a partir del punto en el que se encontraba...
     
      int nuevoX = ((int)(this.puntoFrame.getX() + puntoActual.getX()));
      int nuevoY = ((int) (this.puntoFrame.getY() + puntoActual.getY()));
      
        
        if (permiso) {            
            this.setLocation(new Point(nuevoX, nuevoY));  
        }
        
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {}
    
    private Point getPosicionPantalla(MouseEvent evt) {
        Point cursor = evt.getPoint();
        Point ubicacionPantalla = this.getLocationOnScreen();
        return new Point((int) (ubicacionPantalla.getX() + cursor.getX()),
               (int) (ubicacionPantalla.getY() + cursor.getY()));
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Point getPuntoTorre() {
        return puntoTorre;
    }

    public void setPuntoTorre(Point puntoTorre) {
        this.puntoTorre = puntoTorre;
    }

    public Point getPuntoPantalla() {
        return puntoPantalla;
    }

    public void setPuntoPantalla(Point puntoPantalla) {
        this.puntoPantalla = puntoPantalla;
    }

    public Point getPuntoFrame() {
        return puntoFrame;
    }

    public void setPuntoFrame(Point puntoFrame) {
        this.puntoFrame = puntoFrame;
    }

    public Point getPuntoActual() {
        return puntoActual;
    }

    public void setPuntoActual(Point puntoActual) {
        this.puntoActual = puntoActual;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTorreActual(int torreActual) {
        this.torreActual = torreActual;
    }

    public static void setPermiso(boolean permiso) {
        Disco.permiso = permiso;
    }
    
    
}
