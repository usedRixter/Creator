/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import java.sql.SQLException;

/**
 *
 * @author rixter
 */
public class Except extends SQLException {
    
    int err_code;
    Except(int in){
        this.err_code=in;
    }

    @Override
    public String toString() {
        return "Except{" + "err_code=" + err_code + '}';
    }
    
    
}
