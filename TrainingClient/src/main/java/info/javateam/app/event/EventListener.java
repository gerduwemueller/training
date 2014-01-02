package info.javateam.app.event;

import java.util.Map;

/**
 * @author Sascha
 *
 */
public interface EventListener {
	
	/**
	 * @param eventName
	 * @param arguments
	 */
	public void fireEvent(String eventName, Map<String, Object> arguments);
}
