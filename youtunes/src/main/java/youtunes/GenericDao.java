//Generic class to be used for extensibility purposes later

package youtunes;

import java.util.List;

public interface GenericDao<E, K>{
	//default add method
	void add (E entity);
	
	//default list method
	List<E> list();
	
	//default find method
	E find(K key);
	
	//default update method
	void update (E entity);
	
	//default remove method
	void remove (K Key);
}
