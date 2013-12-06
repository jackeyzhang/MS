/**
 * 
 */
package com.sickle.medu.ms.client.back;

import com.smartgwt.client.types.Side;
import com.smartgwt.client.widgets.tab.TabSet;


/**
 * 主界面tabset
 * 
 * @author chenhao
 *
 */
public class MainPageTabSet extends TabSet
{
	
	public MainPageTabSet()
	{
       	setTabBarPosition(Side.TOP);
        setTabBarAlign(Side.LEFT);
        setWidth100( );
        setHeight100( );
        setBorder( "1px solid blue" );
	}

}
