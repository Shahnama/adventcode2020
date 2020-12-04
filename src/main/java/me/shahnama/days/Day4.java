package me.shahnama.days;


import me.shahnama.object.Passport;
import me.shahnama.tools.Tools;

import java.util.ArrayList;
import java.util.List;

public class Day4 {

    public Day4(){
        readInput();
    }

    private static final String PUZZLE_INPUT = "day4.txt" ;
    private List<String> puzzleInput;
    private List<String> passportDataList = new ArrayList<>();


    private void readInput(){
        List<String> rawPuzzleInput = new Tools().readInput(PUZZLE_INPUT);
        String passportData = "";
        for(String rawData : rawPuzzleInput){
            if(rawData.equals("")){
                passportDataList.add(passportData);
                passportData = "";
            }
            passportData += (" " + rawData);
        }
        passportDataList.add(passportData);
    }

    public int solve_P1(){
        int count = 0;
        for(String passwordData : passportDataList){
            Passport passport = new Passport();
            passport.addData(passwordData);
            if(passport.hasAllFields()){
                count++;
            }
//                System.out.println(passport.isValid() + "  " + passwordData);
        }
        return count;
    }

    public int solve_P2(){
        int count = 0;
        for(String passwordData : passportDataList){
            Passport passport = new Passport();
            passport.addData(passwordData);
            if(passport.isValid()){
                count++;
            }
        }
        return  count;
    }

}

