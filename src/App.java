public class App {
    
    public static void main(String[] args) throws Exception {


        MiClase instancia = new MiClase(10);
        System.out.println(instancia.getNumero());








    }
}

class MiClase {
    private int numero;

    public MiClase() {
        System.out.println("Constructor sin argumentos");
    }

    public MiClase(int value) {
        System.out.println("Constructor con argumentos");
        numero = value;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int value) {
        numero = value;
    }

}