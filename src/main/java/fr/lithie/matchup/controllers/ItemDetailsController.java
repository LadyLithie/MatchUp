package fr.lithie.matchup.controllers;

import javax.swing.JFrame;

import fr.lithie.matchup.entities.User;
import fr.lithie.matchup.views.ItemDetailsView;

public class ItemDetailsController extends BaseController {

	public ItemDetailsController(JFrame frame) {
		super.frame = frame;
		super.view = new ItemDetailsView();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see imiepoecjava2017.controllers.BaseController#initView()
	 */
	@Override
	public void initView() {
		((ItemDetailsView) getView()).getMenuBar().getNavigationBar().setupEvents();

		((ItemDetailsView) getView())
				.getMenuBar()
				.getLblUserName()
				.setText(
						((User) this.viewDatas.get(ViewsDatasTerms.CURRENT_USER))
								.getName());
		
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see imiepoecjava2017.controllers.BaseController#onExit()
	 */
	@Override
	public void onExit() {
		((ItemDetailsView) getView()).getMenuBar().getNavigationBar()
				.resetEvents();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see imiepoecjava2017.controllers.BaseController#onEnter()
	 */
	@Override
	public void onEnter() {
	}

}
