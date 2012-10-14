/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure;

/**
 *
 * @author mazmart
 */
public class Direction {

    public static final int DIR_LEFT = 1;
    public static final int DIR_UP = 2;
    public static final int DIR_RIGHT = 3;
    public static final int DIR_DOWN = 4;

    public static int parseDir(String dir) throws UnknownDirectionException {
        if (dir.equalsIgnoreCase("up")) {
            return Direction.DIR_UP;
        } else if (dir.equalsIgnoreCase("down")) {
            return Direction.DIR_DOWN;
        } else if (dir.equalsIgnoreCase("left")) {
            return Direction.DIR_LEFT;
        } else if (dir.equalsIgnoreCase("right")) {
            return Direction.DIR_RIGHT;
        } else {
            throw new UnknownDirectionException(dir);
        }
    }
}
