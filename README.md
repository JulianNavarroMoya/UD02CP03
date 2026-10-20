# Caso Práctico 3: Programación Multihilo

---

## Análisis de la Ejecución:

No se recogen todos los valores generados del 0 al 100.

Al contar cada hebra con su propio ciclo de 1 a 100, se crea una gran desoncronización, originandose:

1 sobrescrituras: La hebra modificadora puede encontrarse en su iteración con la hebra lectora. Como resultado, los números intermedios que se asignaron entre medias se pierden y nunca son leídos.

2 Lectura de datos duplicados: En varias iteraciones consecutivas del lector (`[GET]`), se observa la lectura del mismo número repetido.

3 Intercalación de la impresión: Las líneas de `[SET]` y `[GET]` se mezclan arbitrariamente en pantalla, evidenciando que ambas hebras corren de manera totalmente desacoplada e impredecible.
