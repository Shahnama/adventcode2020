package me.shahnama;

import me.shahnama.days.*;
import me.shahnama.tools.AnswerNotFindException;

public class MainApp {
    public static void main(String[] args) throws AnswerNotFindException {

        System.out.printf("Day 1 Part 1, Answer: %s%n",new Day1("day1.txt").solve_P1());
        System.out.printf("Day 1 Part 2, Answer: %s%n",new Day1("day1.txt").solve_P2());

        System.out.printf("Day 2 Part 1, Answer: %s%n",new Day2("day2.txt").solve_P1());
        System.out.printf("Day 2 Part 2, Answer: %s%n",new Day2("day2.txt").solve_P2());

        System.out.printf("Day 3 Part 1, Answer: %s%n",new Day3("day3.txt").solve_P1());
        System.out.printf("Day 3 Part 1, Answer: %s%n",new Day3("day3.txt").solve_P2());

        System.out.printf("Day 4 Part 1, Answer: %s%n",new Day4("day4.txt").solve_P1());
        System.out.printf("Day 4 Part 2, Answer: %s%n",new Day4("day4.txt").solve_P2());

        System.out.printf("Day 5 Part 1, Answer: %s%n",new Day5("day5.txt").solve_P1());
        System.out.printf("Day 5 Part 2, Answer: %s%n",new Day5("day5.txt").solve_P2());

        System.out.printf("Day 6 Part 1 (test), Answer: %s%n",new Day6("test6.txt").solve_P1());
        System.out.printf("Day 6 Part 2 (test), Answer: %s%n",new Day6("test6.txt").solve_P2());

        System.out.printf("Day 6 Part 1, Answer: %s%n",new Day6("day6.txt").solve_P1());
        System.out.printf("Day 6 Part 2, Answer: %s%n",new Day6("day6.txt").solve_P2());

        System.out.printf("Day 7 Part 1 (test), Answer: %s%n",new Day7("test7.txt").solve_P1());
        System.out.printf("Day 7 Part 2 (test), Answer: %s%n",new Day7("test7.txt").solve_P2());
        System.out.printf("Day 7 Part 2 (test), Answer: %s%n",new Day7("test7_2.txt").solve_P2());

        System.out.printf("Day 7 Part 2, Answer: %s%n",new Day7("day7.txt").solve_P2());

    }
}
