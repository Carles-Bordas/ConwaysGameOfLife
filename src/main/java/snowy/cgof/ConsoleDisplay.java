package snowy.cgof;

public class ConsoleDisplay implements Display {

    private final int width;
    private final int height;
    private final char buffer[][];

    public ConsoleDisplay(int width, int height) {
        this.width = width;
        this.height = height;
        this.buffer = new char[width][height];
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setPixel(int x, int y, char c) {
        this.buffer[x][y] = c;
    }

    @Override
    public char getPixel(int x, int y) {
        return this.buffer[x][y];
    }

    @Override
    public void clear() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.buffer[i][j] = ' ';
            }
        }
    }

    @Override
    public void draw() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.println(this.buffer[i][j]);
            }
        }
    }
}
