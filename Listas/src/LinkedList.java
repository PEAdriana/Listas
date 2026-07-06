import java.util.Iterator;


public class LinkedList<E> implements Lista<E> {


    private class Nodo<E> {

        private Nodo<E> siguiente= null;
        
        private E info=null;
    
        Nodo(Nodo<E> siguiente, E info) {
            this.siguiente = siguiente;
            this.info = info;
        }
    
        Nodo<E> getSiguiente() {
            return siguiente;
        }
    
        void setSiguiente(Nodo<E> siguiente) {
            this.siguiente = siguiente;
        }
    
        E getInfo() {
            return info;
        }
    
        void setInfo(E info) {
            this.info = info;
        }
    }

	private Nodo<E> primero=null; 
	private Nodo<E> ultimo=null; 		
	private int tamanio=0;


	@Override
	public void agregarElemento(E e) {



	}

	@Override
	public void agregarInicio(E e) {

	}

	@Override
	public void agregarFinal(E e) {
	

	}

	@Override
	public void agregarPosicion(E e, int posicion) {


	}

	@Override
	public E eliminarElemento() {
		
		return eliminarElementoFinal();
		
	}

	@Override
	public E eliminarElementoInicio() {

	}

	@Override
	public E eliminarElementoFinal() {

	}

	@Override
	public E eliminarElementoPosicion(int posicion) {
	
	}

	@Override
	public boolean esVacia() {
		return tamanio==0;
	}

	@Override
	public int numElementos() {
		// TODO Auto-generated method stub
		return tamanio;
	}

	@Override
	public void limpiarLista() {
	

	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] convertirArreglo() {

		Object[] arreglo = new Object[tamanio];
		Nodo<E> aux = primero;
		for(int i=0;aux!=null;i++){
			arreglo[i]=aux.getInfo();
			aux = aux.getSiguiente();
		}

		return (E[])arreglo;
	}

	@Override
	public E consultar(int posicion) {
		
	}
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>(){

            Nodo<E> nodo= primero;
            @Override
            public boolean hasNext() {
                return nodo!=null;
            }

            @Override
            public E next() {
                E tmp=nodo.getInfo();
                nodo=nodo.getSiguiente();
                return tmp;
            }

        };
    }

}



