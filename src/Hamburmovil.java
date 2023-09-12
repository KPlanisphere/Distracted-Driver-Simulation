class Persona {
    private final Thread hiloConducir;
    private final Thread hiloMirarTelefono;
    private final Thread hiloMirarTelefono2;
    private final Thread hiloComerHamburguesa;
    private final Thread hiloComerHamburguesa2;
    private final Thread hiloRetocarLabios;
    private boolean telefonoEnMano = false;
    private boolean labialEnMano = false;
    private boolean hamburguesaEnMano = false;

    public Persona() {
        this.hiloConducir = new Thread(this::conducir);
        this.hiloMirarTelefono = new Thread(this::mirarTelefono);
        this.hiloMirarTelefono2 = new Thread(this::mirarTelefono);
        this.hiloComerHamburguesa = new Thread(this::comerHamburguesa);
        this.hiloComerHamburguesa2 = new Thread(this::comerHamburguesa);
        this.hiloRetocarLabios = new Thread(this::retocarLabios);
    }

    public void start() {
        this.hiloConducir.start();
    }

    private synchronized void conducir() {
        try {
            System.out.println("Conduciendo...");
            Thread.sleep(1000);
            
            // La persona toma su hamburguesa y le da una mordida
            System.out.println("Persona toma su hamburguesa y le da una mordida");
            hamburguesaEnMano = true;
            Thread.sleep(1000);
            
            //En espera a que termine de dar sus mordidas ñam ñam
            this.hiloComerHamburguesa.start();
            Thread.sleep(3000);
            
            // La persona deja su hamburguesa
            System.out.println("Persona deja su hamburguesa");
            this.hamburguesaEnMano = false;
            Thread.sleep(1000);
            
            // La persona toma el teléfono y lo ve
            System.out.println("Persona toma el teléfono y lo ve");
            this.telefonoEnMano = true;
            
            // Espera a que el hilo del teléfono termine
            this.hiloMirarTelefono.start();
            Thread.sleep(3000);
            
            // La persona suelta el teléfono
            System.out.println("Persona suelta el teléfono");
            this.telefonoEnMano = false;
            Thread.sleep(1000);
            
            // La persona toma su hamburguesa y le da una mordida
            System.out.println("Persona toma su hamburguesa y le da una mordida");
            this.hamburguesaEnMano = true;
            Thread.sleep(1000);
            
            //En espera a que termine de dar sus mordidas ñam ñam
            this.hiloComerHamburguesa2.start();
            Thread.sleep(3000);
            
            // La persona deja su hamburguesa
            System.out.println("Persona deja su hamburguesa");
            this.hamburguesaEnMano = false;
            Thread.sleep(1000);
            
            // La persona toma el teléfono y lo ve
            System.out.println("Persona toma el teléfono y lo ve");
            this.telefonoEnMano = true;
            
            // Espera a que el hilo del teléfono termine
            this.hiloMirarTelefono2.start();
            Thread.sleep(3000);
            
            // La persona suelta el teléfono
            System.out.println("Persona suelta el teléfono");
            this.telefonoEnMano = false;
            Thread.sleep(1000);
            
            // La persona se retoca los labios
            System.out.println("Persona se retoca los labios");
            this.labialEnMano = true;
            
            // Espera a que el hilo de retocar labios termine
            this.hiloRetocarLabios.start();
            Thread.sleep(3000);
            
            // La persona termina de retocarse sus labios
            System.out.println("Persona termina de retocarse sus labios");
            this.labialEnMano = false;
            Thread.sleep(1000);
            
            // La persona para el auto
            System.out.println("Persona para el auto");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

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
}

public class Hamburmovil {
    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.start();
    }
}
