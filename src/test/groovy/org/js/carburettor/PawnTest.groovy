package org.js.carburettor

import org.junit.Test
import org.junit.Before
import org.js.carburettor.piece.Pawn
import static org.js.carburettor.Colour.*
import org.js.carburettor.piece.IllegalMoveException

class PawnTest {

    private Pawn whitePawn;

    @Before
    void resetBoard() {
        Squares.reset()
    }

    @Test
    void canCreateNewPawn() {
        whitePawn = new Pawn(WHITE, Squares.A2);

        assert whitePawn.position == Squares.A2
        assert whitePawn.colour == WHITE
    }

    @Test
    void canMovePawnFromA2ToA3() {
        whitePawn = new Pawn(WHITE, Squares.A2);
        whitePawn.move(Squares.A3)
        assert whitePawn.position == Squares.A3
    }

    @Test
    void canMovePawnFromA2ToA4() {
        whitePawn = new Pawn(WHITE, Squares.A2);
        whitePawn.move(Squares.A4)
        assert whitePawn.position == Squares.A4
    }

    @Test
    void canTakeDiagonallyOnTheNextFile() {
        whitePawn = new Pawn(WHITE, Squares.A2);
        Pawn blackPawn = new Pawn(BLACK, Squares.B3);

        whitePawn.move(Squares.B3)
        assert whitePawn.position == Squares.B3
    }

    @Test
    void canTakeDiagonallyOnThePreviousFile() {
        whitePawn = new Pawn(WHITE, Squares.B2);
        Pawn blackPawn = new Pawn(BLACK, Squares.A3);

        whitePawn.move(Squares.A3)
        assert whitePawn.position == Squares.A3
    }

    @Test(expected = IllegalMoveException.class)
    void canNotCaptureOnAnEmptySquare() {
        whitePawn = new Pawn(WHITE, Squares.B2);

        whitePawn.move(Squares.A3)
    }

    @Test(expected = IllegalMoveException.class)
    void canNotMovePawnFromA3ToA5() {
        whitePawn = new Pawn(WHITE, Squares.A3);
        whitePawn.move(Squares.A5)
    }

    @Test(expected = IllegalMoveException.class)
    void canNotMovePawnBackwards() {
        whitePawn = new Pawn(WHITE, Squares.A3);
        whitePawn.move(Squares.A2)
    }

    @Test(expected = IllegalMoveException.class)
    void canNotTakeOnTheSameFile() {
        whitePawn = new Pawn(WHITE, Squares.A2);
        Pawn blackPawn = new Pawn(BLACK, Squares.A3);
        whitePawn.move(Squares.A3)
    }
}
