/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.caja;

/**
 *
 * @author vouilloz
 */
public enum FormaPago {

    EFECTIVO("Efectivo"),
    TARJETA("Tarjeta"),
    CUENTA_CORRIENTE("Cuenta Corriente"),
    CHEQUE("Cheque"),
    DEPOSITO("Deposito"),
    RAPIPAGO("Rapipago");
    private String name;

    private FormaPago(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
