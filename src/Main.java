public class Main {
    public static void main(String[] args) {
        VariableCompartida variable = new VariableCompartida();

        Thread hebraSet = new Thread(new HebraModificadora(variable), "Hebra-Set");
        Thread hebraGet = new Thread(new HebraLectora(variable), "Hebra-Get");

        hebraSet.start();
        hebraGet.start();

        try {
            hebraSet.join();
            hebraGet.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Fin de la ejecución.");
    }
}