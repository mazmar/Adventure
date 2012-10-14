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
public class Room {

    String name;
    Room left, right, up, down;
    List<Item> items = new ArrayList<Item>();
    List<Person> people = new ArrayList<Person>();
    Obstacle obstacle;

    public Room(String name) {
        this.name = name;
    }

    public Room() {
        this.name = "Temna Mistnost";
    }

    void addRoom(Room r, int direction) {
        switch (direction) {
            case Direction.DIR_DOWN:
                this.down = r;
                break;
            case Direction.DIR_LEFT:
                this.left = r;
                break;
            case Direction.DIR_RIGHT:
                this.right = r;
                break;
            case Direction.DIR_UP:
                this.up = r;
                break;
        }
    }

    void addItem(Item item) {
        this.items.add(item);
    }

    void addObstacle(String name, String desc, boolean unlockable, Item lock) {
        this.obstacle = new Obstacle(name, desc, unlockable, lock);
    }

    public String getCommands() {
        StringBuilder sb = new StringBuilder();
        if (this.obstacle != null) {
            sb.append("There is ")
                    .append(this.obstacle.name)
                    .append(" in a way!\n")
                    .append("[Use] what");
        } else {

            sb.append("[Move] to");
            if (!this.items.isEmpty()) {
                sb.append(", [Pick] what");
            }
            if (!this.items.isEmpty()) {
                sb.append(", [Talk] to");
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("You are in " + this.name);
        for (Item item : items) {
            sb.append("\n").append("There is a ").append(item.toString());
        }
        return sb.toString();
    }

    Room goTo(int dir) throws DisallowedCommandException {
        if (this.obstacle != null) {
            throw new DisallowedCommandException("there is a obstacle in a way");
        }
        switch (dir) {
            case Direction.DIR_DOWN:
                return this.down;
            case Direction.DIR_LEFT:
                return this.left;
            case Direction.DIR_RIGHT:
                return this.right;
            case Direction.DIR_UP:
                return this.up;
        }
        return null;
    }

    void addOpositeRoom(Room origin, int dir) {
        switch (dir) {
            case Direction.DIR_DOWN:
                this.up = origin;
                break;
            case Direction.DIR_LEFT:
                this.right = origin;
                break;
            case Direction.DIR_RIGHT:
                this.left = origin;
                break;
            case Direction.DIR_UP:
                this.down = origin;
                break;
        }
    }

    Item pick(String arg) throws DisallowedCommandException {
        Item compare = new Item(arg);
        int i = this.items.indexOf(compare);
        if (i != -1) {
            return this.items.remove(i);
        } else {
            throw new DisallowedCommandException("Item " + arg + " not found in room");
        }
    }

    void use(Item key) throws DisallowedCommandException {
        if (this.obstacle == null) {
            throw new DisallowedCommandException("No obstacle found");
        }
        this.obstacle.unlock(key);
        this.obstacle = null;
    }

    void talk(Command c) throws DisallowedCommandException {
        Person compare = new Person(c.arg);
        int i = this.people.indexOf(compare);
        if (i!=-1){
            Person p = this.people.get(i);
            System.out.println(p.phrase);
        }else {
            throw new DisallowedCommandException("No such person");
        }
    }

    private class Obstacle {

        String name;
        String desc;
        boolean unlockable;
        Item lock;

        public Obstacle(String name, String desc, boolean unlockable, Item lock) {
            this.name = name;
            this.desc = desc;
            this.unlockable = unlockable;
            this.lock = lock;
        }

        private void unlock(Item key) throws DisallowedCommandException {
            if (!lock.equals(key)) {
                throw new DisallowedCommandException("Item " + key.name + " not applicable");
            }
        }
    }
}
