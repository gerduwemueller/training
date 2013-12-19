package info.javateam.dao;



abstract public interface AbstractDao<T> {
	/**
	 * Saves a Domain Object
	 * @param object
	 */
	abstract public void save(T object);

	/**
	 * Updates a Domain Object
	 * @param object
	 */
	abstract public void update(T object);

	/**
	 * Deletes a Domain Object
	 * @param object
	 */
	abstract public void delete(T object);

}
