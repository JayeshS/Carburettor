package org.js.carburettor.piece

import org.js.carburettor.IllegalMoveException
import org.js.carburettor.board.Board
import org.junit.Before
import org.junit.Test
import static org.js.carburettor.piece.Colour.BLACK
import static org.js.carburettor.piece.Colour.WHITE

class PawnTest {

    private Board board
    private Pawn whitePawn;

    @Before
    void resetBoard() {
        board = Board.createEmptyBoard()
        Board.reset()
    }

    @Test
    void canCreateNewPawn() {
        whitePawn = new Pawn(colour: WHITE, position: board['a2']);

        assert whitePawn.position == board['a2']
        assert whitePawn.colour == WHITE
        assert whitePawn.position.piece == whitePawn
    }

    @Test
    void canMovePawnFromA2ToA3() {
        whitePawn = new Pawn(colour: WHITE, position: board['a2']);
        whitePawn.move(board['A3'])
        assert whitePawn.position == board['A3']
    }

    @Test
    void canMovePawnFromA2ToA4() {
        whitePawn = new Pawn(colour: WHITE, position: board['a2']);
        whitePawn.move(board['A4'])
        assert whitePawn.position == board['A4']
    }

    @Test
    void canTakeDiagonallyOnTheNextFile() {
        whitePawn = new Pawn(colour: WHITE, position: board['a2']);
        Pawn blackPawn = new Pawn(colour: BLACK, position: board['B3']);

        whitePawn.move(board['B3'])
        assert whitePawn.position == board['B3']
    }

    @Test
    void canTakeDiagonallyOnThePreviousFile() {
        whitePawn = new Pawn(colour: WHITE, position: board['B2']);
        Pawn blackPawn = new Pawn(colour: BLACK, position: board['A3']);

        whitePawn.move(board['A3'])
        assert whitePawn.position == board['A3']
    }

    @Test(expected = IllegalMoveException.class)
    void canNotCaptureOnAnEmptySquare() {
        whitePawn = new Pawn(colour: WHITE, position: board['B2']);

        whitePawn.move(board['A3'])
    }

    @Test(expected = IllegalMoveException.class)
    void canNotJumpOverAPiece() {
        whitePawn = new Pawn(colour: WHITE, position: board['B2']);
        def anotherPawn = new Pawn(colour: WHITE, position: board['B3']);

        whitePawn.move(board['B4'])
    }

    @Test(expected = IllegalMoveException.class)
    void canNotMovePawnFromA3ToA5() {
        whitePawn = new Pawn(colour: WHITE, position: board['A3']);
        whitePawn.move(board['A5'])
    }

    @Test(expected = IllegalMoveException.class)
    void canNotMovePawnBackwards() {
        whitePawn = new Pawn(colour: WHITE, position: board['A3']);
        whitePawn.move(board['a2'])
    }

    @Test(expected = IllegalMoveException.class)
    void canNotTakeOnTheSameFile() {
        whitePawn = new Pawn(colour: WHITE, position: board['a2']);
        Pawn blackPawn = new Pawn(colour: BLACK, position: board['A3']);
        whitePawn.move(board['A3'])
    }
}
