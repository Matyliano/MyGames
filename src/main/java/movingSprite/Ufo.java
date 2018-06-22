package movingSprite;

public class Ufo extends Sprite {

    private final int INI_X = 400;

    public Ufo( int x, int y ) {
        super( x, y );

        initUfo();
    }

    private void initUfo() {
        loadImage("C:\\Users\\joann\\Desktop\\obrazki\\alien.png");    //zmienić foto
        getImageDimensions();
    }

    public void move() {

        if (x < 0) {
            x = INI_X;
        }

        x -= 1;
    }
}
