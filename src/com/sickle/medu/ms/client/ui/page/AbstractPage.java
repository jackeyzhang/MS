/**
 * 
 */
package com.sickle.medu.ms.client.ui.page;

import com.smartgwt.client.widgets.layout.Layout;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * 抽象的page
 * 
 * 提供history管理功能
 * 
 * @author chenhao
 *
 */
public abstract class AbstractPage extends VLayout
{
	
	private String tokenhistory = "";
	
	public AbstractPage(final String token)
	{
		this.tokenhistory = token;
	}

	
	/**
	 * @return the token
	 */
	public String getToken( )
	{
		return tokenhistory;
	}
	
	public Layout getPage()
	{
		return this;
	}
	
}
