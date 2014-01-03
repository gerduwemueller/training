package info.javateam.services;


/**
 * @author Sascha
 *
 * @param <T>
 */
public abstract interface AbstractService<T> {
	/**
	 * Saves an object
	 * @param object
	 */
	public void save(T object);

	/**
	 * Updates an object
	 * @param object
	 */
	public void update(T object);

	/**
	 * Deletes an object
	 * @param object
	 */
	public void delete(T object);
}
