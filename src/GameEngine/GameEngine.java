package GameEngine;

import Character.CharacterProperties;
import Character.Hero.Hero;
import Character.Monster.Dragon;
import Character.Monster.Goblin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameEngine extends JPanel implements KeyListener {
    // movement
    private static int playerX = 50;
    private static int playerY = 50;
    private static List<CharacterProperties> characters;

    public GameEngine(List<CharacterProperties> characters) {
        this.characters = characters;
        setPreferredSize(new Dimension(400, 400)); // Set the preferred size of the panel
        addKeyListener(this); // Add the KeyListener to the panel
        setFocusable(true); // Set focusable to true so the panel can receive key events

        // Start a thread to update character positions
        Thread updateThread = new Thread(new CharacterUpdater());
        updateThread.start();
    }

    public static void removeCharacter(CharacterProperties character) {
        characters.remove(character);
    }

    protected void movePlayer(int deltaX, int deltaY) {
        playerX += deltaX;
        playerY += deltaY;
        repaint(); // Request a redraw after moving
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw characters
        for (CharacterProperties character : characters) {
            if (character instanceof Goblin) {
                g.setColor(Color.GREEN);
                g.fillRect(character.getGetX(), character.getGetY(), 20, 20); // Draw the character square at its position
                g.setColor(Color.BLACK); // Set the color for the character name
                g.drawString(character.getName(), character.getGetX() - 7, character.getGetY() - 7); // Draw the character's name above the character square
            } else if (character instanceof Dragon) {
                g.setColor(Color.RED);
                g.fillRect(character.getGetX(), character.getGetY(), 50, 50); // Draw the character square at its position
                g.setColor(Color.BLACK); // Set the color for the character name
                g.drawString(character.getName(), character.getGetX() - 7, character.getGetY() - 7); // Draw the character's name above the character square
            } else if (character instanceof Hero) {
                g.setColor(Color.BLUE);
                g.fillRect(playerX , playerY, 20, 20); // Draw the character square at its position
                g.setColor(Color.BLACK); // Set the color for the character name
                g.drawString(character.getName(), playerX - 7, playerY - 7); // Draw the character's name above the character square
            }
        }
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

    // Method to handle battles between characters
    public void battle(CharacterProperties attacker, CharacterProperties target) {
        attacker.attack(target); // Attacker performs an attack on the target
        // Update visual feedback based on the outcome of the attack
        repaint();
    }
    private class CharacterUpdater implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Update character positions
                for (CharacterProperties character : characters) {
                    if (character instanceof Goblin || character instanceof Dragon) {
                        // Calculate direction towards the player
                        int playerX = GameEngine.getPlayerX();
                        int playerY = GameEngine.getPlayerY();
                        int deltaX = playerX - character.getGetX();
                        int deltaY = playerY - character.getGetY();

                        // Normalize direction vector
                        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
                        double directionX = deltaX / distance;
                        double directionY = deltaY / distance;

                        // Adjust movement speed
                        double speed = 10.0; // Adjust as needed
                        int newX = character.getGetX() + (int) (speed * directionX);
                        int newY = character.getGetY() + (int) (speed * directionY);

                        // Update character position
                        character.setGetX(newX);
                        character.setGetY(newY);
                    }

                    repaint(); // Request a redraw after updating character positions
                }
            }
        }
    }

    public static int getPlayerX() {
        return playerX;
    }

    public void setPlayerX(int playerX) {
        GameEngine.playerX = playerX;
    }

    public static int getPlayerY() {
        return playerY;
    }

    public void setPlayerY(int playerY) {
        GameEngine.playerY = playerY;
    }

    public static void main(String[] args) {
        // Create characters
        CharacterProperties goblin = new Goblin();
        goblin.setGetX(100); // Set initial X position
        goblin.setGetY(100); // Set initial Y position

        CharacterProperties dragon = new Dragon();
        dragon.setGetX(200); // Set initial X position
        dragon.setGetY(200); // Set initial Y position

        CharacterProperties hero = new Hero();

        // Add characters to a list
        List<CharacterProperties> characters = new ArrayList<>();
        characters.add(goblin);
        characters.add(dragon);
        characters.add(hero);

        // Pass the list of characters to the GameEngine
        GameEngine gameEngine = new GameEngine(characters);

        // Set up JFrame
        JFrame frame = new JFrame("Game");
        frame.add(gameEngine);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
