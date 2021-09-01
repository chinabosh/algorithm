package com.bosh.lib;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author lzq
 * @date 2021/9/1
 */
public class SolutionTest {

    @Test
    public void reverse() {
        Solution solution = new Solution();
        assertEquals(321, solution.reverse(123));
        assertEquals(-321, solution.reverse(-123));
        assertEquals(21, solution.reverse(120));
        assertEquals(0, solution.reverse(0));
        assertEquals(0, solution.reverse((int )Math.pow(2, 31) - 1));
        assertEquals(0, solution.reverse(1534236469));
    }
}