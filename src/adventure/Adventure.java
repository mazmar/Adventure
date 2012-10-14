/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure;

import java.util.Scanner;

/**
 *
 * @author mazmart
 */
public class Adventure {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Facade  facade = Facade.getInstance();
        MazeBuilder maze = new MazeBuilder();
        maze.buildTemplateMaze();
        facade.setMaze(maze.build());
        
        String cmd;
        boolean konec = false;
        Scanner s = new Scanner(System.in);
        while (!konec) {
            facade.getRoomMsg();
            System.out.println(facade.getCommands());
            cmd = s.nextLine();
            if (cmd.equalsIgnoreCase("k") || cmd.equalsIgnoreCase("Konec")) {
                break;
            }
            konec = facade.make(cmd);
        }
        facade.getEnd();
    }
}
