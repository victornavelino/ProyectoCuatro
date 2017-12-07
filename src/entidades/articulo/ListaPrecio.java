/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.articulo;

import entidades.caja.FormaPago;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "precio")
public class ListaPrecio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    private String descripcion;
    @Column(scale = 2, precision = 12)
    private BigDecimal margen;
    @ElementCollection
    List<FormaPago> formasDePago;
    @OneToMany
    List<ListaPrecio> permiteCambioAListas;

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

    public BigDecimal getMargen() {
        return margen;
    }

    public void setMargen(BigDecimal margen) {
        this.margen = margen;
    }

    public List<FormaPago> getFormasDePago() {
        return formasDePago;
    }

    public void setFormasDePago(List<FormaPago> formasDePago) {
        this.formasDePago = formasDePago;
    }

    public List<ListaPrecio> getPermiteCambioAListas() {
        return permiteCambioAListas;
    }

    public void setPermiteCambioAListas(List<ListaPrecio> permiteCambioAListas) {
        this.permiteCambioAListas = permiteCambioAListas;
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
        if (!(object instanceof ListaPrecio)) {
            return false;
        }
        ListaPrecio other = (ListaPrecio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descripcion;
    }

}
