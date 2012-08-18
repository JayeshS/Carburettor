package org.js.carburettor.board

class BoardTraversal {

    def nextFile() {
        {file-> file.next()}
    }

    def previousFile() {
        {file-> file.previous()}
    }

    def nextRank() {
        {rank-> rank + 1}
    }

    def previousRank() {
        {rank-> rank - 1}
    }

    def sameRank() {
        {rank-> rank}
    }

    def sameFile() {
        sameRank()
    }
}
