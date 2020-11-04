/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reloj;

import javax.swing.JLabel;

/**
 *
 * @author samuel
 */
public class Timer extends javax.swing.JLabel {

    int milisegundos;
    int segundos;
    int minutos;
    int hora;
    static boolean estado;
    static int tiempoLimite = 1000;//se ingresa en minutos
    static int copiaHoras;
    static int copiaMinutos;
    static int referencia;
    static boolean bandera;
    
    Timer timer;
    public Timer() {
        initComponents();
    }
    public void iniciarTimer(){
        estado = true;
        //Verifica el tiempo limite y lo convierte en horas y minutos

        if (tiempoLimite >= 60) {
            
            int horas = (int)Math.round(tiempoLimite/60);
            int minute =(int)Math.round(tiempoLimite%60);
            tiempoLimite = horas+minute;
        } 
         //Este es el reloj
        Thread hilo = new Thread(){
          @Override
          public void run(){
              for (;;) {
                  if(estado == true){
                      try{
                          sleep(1);
                          if (milisegundos >= 1000) {
                              milisegundos = 0;
                              segundos++;
                          }if (segundos >= 60) {
                              milisegundos = 0;
                              segundos = 0;
                              minutos ++;
                          }if (minutos >= 60) {
                              milisegundos = 0;
                              segundos = 0;
                              minutos = 0;
                              hora++;
                          }//A cada ciclo, actualiza el lablel de la hora
                          labelTiempo.setText(hora+":"+minutos+":"+segundos);
                          //Convierte el tiempo a minutos para comparar
                          referencia = ((int)(hora*60)+(minutos));
                          if (bandera) {
                            //  Main.drivers.guardaHora(hora, minutos, segundos);
                              pausarTimer();
                          }//Detiene el reloj cuando llega al tiempo limite
                          if (referencia>=tiempoLimite) {
                              detenerTimer();
                              pausarTimer();
                          }//Inicia el Reloj
                          milisegundos++;
                      }catch(InterruptedException e){
                          
                      }
                  }else{
                      break;
                  }
              }
          }  
        };
        hilo.start();
    }//Reinicia el Timer;
    //Ojo! no lo pausa, solo lo reinicia
    public void detenerTimer(){
        estado = true;
        milisegundos = 0;
        segundos = 0;
        minutos = 0;
        hora = 0;
        labelTiempo.setText("00:00:00");
        
    }//Pausa el timer (usar despues de detener)
    public void pausarTimer(){
        estado = false;
    }
    
    public int getMinutos() {
        return minutos;
    }

    public JLabel getLabelTiempo() {
        return labelTiempo;
    }

    public int getSegundos() {
        return segundos;
    }

    public static int getTiempoLimite() {
        return tiempoLimite;
    }
//Setea el tiempo limite (unico modo de  detener el reloj)
    public static void setTiempoLimite(int tiempoLimite) {
        Timer.tiempoLimite = tiempoLimite;
    }

    public static boolean isBandera() {
        return bandera;
    }

    public static void setBandera(boolean bandera) {
        Timer.bandera = bandera;
    }

    public int getHora() {
        return hora;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTiempo = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        labelTiempo.setFont(new java.awt.Font("Chilanka", 1, 24)); // NOI18N
        labelTiempo.setForeground(new java.awt.Color(255, 255, 255));
        labelTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTiempo.setText("00:00:00");
        add(labelTiempo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelTiempo;
    // End of variables declaration//GEN-END:variables
}
