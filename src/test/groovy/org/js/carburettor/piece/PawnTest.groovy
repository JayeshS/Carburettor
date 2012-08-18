package org.js.carburettor.piece

import org.junit.Test
import org.junit.Before

import static org.js.carburettor.piece.Colour.*
import org.js.carburettor.board.Board
import org.js.carburettor.IllegalMoveException

class PawnTest {

    private Pawn whitePawn;

    @Before
    void resetBoard() {
        Board.reset()
    }

    @Test
    void canCreateNewPawn() {
        whitePawn = new Pawn(colour: WHITE, position: Board.A2);

        assert whitePawn.position == Board.A2
        assert whitePawn.colour == WHITE
        assert whitePawn.position.piece == whitePawn
    }

    @Test
    void canMovePawnFromA2ToA3() {
        whitePawn = new Pawn(colour: WHITE, position: Board.A2);
        whitePawn.move(Board.A3)
        assert whitePawn.position == Board.A3
    }

    @Test
    void canMovePawnFromA2ToA4() {
        whitePawn = new Pawn(colour: WHITE, position: Board.A2);
        whitePawn.move(Board.A4)
        assert whitePawn.position == Board.A4
    }

    @Test
    void canTakeDiagonallyOnTheNextFile() {
        whitePawn = new Pawn(colour: WHITE, position: Board.A2);
        Pawn blackPawn = new Pawn(colour: BLACK, position: Board.B3);

        whitePawn.move(Board.B3)
        assert whitePawn.position == Board.B3
    }

    @Test
    void canTakeDiagonallyOnThePreviousFile() {
        whitePawn = new Pawn(colour: WHITE, position: Board.B2);
        Pawn blackPawn = new Pawn(colour: BLACK, position: Board.A3);

        whitePawn.move(Board.A3)
        assert whitePawn.position == Board.A3
    }

    @Test(expected = IllegalMoveException.class)
    void canNotCaptureOnAnEmptySquare() {
        whitePawn = new Pawn(colour: WHITE, position: Board.B2);

        whitePawn.move(Board.A3)
    }

    @Test(expected = IllegalMoveException.class)
    void canNotJumpOverAPiece() {
        whitePawn = new Pawn(colour: WHITE, position: Board.B2);
        def anotherPawn = new Pawn(colour: WHITE, position: Board.B3);

        whitePawn.move(Board.B4)
    }

    @Test(expected = IllegalMoveException.class)
    void canNotMovePawnFromA3ToA5() {
        whitePawn = new Pawn(colour: WHITE, position: Board.A3);
        whitePawn.move(Board.A5)
    }

    @Test(expected = IllegalMoveException.class)
    void canNotMovePawnBackwards() {
        whitePawn = new Pawn(colour: WHITE, position: Board.A3);
        whitePawn.move(Board.A2)
    }

    @Test(expected = IllegalMoveException.class)
    void canNotTakeOnTheSameFile() {
        whitePawn = new Pawn(colour: WHITE, position: Board.A2);
        Pawn blackPawn = new Pawn(colour: BLACK, position: Board.A3);
        whitePawn.move(Board.A3)
    }
}
