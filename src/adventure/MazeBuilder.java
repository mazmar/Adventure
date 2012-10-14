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
        Room r1 = this.addRoom(this.start, Direction.DIR_UP, new Room("Temnejsi Misnost 2"));
        Room r2 = this.addRoom(r1, Direction.DIR_UP, new Room("Dlouha chodba"));
        Room r3 = this.addRoom(r1, Direction.DIR_RIGHT, new Room("Kaplnka"));
        Room r4 = this.addRoom(r2, Direction.DIR_UP, new Room("Pokracujuca Chodba"));
        Room r5 = this.addRoom(r4, Direction.DIR_UP, new Room("Tajna Jeskyne"));
        Room r6 = this.addRoom(r4, Direction.DIR_RIGHT, new Room("Pokladnice"));
        Room r7 = this.addRoom(r6, Direction.DIR_RIGHT, new Room("Park pred zamkem"));
        r7.endRoom = true;
        Room r8 = this.addRoom(r1, Direction.DIR_LEFT, new Room("Misnost s obrazy"));
        Item sword = new Item("Mec");
        Item key = new Item("Kluc");
        Item poklad = new Item("Poklad");
        Person knez = new Person("Knez", "Mec je dvakrat vlevo, Kluc je vlevo pak hore");
        r3.addItem(knez);
        r8.addItem(sword);
        r2.addItem(key);
        r8.addObstacle("Zamok", "Rezavy [zamok]", true, key);
        r4.addObstacle("drak", "Straslivy dvouhlavy [drak]", true, sword);
        r6.addItem(poklad);
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
