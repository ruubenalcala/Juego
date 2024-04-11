/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.*;
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
/**
 *
 * @author ruube
 */

public class FlappyBird extends JPanel implements ActionListener, KeyListener {
    int boardWidth = 560; //ANCHO
    int boardHeight = 840; //ALTO

    //IMAGENES
    Image backgroundImg; //FONDO
    Image birdImg; //PAJARO
    Image topPipeImg; // TUBO SUPERIOR
    Image bottomPipeImg; //TUBO INFERIOR

    //CLASE PAJARO
    int birdX = boardWidth/8; //X
    int birdY = boardWidth/2; //Y
    int birdWidth = 54; //ANCHO
    int birdHeight = 44; //ALTO

    void startGame() {
        int boardWidth = 560;
    int boardHeight = 840;

    JFrame frame = new JFrame("Flappy Bird");
    frame.setSize(boardWidth, boardHeight);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    FlappyBird flappyBirdPanel = new FlappyBird();
    frame.add(flappyBirdPanel);
    frame.setVisible(true);
    playBackgroudSound();
    
    }

    class Bird {
        int x = birdX;
        int y = birdY;
        int width = birdWidth;
        int height = birdHeight;
        Image img;

        Bird(Image img) {
            this.img = img;
        }
    }

    //CLASE TUBO
    int pipeX = boardWidth; //X INICIAL
    int pipeY = 0; //Y INICIAL
    int pipeWidth = 84;  //ANCHO
    int pipeHeight = 712; //ALTO (1/6)

    class Pipe {
        int x = pipeX;
        int y = pipeY;
        int width = pipeWidth;
        int height = pipeHeight;
        Image img;
        boolean passed = false;

        Pipe(Image img) {
            this.img = img;
        }
    }

    //LOGICA
    Bird bird;
    int velocityX = -5; //velocidad de movimiento de los tubos hacia la izquierda (simula el movimiento del pajaro hacia la derecha)
    int velocityY = 0; //velocidad de movimiento del pajaro hacia arriba/abajo
    int gravity = 1;

    ArrayList<Pipe> pipes;
    Random random = new Random();

    Timer gameLoop;
    Timer placePipeTimer;
    boolean gameOver = false;
    double score = 0;

    FlappyBird() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        // setBackground(Color.blue);
        setFocusable(true);
        addKeyListener(this);

        //cargar imagenes
        backgroundImg = new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();
        topPipeImg = new ImageIcon(getClass().getResource("./toppipe.png")).getImage();
        bottomPipeImg = new ImageIcon(getClass().getResource("./bottompipe.png")).getImage();

        //PAJARO
        bird = new Bird(birdImg);
        pipes = new ArrayList<Pipe>();

        // TEMPORIZADOR TUBOS
        placePipeTimer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              // codigo a ejecutar
              placePipes();
            }
        });
        placePipeTimer.start();
        
		//TEMPORIZADOR JUEGO
		gameLoop = new Timer(1000/60, this); //cuanto tiempo tarda en comenzar el temporizador, milisegundos transcurridos entre fotogramas 
        gameLoop.start();
	}
    
    void placePipes() {
        //(0-1) * pipeHeight/2.
        // 0 -> -128 (pipeHeight/4)
        // 1 -> -128 - 256 (pipeHeight/4 - pipeHeight/2) = -3/4 pipeHeight
        int randomPipeY = (int) (pipeY - pipeHeight/4 - Math.random()*(pipeHeight/2));
        int openingSpace = boardHeight/4;
    
        Pipe topPipe = new Pipe(topPipeImg);
        topPipe.y = randomPipeY;
        pipes.add(topPipe);
    
        Pipe bottomPipe = new Pipe(bottomPipeImg);
        bottomPipe.y = topPipe.y  + pipeHeight + openingSpace;
        pipes.add(bottomPipe);
    }
    
    
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g) {
    // FONDO
    g.drawImage(backgroundImg, 0, 0, this.boardWidth, this.boardHeight, null);

    // PAJARO
    g.drawImage(birdImg, bird.x, bird.y, bird.width, bird.height, null);

    // TUBOS
    for (int i = 0; i < pipes.size(); i++) {
        Pipe pipe = pipes.get(i);
        g.drawImage(pipe.img, pipe.x, pipe.y, pipe.width, pipe.height, null);
    }

    // PUNTUACION
    g.setColor(Color.white);
    g.setFont(new Font("Arial", Font.PLAIN, 32));
    if (gameOver) {
        String gameOverMessage1 = "¡OH NO! ¡HAS CHOCADO Y PERDIDO!";
        String gameOverMessage2 = "PUNTUACIÓN FINAL: " + String.valueOf((int) score);
        String gameOverMessage3 = "PARA CONTINUAR, PRESIONA ESPACIO";

        FontMetrics fontMetrics = g.getFontMetrics();
        int messageWidth1 = fontMetrics.stringWidth(gameOverMessage1);
        int messageWidth2 = fontMetrics.stringWidth(gameOverMessage2);
        int messageWidth3 = fontMetrics.stringWidth(gameOverMessage3);
        int messageHeight = fontMetrics.getHeight();

        int x1 = (boardWidth - messageWidth1) / 20;
        int x2 = (boardWidth - messageWidth2) / 2;
        int x3 = (boardWidth - messageWidth3) / 20;
        int y = (boardHeight - 3 * messageHeight) / 2;

        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 22)); 
        g.drawString(gameOverMessage1, x1, y);
        g.drawString(gameOverMessage2, x2, y + messageHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 15)); 
        g.drawString(gameOverMessage3, x3, y + 2 * messageHeight); 
    } else {
        g.drawString(String.valueOf((int) score), 10, 35);
    }

}



    public void move() {
        //PAJARO
        velocityY += gravity;
        bird.y += velocityY;
        bird.y = Math.max(bird.y, 0); //aplicar gravedad a la posicion actual de bird.y, limitar bird.y a la parte superior del lienzo

        //TUBOS
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            pipe.x += velocityX;

            if (!pipe.passed && bird.x > pipe.x + pipe.width) {
                score += 0.5; //0.5 porque hay 2 tubos. así que 0.5*2 = 1, 1 por cada conjunto de tubos
                pipe.passed = true;
                playPointSound();
            }

            if (collision(bird, pipe)) {
                gameOver = true;
                playCollisionSound();
            }
        }

        if (bird.y > boardHeight) {
            gameOver = true;
        }
    }

    boolean collision(Bird a, Pipe b) {
        return a.x < b.x + b.width &&   //la esquina superior izquierda de 'a' no alcanza la esquina superior derecha de 'b'
               a.x + a.width > b.x &&   //la esquina superior derecha de 'a' pasa la esquina superior izquierda de 'b'
               a.y < b.y + b.height &&  //la esquina superior izquierda de 'a' no alcanza la esquina inferior izquierda de 'b'
               a.y + a.height > b.y;    //la esquina inferior izquierda de 'a' pasa la esquina superior izquierda de 'b'
    }

    @Override
    public void actionPerformed(ActionEvent e) { //llamado cada x milisegundos por el temporizador gameLoop
        move();
        repaint();
        if (gameOver) {
            placePipeTimer.stop();
            gameLoop.stop();
        }
    }  

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            // System.out.println("salto");
            velocityY = -9;
            playJumpSound();

            if (

gameOver) {
                //reiniciar juego restableciendo las condiciones
                bird.y = birdY;
                velocityY = 0;
                pipes.clear();
                gameOver = false;
                score = 0;
                gameLoop.start();
                placePipeTimer.start();
            }
        }
    }
    
    private void playCollisionSound() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("./collision.wav"); //carga el archivo de audio como un recurso 

            if (inputStream == null) {
                throw new IOException("No se pudo encontrar el archivo de audio: collision.wav");
            }
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(inputStream));
            Clip clip = AudioSystem.getClip(); //obtiene el clip de audio y lo reproduce
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido de introducción: " + ex.getMessage());
        }
    }
    
    private void playJumpSound() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("./jump.wav");
            if (inputStream == null) {
                throw new IOException("No se pudo encontrar el archivo de audio: jump.wav");
            }
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(inputStream));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido de introducción: " + ex.getMessage());
        }
    }
    
    private void playPointSound() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("./point.wav");
            if (inputStream == null) {
                throw new IOException("No se pudo encontrar el archivo de audio: point.wav");
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(inputStream));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido de introducción: " + ex.getMessage());
        }
    }
    
    private void playBackgroudSound() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("./background.wav");
            if (inputStream == null) {
                throw new IOException("No se pudo encontrar el archivo de audio: backgroud.wav");
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(inputStream));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido de introducción: " + ex.getMessage());
        }
    }

    //no necesario
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
