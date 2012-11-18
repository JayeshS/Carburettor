package org.js.carburettor.board.rule

import org.junit.Before
import org.junit.Test
import org.js.carburettor.board.Board;

public class PieceActivityRuleTest {

    private PieceActivityRule rule

    @Before
    void setup() {
        rule = new PieceActivityRule()
    }

    @Test
    void pawnsOnTheEdgeAreBad() {
        Board board = Board.setup("7k/7p/8/8/8/8/4P3/7K w - - 0 1")
        assert rule.analyse(board) == 1
    }

    @Test
    void doubledPawnsAreBad() {
        Board board = Board.setup("7k/5p2/5p2/8/8/4PP2/8/7K w - - 0 1")
        assert rule.analyse(board) == 1
    }

    @Test
    void knightOnTheRimIsDim() {
        Board board = Board.setup("7k/n7/8/8/8/4N3/8/7K w - - 0 1")
        assert rule.analyse(board) == 5
    }
}
