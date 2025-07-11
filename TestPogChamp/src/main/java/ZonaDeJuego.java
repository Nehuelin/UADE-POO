import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ZonaDeJuego extends JPanel implements ActionListener {
    private Serpiente serpiente;
    private Comida comida;
    private int puntaje;
    private boolean gameOver;
    private final Timer timer;

    public ZonaDeJuego() {
        setPreferredSize(new Dimension(Juego.WIDTH, Juego.HEIGHT));
        // setBackground(Color.BLACK);
        setFocusable(true);

        inicializarJuego();

        serpiente = new Serpiente(new Point(Juego.WIDTH / 2, Juego.HEIGHT / 2), Color.BLACK);
        comida = new Comida(Color.RED, Juego.WIDTH, Juego.HEIGHT);
        timer = new Timer(Juego.SPEED, this);
        timer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT -> serpiente.setDireccion(Direccion.IZQUIERDA);
                    case KeyEvent.VK_RIGHT -> serpiente.setDireccion(Direccion.DERECHA);
                    case KeyEvent.VK_UP -> serpiente.setDireccion(Direccion.ARRIBA);
                    case KeyEvent.VK_DOWN -> serpiente.setDireccion(Direccion.ABAJO);
                    case KeyEvent.VK_R -> reset();
                }
            }
        });
    }

    private void inicializarJuego() {
        serpiente = new Serpiente(new Point(Juego.WIDTH / 2, Juego.HEIGHT / 2), Color.BLACK);
        comida = new Comida(Color.RED, Juego.WIDTH, Juego.HEIGHT);
        puntaje = 0;
        gameOver = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            serpiente.mover();

            if (serpiente.checkColision(comida.getPosition())) {
                serpiente.crecer();
                comida.spawn();
                puntaje++;
            }

            if(serpiente.estaMuerta(Juego.WIDTH, Juego.HEIGHT, null)){
                gameOver = true;
            }
            repaint();
        }
    }

    private void reset(){
        inicializarJuego();
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        serpiente.render(g);
        comida.render(g);
        drawPuntaje(g);

        if (gameOver) {
            drawGameOver(g);
        }
    }

    private void drawPuntaje(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString("Puntaje: " + puntaje, 10, 10);
    }

    private void drawGameOver(Graphics g) {
        g.setColor(Color.RED);
        g.drawString("Game Over!", Juego.WIDTH / 2 - 50, Juego.HEIGHT / 2);
        g.drawString("Puntaje Final: " + puntaje, Juego.WIDTH / 2 - 60, Juego.HEIGHT / 2 + 20);
    }
}
