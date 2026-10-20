public class HebraModificadora implements Runnable {
    private final VariableCompartida variable;

    public HebraModificadora(VariableCompartida variable) {
        this.variable = variable;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            variable.set(i);
            System.out.println("[SET] : " + i);
        }
    }
}