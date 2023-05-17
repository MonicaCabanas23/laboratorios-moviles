### ¿Qué es una coroutine en Kotlin y cómo se diferencia de un hilo tradicional?
Es un mecanismo de programación para poder decidir cuándo se ejecutarán ciertos pŕocesos, estos procesos son mayormente aquellos en los que no se sabe cuánto tiempo tardarán. 
Estos procesos son principalmente aquellos que tienen que ver con la recuperación de datos de una fuente de datos. 

### ¿Cuál es la importancia de la suspensión en las coroutines y cómo se implementa?
La suspensión permite la delegación de las tareas en un hio aparte del hilo principal, de esta manera no se satura el hilo principal, permitiendo que en el principal solo 
se ejecuten tareas que se sabe que se ejecutarán rápido. 

### ¿Cuál es el propósito del dispatcher en las coroutines y cómo se elige uno adecuado para cada tarea?
El dispatcher cumple con la función de  especificar el hilo en el que se ejecutarán las tareas. Existen diferentes hilos en los que se pueden delegar las tareas: 
IO para la recuperación de datos, Main para la ejecución de la UI, y Default para la ejecución de computación intensiva. 

### ¿Cuál es el propósito y el uso de la función async en las coroutines?
El proósito de la función async es el de lanza coroutines así como launch, con la diferencia de que async devuelve un resultado en el objeto Deferred. 
