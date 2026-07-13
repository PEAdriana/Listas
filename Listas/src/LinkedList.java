import java.util.Iterator;

public class LinkedList <E> implements Lista <E> 
{
	private class Nodo <E> 
	{
		//ATRIBUTOS DE LA CLASE NODO
		private Nodo <E> siguiente = null;
        private E info = null;
    
    	//CONSTRUCTOR
		Nodo (Nodo <E> siguiente, E info) 
		{
            this.siguiente = siguiente;
            this.info = info;
        }
    
    	//GETTER Y SETTER DE SIGUIENTE
		Nodo <E> getSiguiente () 
		{
            return siguiente;
        }
    
        void setSiguiente (Nodo <E> siguiente) 
		{
            this.siguiente = siguiente;
        }
    
    	//GETTER Y SETTER DE INFO
        E getInfo ()
		{
            return info;
        }

		void setInfo (E info)
		{
			this.info = info;
		}
    }
	
	//ATRIBUTOS DE LA CLASE LINKEDLIST
	private Nodo <E> primero = null; 
	private Nodo <E> ultimo = null; 		
	private int tamanio = 0;

	//METODOS DE LA CLASE LINKEDLIST
	@Override
	public void agregarElemento (E e) 
	{
		agregarFinal(e);
	}

	@Override
	public void agregarInicio (E e) 
	{
		Nodo<E> aux = new Nodo <E>(primero, e);
		primero = aux;
		if (ultimo  == null) 
		{
			ultimo = aux;
		}
		tamanio++;
	}

	@Override
	public void agregarFinal (E e) 
	{
		Nodo<E> aux = new Nodo <E>(null, e);
		if (esVacia ()) 
		{
			this.primero = aux;
			this.ultimo = aux;
		} 
		else 
		{
			this.ultimo.setSiguiente(aux);
			this.ultimo = aux;
		}
		aux = null;
		this.tamanio++;
	}

	@Override
	public void agregarPosicion (E e, int posicion) 
	{
		if (posicion < 0 || posicion > tamanio) 
		{
			throw new IndexOutOfBoundsException("Posición fuera de rango: " + posicion);
		}
		
		if (posicion == 0) 
		{
			agregarInicio(e);
		} 
		else  
		{
			if (posicion == tamanio) 
			{
				agregarFinal(e);
			} 
			else 
			{
				Nodo<E> aux = primero;
				for (int i = 0; i < posicion - 1; i++) 
				{
					aux = aux.getSiguiente();
				}
				
				Nodo<E> nuevoNodo = new Nodo<>(aux.getSiguiente(), e);
				aux.setSiguiente(nuevoNodo);
				tamanio++;
			}
		}
	}

	@Override
	public E eliminarElemento () 
	{
		return eliminarElementoFinal ();
	}

	@Override
	public E eliminarElementoInicio () 
	{
		if (esVacia ()) 
		{
			return null;
		}

		E info = primero.getInfo();
		primero = primero.getSiguiente();

		if (primero == null) 
		{
			ultimo = null;
		}
		
		tamanio--;
		return info;
	}

	@Override
	public E eliminarElementoFinal () 
	{
		if (esVacia ()) 
		{
			return null;
		}

		E info = ultimo.getInfo();

		if (primero == ultimo) 
		{
			primero = null;
			ultimo = null;
		} 
		else 
		{
			Nodo<E> aux = primero;
			while (aux.getSiguiente() != ultimo) 
			{
				aux = aux.getSiguiente();
			}

			aux.setSiguiente(null);
			ultimo = aux;
		}

		tamanio--;
		return info;
	}

	@Override
	public E eliminarElementoPosicion (int posicion) 
	{
		if (posicion < 0 || posicion >= tamanio) 
		{
			throw new IndexOutOfBoundsException("Posición fuera de rango: " + posicion);
		}

		if (posicion == 0) 
		{
			return eliminarElementoInicio();
		} 
		else 
		{
			if (posicion == tamanio - 1) 
			{
			return eliminarElementoFinal();
			} 
			else 
			{
				Nodo<E> aux = primero;
				for (int i = 0; i < posicion - 1; i++) 
				{
					aux = aux.getSiguiente();
				}

				Nodo <E> nodoAEliminar = aux.getSiguiente();
				E info = nodoAEliminar.getInfo();
				aux.setSiguiente(nodoAEliminar.getSiguiente());
				tamanio--;
				return info;
			}
		}
	}

	@Override
	public boolean esVacia () 
	{
		return tamanio==0;
	}

	@Override
	public int numElementos () 
	{
		return tamanio;
	}

	@SuppressWarnings ("unchecked")
	
	@Override
	public E[] convertirArreglo () 
	{
		Object[] arreglo = new Object[tamanio];
		Nodo <E> aux = primero;
		for(int i = 0; aux != null; i++)
		{
			arreglo[i] = aux.getInfo ();
			aux = aux.getSiguiente ();
		}

		return (E[]) arreglo;
	}

	@Override
	public E consultar (int posicion) 
	{
		if (posicion < 0 || posicion >= tamanio)
		{
			throw new IndexOutOfBoundsException("Posición fuera de rango: " + posicion);
		}
		
		Nodo<E> aux = primero;
		for (int i = 0; i < posicion; i++) 
		{
			aux = aux.getSiguiente();
		}
		
		return aux.getInfo();
	}
    
	@Override
    public Iterator <E> iterator ()
	{
        return new Iterator <E> ()
		{
            Nodo <E> nodo = primero;
            @Override
            public boolean hasNext () 
			{
                return nodo != null;
            }

            @Override
            public E next () 
			{
                E tmp = nodo.getInfo ();
                nodo = nodo.getSiguiente ();
                return tmp;
            }

        };
    }
	
	@Override
	public void limpiarLista () 
	{
		primero = null;
		ultimo = null;
		tamanio = 0;
	}
}