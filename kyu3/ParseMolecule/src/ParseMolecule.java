import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.IllegalArgumentException;

class ParseMolecule {
    
    public static Map<String,Integer> getAtoms(String formula) throws IllegalArgumentException{
        //Get rid of brackets
        int bracketLocation=Math.max(Math.max(formula.indexOf('('), formula.indexOf('{')),formula.indexOf('['));
        while (bracketLocation!=-1) {            
            int start=bracketLocation;
            int end=formula.lastIndexOf(opposite(formula.charAt(start)));
            if (end==-1) {
                
            }
            int repeat = Integer.parseInt(formula.charAt(end+1)+"");
            String part=formula.substring(start+1, end);
            formula=formula.substring(0,start)+formula.substring(end+2);
            for (int i = 0; i < repeat; i++) {
                formula=formula.substring(0, start)+part+formula.substring(start);
            }
            bracketLocation=Math.max(Math.max(formula.indexOf('('), formula.indexOf('{')),formula.indexOf('['));
        }
        
        
        
        //Get rid of numbers
        Scanner numbers=new Scanner(formula).useDelimiter("\\D+");
        while (numbers.hasNextInt()) {
            int repeat=numbers.nextInt();
            int numLocation = formula.indexOf(repeat+"");
            String elem=formula.substring(numLocation-1, numLocation);
            if (Character.isLowerCase(elem.charAt(0))) 
                elem=formula.substring(numLocation-2, numLocation);
            formula=formula.substring(0,numLocation-elem.length())+formula.substring(numLocation+(repeat+"").length());
            for (int i = 0; i < repeat; i++) {
                formula=formula.substring(0, numLocation-1)+elem+formula.substring(numLocation-1);
            }
        }
        
        //Put spaces between elements
        for (int i = 0; i < formula.length(); i++) {
            if (Character.isUpperCase(formula.charAt(i))) {
                formula=formula.substring(0, i)+" "+formula.substring(i);
                i++;
            }
        }
        
        //CountLetters
        Map<String,Integer> map=new HashMap<String,Integer>();
        Scanner elem=new Scanner(formula);
        while (elem.hasNext()) {
            String element=elem.next();
            if (map.containsKey(element)) {
                map.put(element, map.get(element)+1);
            }else{
                map.put(element, 1);
            }
        }
        
        return map;
    }

    private static char opposite(char charAt) {
        switch(charAt){
            case '{':
                return '}';
            case '[':
                return ']';
            default:
                return ')';
        }
    }
}