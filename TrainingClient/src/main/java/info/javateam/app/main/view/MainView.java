package info.javateam.app.main.view;

import info.javateam.app.demo.table.controller.DemoTableController;
import info.javateam.app.demo.tree.controller.DemoTreeController;
import info.javateam.app.event.EventFactory;
import info.javateam.app.event.EventListener;

import java.util.Map;
import java.util.ResourceBundle;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

public class MainView extends JInternalFrame implements EventListener {
	private static final long serialVersionUID = 1L;

	public MainView() {
		EventFactory.addEventListener(this);
		
		ResourceBundle resourceBundle = ResourceBundle.getBundle("MainView");

		setTitle(resourceBundle.getString("Titel"));
		setResizable(false);
		setClosable(false);
		setMaximizable(false);
		setIconifiable(false);
		
		JSplitPane splitPaneTree = new JSplitPane();
		add(splitPaneTree);

		
		DemoTableController controller1 = new DemoTableController();
		DemoTableController controller2 = new DemoTableController();
		
		JTabbedPane tabbedPaneMaster = new JTabbedPane();
		tabbedPaneMaster.add("TabMaster1", new JScrollPane(controller1.getView()));
		tabbedPaneMaster.add("TabMaster2", new JPanel());
		
		JTabbedPane tabbedPaneInfo = new JTabbedPane();
		tabbedPaneInfo.add("TabInfo1", new JScrollPane(controller2.getView()));
		tabbedPaneInfo.add("TabInfo2", new JPanel());
		
		
		JSplitPane splitPaneMaster = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPaneMaster.setOneTouchExpandable(true);
		splitPaneMaster.setDividerLocation(200);
		splitPaneMaster.setTopComponent(tabbedPaneMaster);
		splitPaneMaster.setBottomComponent(tabbedPaneInfo);

		splitPaneTree.setOneTouchExpandable(true);
		splitPaneTree.setDividerLocation(200);
		splitPaneTree.setLeftComponent(new JScrollPane(new DemoTreeController().getView()));
		splitPaneTree.setRightComponent(splitPaneMaster);
	}

	@Override
	public void fireEvent(String eventName, Map<String, Object> arguments) {
		System.out.println("Umschalten auf: " + eventName);
		
	}
}
