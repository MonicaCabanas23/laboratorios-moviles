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

# Laboratorio 08
### ¿Cuál es la principal ventaja de utilizar RecyclerView?
Permite que se puedan reutilizar elementos visuales en una lista para cargarlos eficientemente al hacer scroll.

### Menciona los componentes de RecyclerView y la función que tiene cada uno de ellos
- RecyclerViewHolder: es el encargado de crear el elemento visual que se utilizará en la lista. Corresponde a un elemento de la lista
- RecyclerViewAdapter: es el encargado de enlazar los datos del ViewModel a la vista o widget creada anteriormente.
- List Item: es el archivo .xml como tal que establece cómo se verá un elemento de la lista en el Recycler View
