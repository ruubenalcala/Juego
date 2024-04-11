/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.*;
import javax.sound.sampled.*;



/**
 *
 * @author ruube
 */

public class Home extends javax.swing.JFrame {
    private Clip introClip;

    public Home() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        
        playIntroSound();

        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getResource("./principal.png"));
        Image backgroundResized = backgroundImageIcon.getImage().getScaledInstance(560, 840, Image.SCALE_SMOOTH);
        ImageIcon backgroundScaledIcon = new ImageIcon(backgroundResized);
        JLabel background = new JLabel(backgroundScaledIcon);
        getContentPane().add(background); 
        background.setLayout(new BorderLayout()); 
        background.setBounds(0, 0, 560, 840);
        setLocationRelativeTo(null);
    
    }
    
    private void playIntroSound() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("./intro.wav");
            if (inputStream == null) {
                throw new IOException("No se pudo encontrar el archivo de audio: intro.wav");
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(inputStream));

            introClip = AudioSystem.getClip();
            introClip.open(audioInputStream);
            introClip.addLineListener(new LineListener() {
                public void update(LineEvent event) {
                    if (event.getType() == LineEvent.Type.STOP) {
                        introClip.close();
                    }
                }
            });
            introClip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido de introducción: " + ex.getMessage());
        }
    }

    private void stopIntroSound() {
        if (introClip != null && introClip.isRunning()) {
            introClip.stop();
            introClip.close();
        }
    
    
}

    public Home( String uname) { //PASA USUARIO A HOME
        this();
        juname.setText(uname);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        juname = new javax.swing.JLabel();
        play = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        juname.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        juname.setForeground(new java.awt.Color(255, 255, 0));
        juname.setText("0");
        juname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                junameMouseClicked(evt);
            }
        });

        play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play.png"))); // NOI18N
        play.setText("\n");
        play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hometit.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(play, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(juname)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(juname)
                .addGap(146, 146, 146)
                .addComponent(play)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void junameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_junameMouseClicked
        
    }//GEN-LAST:event_junameMouseClicked

    private void playMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseClicked
        stopIntroSound();
        FlappyBird flappyBird = new FlappyBird();
    flappyBird.startGame();
    this.setVisible(false);
    }//GEN-LAST:event_playMouseClicked

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel juname;
    private javax.swing.JButton play;
    // End of variables declaration//GEN-END:variables

    private static class flappyBird {
        public void startGame() {
            int boardWidth = 560;
            int boardHeight = 840;

            JFrame frame = new JFrame("Flappy Bird");
            // frame.setVisible(true);

            //VENTANA
            frame.setSize(boardWidth, boardHeight); 
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            FlappyBird flappyBird = new FlappyBird();
            frame.add(flappyBird);
            frame.pack();
            flappyBird.requestFocus();
            frame.setVisible(true);
        }
    }
}
