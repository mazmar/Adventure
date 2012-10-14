/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure;

/**
 *
 * @author mazmart
 */
public class Person {

    String name;
    String phrase;

    Person(String arg) {
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
        final Person other = (Person) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

    public Person(String name, String phrase) {
        this.name = name;
        this.phrase = phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "["+this.name+"]";
    }
    
}
