package lesson7;

public class Main {
    public static void main(String[] args) {
        testTowns();
        testNumbers();

    }

    public static void testTowns() {

        Graph towns = new Graph(10);
        towns.addVertex("Москва");
        towns.addVertex("Тула");
        towns.addVertex("Рязань");
        towns.addVertex("Калуга");
        towns.addVertex("Липецк");
        towns.addVertex("Тамбов");
        towns.addVertex("Орел");
        towns.addVertex("Саратов");
        towns.addVertex("Курск");
        towns.addVertex("Воронеж");

        towns.addEdges("Москва", "Тула", "Рязань", "Калуга");
        towns.addEdges("Воронеж", "Липецк", "Саратов", "Курск");
        towns.addEdges("Тула", "Липецк");
        towns.addEdges("Тамбов", "Рязань", "Саратов");
        towns.addEdges("Орел", "Калуга", "Курск");

        towns.findBestWay("Москва", "Воронеж");
    }

    private static void testNumbers() {
        Graph numbers = new Graph(12);
        for (int i = 1; i <= 12; i++){
            numbers.addVertex(String.valueOf(i));
        }

        numbers.addEdges("1", "2", "7", "9");
        numbers.addEdges("2", "3", "6");
        numbers.addEdges("7", "6", "10");
        numbers.addEdges("9", "10");
        numbers.addEdges("6", "4", "8");
        numbers.addEdges("4", "5");
        numbers.addEdges("11", "8", "10", "12");

        numbers.findBestWay("5", "9");
    }
}
