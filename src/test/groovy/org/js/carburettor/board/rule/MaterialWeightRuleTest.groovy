package org.js.carburettor.board.rule

import org.junit.Before
import org.junit.Test
import org.js.carburettor.board.Board

class MaterialWeightRuleTest {

    private MaterialWeightRule rule

    @Before
    public void setUp() {
        rule = new MaterialWeightRule()
    }

    @Test
    public void materialIsEqualAtTheStart() throws Exception {
        Board board = Board.setupNewGame()
        assert rule.analyse(board) == 0
    }

    @Test
    public void positiveValueIsUsedToIndicateWhiteHasMoreMaterial() throws Exception {
        Board board = Board.setup("7k/8/8/8/8/8/7P/7K w - - 0 1")
        assert rule.analyse(board) == 100
    }

    @Test
    public void negativeValueIsUsedToIndicateWhiteHasMoreMaterial() throws Exception {
        Board board = Board.setup("7k/7p/8/8/8/8/8/7K w - - 0 1")
        assert rule.analyse(board) == -100
    }
}
