/**
 * 
 */
package com.sickle.medu.ms.client.iportal;

import com.sickle.medu.ms.client.iportal.panel.RegisterPanel;
import com.sickle.medu.ms.client.ui.IPageConst;
import com.sickle.medu.ms.client.ui.page.AbstractPage;
import com.smartgwt.client.widgets.Canvas;


/**
 * 用户注册界面
 * 
 * @author chenhao
 *
 */
public class RegisterPage extends AbstractPage
{

	private static RegisterPage instance = new RegisterPage();
	
	
	public static RegisterPage getInstance()
	{
		return instance;
	}
	
	private RegisterPage()
	{
		super( IPageConst.PAGE_REGISTER );
		init();
	}
	

	private void init( )
	{
		this.setWidth100( );
		this.setHeight100( );

		//上部分
		this.addMember( getDefaultTopPanel() );
		//中间部分
		this.addMember( getRegisterPanel() );
		//下部分
		this.addMember( getDefaultVersionPanel() ) ;
	}
	
	private Canvas getRegisterPanel()
	{
		return new RegisterPanel();
	}

}
