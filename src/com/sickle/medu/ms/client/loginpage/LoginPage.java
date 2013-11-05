/**
 * 
 */
package com.sickle.medu.ms.client.loginpage;

import com.sickle.medu.ms.client.ui.IPageConst;
import com.sickle.medu.ms.client.ui.page.AbstractPage;
import com.sickle.medu.ms.client.ui.widget.LinkLabel;


/**
 * @author chenhao
 *
 */
public class LoginPage extends AbstractPage
{

	private static LoginPage instance = new LoginPage();
	
	public static LoginPage getInstance()
	{
		return instance;
	}
	
	private LoginPage()
	{
		super( IPageConst.PAGE_LOGIN );
		init();
	}
	
	private void init()
	{
		addMember( new LinkLabel("Test login page") );
	}
	
	public void clear()
	{
		if( this.isCreated( ))
		{
			super.clear( );
		}
	}

}
