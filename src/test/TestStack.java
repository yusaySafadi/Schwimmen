package test;

import cardgame.Stack;

import java.util.*;
import java.util.stream.Stream;

public class TestStack implements Testrunner {
    private void deckToStringContainer(Collection container, Stack stack) {
        Stream.generate(() -> stack.reveal())
                .limit(32)
                .forEach(card -> container.add(card.toString()));
    }

    private boolean mustHaveThirtyTwoUniqueCards() {
        Stack stack = new Stack();
        int stackSizeInitial = stack.size();

        Set<String> uniqueCards = new HashSet<>();
        deckToStringContainer(uniqueCards, stack);

        return stackSizeInitial == 32 && stack.size() == 0 && uniqueCards.size() == 32;
    }

    private boolean mustHaveRandomOrder() {
        for (int i = 0; i < 100; i++) {
            List<String> deck1 = new ArrayList();
            List<String> deck2 = new ArrayList();
            deckToStringContainer(deck1, new Stack());
            deckToStringContainer(deck2, new Stack());
            if (deck1.equals(deck2)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String testname() {
        return "Test der Stackimplementierung";
    }

    @Override
    public void run() {
        System.out.println("Test for 32 unique cards: " + mustHaveThirtyTwoUniqueCards());
        System.out.println("Test for random order: " + mustHaveRandomOrder());
    }
}
