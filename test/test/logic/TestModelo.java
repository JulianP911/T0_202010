package test.logic;

import static org.junit.Assert.*;
import model.logic.Modelo;
import org.junit.Before;
import org.junit.Test;

public class TestModelo 
{
	private Modelo modelo;
	private static int CAPACIDAD=100;
	
	@Before
	public void setUp1() 
	{
		modelo= new Modelo(CAPACIDAD);
	}

	public void setUp2() 
	{
		for(int i =0; i< CAPACIDAD;i++)
		{
			modelo.agregar(i);
		}
	}
	public void setUp3()
	{
		modelo = new Modelo(10);
	}

	@Test
	public void testModelo() 
	{
		assertTrue(modelo!=null);
		assertEquals(0, modelo.darTamano());  // Modelo con 0 elementos presentes.
	}

	/**
	 * Verifica que el tamaño sea el correcto utilizando el escenario 3
	 * Se hacen dos test para verificar que el tamaño sea igual y que el tamaño concida con el original establecido en el setup3
	 */
	@Test
	public void testDarTamano() 
	{
		setUp3();
        assertEquals( "El tamaño no es correcto", 10, modelo.darTamano());
        assertFalse("El tamaño no concide con lo esperado" , modelo.darTamano() == 10);
	}

	/**
	 * Verifica que se haya agregado el elemento en el arreglo
	 * Se hacen dos test para verificar que el arreglo haya aumentado y que no haya aumnetado sino que sigio con los mismos elementos
	 */
	@Test
	public void testAgregar() 
	{
		setUp3();
		modelo.agregar(1);
        assertEquals( "El tamaño del arreglo no aumentó como esperado.", 11, modelo.darTamano());
        assertEquals( "No se agregó el elemento al arreglo dinamico como lo esperado.", 10, modelo.darTamano());

        modelo.agregar(5);
        assertEquals( "El tamaño del arreglo no aumentó como esperado.", 15, modelo.darTamano());
        assertEquals( "No se agregó el elemento al arreglo dinamico como lo  esperado.", 10, modelo.darTamano());

    }

	/**
	 * Verifica que el elemento si se haya encontrado en el arreglo
	 * Se hacen dos test para verificar que el arreglo haya buscado un elemento especifico y que verificacion en los casos que es null o not null
	 */
	@Test
	public void testBuscar() 
	{
		setUp2();
		assertEquals("El elemento buscado no concide con el ingresado", modelo.buscar(25), modelo.buscar(25));
		assertTrue("El elemento buscado no es nulo", modelo.buscar(25) != null);
		assertTrue("El elemento buscado es nulo", modelo.buscar(101) == null);
	}

	/**
	 * Verifica que se haya eliminado el elemento en el arreglo
	 * Se hacen dos test para verificar que el arreglo haya eliminado y que no haya eliminado sino que sigio con los mismos elementos
	 */
	@Test
	public void testEliminar() 
	{
		setUp2();
		modelo.eliminar(1);
        assertEquals( "El tamaño del arreglo no disminuyo como lo esperado.", 99, modelo.darTamano());
        assertEquals( "No se elimino el elemento al arreglo dinamico como lo  esperado.", 100, modelo.darTamano());

        modelo.eliminar(15);
        assertEquals( "El tamaño del arreglo no disminuyo como lo esperado.", 85, modelo.darTamano());
        assertEquals( "No se elimino el elemento al arreglo dinamico como lo  esperado.", 100, modelo.darTamano());
	}
}
