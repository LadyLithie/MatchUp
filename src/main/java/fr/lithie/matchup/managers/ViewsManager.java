package fr.lithie.matchup.managers;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import fr.lithie.matchup.controllers.BaseController;
import fr.lithie.matchup.controllers.LoginController;
import fr.lithie.matchup.utils.views.ViewsUtils;

public class ViewsManager {
	//Start Singleton Pattern
	private static ViewsManager instance = null;

	protected ViewsManager() {
		this.frame = new JFrame();
		controllers = new ArrayList<BaseController>();
		currentControllerIndex = 0;
	}

	public static ViewsManager getInstance() {
		if (instance == null) {
			instance = new ViewsManager();
		}
		return instance;
	}
	//End Singleton Pattern

	private JFrame frame;
	private List<BaseController> controllers;
	private int currentControllerIndex;
	private BaseController currentController;
	private Boolean haveBack = false;

	/**
	 * The call start of the visual application
	 * Initialization of the graphic
	 */
	public void start() {
		//generate the first frame with independant attributes
		ViewsUtils.configureFirstJFrame(frame);

		currentController = new LoginController(frame);

		controllers.add(currentController);
		//initialized the eventQueue thread for our frame
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//charge a view
					controllers.get(currentControllerIndex).loadController(
							frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Add a view controller to the pile history of view
	 * @param controller
	 * @return
	 */
	public ViewsManager add(BaseController controller) {
		this.controllers.add(controller);
		return this;
	}

	/**
	 * ActionEvent produce need to a new view
	 * @param controller
	 * @return
	 */
	public ViewsManager next(BaseController controller) {
		System.out.println("go next to " + controller.getView().getPageName());

		if (haveBack) {
			haveBack = false;
			int looper = controllers.size();
			int toRemove = currentControllerIndex + 1;
			for (int i = toRemove; i < looper; i++) {
				controllers.remove(toRemove);
			}
		}
		currentController.onExit();

		controller.setViewDatas(controllers.get(currentControllerIndex)
				.getViewDatas());
		currentController = controller;
		this.controllers.add(currentController);
		currentControllerIndex++;
		executeIntoUI();
		return this;
	}

	/**
	 * Forward behavior to existing view if possible
	 * @return
	 */
	public ViewsManager next() {
		if (canNext()) {
			System.out.println("go next to " + controllers.get(currentControllerIndex + 1).getView().getPageName());

			controllers.get(currentControllerIndex + 1).setViewDatas(
					controllers.get(currentControllerIndex).getViewDatas());
			currentController.onExit();
			currentController = controllers.get(currentControllerIndex + 1);
			currentControllerIndex++;
			executeIntoUI();
		}
		return this;
	}

	/**
	 * Backtracking behavior if possible
	 * @return
	 */
	public ViewsManager back() {
		if (canBack()) {
			System.out.println("go back to " + controllers.get(currentControllerIndex - 1).getView().getPageName());

			haveBack = true;
			controllers.get(currentControllerIndex - 1).setViewDatas(
					controllers.get(currentControllerIndex).getViewDatas());
			currentController.onExit();
			currentController = controllers.get(currentControllerIndex - 1);
			currentControllerIndex--;
			executeIntoUI();
		}
		return this;
	}

	/**
	 * Test possibility to return to a previous view
	 * @return
	 */
	public Boolean canBack() {
		if (controllers.size() - 1 >= 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Test possibility to go to a following view
	 * @return
	 */
	public Boolean canNext() {
		if (controllers.size() > currentControllerIndex + 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * For every element, allow to invoke it at the current level
	 */
	public void executeIntoUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					controllers.get(currentControllerIndex).loadController(
							frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
