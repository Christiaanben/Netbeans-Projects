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
}