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
public enum TipoResponsabilidad {
    RESPONSABLE_INSCRIPTO("RESPONSABLE_INSCRIPTO"),
    RESPONSABLE_NO_INSCRIPTO("RESPONSABLE_NO_INSCRIPTO"),
    RESPONSABLE_EXENTO("RESPONSABLE_EXENTO"),
    NO_RESPONSABLE("NO_RESPONSABLE"),
    CONSUMIDOR_FINAL("CONSUMIDOR_FINAL");
    private String name;

    private TipoResponsabilidad(String name) {
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
