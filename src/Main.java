/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ruube
 */

public class Main {

    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() { //CREA VIRTUALIZACION VENTANA
        @Override
        public void run() {
            new Principal().setVisible(true);
        }
    });
    }
    
}
