import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    int position_X;
    int position_Y;

    public Hero (int x, int y){
        this.position_X = x;
        this.position_Y = y;
    }

    // Getter
    public int[] getCoords() {
        int[] values = {position_X, position_Y};
        return values;
    }

    // Setter
    public void setCoords (int x, int y) {
        this.position_X = x;
        this.position_Y = y;
    }

    public void moveUp () {
        this.position_Y = this.position_Y - 1;
    }

    public void moveDown () {
        this.position_Y = this.position_Y + 1;
    }

    public void moveLeft () {
        this.position_X = this.position_X - 1;
    }

    public void moveRight () {
        this.position_X = this.position_X + 1;
    }

    public void draw(Screen screen) {
        screen.setCharacter(this.position_X, this.position_Y, TextCharacter.fromCharacter('X')[0]);
    }

}
