package com.group11.othello.Logic;

import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

public class Board {

    private static int[][] board = new int[9][9];



    public Board()
    {

    }

    public void setChip(int i, int j, int player)
    {
        board [j][i] = player;
    }

    public int getChip(int i,int j)
    {
        int chip;
        chip = board[i][j];
        return chip;
    }

    public int getChipVector(Vector2 vector) {
        int x = (int) vector.x;
        int y = (int) vector.y;
        int chip = board[x][y];
        return chip;
    }

    public static int[][] getBoard()
    {
        return board;
    }








}