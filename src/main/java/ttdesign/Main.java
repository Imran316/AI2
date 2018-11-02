/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttdesign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author imran
 */
public class Main {
    
    public static void main(String args[]){
        Splash splash = new Splash();
        splash.setVisible(true);
        try{
            Thread.sleep(2000);
            splash.dispose();
            splash.setVisible(false);
            LoginActivity mainActivity = new LoginActivity();
            mainActivity.setVisible(true);
            mainActivity.pack();
            mainActivity.setLocationRelativeTo(null);
            mainActivity.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (InterruptedException ex) { 
           System.out.println(ex.toString());
        }
        
    }
}
