/**
 * 
 */

package com.sickle.medu.ms.client.iportal;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Anchor;
import com.sickle.medu.ms.client.form.LoginDform;
import com.sickle.medu.ms.client.iportal.banner.AdvertBanner;
import com.sickle.medu.ms.client.rpc.UserManageService;
import com.sickle.medu.ms.client.rpc.UserManageServiceAsync;
import com.sickle.medu.ms.client.ui.IPageConst;
import com.sickle.medu.ms.client.ui.page.AbstractPage;
import com.sickle.medu.ms.client.util.AsyncCallbackWithStatus;
import com.sickle.medu.ms.client.util.ScreenUtil;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * 登录页面
 * 
 * @author chenhao
 * 
 */
public class LoginPage extends AbstractPage
{

	private static LoginPage instance = new LoginPage( );

	private LoginDform loginform;
	
	private Label loginResult;

	public static LoginPage getInstance( )
	{
		return instance;
	}

	private LoginPage( )
	{
		super( IPageConst.PAGE_LOGIN );
		init( );
	}

	private void init( )
	{
		this.setWidth100( );
		/*this.setHeight100( );*/

		// 上部分
		addMember( getDefaultTopPanel() );

		//中间部分
		addMember( getMiddlePanel() );
		
		//下部分
		addMember( getDefaultVersionPanel() ) ;
	}
	
	private Canvas getMiddlePanel()
	{
		// 中间部分
		HLayout middlepanel = new HLayout( );
		middlepanel.setStyleName( "loginpage_middlepanel" );
		middlepanel.setHeight( 400 );

		// banner
		VLayout banner = new VLayout( );
		banner.setStyleName( "loginpage_bannerpanel" );
		banner.setHeight100( );
		banner.addMember( new AdvertBanner( 0.7, 0.3 ) );
		middlepanel.addMember( banner );
		
		// 登陆panel
		VLayout loginpanel = new VLayout( );
		loginpanel.setWidth( ScreenUtil.getWidth( 0.29 ) );
		loginpanel.setHeight( ScreenUtil.getHeight( 0.3 ) );
		middlepanel.addMember( loginpanel );

		// 欢迎词
		HLayout welcomepanel = new HLayout();
		Label welcome = new Label( "欢迎登录爱师网" );
		welcome.setStyleName( "sgwtTitle" );
		welcome.setWidth(  ScreenUtil.getWidth( 0.1 ) );
		welcomepanel.setPadding( 20 );
		welcomepanel.setWidth(  ScreenUtil.getWidth( 0.29 ) );
		welcomepanel.setAlign( Alignment.CENTER );
		welcomepanel.addMember( welcome );
		loginpanel.addMember( welcomepanel );
		// 登陆对话框的表单
		loginform = new LoginDform( );
		loginpanel.addMember( loginform );

		// 登陆对话框的登陆按钮
		HLayout formlayout = new HLayout( );
		formlayout.setWidth( ScreenUtil.getWidth( 0.29 ) );
		formlayout.setAlign( Alignment.CENTER );
		formlayout.setMembersMargin( 10 );
		IButton loginButton = new IButton( "登录" );
		loginButton.setWidth( 60 );
		loginButton.setShowRollOver(true);  
		loginButton.setShowDown(true);  
		loginButton.addClickHandler( new ClickHandler( ) {

			@Override
			public void onClick( ClickEvent event )
			{
				boolean validate = loginform.validate( );
				if ( validate )
				{
					commitform( );
				}
			}
		} );

		Anchor register = new Anchor( "新用户注册" );
		register.addClickHandler( new com.google.gwt.event.dom.client.ClickHandler( ) {

			@Override
			public void onClick(
					com.google.gwt.event.dom.client.ClickEvent event )
			{
				History.newItem( IPageConst.PAGE_REGISTER );
			}
		} );

		formlayout.addMember( loginButton );
		formlayout.addMember( register );
		loginpanel.addMember( formlayout );

		
		loginResult = new Label("");
		loginResult.setWidth( 200 );
		
		loginpanel.addMember( formlayout );
		
		HLayout loginresultpanel = new HLayout();
		loginresultpanel.setWidth100( );
		loginresultpanel.setAlign( Alignment.CENTER );
		loginresultpanel.addMember( loginResult );
		
		
		loginpanel.addMember( loginresultpanel );
				
		return middlepanel;
	}

	/**
	 * 提交登陆表单
	 */
	private void commitform( )
	{
		String username = loginform.getUsername( ).getValue( ).toString( );
		String password = loginform.getPassword( ).getValue( ).toString( );
		UserManageServiceAsync service = (UserManageServiceAsync) UserManageService.Util
				.getInstance( );
		service.login( username, password,
				new AsyncCallbackWithStatus<Boolean>( loginResult ) {
			
					@Override
					protected void callingshow( )
					{
						loginResult.setStyleName( "loginpage_logininglabel" );
						loginResult.setContents( "登录中..." );
					}

					@Override
					public void call( Boolean result )
					{
						if ( result )
						{
							freshpage( );
							//登录完毕 清空密码
							loginform.getUsername( ).clearValue( );
							loginform.getPassword( ).clearValue( );
							loginResult.setContents( "" );
						}
						else
						{
							loginResult.setStyleName( "loginpage_loginfailedlabel" );
							loginResult.setContents( "用户名或密码错误!" );
						}
					}

				} );

	}

	private void freshpage( )
	{
		History.newItem( IPageConst.PAGE_MEDU );
		MeduIndexPage.getInstance( ).getTopbar( ).getWelcome( )
				.setContents( "用户:" + loginform.getUsername( ).getValue( ).toString( ) );
		callback( );
	}

	protected void callback( )
	{
	}
}
