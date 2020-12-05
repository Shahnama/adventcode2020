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
    }
}
