/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Articulos;

import entidades.articulo.ListaPrecio;
import entidades.articulo.costo.ListaCosto;
import entidades.articulo.costo.ValorCosto;
import entidades.caja.FormaPago;
import facade.ListaCostoFacade;
import facade.ListaPrecioFacade;
import facade.ValorCostoFacade;
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
public class ListaCostoTest {

    public ListaCostoTest() {
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
    @Test
    public void hello() {
        //1
        ListaCosto lista1 = new ListaCosto();
        lista1.setDescripcion("Lista 1");
        ListaCostoFacade.getInstance().alta(lista1);
        //2
        ListaCosto lista2 = new ListaCosto();
        lista1.setDescripcion("Lista 2");
        ListaCostoFacade.getInstance().alta(lista2);
        //valores lista 1
        //1
        ValorCosto valor1 = new ValorCosto();
        valor1.setDescripcion("1");
        valor1.setListaCosto(lista1);
        valor1.setValor(new BigDecimal("10"));
        ValorCostoFacade.getInstance().alta(valor1);
        //2
        ValorCosto valor2 = new ValorCosto();
        valor2.setDescripcion("2");
        valor2.setListaCosto(lista1);
        valor2.setValor(new BigDecimal("20"));
        ValorCostoFacade.getInstance().alta(valor2);
        //3
        ValorCosto valor3 = new ValorCosto();
        valor3.setDescripcion("3");
        valor3.setListaCosto(lista1);
        valor3.setValor(new BigDecimal("30"));
        ValorCostoFacade.getInstance().alta(valor3);
        //4
        ValorCosto valor4 = new ValorCosto();
        valor4.setDescripcion("4");
        valor4.setListaCosto(lista1);
        valor4.setValor(new BigDecimal("40"));
        ValorCostoFacade.getInstance().alta(valor4);

        //5
        ValorCosto valor5 = new ValorCosto();
        valor5.setDescripcion("5");
        valor5.setListaCosto(lista1);
        valor5.setValor(new BigDecimal("50"));
        ValorCostoFacade.getInstance().alta(valor5);

        //6
        ValorCosto valor6 = new ValorCosto();
        valor6.setDescripcion("6");
        valor6.setListaCosto(lista1);
        valor6.setValor(new BigDecimal("55"));
        ValorCostoFacade.getInstance().alta(valor6);
        //valores lista 2
        //1
        ValorCosto valor21 = new ValorCosto();
        valor21.setDescripcion("1");
        valor21.setListaCosto(lista2);
        valor21.setValor(new BigDecimal("10"));
        ValorCostoFacade.getInstance().alta(valor21);
        //2
        ValorCosto valor22 = new ValorCosto();
        valor22.setDescripcion("2");
        valor22.setListaCosto(lista2);
        valor22.setValor(new BigDecimal("20"));
        ValorCostoFacade.getInstance().alta(valor22);
        //3
        ValorCosto valor23 = new ValorCosto();
        valor23.setDescripcion("3");
        valor23.setListaCosto(lista2);
        valor23.setValor(new BigDecimal("25"));
        ValorCostoFacade.getInstance().alta(valor23);
        //4
        ValorCosto valor24 = new ValorCosto();
        valor24.setDescripcion("4");
        valor24.setListaCosto(lista2);
        valor24.setValor(new BigDecimal("35"));
        ValorCostoFacade.getInstance().alta(valor24);

        //5
        ValorCosto valor25 = new ValorCosto();
        valor25.setDescripcion("5");
        valor25.setListaCosto(lista2);
        valor25.setValor(new BigDecimal("40"));
        ValorCostoFacade.getInstance().alta(valor25);

        //6
        ValorCosto valor26 = new ValorCosto();
        valor26.setDescripcion("6");
        valor26.setListaCosto(lista2);
        valor26.setValor(new BigDecimal("55"));
        ValorCostoFacade.getInstance().alta(valor26);
    }
}
