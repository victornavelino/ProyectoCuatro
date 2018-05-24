/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package includes;

/**
 *
 * @author hugo
 */
public enum TipoDoc {
    TIPO_CUIT("TIPO_CUIT"),
    TIPO_CUIL("TIPO_CUIL"),
    TIPO_LE("TIPO_LE"),
    TIPO_LC("TIPO_LC"),
    TIPO_DNI("TIPO_DNI");
    private String name;

    private TipoDoc(String name) {
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
