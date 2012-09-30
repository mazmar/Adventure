/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure;

import java.util.List;

/**
 *
 * @author mazmart
 */
public abstract class Room {

    String name;
    Room left, right, up, down;
    List<Item> items;

    abstract void addRoom(Room r, String direction);
    
    abstract void addItem(Item item);

    abstract void addObstacle(String name, String desc, boolean unlockable, Item lock);
}
