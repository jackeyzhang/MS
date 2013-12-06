/**
 * 
 */

package com.sickle.medu.ms.client.back;

import com.sickle.medu.ms.client.form.LoginDform;
import com.sickle.medu.ms.client.ui.MainPagePanel;
import com.sickle.medu.ms.client.ui.dialog.AbstractDialog;
import com.sickle.medu.ms.client.ui.tabpanel.MainPageTab;
import com.sickle.medu.ms.client.ui.tabpanel.WebSiteEditTab;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * 登陆对话框
 * 
 * @author chenhao
 * 
 */
public class UILoginDialog extends AbstractDialog
{

	private LoginDform loginform;
	
	private static UILoginDialog instance = new UILoginDialog();
	
	public static UILoginDialog getInstance()
	{
		return instance;
	}

	private UILoginDialog( )
	{
		super( "medu welcome-打造中国最好的教育办公系统", false, false, false );
	}

	@Override
	public Canvas getView( )
	{
		VLayout layout = new VLayout( );
		layout.setWidth( 360 );
		layout.setHeight( 270 );

		// 登陆对话框的图片
		Img img = new Img( "other/eyes.jpg");
		img.setWidth( 360 );
		img.setHeight( 180 );
		img.setPrompt( "360px by 188px<BR>25k<BR>JPEG high quality" );
		img.setHoverWidth( 120 );
		img.setHoverOpacity( 75 );
		img.setHoverStyle( "interactImageHover" );
		layout.addMember( img );

		// 登陆对话框的表单
		loginform = new LoginDform( );
		layout.addMember( loginform );

		// 登陆对话框的登陆按钮
		HLayout formlayout = new HLayout( );
		formlayout.setWidth100( );
		formlayout.setHeight100( );
		formlayout.setAlign( Alignment.CENTER );
		IButton loginButton = new IButton( "登陆" );
		loginButton.addClickHandler( new ClickHandler( ) {

			@Override
			public void onClick( ClickEvent event )
			{
				boolean validate = loginform.validate( );
				if ( validate )
				{
					commitform( );
					hide( );
				}
			}
		} );
		formlayout.addMember( loginButton );
		layout.addMember( formlayout );

		return layout;
	}

	/**
	 * 提交登陆表单
	 */
	private void commitform( )
	{
//		Object username = 
				loginform.getUsername( ).getValue( );
//		Object password = 
				loginform.getPassword( ).getValue( );
		initMainPage();
	}
	
	
	private void initMainPage()
	{
		MainPagePanel mainpage = MainPagePanel.getInstance( );
		mainpage.getTabset( ).addTab( new MainPageTab() );
		mainpage.getTabset( ).addTab( new WebSiteEditTab() );
		mainpage.draw( );
	}

}
