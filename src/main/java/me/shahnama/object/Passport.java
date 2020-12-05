package me.shahnama.object;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Passport {

    private final HashMap<String, String> passportData;
    private boolean isAllValueValid;

    public Passport(){
        passportData = new HashMap<>();
        isAllValueValid = true;
    }

    public static final String byr = "byr";
    public static final String iyr = "iyr";
    public static final String eyr = "eyr";
    public static final String hgt = "hgt";
    public static final String hcl = "hcl";
    public static final String ecl = "ecl";
    public static final String pid = "pid";
    public static final String cid = "cid";


    private final Set<String> allKeySet = Stream.of(byr, iyr, eyr,hgt, hcl,ecl,pid )
            .collect(Collectors.toSet());

    public int Birth_Year;
    public int  Issue_Year ;
    public int Expiration_Year;
    public String Height = null;
    public String Eye_Color = null;
    public String Passport_ID = null;

    public void addData(String passportDataString){
        String [] passportData = passportDataString.split(" ");

        for(String data : passportData){
            if(data.equals(""))
                continue;
            String[] keyValue = data.split(":");
            String key = keyValue[0];
            String value = keyValue[1];
            this.passportData.put(key, value);
            if(!isValueValid(key, value)){
                isAllValueValid = false;
            }
        }
    }

    public boolean hasAllFields(){
        Set<String> keySet = this.passportData.keySet();
        return keySet.containsAll(allKeySet);
    }

    public boolean isAllValueValid(){
        return isAllValueValid;
    }

    public boolean isValid(){
        return (hasAllFields()&& isAllValueValid());
    }

    private boolean isValueValid(String key, String value){
        switch(key)
        {
            case byr:
                try{
                    Birth_Year = Integer.parseInt(value);
                    return (Birth_Year >= 1920 && Birth_Year <= 2002 );
                }catch(Exception ex){
                    System.out.println("Birth_Year convert error");
                    return false;
                }
            case iyr:
                try{
                    Issue_Year = Integer.parseInt(value);
                    return (Issue_Year >= 2010 && Issue_Year <= 2020 );
                }catch(Exception ex){
                    System.out.println("Issue_Year convert error");
                    return false;
                }
            case eyr:
                try{
                    Expiration_Year = Integer.parseInt(value);
                    return (Expiration_Year >= 2020 && Expiration_Year <= 2030 );
                }catch(Exception ex){
                    System.out.println("Expiration_Year convert error");
                    return false;
                }
            case hgt:
                try{
                    Height = value;
                    if(Height.contains("cm")){
                        int HeightValue = Integer.parseInt(value.replace("cm", ""));
                        return (HeightValue >= 150 && HeightValue <= 193 );
                    }else if(Height.contains("in")){
                        int HeightValue = Integer.parseInt(value.replace("in", ""));
                        return (HeightValue >= 59 && HeightValue <= 76 );
                    }else{
                        return false;
                    }
                }catch(Exception ex){
                    System.out.println("Height convert error "+Height);
                    return false;
                }
            case hcl:
                Eye_Color = value;
                String pattern = "#[0-9a-f]{1,6}";
                return Eye_Color.matches(pattern);
            case ecl:
                Eye_Color = value;
                List<String> validEyeColor = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
                return validEyeColor.contains(Eye_Color);
            case pid:
                Passport_ID = value;
                String PassportIdPattern = "[0-9]{9}";
                return Passport_ID.matches(PassportIdPattern);
            case cid:
                return true;
            default:
                System.out.println("no match:" +key );
                return false;
        }
    }
}

