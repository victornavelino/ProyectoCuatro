/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Articulos;

import entidades.articulo.ListaPrecio;
import entidades.caja.FormaPago;
import facade.ListaPrecioFacade;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author franco
 */
public class ListaPreciosTest {

    public ListaPreciosTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //Minorista (50% de Margen)
    //Mayorista (20)
    //Contado (30)
    //Profesional (40)
    @Test
    public void hello() {
        //Minorista
        ListaPrecio minorista = new ListaPrecio();
        minorista.setDescripcion("Minorista");
        minorista.setMargen(new BigDecimal(50));
        List<FormaPago> formasPagoMinorista = new ArrayList<>();
        formasPagoMinorista.add(FormaPago.TARJETA);
        formasPagoMinorista.add(FormaPago.CUENTA_CORRIENTE);
        formasPagoMinorista.add(FormaPago.EFECTIVO);
        minorista.setFormasDePago(formasPagoMinorista);
        ListaPrecioFacade.getInstance().alta(minorista);
        //Mayorista
        ListaPrecio mayorista = new ListaPrecio();
        mayorista.setDescripcion("Mayorista");
        mayorista.setMargen(new BigDecimal(20));
        List<FormaPago> formasdePagoMayorista = new ArrayList<>();
        formasdePagoMayorista.add(FormaPago.CHEQUE);
        mayorista.setFormasDePago(formasdePagoMayorista);
        ListaPrecioFacade.getInstance().alta(mayorista);

        //Contado
        ListaPrecio contado = new ListaPrecio();
        contado.setDescripcion("Contado");
        contado.setMargen(new BigDecimal(30));
        List<FormaPago> formasdePagoContado = new ArrayList<>();
        formasdePagoContado.add(FormaPago.EFECTIVO);
        contado.setFormasDePago(formasdePagoContado);
        ListaPrecioFacade.getInstance().alta(contado);

        //Profesional
        ListaPrecio profesional = new ListaPrecio();
        profesional.setDescripcion("Profesional");
        profesional.setMargen(new BigDecimal(40));
        List<FormaPago> formasdePagoProfesional = new ArrayList<>();
        formasdePagoProfesional.add(FormaPago.EFECTIVO);
        profesional.setFormasDePago(formasdePagoProfesional);
        ListaPrecioFacade.getInstance().alta(profesional);

        //Listas Permitidas
        //Minorista
        List<ListaPrecio> listaPreciosCambiarMinorista = new ArrayList<>();
        listaPreciosCambiarMinorista.add(contado);
        minorista.setPermiteCambioAListas(listaPreciosCambiarMinorista);
        ListaPrecioFacade.getInstance().modificar(minorista);

        //Mayorista
        //Contado
        List<ListaPrecio> listaPreciosCambiarContado = new ArrayList<>();
        listaPreciosCambiarContado.add(minorista);
        contado.setPermiteCambioAListas(listaPreciosCambiarContado);
        ListaPrecioFacade.getInstance().modificar(contado);

        //Profesional
        List<ListaPrecio> listaPreciosCambiarProfesional = new ArrayList<>();
        listaPreciosCambiarProfesional.add(minorista);
        profesional.setPermiteCambioAListas(listaPreciosCambiarProfesional);
        ListaPrecioFacade.getInstance().modificar(profesional);

    }
}
