//Generic class to be used for extensibility purposes later

package youtunes;

import java.util.List;

public interface GenericDao<E, K>{
	void add (E entity);
	
	List<E> list();
	
	E find(K key);
	
	void update (E entity);
	
	void remove (K Key);
}
