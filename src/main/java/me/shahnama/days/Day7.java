package me.shahnama.days;

import me.shahnama.object.Bag;
import me.shahnama.tools.Tools;

import java.util.*;

public class Day7 {
    private final String PUZZLE_INPUT;
    private List<String> puzzleInput;
    private HashMap<String, List<Bag> > ourBagList = null;


    public Day7(String PUZZLE_INPUT){
        this.PUZZLE_INPUT = PUZZLE_INPUT;
        readInput();
        readBags();
    }

    private void readInput(){
        puzzleInput = new Tools().readInput(PUZZLE_INPUT);
    }

    public int solve_P1() {
        Set<String> keys = ourBagList.keySet();
        List<String> bagContainTargetColour = new ArrayList<>();
        List<String> targetColours = Collections.singletonList("shiny gold");
        while (targetColours.size() > 0) {
            List<String> tempList = new ArrayList<>();
            for (String targetColour : targetColours) {
                for (String key : keys) {
                    if (isIncludeShinyGold(ourBagList.get(key), targetColour)) {
                        if (!bagContainTargetColour.contains(key)) {
                            bagContainTargetColour.add(key);
                            tempList.add(key);
                        }
                    }
                }
            }
            targetColours = tempList;
        }
        return bagContainTargetColour.size();
    }

    public int solve_P2() {
        return countInsideBags("shiny gold" );
    }

    private void readBags(){
        ourBagList =new HashMap<>();
        List<Bag> bagContain;
        for(String data:puzzleInput){
            bagContain = new ArrayList<>();
            data = data.replace("contain ", "").replace(",","").replace(".","").replace("bags","bag");
            String [] bagsContain = data.split("bag");
            String mainBagColour = bagsContain[0].trim();
            for(int index=1;index<bagsContain.length;index++){
                if(bagsContain[index].contains("no other"))
                    continue;
                int bagCount = Integer.parseInt(bagsContain[index].split(" [a-z]{1,6}")[0].trim());
                String bagColour = bagsContain[index].split(" [0-9] ")[1].trim();
                bagContain.add(new Bag(bagCount,bagColour));
            }
            ourBagList.put(mainBagColour,bagContain);
        }
    }

    private boolean isIncludeShinyGold(List<Bag> bagContain  , String colour) {
        for (Bag bag : bagContain) {
            if (bag.colour.contains(colour)) {
                return true;
            }
        }
        return false;
    }

    private int countInsideBags(String targetColour ){
        int count = 0;
        List<Bag> bagContain = ourBagList.get(targetColour);
        for (Bag bag : bagContain) {
            int inEachBag = bag.quantity *  countInsideBags(bag.colour );
            int eachBagIncludeItself = inEachBag +  bag.quantity;
            count+= eachBagIncludeItself;
        }
        return count;
    }
}
