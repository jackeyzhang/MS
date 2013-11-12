/**
 * 
 */
package com.sickle.medu.ms.client.ui.tabpanel;

import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.tab.Tab;


/**
 * 抽象tab
 * 
 * @author chenhao
 *
 */
public abstract class AbstractTab extends Tab
{

	/**
	 * 构造器
	 * @param title
	 * @param icon
	 */
	public AbstractTab( )
	{
		super( );
	}
	
	
	/**
	 * 构造器
	 * @param title
	 * @param icon
	 */
	public AbstractTab( String title, String icon ,boolean canClose)
	{
		super( title, icon );
		this.setCanClose( canClose );
		this.setPane( getPanel() );
	}

	/**
	 * 获取tab的panel
	 * 
	 * @return
	 */
	public abstract Canvas getPanel();
}
