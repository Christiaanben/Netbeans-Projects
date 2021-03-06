import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runners.JUnit4;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class ParseMoleculeTest {
    
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList( new Object[][] { {Arrays.asList("H", "O"),
                                                Arrays.asList( 2,   1 ),
                                                "{((H)2)[O]}",
                                                "waterSpecial"},
                                                
                                                {Arrays.asList("H", "O"),
                                                Arrays.asList( 2,   1 ),
                                                "H2O",
                                                "water"},
                                                
                                               {Arrays.asList("Mg", "H", "O"),
                                                Arrays.asList(  1,   2,   2 ),
                                                "Mg(OH)2",
                                                "magnesium hydroxide"},
                                                
                                               {Arrays.asList("K", "O", "N", "S"),
                                                Arrays.asList( 4,   14,  2,   4 ),
                                                "K4[ON(SO3)2]2",
                                                "Fremy's salt"},
                                               
                                               {Arrays.asList("C", "H", "O"),
                                                Arrays.asList( 6,   12,  6),
                                                "C6H12O6",
                                                "glucose"},
                                               
                                               {Arrays.asList("C","H","Fe","O"),
                                                Arrays.asList( 8, 8, 1, 2 ),
                                                "(C5H5)Fe(CO)2CH3",
                                                "(Cyclopentadienyl)dicarbonylmethyliron"},
                                               
                                               {Arrays.asList("As", "Be", "C", "B","Co","O","Cu"),
                                                Arrays.asList( 2,   16,  44, 8, 24, 48, 5),
                                                "As2{Be4C5[BCo3(CO2)3]2}4Cu5",
                                                "Unknown Molecule"},
                                               
                                               
                              });
    }
    
    private Map<String,Integer> expected;
    private String formula, name;
    
    public ParseMoleculeTest(List<String> atoms, List<Integer> nums, String formula, String name) {
        Map<String,Integer> exp = new HashMap<String,Integer>();
        for (int i = 0 ; i < atoms.size() ; i++) exp.put(atoms.get(i), nums.get(i));
        
        this.expected = exp;
        this.formula = formula;
        this.name = name;
    }

    @Test
    public void testMolecule() {
        System.out.println(expected);
        assertEquals(String.format("Should parse %s: %s", name, formula), expected, ParseMolecule.getAtoms(formula));
    }
    
//    @Test
//    public void testIllegalArguments(){
//        assertEquals(new IllegalArgumentException(), ParseMolecule.getAtoms("MgOH)2"));
//    }
}
