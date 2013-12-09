/**
 * 
 */
package com.sickle.medu.ms.client.back;

import com.sickle.medu.ms.client.iportal.panel.IndexPageTopPanel;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * MS main panel
 * 
 * @author chenhao
 *
 */
public class MainPagePanel extends VLayout
{
	private IndexPageTopPanel topbar;
	
	private MainPageToolBar toolbar;
	
	private MainPageTabSet tabset;

	private static MainPagePanel instance;
	
	public static MainPagePanel getInstance()
	{
		if( instance == null )
		{
			instance = new MainPagePanel( );
		}
		return instance;
	}
	
	private MainPagePanel()
	{
		setWidth100( );
		setHeight100( );
		
		topbar = new IndexPageTopPanel();
		toolbar = new MainPageToolBar();
		tabset = new MainPageTabSet();
		
		addMember( topbar );
		addMember( toolbar );
		addMember( tabset );
	}

	
	/**
	 * @return the topbar
	 */
	public IndexPageTopPanel getTopbar( )
	{
		return topbar;
	}

	
	/**
	 * @return the toolbar
	 */
	public MainPageToolBar getToolbar( )
	{
		return toolbar;
	}

	
	/**
	 * @return the tabset
	 */
	public MainPageTabSet getTabset( )
	{
		return tabset;
	}
}
