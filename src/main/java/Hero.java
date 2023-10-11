import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {

    private Position position = new Position ();

    public Hero (int x, int y){
        this.position.setX(x);
        this.position.setY(y);
    }

    // Getter
    public int[] getCoords() {
        int[] values = {this.position.getX(), this.position.getY()};
        return values;
    }

    // Setter
    public void setCoords (int x, int y) {
        this.position.setX(x);
        this.position.setY(y);
    }

    public void moveUp () { this.position.setY(this.position.getY() - 1);}

    public void moveDown () {
        this.position.setY(this.position.getY() + 1);
    }

    public void moveLeft () { this.position.setX(this.position.getX() - 1);}

    public void moveRight () {
        this.position.setX(this.position.getX() + 1);
    }

    public void draw(Screen screen) {
        screen.setCharacter(this.position.getX(), this.position.getY(), TextCharacter.fromCharacter('X')[0]);
    }

}
