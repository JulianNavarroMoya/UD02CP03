public class VariableCompartida {
    private int v;
    private boolean disponible = false; // true si hay un valor listo para leer

    public VariableCompartida() {
        this.v = 0;
    }

    public synchronized int get() {
        // Si no hay dato nuevo disponible, espera a que el productor escriba
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        disponible = false; // Marcamos que el dato ya fue consumido
        notifyAll();        // Avisamos al productor de que puede escribir el siguiente
        return v;
    }

    public synchronized void set(int v) {
        // Si ya hay un dato sin leer, espera a que el consumidor lo lea
        while (disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.v = v;
        disponible = true;  // Marcamos que hay un nuevo valor listo
        notifyAll();        // Avisamos al consumidor
    }

    public synchronized void inc() {
        this.v++;
    }
}
