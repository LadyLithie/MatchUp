package fr.lithie.matchup.controllers;

import javax.swing.JFrame;
/**
 * Allow to have an interface for future development
 * @author Audrey
 *
 */
public interface IBaseController {
	/**
	 * Load controller in the graphic context
	 * @param frame
	 * @return
	 */
	public BaseController loadController(JFrame frame);
	/**
	 * Maj on event link to view
	 */
	public void initEvent();
	/**
	 * Maj of datas
	 */
	public void initView();
	/**
	 * manage informations that we want to allow to transit
	 */
	public void setupDatas();
	/**
	 * Action to do on exit of the view
	 */
	public void onExit();
	/**
	 * 
	 */
	public void onEnter();
}
