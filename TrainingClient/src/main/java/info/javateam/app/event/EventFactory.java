package info.javateam.app.event;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventFactory {

	private static List<EventListener> list = new ArrayList<EventListener>();

	/**
	 * @param eventListener
	 */
	public static void addEventListener(EventListener eventListener) {
		list.add(eventListener);
	}

	/**
	 * @param eventListener
	 */
	public static void removeEventListener(EventListener eventListener) {
		list.remove(eventListener);
	}

	/**
	 * @param eventName
	 * @param arguments
	 */
	public static void fireEvent(String eventName, Map<String, Object> arguments) {
		for (EventListener eventListener : list) {
			eventListener.fireEvent(eventName, arguments);
		}
	}

}
