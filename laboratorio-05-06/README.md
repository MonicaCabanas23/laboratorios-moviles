# Laboratorio 05
### ¿Qué diferencia existe entre navegar dentro de la aplicación utilizando Navigation Component o hacer uso de intents?
Con Navigation Component no es necesario la existencia de un bundle para pasar datos de un fragmento al otro, en cambio con intents es 
necesario pasar un bundle por cada navegación que se realice. Además, con Navigation Component, la navegación se da entre fragmentos, y con los intents
las navegaciones se dan entre actividades.

### Menciona los componentes fundamentales de Navigation
Component
Fragmentos entre los cuales se dará la navegación, la actividad y el nav_graph.

### Mencione algunas de las ventajas del Navigation Graph
EL flujo de navegación es visible, lo cual facilita tanto el entendimiento de cómo se dará el flujo y en qué orden irá.

# Laboratorio 06
### ¿En qué consiste el patrón de diseño Repository?
Consiste en una capa que actúa como intermediario entre la fuente de datos y la lógica de negocios

### ¿Qué es el ViewModel?
Es el intermediario entre los modelos y las vistas

# Laboratorio 07
### ¿Qué ventajas tiene el utilizar LiveData?
- Garantiza la congruencia entre la UI y los datos.
- Evita fugas de memoria al eliminar los objetos que ya no se utilizan cuando el ciclo de vida de un fragmento o componente termina
- Detiene actividades para evitar fallas.
- No se realiza más el control manual de los ciclos de vida.
- Los datos siempre están actualizados. 

### ¿Qué patrón de diseño utiliza LiveData?
Model View ViewModel

### Menciona que se debe agregar al Gradle para poder implementar DataBinding
Habilitar en el buildTypes el dataBinding.

### ¿Qué es DataBinding? Menciona sus ventajas frente a findViewById
  
