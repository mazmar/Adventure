/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure;

/**
 *
 * @author mazmart
 */
public class Item {

    String name;
    String desc;

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    Item(String arg) {
        this.name = arg;
    }

    @Override
    public boolean equals(Object o) {
        return this.name.equalsIgnoreCase(((Item) o).name);
    }
    
    public boolean equals(String o) {
        return this.name.equalsIgnoreCase(o);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return name;
    }
}
