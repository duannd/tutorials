package com.duannd.fundamental;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Scoreboard {

    private int numEntries = 0;
    private GameEntry[] board;

    public Scoreboard(int cap) {
        this.board = new GameEntry[cap];
    }

    public void add(GameEntry entry) {
        int newScore = entry.getScore();
        if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
            if (numEntries < board.length)
                numEntries++;
            // shift any lower scores rightward to make room for the new entry
            int j = numEntries - 1; // last index
            while (j > 0 && newScore > board[j - 1].getScore()) {
                board[j] = board[j - 1];    // shift entry from j-1 to j
                j--;                        // and decrement j
            }
            board[j] = entry;               // when done, add new entry
        }
    }

    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= numEntries)
            throw new IndexOutOfBoundsException("Invalid index " + i);
        GameEntry temp = board[i];
        for (int j = i; j < numEntries - 1; j++) {
            board[j] = board[j + 1];
        }
        board[numEntries - 1] = null;
        numEntries--;
        return temp;
    }

}
