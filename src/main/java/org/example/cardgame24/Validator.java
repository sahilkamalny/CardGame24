package org.example.cardgame24;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static boolean isValid(String expression, List<Card> cards) {
        List<Integer> vals = new ArrayList<>(); // list to hold values of four cards
        for (Card card : cards) {
            vals.add(card.getValue()); // adds values from cards to list
        }

        for (int val : vals) { // loops through each value
            if (!expression.contains(String.valueOf(val))) {
                return false; // if the value is not in the expression return false
            }
        }

        // using ScriptEngineManager to evaluate expressions
        try {
            ScriptEngineManager mng = new ScriptEngineManager(); // creates the ScriptEngineManager
            ScriptEngine eng = mng.getEngineByName("JavaScript"); // using the JavaScript engine
            Object solution = eng.eval(expression); // object to hold the solution
            return solution instanceof Number && ((Number)solution).doubleValue() == 24; // returns true if the solution is a valid number and is 24

        } catch (ScriptException e) {
            return false; // if there is an issue with the script engine return false
        }
    }
}