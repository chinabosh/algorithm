package com.bosh.lib;

/**
 * @author lzq
 * @date 2021/9/3
 */
public class Solution30 {
    public boolean isRobotBounded(String instructions) {
        final int NORTH = 0;
        final int EAST = 1;
        final int SOUTH = 2;
        final int WEST = 3;
        int direction = NORTH;

        int x = 0;
        int y = 0;
        do {
            for (int i = 0; i < instructions.length(); i++) {
                char tmp = instructions.charAt(i);
                if ('G' == tmp) {
                    switch (direction) {
                        case NORTH:
                            y++;
                            break;
                        case EAST:
                            x++;
                            break;
                        case SOUTH:
                            y--;
                            break;
                        case WEST:
                            x--;
                            break;
                        default:
                    }
                }
                if ('L' == tmp) {
                    direction = (direction + 3) % 4;
                }
                if ('R' == tmp) {
                    direction = (direction + 5) % 4;
                }
            }
        } while (direction != 0);
        return (x == 0 && y == 0);
    }
}
