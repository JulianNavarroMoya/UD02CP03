## 2. Solución Aplicada: ¿Por qué ahora sí funciona?

### Mecanismos clave implementados:

* **Exclusión Mutua con `synchronized`:**  
  Al marcar los métodos `get()` y `set()` como `synchronized`, Solo un hilo puede estar ejecutando código dentro del objeto a la vez, garantizando que no se solapen y que vayan sincronizados.


* **Coordinación mediante Monitor (`wait()` y `notifyAll()`):**  
  Los hilos ya no consumen CPU, en su lugar, se suspenden de forma eficiente hasta que el estado del objeto cambia.


* **Protección contra despertares espurios (`while (!condicion)`):**  
  Se utiliza un bucle `while` en lugar de una sentencia `if` para envolver la llamada a `wait()`. Esto garantiza que, si el hilo despierta por una interrupción no esperada y reevalúe la condición antes de continuar.