/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.cliente;

import entidades.articulo.ListaPrecio;
import entidades.persona.CorreoElectronico;
import entidades.persona.DocumentoIdentidad;
import entidades.persona.Domicilio;
import entidades.persona.Sexo;
import entidades.persona.Telefono;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Domicilio domicilio;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Telefono> telefonos;
    @OneToMany(cascade = CascadeType.ALL)
    private List<CorreoElectronico> correosElectronicos;
    @OneToOne
    private ListaPrecio listaPrecio;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAlta;
    private String razonSocial;
    @Basic(optional = false)
    private String apellido;
    @Basic(optional = false)
    private String nombre;
    @Embedded
    private DocumentoIdentidad documentoIdentidad;
    private String cuil;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNacimiento;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public List<CorreoElectronico> getCorreosElectronicos() {
        return correosElectronicos;
    }

    public void setCorreosElectronicos(List<CorreoElectronico> correosElectronicos) {
        this.correosElectronicos = correosElectronicos;
    }

    public ListaPrecio getListaPrecio() {
        return listaPrecio;
    }

    public void setListaPrecio(ListaPrecio listaPrecio) {
        this.listaPrecio = listaPrecio;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DocumentoIdentidad getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(DocumentoIdentidad documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return apellido + ", " + nombre;
    }

}
