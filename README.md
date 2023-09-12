## Distracted Driver Simulation

This project simulates a person performing various tasks while driving, demonstrating the use of Java threads to handle concurrent activities. The primary focus is on creating a realistic scenario where the driver engages in multiple actions such as eating, using a phone, and retouching makeup.

### Description

The Distracted Driver Simulation project uses Java's multithreading capabilities to simulate a driver performing various activities while driving. The main class, `Persona`, contains multiple threads that represent different actions, ensuring they are performed in a synchronized manner to mimic real-life distractions.

### Features

-   **Multithreading:** Utilizes Java's threading capabilities to manage concurrent tasks.
-   **Synchronization:** Ensures conflicting actions are not performed simultaneously (e.g., holding a hamburger and a phone at the same time).
-   **Simulation:** Creates a realistic scenario of distracted driving using print statements to represent the driver's actions.


### File Structure

-   **Hamburmovil/**: Root directory containing project files and directories.
    -   **build.xml**: Build script for the project.
    -   **manifest.mf**: Manifest file for the project.
    -   **build/**: Directory containing compiled classes and build related files.
        -   **classes/**: Compiled class files.
            -   **.netbeans_automatic_build**: NetBeans automatic build indicator file.
            -   **.netbeans_update_resources**: NetBeans resource update indicator file.
            -   **Hamburmovil.class**: Compiled bytecode of the Hamburmovil class.
            -   **Persona.class**: Compiled bytecode of the Persona class.
            -   **hamburmovil/Hamburmovil.rs**: Resource file for the Hamburmovil package.
    -   **nbproject/**: NetBeans project-specific files.
        -   **build-impl.xml**: NetBeans build implementation file.
        -   **genfiles.properties**: Generated files properties for the NetBeans project.
        -   **project.properties**: Properties file for the NetBeans project.
        -   **project.xml**: Project configuration file for NetBeans.
        -   **private/**: Private NetBeans project files.
            -   **private.properties**: Private properties file for NetBeans project.
    -   **src/**: Source directory containing Java source files.
        -   **hamburmovil/**: Package directory for the Hamburmovil classes.
            -   **Hamburmovil.java**: Main Java source file for the project.
### Main Classes and Methods

#### Persona Class

This class simulates a person performing various activities while driving, utilizing multiple threads to handle different actions.

**Constructor:**

```java
public Persona() {
    this.hiloConducir = new Thread(this::conducir);
    this.hiloMirarTelefono = new Thread(this::mirarTelefono);
    this.hiloMirarTelefono2 = new Thread(this::mirarTelefono);
    this.hiloComerHamburguesa = new Thread(this::comerHamburguesa);
    this.hiloComerHamburguesa2 = new Thread(this::comerHamburguesa);
    this.hiloRetocarLabios = new Thread(this::retocarLabios);
}
```

Initializes the threads for various actions.

**Start Method:**

```java
public void start() {
    this.hiloConducir.start();
}
```

Starts the driving thread, which sequentially manages other activities.

**Conducir Method:**

```java
private synchronized void conducir() {
    try {
        // Simulation of driving and other activities
        System.out.println("Conduciendo...");
        Thread.sleep(1000);
        // Additional actions
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
```

Manages the driving process and coordinates with other threads.

**ComerHamburguesa Method:**

```java
private void comerHamburguesa() {
    int cont = 0;
    while (cont < 3) {
        if (hamburguesaEnMano) {
            System.out.println("\tComiendo hamburguesa...");
            try {
                Thread.sleep(1000);
                cont++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

Simulates the process of eating a hamburger.

**MirarTelefono Method:**

```java
private void mirarTelefono() {
    int cont = 0;
    while (cont < 3) {
        if (telefonoEnMano) {
            System.out.println("\tMirando el teléfono...");
            try {
                Thread.sleep(1000);
                cont++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

Simulates the process of looking at the phone.

**RetocarLabios Method:**

```java
private void retocarLabios() {
    int cont = 0;
    while (cont < 3) {
        if(labialEnMano){
            System.out.println("\tRetocando los labios...");
            try {
                Thread.sleep(1000);
                cont++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

Simulates the process of retouching makeup.

### Getting Started

To run the simulation, compile the Java files and execute the `Hamburmovil` class.

### Requirements

-   Java Development Kit (JDK)
-   An IDE or text editor for Java development

### Usage

1.  Clone the repository.
2.  Navigate to the `src` directory.
3.  Compile the Java files using `javac Hamburmovil.java`.
4.  Run the simulation using `java Hamburmovil`.