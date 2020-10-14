package snowy.cgof;

public final class App {

    /**
     * Launches the game of life with the given parameters
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        // Specify input arguments (Width and Height)
        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);

        GameOfLife videogame = new GameOfLife(width, height);

        // Set up simulation
        
        try {
            while (true) {
                videogame.draw();
                videogame.step();
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
