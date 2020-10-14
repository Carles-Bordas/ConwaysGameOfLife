package snowy.cgof;

public interface Display {

    /**
     * @return The width of the display
     */
    public int getWidth();
    
    /**
     * @return The height of the display
     */
    public int getHeight();

    /**
     * Sets the value of a pixel
     * 
     * @param x X coordinate of the pixel
     * @param y Y coordinate of the pixel
     * @param c Character to print to the buffer
     */
    public void setPixel(int x, int y, char c);

    /**
     * Gets the value of a pixel
     * 
     * @param x X coordinate of the pixel
     * @param y Y coordinate of the pixel
     */
    public char getPixel(int x, int y);

    /**
     * Clears the contents of the internal buffer
     */
    public void clear();

    /**
     * Draws the contents of the internal buffer to the console (System.out)
     */
    public void draw();

}
