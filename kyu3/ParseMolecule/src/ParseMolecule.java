import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

class ParseMolecule {

    public static Map<String, Integer> getAtoms(String formula) throws IllegalArgumentException {
        //Get rid of brackets
        System.out.println("");
        int bracketLocation = Math.max(Math.max(formula.lastIndexOf('('), formula.lastIndexOf('{')), formula.lastIndexOf('['));
        while (bracketLocation != -1) {
            int start = bracketLocation;
            int end = formula.indexOf(opposite(formula.charAt(start)), bracketLocation);
            if (end == -1)
                throw new IllegalArgumentException();
            int repeat = 1;
            if (end+1 < formula.length())
                try {repeat = Integer.parseInt(formula.charAt(end + 1) + "");} 
                catch (NumberFormatException numberFormatException){}
            String part = formula.substring(start + 1, end);
            if (repeat == 1)
                end--;
            formula = formula.substring(0, start) + formula.substring(end + 2);
            for (int i = 0; i < repeat; i++) {
                formula = formula.substring(0, start) + part + formula.substring(start);
            }
            bracketLocation = Math.max(Math.max(formula.lastIndexOf('('), formula.lastIndexOf('{')), formula.lastIndexOf('['));
        }
        
        
        
        
        asdfknm;k;
        
        a;lsdkfj;
        
        if (formula.contains(")") || formula.contains("]") || formula.contains("}"))
            throw new IllegalArgumentException();

        //Get rid of numbers
        Scanner numbers = new Scanner(formula).useDelimiter("\\D+");
        while (numbers.hasNextInt()) {
            int repeat = numbers.nextInt();
            int numLocation = formula.indexOf(repeat + "");
            String elem = formula.substring(numLocation - 1, numLocation);
            if (Character.isLowerCase(elem.charAt(0)))
                elem = formula.substring(numLocation - 2, numLocation);
            formula = formula.substring(0, numLocation - elem.length()) + formula.substring(numLocation + (repeat + "").length());
            for (int i = 0; i < repeat; i++)
                formula = formula.substring(0, numLocation - elem.length()) + elem + formula.substring(numLocation - elem.length());
        }

        //Check for non-elements
        Scanner check = new Scanner(formula).useDelimiter("[A-Z]");
        while (check.hasNext())
            if (check.next().length() > 1)
                throw new IllegalArgumentException();

        //Put spaces between elements (Before uppercase lettters)
        for (int i = 0; i < formula.length(); i++)
            if (Character.isUpperCase(formula.charAt(i)))
                formula = formula.substring(0, i) + " " + formula.substring(i++);

        //CountLetters
        Map<String, Integer> map = new HashMap<>();
        Scanner elem = new Scanner(formula);
        while (elem.hasNext()) {
            String element = elem.next();
            if (map.containsKey(element))
                map.put(element, map.get(element) + 1);
            else 
                map.put(element, 1);
        }

        return map;
    }

    private static char opposite(char charAt) {
        switch (charAt) {
            case '{':   return '}';
            case '[':   return ']';
            default :   return ')';
        }
    }
}