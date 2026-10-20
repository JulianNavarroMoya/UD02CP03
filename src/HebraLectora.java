public class HebraLectora implements Runnable {
    private final VariableCompartida variable;

    public HebraLectora(VariableCompartida variable) {
        this.variable = variable;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            int valorLeido = variable.get();
            System.out.println("[GET] : "+ valorLeido);
        }
    }
}