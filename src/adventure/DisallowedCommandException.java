/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adventure;

/**
 *
 * @author mazmart
 */
class DisallowedCommandException extends Exception {

    String reason;

    public DisallowedCommandException(String reason) {
        this.reason = reason;
    }

    public DisallowedCommandException() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("This Command is not allowed");
        if (reason != null) {
            sb.append(" because ").append(this.reason);
        }
        return sb.toString();
    }
}
