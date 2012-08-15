package org.js.carburettor.piece

import org.junit.Test
import org.junit.Before
import org.js.carburettor.piece.Pawn
import static org.js.carburettor.piece.Colour.*
import org.js.carburettor.board.Squares
import org.js.carburettor.IllegalMoveException

class PawnTest {

    private Pawn whitePawn;

    @Before
    void resetBoard() {
        Squares.reset()
    }

    @Test
    void canCreateNewPawn() {
        whitePawn = new Pawn(colour: WHITE, position: Squares.A2);

        assert whitePawn.position == Squares.A2
        assert whitePawn.colour == WHITE
        assert whitePawn.position.piece == whitePawn
    }

    @Test
    void canMovePawnFromA2ToA3() {
        whitePawn = new Pawn(colour: WHITE, position: Squares.A2);
        whitePawn.move(Squares.A3)
        assert whitePawn.position == Squares.A3
    }

    @Test
    void canMovePawnFromA2ToA4() {
        whitePawn = new Pawn(colour: WHITE, position: Squares.A2);
        whitePawn.move(Squares.A4)
        assert whitePawn.position == Squares.A4
    }

    @Test
    void canTakeDiagonallyOnTheNextFile() {
        whitePawn = new Pawn(colour: WHITE, position: Squares.A2);
        Pawn blackPawn = new Pawn(colour: BLACK, position: Squares.B3);

        whitePawn.move(Squares.B3)
        assert whitePawn.position == Squares.B3
    }

    @Test
    void canTakeDiagonallyOnThePreviousFile() {
        whitePawn = new Pawn(colour: WHITE, position: Squares.B2);
        Pawn blackPawn = new Pawn(colour: BLACK, position: Squares.A3);

        whitePawn.move(Squares.A3)
        assert whitePawn.position == Squares.A3
    }

    @Test(expected = IllegalMoveException.class)
    void canNotCaptureOnAnEmptySquare() {
        whitePawn = new Pawn(colour: WHITE, position: Squares.B2);

        whitePawn.move(Squares.A3)
    }

    @Test(expected = IllegalMoveException.class)
    void canNotJumpOverAPiece() {
        whitePawn = new Pawn(colour: WHITE, position: Squares.B2);
        def anotherPawn = new Pawn(colour: WHITE, position: Squares.B3);

        whitePawn.move(Squares.B4)
    }

    @Test(expected = IllegalMoveException.class)
    void canNotMovePawnFromA3ToA5() {
        whitePawn = new Pawn(colour: WHITE, position: Squares.A3);
        whitePawn.move(Squares.A5)
    }

    @Test(expected = IllegalMoveException.class)
    void canNotMovePawnBackwards() {
        whitePawn = new Pawn(colour: WHITE, position: Squares.A3);
        whitePawn.move(Squares.A2)
    }

    @Test(expected = IllegalMoveException.class)
    void canNotTakeOnTheSameFile() {
        whitePawn = new Pawn(colour: WHITE, position: Squares.A2);
        Pawn blackPawn = new Pawn(colour: BLACK, position: Squares.A3);
        whitePawn.move(Squares.A3)
    }
}
