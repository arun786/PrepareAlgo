package DijkstraImplementation;

public class App {

    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
        String expression = "( ( 1 + 2 ) * ( 9 + 7 ) )";
        algorithm.interpreterExpression(expression);
        algorithm.result();
    }
}
