package com.group11.othello.Logic;

public class GameLogic {

    final int WHITE = 1;
    final int BLACK = 2;
    final int EMPTY = 0;
    private Board board;
    public int turnCnt = 0;

    public GameLogic() {

        board = new Board();
        board.setChip(3,3, WHITE);
        board.setChip(3,4, BLACK);
        board.setChip(4,3, BLACK);
        board.setChip(4,4, WHITE);
    }

    public void changeTurn(){

        if (turnCnt == 0) {
            turnCnt = 1;
        }else if (turnCnt == 1){
            turnCnt = 0;
        }
    }

    public int getTurnStatus(){

        return turnCnt;
    }


    //checks if the black player does have a legal move
    public boolean canMoveBlack(){

        for (int x=0; x<8; x++){
            for (int y = 0; y<8; y++){

                if (checkLegalBlack(x, y, 1, 0)){
                    return true;
                }

                if (checkLegalBlack(x, y, 1, -1)){
                    return true;
                }

                if (checkLegalBlack(x, y, 0, -1)){
                    return true;
                }

                if (checkLegalBlack(x, y, -1, -1)){
                    return true;
                }

                if (checkLegalBlack(x, y, -1, 0)){
                    return true;
                }

                if (checkLegalBlack(x, y, -1, 1)){
                    return true;
                }

                if (checkLegalBlack(x, y, 0, 1)){
                    return true;
                }

                if (checkLegalBlack(x, y, 1, 1)){
                    return true;
                }

            }

        }
        return false;
       // Game Over ; end Game in GameState

    }

    //checks if the white player does have a legal move
    public boolean canMoveWhite(){

        for (int x=0; x<8; x++){
            for (int y = 0; y<8; y++){

                if (checkLegalWhite(x, y, 1, 0)){
                    return true;
                }

                if (checkLegalWhite(x, y, 1, -1)){
                    return true;
                }

                if (checkLegalWhite(x, y, 0, -1)){
                    return true;
                }

                if (checkLegalWhite(x, y, -1, -1)){
                    return true;
                }

                if (checkLegalWhite(x, y, -1, 0)){
                    return true;
                }

                if (checkLegalWhite(x, y, -1, 1)){
                    return true;
                }

                if (checkLegalWhite(x, y, 0, 1)){
                    return true;
                }

                if (checkLegalWhite(x, y, 1, 1)){
                    return true;
                }


            }

        }
        return false;
       // Game Over ; end Game in GameState

    }



    //places black chip in board
    public boolean placeChipBlack(int x, int y) {

        //keeps track if there is any legal move
        boolean wasLegal = false;

        if (checkLegalBlack(x, y, 1, 0)) {

            turnChipBlack(x, y, 1, 0);
            wasLegal = true;
        }

        if (checkLegalBlack(x, y, 1, 1)) {

            turnChipBlack(x, y, 1, 1);
            wasLegal = true;
        }

        if (checkLegalBlack(x, y, 1, -1)) {

            turnChipBlack(x, y, 1, -1);
            wasLegal = true;
        }

        if (checkLegalBlack(x, y, 0, -1)) {

            turnChipBlack(x, y, 0, -1);
            wasLegal = true;
        }

        if (checkLegalBlack(x, y, -1, -1)) {

            turnChipBlack(x, y, -1, -1);
            wasLegal = true;
        }

        if (checkLegalBlack(x, y, -1, 0)) {

            turnChipBlack(x, y, -1, 0);
            wasLegal = true;
        }

        if (checkLegalBlack(x, y, -1, 1)) {

            turnChipBlack(x, y, -1, 1);
            wasLegal = true;
        }

        if (checkLegalBlack(x, y, 0, 1)) {

            turnChipBlack(x, y, 0, 1);
            wasLegal = true;
        }

        if (wasLegal){
            board.setChip(x,y, BLACK);
            return true;
        }

        return false;

    }

    public boolean placeChipWhite(int x, int y) {

        boolean wasLegal = false;
        if (checkLegalWhite(x, y, 1, 0)) {

            turnChipWhite(x, y, 1, 0);
            wasLegal = true;
        }

        if (checkLegalWhite(x, y, 1, 1)) {

            turnChipWhite(x, y, 1, 1);
            wasLegal = true;
        }

        if (checkLegalWhite(x, y, 1, -1)) {

            turnChipWhite(x, y, 1, -1);
            wasLegal = true;
        }

        if (checkLegalWhite(x, y, 0, -1)) {

            turnChipWhite(x, y, 0, -1);
            wasLegal = true;
        }

        if (checkLegalWhite(x, y, -1, -1)) {

            turnChipWhite(x, y, -1, -1);
            wasLegal = true;
        }

        if (checkLegalWhite(x, y, -1, 0)) {

            turnChipWhite(x, y, -1, 0);
            wasLegal = true;
        }

        if (checkLegalWhite(x, y, -1, 1)) {

            turnChipWhite(x, y, -1, 1);
            wasLegal = true;
        }

        if (checkLegalWhite(x, y, 0, 1)) {

            turnChipWhite(x, y, 0, 1);
            wasLegal = true;
        }

        if (wasLegal){
            board.setChip(x,y, WHITE);
            return true;
        }

        return false;

    }


    public boolean checkLegalBlack (int x, int y, int dx, int dy){

        int nSteps = 1;
        x += dx;
        y += dy;

        while ( 0<=x && x<8 && 0<=y && y<8) {

            if ( board.getChip(x,y)== BLACK) {
                if (nSteps > 1) return true;
            else
                return false;
            }

            if (board.getChip(x,y) == EMPTY) return false;

            x = x + dx;
            y = y + dy;
            nSteps =  nSteps + 1;
        }

        return false;

    }

    public boolean checkLegalWhite (int x, int y, int dx, int dy){

        int nSteps = 1;
        x += dx;
        y += dy;

        while ( 0<=x && x<8 && 0<=y && y<8) {

            if ( board.getChip(x,y) == WHITE)
                if (nSteps > 1) return true;
            else
                return false;


            if (board.getChip(x,y) == EMPTY) return false;

            x = x + dx;
            y = y + dy;
            nSteps =  nSteps + 1;
        }


        return false;

    }

    public void turnChipBlack(int x, int y, int dx, int dy){

        x += dx;
        y += dx;

        while ( board.getChip(x,y) == WHITE ){

        board.setChip(x, y, BLACK);
        x += dx;
        y += dx;

        }

    }

    public void turnChipWhite(int x, int y, int dx, int dy){

        x += dx;
        y += dx;

        while ( board.getChip(x,y) == BLACK ){

        board.setChip(x,y, WHITE);
        x += dx;
        y += dx;

        }


    }




}
