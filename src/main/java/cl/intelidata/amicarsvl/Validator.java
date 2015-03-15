/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.intelidata.amicarsvl;

import cl.intelidata.amicarsvl.util.MCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Maze
 */
public class Validator {

    public static Logger logger = LoggerFactory.getLogger(Validator.class);

    public Boolean validateInputs(String user, String process) {
        return user != null && process != null;
    }

    public String desencryptInput(String input) {
        String decrypted = null;
        try {
            MCrypt mcrypt = new MCrypt();
            decrypted = new String(mcrypt.decrypt(input)).trim();
        } catch (Exception e) {
            logger.error(e.getMessage() + " {}", e);
        }

        return decrypted;
    }

    public String encryptInputs(String input) {
        String encrypted = null;
        try {
            MCrypt mcrypt = new MCrypt();
            encrypted = MCrypt.bytesToHex(mcrypt.encrypt("1")).trim();
        } catch (Exception e) {
            logger.error(e.getMessage() + " {}", e);
        }

        return encrypted;
    }
}
