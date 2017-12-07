import java.awt.Point;
class PawnMoveTracker {
    public static String[][] movePawns(String[] moves) {
        boolean whiteTurn=true;
        String[][] board = {{".", ".", ".", ".", ".", ".", ".", "."},{"p", "p", "p", "p", "p", "p", "p", "p"},{".", ".", ".", ".", ".", ".", ".", "."},{".", ".", ".", ".", ".", ".", ".", "."},
                            {".", ".", ".", ".", ".", ".", ".", "."},{".", ".", ".", ".", ".", ".", ".", "."},{"P", "P", "P", "P", "P", "P", "P", "P"},{".", ".", ".", ".", ".", ".", ".", "."}};
        for (String move : moves) {
            Point loc = new Point(56 - move.charAt(move.length()-1), move.charAt(move.length()-2) - 97);
            Point now = new Point(loc);
            now.x = whiteTurn ? now.x + 1 : now.x - 1;
            if (move.length() != 2)
                now.y = move.charAt(0) - 97;
            if (((board[loc.x][loc.y].equals(".") && move.length() == 2) || move.length()==4 &&((whiteTurn && board[loc.x][loc.y].equals("p")) || (!whiteTurn && board[loc.x][loc.y].equals("P"))))) {
                if ((whiteTurn && board[now.x][now.y].equals("P")) || (!whiteTurn && board[now.x][now.y].equals("p"))) {} 
                else if ((whiteTurn && loc.x == 4) || (!whiteTurn && loc.x == 3))
                    now.x = whiteTurn ? now.x + 1 : now.x - 1;
                else
                    return new String[][]{{move + " is invalid"}};
                board[loc.x][loc.y] = board[now.x][now.y];
                board[now.x][now.y] = ".";
            } else
                return new String[][]{{move + " is invalid"}};
            whiteTurn = !whiteTurn;
        }
        return board;
    }
}