package fr.lithie.matchup.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import fr.lithie.matchup.views.base.BaseView;

public abstract class BaseController implements IBaseController {
	protected JFrame frame;
	protected BaseView view;
	/**
	 * Container of datas
	 */
	protected Map<String,Object> viewDatas = new HashMap<String, Object>();

	/**
	 * getter
	 * @return the view
	 */
	public BaseView getView() {
		return view;
	}

	/**
	 * setter
	 * @param viewDatas the viewDatas to set
	 */
	public void setViewDatas(Map<String, Object> viewDatas) {
		this.viewDatas = viewDatas;
	}

	/**
	 * getter
	 * @return the viewDatas
	 */
	public Map<String, Object> getViewDatas() {
		return viewDatas;
	}

	//Interface functions
	//*******************
	@Override
	public BaseController loadController(JFrame frame) {
		getView().loadView(frame);
		initView();
		initEvent();
		setupDatas();
		return this;
	}

	/**
	 * set the basic information I want to see in my view
	 */
	@Override
	public void initView() {
	}

	/**
	 * Add or update transverse objects such as user
	 */
	@Override
	public void setupDatas() {
	}

	/**
	 * Set the action done when an event happen
	 */
	/* (non-Javadoc)
	 * @see imiepoecjava2017.controllers.IBaseController#initEvent()
	 */
	@Override
	public void initEvent() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Actions at the exit of a view
	 */
	/* (non-Javadoc)
	 * @see imiepoecjava2017.controllers.IBaseController#onExit()
	 */
	@Override
	public void onExit() {

	}

	/**
	 * Actions at the entry of a view
	 */
	/* (non-Javadoc)
	 * @see imiepoecjava2017.controllers.IBaseController#onEnter()
	 */
	@Override
	public void onEnter() {
		// TODO Auto-generated method stub

	}
}
