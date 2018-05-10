

/**
 * 
 * @author BALTACI , LANGARD , MBONGO PASSI
 *
 */

public class Maillon<T> {
	
	public Maillon<T> next;
	public T info;
	
	
	/**
	 * 
	 * @param t : représente le type de l'information du maillon
	 */
	public Maillon(T t) {
		
	
		this.info=t;
		this.next = null;
}
}