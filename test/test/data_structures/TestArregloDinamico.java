package test.data_structures;

import model.data_structures.ArregloDinamico;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public  class TestArregloDinamico 
{
	private ArregloDinamico arreglo;
	private static int TAMANO=100;
	
	@Before
	public void setUp1() 
	{
		arreglo= new ArregloDinamico(TAMANO);
	}

	public void setUp2() 
	{
		for(int i =0; i< TAMANO*2; i++)
		{
			arreglo.agregar(""+i);
		}
	}

	/**
	 * Verifica el numero de elementos del arreglo y asismismo, verifica que el arreglo contenga elementos
	 */
	@Test
	public void testArregloDinamico() 
	{
		assertEquals("El numero de elementos no concide con el arreglo" , 100, arreglo.darCapacidad());
		assertNotNull("El arreglo dinamico es nulo", arreglo.darTamano() >= 1);
	}

	/**
	 * Verifica que el elemento en la posicion que ingresa si exista y verifica si sea el mismo
	 */
	@Test
	public void testDarElemento() 
	{
		setUp2();
		arreglo.darElemento(3);
		assertNotNull("El elmento de entrada es nulo" , arreglo.darElemento(3) != null);
		assertTrue("El elemento no concide con el elemento original", arreglo.darElemento(5) == arreglo.darElemento(5));
	}

}
