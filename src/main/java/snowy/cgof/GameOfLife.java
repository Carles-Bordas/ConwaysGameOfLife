package snowy.cgof;

/**
 * This class is responsible of the simulation logic
 */
public class GameOfLife {
    private Display display;

    /**
     * Constructs a game of life simulation of the given width and height
     * @param width The width of the simulation
     * @param height The height of the simulation
     */
    public GameOfLife(int width, int height) {
        this.display = new ConsoleDisplay(width, height);
    }

    /**
     * Updates the state of the simulation by one step
     */
    public void step() {
        short currSurr;
        State currState;

        for (int x = 0; x < display.getWidth(); x++) {
            for (int y = 0; y < display.getHeight(); y++) {
                currSurr = getSurrounding(x, y);
                currState = calcState(currSurr);

                switch (currState) {
                    case BORN:
                        display.setPixel(x, y, 'A');
                        break;
                    case DIE:
                        display.setPixel(x, y, ' ');
                        break;
                    default:
                        break;
                }

            }
        }
    }

    /**
     * Draws the current state of the simulation
     */
    public void draw() {
        display.draw();
    }

    /**
     * Gets the number of alive cells surrounding the given position
     * @return the number of alive cells surrounding the given position
     */
    private short getSurrounding(int cooX, int cooY) {
        short aliveCells = 0;

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (cooX + x < 0 || cooY + y < 0 || cooX + x >= display.getWidth() || cooY + y >= display.getHeight()
                        || x == 0 && y == 0) {
                    continue;
                }

                if (display.getPixel(cooX + x, cooY + y) == 'A') {
                    aliveCells++;
                }
            }
        }

        return aliveCells;
    }

    /**
     * Calculates the state that the cell will take depending on the surrounding alive cells
     * @param surrounding the number of surrounding cells that are alive
     * @return the state of the cell
    */
    private State calcState(short surrounding) {
        State state;

        if (surrounding < 2) {//underpopulation
            state = State.DIE;
        } else if (surrounding > 3) { //overpopulation
            state = State.DIE;
        } else if (surrounding == 3) { //reproduction
            state = State.BORN;
        } else { //noChange
            state = State.UNBOTHERED;
        }

        return state;
    }

}
