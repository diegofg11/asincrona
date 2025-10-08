Conexión asíncrona - Diego Fernández

Este proyecto muestra cómo realizar una conexión asíncrona a una base de datos MariaDB desde una aplicación JavaFX.
La interfaz permite cargar, añadir, eliminar y restaurar registros de personas de forma sencilla, utilizando operaciones no bloqueantes para mejorar el rendimiento.

Tecnologías utilizadas

Java 23

JavaFX 23

MariaDB 10 o superior

Maven para la gestión de dependencias

Estructura del proyecto
src/
└── main/
├── java/
│    └── org.diegofg11/
│          ├── App.java
│          ├── Lanzador.java
│          ├── Controlador/
│          │     └── Controlador.java
│          ├── Conexion/
│          │     ├── Conexion.java
│          │     └── Config.java
│          ├── DAO/
│          │     └── PersonaDAO.java
│          └── Modelo/
│                └── Persona.java
├── resources/
│    ├── org/diegofg11/fxml/tabla.fxml
│    ├── org/diegofg11/css/estilos.css
│    ├── config.properties
│    └── init.sql
└── pom.xml

Configuración de la base de datos

Asegúrate de tener MariaDB en ejecución (por ejemplo, en Docker).

Importa el archivo init.sql en tu servidor (desde Workbench o la consola).

Verifica que los datos de conexión en config.properties coincidan con los de tu base de datos:

db.url=jdbc:mariadb://localhost:3306/asincrona
db.user=root
db.password=tu_contraseña

Ejecución

Compila el proyecto con Maven:

mvn clean package


Ejecuta la aplicación:

java -jar target/asincrona.jar

Autor

Diego Fernández