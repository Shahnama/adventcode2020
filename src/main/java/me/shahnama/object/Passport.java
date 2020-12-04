package me.shahnama.object;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Passport {

    HashMap<String, String> passportData = new HashMap<String, String>();
    private boolean isAllValueValid;

    public Passport(){
        passportData = new HashMap<String, String>();
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

    String [] allKey = new String[]{byr,iyr,eyr,hgt,hcl,ecl,pid};

    private Set<String> allKeySet = Stream.of(byr, iyr, eyr,hgt, hcl,ecl,pid )
            .collect(Collectors.toSet());

    public int Birth_Year;
    public int  Issue_Year ;
    public int Expiration_Year;
    public String Height = null;
    public String Hair_Color = null;
    public String Eye_Color = null;
    public String Passport_ID = null;
    public String Country_ID = null;

    public void addData(String passportDataString){
        String [] passportData = passportDataString.split(" ");

        for(String data : passportData){
            if(data.equals(""))
                continue;
//            System.out.println(String.format("\"%s\"",data));
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
//                System.out.println(byr);
                try{
                    Birth_Year = Integer.parseInt(value);
                    return (Birth_Year >= 1920 && Birth_Year <= 2002 );
                }catch(Exception ex){
                    System.out.println("Birth_Year convert error");
                    return false;
                }
            case iyr:
//                System.out.println(iyr);
                try{
                    Issue_Year = Integer.parseInt(value);
                    return (Issue_Year >= 2010 && Issue_Year <= 2020 );
                }catch(Exception ex){
                    System.out.println("Issue_Year convert error");
                    return false;
                }
            case eyr:
//                System.out.println(eyr);
                try{
                    Expiration_Year = Integer.parseInt(value);
                    return (Expiration_Year >= 2020 && Expiration_Year <= 2030 );
                }catch(Exception ex){
                    System.out.println("Expiration_Year convert error");
                    return false;
                }
            case hgt:
//                System.out.println(hgt);
                try{
                    Height = value;
                    if(Height.contains("cm")){
                        int HeightValue = Integer.parseInt(value.replace("cm", ""));
                        return (HeightValue >= 150 && HeightValue <= 193 );
                    }else if(Height.contains("in")){
                        int HeightValue = Integer.parseInt(value.replace("in", ""));
                        return (HeightValue >= 59 && HeightValue <= 76 );
                    }else{
                        //System.out.println("Height is not in or cm " + Height);
                        return false;
                    }
                }catch(Exception ex){
                    System.out.println("Height convert error "+Height);
                    return false;
                }
            case hcl:
//                System.out.println(hcl);
                Eye_Color = value;
                String pattern = "#[0-9a-f]{1,6}";
                return Eye_Color.matches(pattern);
            case ecl:
//                System.out.println(ecl);
                Eye_Color = value;
                List<String> valieEyeColor = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
                return valieEyeColor.contains(Eye_Color);
            case pid:
//                System.out.println(pid);
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

