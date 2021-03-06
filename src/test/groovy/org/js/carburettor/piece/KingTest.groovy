package org.js.carburettor.piece

import org.js.carburettor.board.Board
import org.junit.Before
import org.junit.Test
import static org.js.carburettor.piece.Colour.BLACK
import static org.js.carburettor.piece.Colour.WHITE

public class KingTest {

    private Board board
    private King king

    @Before
    void resetBoard() {
        board = Board.createEmptyBoard()
    }

    @Test
    void canCreateKing() {
        King whiteKing = new King(colour: WHITE)
        board.addAt 'e1', whiteKing
        assert whiteKing.position == board['E1']
        assert whiteKing.position.piece == whiteKing
    }

    @Test
    void canMoveOneSquareInAnyDirection() {
        King whiteKing = new King(colour: WHITE)
        board.addAt 'e2', whiteKing
        assert whiteKing.possibleMoves.containsAll([board['D2'], board['D1'], board['E1'], board['F1'], board['F2'], board['F3'], board['E3'], board['D3']])
        assert whiteKing.possibleMoves.size() == 8
    }

    @Test
    void canNotMoveIntoCheck() {
        King whiteKing = new King(colour: WHITE)
        board.addAt 'e2', whiteKing
        Bishop blackBishop = new Bishop(colour: BLACK)
        board.addAt 'd4', blackBishop

        assert !whiteKing.possibleMoves.contains(board['e3'])
    }

    @Test
    void canNotMoveIntoCheckByOpponentsKing() {
        King whiteKing = new King(colour: WHITE)
        board.addAt 'e2', whiteKing
        King blackKing = new King(colour: BLACK)
        board.addAt 'e4', blackKing

        assert !whiteKing.possibleMoves.contains(board['e3'])
    }

    @Test
    void canNotMoveIntoCheckByOpponentsPawn() {
        King whiteKing = new King(colour: WHITE)
        board.addAt 'e2', whiteKing
        Pawn blackPawn = new Pawn(colour: BLACK)
        board.addAt 'f4', blackPawn

        assert !whiteKing.possibleMoves.contains(board['e3'])
    }
}
