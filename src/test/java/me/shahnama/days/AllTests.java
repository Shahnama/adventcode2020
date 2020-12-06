package me.shahnama.days;

import me.shahnama.tools.AnswerNotFindException;

import static org.junit.jupiter.api.Assertions.*;

class AllTests {

    @org.junit.jupiter.api.Test
    void solve_Day1_P1() throws AnswerNotFindException {
        int expectedAnswer = 514579;
        assertEquals(expectedAnswer, new Day1("test1.txt").solve_P1());

        expectedAnswer = 719796;
        assertEquals(expectedAnswer, new Day1("day1.txt").solve_P1());
    }

    @org.junit.jupiter.api.Test
    void solve_Day1_P2() throws AnswerNotFindException {
        int expectedAnswer = 241861950;
        assertEquals(expectedAnswer, new Day1("test1.txt").solve_P2());

        expectedAnswer = 144554112;
        assertEquals(expectedAnswer, new Day1("day1.txt").solve_P2());
    }

    @org.junit.jupiter.api.Test
    void solve_Day2_P1() {
        int expectedAnswer = 2;
        assertEquals(expectedAnswer, new Day2("test2.txt").solve_P1());

        expectedAnswer = 474;
        assertEquals(expectedAnswer, new Day2("day2.txt").solve_P1());
    }

    @org.junit.jupiter.api.Test
    void solve_Day2_P2() {
        int expectedAnswer = 1;
        assertEquals(expectedAnswer, new Day2("test2.txt").solve_P2());

        expectedAnswer = 745;
        assertEquals(expectedAnswer, new Day2("day2.txt").solve_P2());
    }

    @org.junit.jupiter.api.Test
    void solve_Day3_P1() {
        int expectedAnswer = 7;
        assertEquals(expectedAnswer, new Day3("test3.txt").solve_P1());

        expectedAnswer = 195;
        assertEquals(expectedAnswer, new Day3("day3.txt").solve_P1());
    }

    @org.junit.jupiter.api.Test
    void solve_Day3_P2() {
        long expectedAnswer = 336;
        assertEquals(expectedAnswer, new Day3("test3.txt").solve_P2());

        expectedAnswer = 3772314000L;
        assertEquals(expectedAnswer, new Day3("day3.txt").solve_P2());
    }

    @org.junit.jupiter.api.Test
    void solve_Day4_P1() {
        int expectedAnswer = 2;
        assertEquals(expectedAnswer, new Day4("test4.txt").solve_P1());

        expectedAnswer = 216;
        assertEquals(expectedAnswer, new Day4("day4.txt").solve_P1());
    }

    @org.junit.jupiter.api.Test
    void solve_Day4_P2() {
        long expectedAnswer = 4;
        assertEquals(expectedAnswer, new Day4("test4_p2.txt").solve_P2());

        expectedAnswer = 150;
        assertEquals(expectedAnswer, new Day4("day4.txt").solve_P2());
    }

    @org.junit.jupiter.api.Test
    void solve_Day5_P1() {
        int expectedAnswer = 820;
        assertEquals(expectedAnswer, new Day5("test5.txt").solve_P1());

        expectedAnswer = 951;
        assertEquals(expectedAnswer, new Day5("day5.txt").solve_P1());
    }

    @org.junit.jupiter.api.Test
    void solve_Day5_P2() throws AnswerNotFindException {

        //Day 5 Part 2 does not have a test

        int expectedAnswer = 653;
        assertEquals(expectedAnswer, new Day5("day5.txt").solve_P2());
    }

    @org.junit.jupiter.api.Test
    void solve_Day6_P1() {
        int expectedAnswer = 11;
        assertEquals(expectedAnswer, new Day6("test6.txt").solve_P1());

        expectedAnswer = 6534;
        assertEquals(expectedAnswer, new Day6("day6.txt").solve_P1());
    }

    @org.junit.jupiter.api.Test
    void solve_Day6_P2() {

        int expectedAnswer = 6;
        assertEquals(expectedAnswer, new Day6("test6.txt").solve_P2());

        expectedAnswer = 3402;
        assertEquals(expectedAnswer, new Day6("day6.txt").solve_P2());
    }
}