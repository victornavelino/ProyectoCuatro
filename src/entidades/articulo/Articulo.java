/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.articulo;

import entidades.articulo.costo.ValorCosto;
import entidades.articulo.marca.Marca;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "articulo")
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    private String descripcion;
    @Basic(optional = false)
    private String descripcionReducida;
    @Column(unique = true, nullable = false)
    private String codigoBarra;
    @OneToOne
    private SubCategoria subCategoria;

    @OneToOne
    private UnidadMedida unidadMedida;

    @Column(scale = 2, precision = 12)
    private BigDecimal precioCosto;
    @OneToOne
    private ValorCosto descuentoCosto;

    @OneToOne
    private Marca marca;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcionReducida() {
        return descripcionReducida;
    }

    public void setDescripcionReducida(String descripcionReducida) {
        this.descripcionReducida = descripcionReducida;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public SubCategoria getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(SubCategoria subCategoria) {
        this.subCategoria = subCategoria;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public BigDecimal getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(BigDecimal precioCosto) {
        this.precioCosto = precioCosto;
    }

    public ValorCosto getDescuentoCosto() {
        return descuentoCosto;
    }

    public void setDescuentoCosto(ValorCosto descuentoCosto) {
        this.descuentoCosto = descuentoCosto;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Articulo)) {
            return false;
        }
        Articulo other = (Articulo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        try {
            return descripcionReducida;
        } catch (Exception e) {
            return "";
        }
    }

}
