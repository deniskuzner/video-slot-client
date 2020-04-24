/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Communication {
    
    private static Communication instance;
    private Socket socket;
    
    private Communication() {
        try {
            socket = new Socket("localhost", 8189);
        } catch (IOException ex) {
            Logger.getLogger(Communication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Communication getInstance() {
        if(instance == null)
            instance = new Communication();
        return instance;
    }
}
