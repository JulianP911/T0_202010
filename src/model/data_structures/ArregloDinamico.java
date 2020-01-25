package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico<T extends Comparable<T>> implements IArregloDinamico<T>
{
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private T elementos[];

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	@SuppressWarnings("unchecked")
	public ArregloDinamico( int max )
	{
		elementos = (T[]) new Object[max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	/**
	 * Este metodo se encarga de agragar un elemento al arreglo dinamico de tipo generics
	 * @param dato Dato que ingresa al nuevo arreglo dinamico
	 */
	@SuppressWarnings("unchecked")
	public void agregar(T dato)
	{
		if ( tamanoAct == tamanoMax )
		{ 
			// caso de arreglo lleno (aumentar tamanio)
			tamanoMax = 2 * tamanoMax;
		    T[] copia = (T[]) elementos;
			elementos =  (T[]) new Object[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = (T) dato;
		tamanoAct++;
	}

	/**
	 * Devuelve la capacidad del arreglo dinamico
	 */
	public int darCapacidad() 
	{
		return tamanoMax;
	}

	/**
	 * Devuele el tamaño actual del arreglo dinamico
	 */
	public int darTamano()
	{
		return tamanoAct;
	}

	/**
	 * Devuelve el elemento en la posicion dada como parametro, si no hay retorna null
	 * @return Elemento del arreglo dinamico
	 */
	public T darElemento(int posicion) 
	{
		T elemento = null;
		if(elementos[posicion] != null)
		{
			elemento = elementos[posicion];
		}
		return elemento;
	}

	/**
	 * Busca el elemento del arreglo elementos, si no hay ninguno que consida con el elemento dado retorna null
	 * @return Elemento del arreglo dinamico que concide con el parametro
	 */
	public T buscar(T dato) 
	{
		T elemento = null;
		for(T e : elementos)
		{
			if(e.compareTo(dato) == 0)
			{
				elemento = dato;
			}
		}
		return elemento;
	}

	/**
	 * Elimina el elemento del arreglo elementos, si no hay ninguno que consida con el elemento dado retorna null
	 * Cambia de apuntador para eliminar el object
	 * @return Elemento del arreglo dinamico que que concide con el parametro que ha sido eliminado
	 */
	public T eliminar(T dato) 
	{
		T elemento = null;
		for(int i = 0; i < elementos.length; i++)
		{
			T actual = elementos[i];
		    if(actual.compareTo(dato) == 0)
			{
		    	elemento = elementos[i];
		    	elementos[i] = elementos[i+1]; 
			}
		}
		return elemento;
	}
}
