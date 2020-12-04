package me.shahnama.tools;

import me.shahnama.MainApp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tools {

    public List<String> readInput(String fileName){
        List<String> puzzleInput = new ArrayList<String>();
        try {
            System.out.println(this.getClass().getResourceAsStream("/puzzleInput/" + fileName));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    this.getClass().getResourceAsStream("/puzzleInput/" + fileName), "UTF-8"));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                puzzleInput.add(line);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return puzzleInput;
    }

}
