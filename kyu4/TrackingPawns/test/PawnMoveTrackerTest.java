import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class PawnMoveTrackerTest {

    @Test
    public void exampleTest1() {
        String[][] expected = { {".",".",".",".",".",".",".","."},
                                {".","p","p",".","p","p","p","p"},
                                {"p",".",".","p",".",".",".","."},
                                {".",".",".",".",".",".",".","."},
                                {".",".",".",".","P",".",".","."},
                                {".",".",".",".",".",".",".","."},
                                {"P","P","P","P",".","P","P","P"},
                                {".",".",".",".",".",".",".","."} };
        assertEquals(expected, PawnMoveTracker.movePawns(new String[] {"e3", "d6", "e4", "a6"}));
    }
    
    @Test
    public void exampleTest2() {
        String[][] expected = { {".",".",".",".",".",".",".","."},
                                {"p","p","p",".","p","p","p","p"},
                                {".",".",".",".",".",".",".","."},
                                {".",".",".",".",".",".",".","."},
                                {".",".",".",".","p",".",".","."},
                                {".",".",".","P",".",".",".","."},
                                {"P","P","P",".",".","P","P","P"},
                                {".",".",".",".",".",".",".","."} };
        assertEquals(expected, PawnMoveTracker.movePawns(new String[] {"e4", "d5", "d3", "dxe4"}));
    }
    
    @Test
    public void moreTest() {
        String[][] expected = { {"e5 is invalid"} };
        assertEquals(expected, PawnMoveTracker.movePawns(new String[] {"e5"}));
    }
    
    @Test
    public void invalid() {
        String[][] expected = { {"b4 is invalid"} };
        assertEquals(expected, PawnMoveTracker.movePawns(new String[] {"a4", "a5",  "b4",  "b5",  "c4",  "b4"}));
    }
    
}