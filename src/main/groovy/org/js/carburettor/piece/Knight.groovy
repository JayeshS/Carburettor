package org.js.carburettor.piece

import org.js.carburettor.board.Square

class Knight extends Piece {

    @Override
    List<Square> getPossibleMoves() {
        def possibleMoves = []
        Closure twoFilesBack = {file -> file.previous().previous()}
        getMoves(twoFilesBack, boardTraversal.nextRank(), possibleMoves, true)
        getMoves(twoFilesBack, boardTraversal.previousRank(), possibleMoves, true)
        Closure twoFilesFwd = {file -> file.next().next()}
        getMoves(twoFilesFwd, boardTraversal.nextRank(), possibleMoves, true)
        getMoves(twoFilesFwd, boardTraversal.previousRank(), possibleMoves, true)

        Closure twoRanksFwd = {rank -> rank.next().next()}
        Closure twoRanksBack = {rank -> rank.previous().previous()}
        getMoves(boardTraversal.nextFile(), twoRanksFwd, possibleMoves, true)
        getMoves(boardTraversal.nextFile(), twoRanksBack, possibleMoves, true)
        getMoves(boardTraversal.previousFile(), twoRanksFwd, possibleMoves, true)
        getMoves(boardTraversal.previousFile(), twoRanksBack, possibleMoves, true)
        return possibleMoves
    }
}
