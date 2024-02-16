package GameEngine;
import Character.Monster.Monster;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameEngine extends JPanel implements KeyListener {
    // movement
    private int playerX = 50;
    private int playerY = 50;
    //Color
    protected Color playerColor;
    public GameEngine() {
        setPreferredSize(new Dimension(400, 400)); // Set the preferred size of the panel
        addKeyListener(this); // Add the KeyListener to the panel
        setFocusable(true); // Set focusable to true so the panel can receive key events
    }

    protected void movePlayer(int deltaX, int deltaY) {
        playerX += deltaX;
        playerY += deltaY;
        repaint(); // Request a redraw after moving
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(playerColor);
        g.fillRect(playerX, playerY, 20, 20); // Draw the player square at its current position
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not needed for arrow key movement
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_UP:
                movePlayer(0, -10);
                break;
            case KeyEvent.VK_DOWN:
                movePlayer(0, 10);
                break;
            case KeyEvent.VK_LEFT:
                movePlayer(-10, 0);
                break;
            case KeyEvent.VK_RIGHT:
                movePlayer(10, 0);
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // Not needed for arrow key movement
    }
    public static void main(String[] args){
//        JFrame frame = new JFrame("Game");
//        GameEngine game = new GameEngine();
//        frame.add(game);
//        frame.pack();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//        Monster mon = new Monster();
//        System.out.print(mon.getType());

    }

}
