/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure;

/**
 *
 * @author mazmart
 */
class UnknownDirectionException extends Exception {

    String dir;

    UnknownDirectionException(String dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return "UnknownDirection{" + this.dir + '}';
    }
}
