import java.util.Map;
import java.util.HashMap;

class ParseMolecule {
    
    public static Map<String,Integer> getAtoms(String formula) {
        //Get rid of brackets
        int bracketLocation=Math.max(Math.max(formula.indexOf('('), formula.indexOf('{')),formula.indexOf('['));
        while (bracketLocation!=-1) {            
            int start=bracketLocation;
            int end=formula.lastIndexOf(opposite(formula.charAt(start)));
            int repeat = Integer.parseInt(formula.charAt(end+1)+"");
            String part=formula.substring(start+1, end);
            formula=formula.substring(0,start)+formula.substring(end+2);
            for (int i = 0; i < repeat; i++) {
                formula=formula.substring(0, start)+part+formula.substring(start);
            }
            bracketLocation=Math.max(Math.max(formula.indexOf('('), formula.indexOf('{')),formula.indexOf('['));
        }
        
        //Get rid of numbers
        if (formula.matches(".*\\d+.*")) {            
            int numLocation = formula.indexOf(".*\\d+.*");
            System.out.println(numLocation);
        }
        
        return new HashMap<String,Integer>();
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