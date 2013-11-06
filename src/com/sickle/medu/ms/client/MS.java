
package com.sickle.medu.ms.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.sickle.medu.ms.client.iportal.LoginPage;
import com.sickle.medu.ms.client.iportal.MeduIndexPage;
import com.sickle.medu.ms.client.iportal.RegisterPage;
import com.sickle.medu.ms.client.ui.IPageConst;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MS implements EntryPoint
{


	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad( )
	{
		initHistoryMange();
		History.newItem( IPageConst.PAGE_LOGIN );
	}
	
	public void initHistoryMange()
	{
		History.addValueChangeHandler( new ValueChangeHandler<String>( ) {
			@Override
			public void onValueChange( ValueChangeEvent<String> event )
			{
				if(event.getValue( ).equalsIgnoreCase( IPageConst.PAGE_MEDU ))
				{
					LoginPage.getInstance( ).clear( );
					RegisterPage.getInstance( ).clear( );
					MeduIndexPage.getInstance( ).draw( );
				}
				else if(event.getValue( ).equalsIgnoreCase( IPageConst.PAGE_LOGIN ))
				{
					MeduIndexPage.getInstance( ).clear( );
					RegisterPage.getInstance( ).clear( );
					LoginPage.getInstance( ).draw( );
				}
				else if(event.getValue( ).equalsIgnoreCase( IPageConst.PAGE_REGISTER ))
				{
					MeduIndexPage.getInstance( ).clear( );
					LoginPage.getInstance( ).clear( );
					RegisterPage.getInstance( ).draw( );
				}
				else if(event.getValue( ).startsWith( IPageConst.PAGE_MEMBER ))
				{
					MeduIndexPage.getInstance( ).clear( );
					LoginPage.getInstance( ).clear( );
					RegisterPage.getInstance( ).clear( );
					//TODO 提供memberid 显示对应member界面或提示先注册或登录
					
				}
				else
				{
					History.newItem( IPageConst.PAGE_LOGIN );
				}
			}
		} );
	}
}
