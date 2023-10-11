import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.awt.event.KeyEvent;
import java.io.IOException;

public class Game {
    private final Screen screen;

    Hero hero = new Hero(10, 10);

    public Game () throws IOException {
        TerminalSize terminalSize = new TerminalSize(40, 20);
        DefaultTerminalFactory terminalFactory = new
                DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();

        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null); // we don't need a cursor
        screen.startScreen(); // screens must be started
        screen.doResizeIfNecessary(); // resize screen if necessary
    }

    public void draw() throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }

    public void run() throws IOException {
        while(true) {
            draw();
            KeyStroke key = screen.readInput();

            if (key.getKeyType() == KeyType.EOF){
                break;
            }

            processKey(key);
        }
    }

    private void processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.ArrowUp){
            hero.moveUp();
        }
        if (key.getKeyType() == KeyType.ArrowDown){
            hero.moveDown();
        }
        if (key.getKeyType() == KeyType.ArrowLeft){
            hero.moveLeft();
        }
        if (key.getKeyType() == KeyType.ArrowRight){
            hero.moveRight();
        }
    }
}