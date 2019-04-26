package DijkstraImplementation;

import java.util.Stack;

public class Algorithm {

    private Stack<String> operations;
    private Stack<Double> values;

    public Algorithm() {
        operations = new Stack<>();
        values = new Stack<>();
    }

    public void interpreterExpression(String expression) {
        String[] expressionArray = expression.split(" ");

        for (String exp :
                expressionArray) {

            if (exp.equals("(")) {
                //do nothing
            } else if (exp.equals("+") || exp.equals("*")) {
                operations.push(exp);
            } else if (exp.equals(")")) {
                if (operations.pop().equals("+")) {
                    values.push(values.pop() + values.pop());
                } else {
                    values.push(values.pop() * values.pop());
                }
            } else {
                values.push(Double.parseDouble(exp));
            }
        }
    }

    public void result() {
        System.out.println(values.pop());
    }
}
