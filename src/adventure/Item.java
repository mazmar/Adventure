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
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "["+name+"]";
    }
}
