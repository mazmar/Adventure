/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author mazmart
 */
public class Facade {

    private static Facade instance;
    private Room currentRoom;
    private Stack<Room> lastRooms = new Stack<Room>();
    private List<Item> bag = new ArrayList();
    private boolean endGame = false;

    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }

    boolean make(String cmd) {
        try {
            Command c = parseCommand(cmd);
            if (c.name.toLowerCase().startsWith("pick")) {
                this.pick(c);
            } else if (c.name.toLowerCase().startsWith("back")) {
                this.back();
            } else if (c.name.toLowerCase().startsWith("move")) {
                this.move(c);
            } else if (c.name.toLowerCase().startsWith("use")) {
                this.use(c);
            } else if (c.name.toLowerCase().startsWith("talk")) {
                this.talk(c);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return this.endGame;
    }

    String getCommands() {
        return currentRoom.getCommands() + ", [Back]";
    }

    void back() {
        if (this.lastRooms.isEmpty()) {
            System.out.println("No Way Back");
        } else {
            this.currentRoom = lastRooms.pop();
        }
    }

    private Command parseCommand(String cmd) {
        String[] s = cmd.split(" ", 2);
        Command c;
        if (s.length == 1) {
            c = new Command(cmd, null);
        } else {
            c = new Command(s[0], s[1]);
        }
        return c;
    }

    private void move(Command c) throws UnknownDirectionException, DisallowedCommandException {
        int dir = Direction.parseDir(c.arg);
        Room next = this.currentRoom.goTo(dir);
        if (next != null) {
            this.lastRooms.add(this.currentRoom);
            this.currentRoom = next;
        } else {
            throw new DisallowedCommandException("Room not found on Direction " + c.arg);
        }
        if (this.currentRoom.endRoom) {
            this.endGame = true;
        }
    }

    private void pick(Command c) throws DisallowedCommandException {
        this.bag.add(this.currentRoom.pick(c.arg));
    }

    void setMaze(Room startRoom) {
        this.currentRoom = startRoom;
    }

    void getRoomMsg() {
        System.out.println(currentRoom.toString());
    }

    private void use(Command c) throws DisallowedCommandException {
        Item compare = new Item(c.arg);
        int i = this.bag.indexOf(compare);
        if (i != -1) {
            this.currentRoom.use(this.bag.get(i));
        } else {
            throw new DisallowedCommandException("No such item in bag");
        }
    }

    private void talk(Command c) throws DisallowedCommandException {
        this.currentRoom.talk(c);
    }

    void getEnd() {
        if (bag.contains(new Item("Poklad"))){
            System.out.println("Gratulujem zvitazil si nad drakem a odnesl sis sebou poklad si tym pravym vitezem!!!");
        } else {
            System.out.println("Gratulujem zvitazil si nad drakem "
                    + "\nale nechal si za sebou poklad a jeskyne se za tebou zroutila"
                    + "\nTo je ale smula!!!");
        }
    }
}
