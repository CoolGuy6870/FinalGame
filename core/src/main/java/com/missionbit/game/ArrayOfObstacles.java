package com.missionbit.game;


import java.util.ArrayList;
import java.util.Scanner;

public class ArrayOfObstacles {
    public static void main(String[] argv) {
        ArrayList<String> items = new ArrayList<String>();

        for (int i = 0; i < 4; i++) {
            Scanner scanner = new Scanner(System.in);
            String item = scanner.next();
            items.add(item);
        }

    }
}
