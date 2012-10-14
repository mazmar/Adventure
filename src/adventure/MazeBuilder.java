/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mazmart
 */
public class MazeBuilder {

    int offset;
    Room start;
    public void buildTemplateMaze(){
        this.start = this.addRoom(new Room());
        Room r = this.addRoom(this.start, Direction.DIR_DOWN, new Room("Temnejsi Misnost 2"));
        Item key = new Item("Kluc", null);
        this.start.addItem(key);
        r.addObstacle("Zamek", "Rezavejici Zamek", true, key);
    }
    
    
    public Room addRoom(Room origin, int dir, Room r1){
        origin.addRoom(r1, dir);
        r1.addOpositeRoom(origin, dir);
        return r1;
    }
    
    public Room addRoom(Room r){
        this.start = r;
        return r;
    }
    
    public Room build(){
        return this.start;
    }
}
