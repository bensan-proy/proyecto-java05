package libswing;

public class Cuenta {

    private String nombreTitular;
    private int saldo;

    public Cuenta() {
    }

    // Getters y Setters
    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    // Métodos de operaciones bancarias
    public String consultar() {
        return "Titular de la cuenta: " + nombreTitular + " - Saldo de la cuenta: " + saldo;
    }

    public void consignar(int monto) {
        if (monto > 0) {
            saldo += monto;
        } else {
            System.out.println("Error: El monto a consignar debe ser positivo");
        }
    }

    public void retirar(int monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
        } else if (monto <= 0) {
            System.out.println("Error: El monto a retirar debe ser positivo");
        } else {
            System.out.println("Error: Saldo insuficiente");
        }
    }

    public void transferir(int monto, Cuenta cuentaDestino) {
        // Validación básica
        if (monto <= 0) {
            System.out.println("Error: Monto debe ser positivo");
            return;
        }

        if (cuentaDestino == null) {
            System.out.println("Error: Cuenta destino no existe");
            return;
        }

        if (this.saldo < monto) {
            System.out.println("Error: Saldo insuficiente");
            return;
        }

        // Realizar transferencia
        this.saldo -= monto;
        cuentaDestino.saldo += monto;

        System.out.println("Transferencia exitosa de $" + monto);
    }
}
