package testng;

import org.example.entity.Almacen;
import org.example.entity.Ingrediente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class AlmacenTestNG {
    private static final Logger log = LoggerFactory.getLogger(AlmacenTestNG.class);
    static List<Ingrediente> listaTotal;
    static int cantIngredientes;


    @Parameters({"ingredient-count"})
    @BeforeClass
    public void beforeClass(@Optional("2") int count) {
        cantIngredientes = count;
        /***Esto debería hacerse con datos reales desde algun origen*/
        listaTotal =  new  ArrayList<Ingrediente>();
        listaTotal.add( new Ingrediente("harina", "kg",  (int) (Math.random() * 100)));
        listaTotal.add(  new Ingrediente("aceilte", "ltd",  (int) (Math.random() * 100)));
        listaTotal.add(  new Ingrediente("papa", "kg",  (int) (Math.random() * 100)));
        listaTotal.add(  new Ingrediente("huevo", "un",  (int) (Math.random() * 100)));
        listaTotal.add( new Ingrediente("fideos", "kg",  (int) (Math.random()) * 100));
    }


    /**
     *
     * @param i
     */
    @Test(dataProvider = "generarIngredientes")
    public void testAgregarStock(Ingrediente i) {
        int cantidadInicial = i.getStock();
        int cantidadAIncrementar = (int)(Math.random()*100);
        /** Se invoca a la función que realmenete se va evaluar*/
        Almacen.IngresarConsumibles(i, cantidadAIncrementar);
        assertEquals(cantidadInicial+cantidadAIncrementar, i.getStock());;

        System.out.println(i);
    }

    @BeforeMethod
    public void setUp() {
    }

    /**
     *  Genera aleatoriamente una lista de diferentes ingredientes
     *  listaTotal está definida por extensión, pero en un caso más real, ese conjunto
     *  de datos debería ser cargado desde un archivo o desde una conexión a una
     *  base de datos
     * */
    @DataProvider
    public Iterator<Ingrediente> generarIngredientes() {
        /** A continuacion se crea una lista de ingredientes al azar*/
        List<Ingrediente>  ingATestear = new ArrayList<Ingrediente>();
        for (int i=0; i< AlmacenTestNG.cantIngredientes;i++)
            ingATestear.add( listaTotal.get( (int) (Math.random() * listaTotal.size() ) ));

        return ingATestear.iterator();
    }


    @Test(dataProvider = "generarIngredientes")
    public void testQuitarStock(Ingrediente i) {
        int cantidadInicial = i.getStock();
        int cantidadADecrementar = (int)(Math.random()*cantidadInicial);
        /** Se invoca a la función que realmenete se va evaluar*/
        Almacen.IngresarConsumibles(i, cantidadADecrementar);
        assertEquals(cantidadInicial-cantidadADecrementar, i.getStock());

        System.out.println(i);
    }

    @BeforeTest
    public void beforeTest() {
    }

}
