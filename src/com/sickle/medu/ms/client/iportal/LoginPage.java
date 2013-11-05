/**
 * 
 */
package com.sickle.medu.ms.client.iportal;

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
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * @author chenhao
 *
 */
public class LoginPage extends AbstractPage
{

	private static LoginPage instance = new LoginPage();
	
	private LoginDform loginform;
	
	public static LoginPage getInstance()
	{
		return instance;
	}
	
	private LoginPage()
	{
		super( IPageConst.PAGE_LOGIN );
		init();
	}
	
	public void clear()
	{
		if( this.isCreated( ))
		{
			super.clear( );
		}
	}

	private void init( )
	{
		this.setWidth100(  );
		this.setHeight100( );

		//上部分
		HLayout toppanel = new HLayout();
		toppanel.setWidth100( );
		toppanel.setHeight( 100 );
		addMember( toppanel );
		
		//中间部分
		HLayout middlepanel = new HLayout();
		middlepanel.setStyleName( "loginpage_middlepanel" );
		middlepanel.setWidth100( );
		middlepanel.setHeight( 400 );
		addMember( middlepanel );
		
		//banner
		VLayout banner = new VLayout();
		banner.setWidth100( );
		banner.setHeight100(  );
		banner.addMember( new AdvertBanner(0.7,0.3) );
		middlepanel.addMember( banner );
		
		//登陆panel
		VLayout loginpanel = new VLayout();
		loginpanel.setPadding( 15 );
		loginpanel.setWidth( ScreenUtil.getWidth( 0.3 ) );
		loginpanel.setHeight( ScreenUtil.getHeight( 0.3 ) );
		middlepanel.addMember( loginpanel );
		
		// 登陆对话框的表单
		loginform = new LoginDform( );
		loginpanel.addMember( loginform );

		// 登陆对话框的登陆按钮
		HLayout formlayout = new HLayout( );
		formlayout.setWidth( ScreenUtil.getWidth( 0.3 ) );
		formlayout.setHeight( ScreenUtil.getHeight( 0.3 ) );
		formlayout.setAlign( Alignment.CENTER );
		formlayout.setMembersMargin( 10 );
		Button loginButton = new Button( "登录" );
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
			public void onClick( com.google.gwt.event.dom.client.ClickEvent event )
			{
				SC.say( "注册界面" );
			}
		} );
		
		formlayout.addMember( loginButton );
		formlayout.addMember( register );
		loginpanel.addMember( formlayout );
		
	}

	/**
	 * 提交登陆表单
	 */
	private void commitform( )
	{
		String username = loginform.getUsername( ).getValue( ).toString( );
		String password = loginform.getPassword( ).getValue( ).toString( );
		UserManageServiceAsync service = (UserManageServiceAsync)UserManageService.Util.getInstance( );
		service.login( username, password, new AsyncCallbackWithStatus<Boolean>( "登录中..." ) {
			@Override
			public void call( Boolean result )
			{
				if( result )
				{
					freshpage();
				}
				else
				{
					SC.say( "用户名或密码错误!" );
				}
			}
			
		} );
		
	}
	
	
	private void freshpage()
	{
		MeduIndexPage.getInstance( ).getTopbar( ).getWelcome( ).setContents( loginform.getUsername( ).getValue( ).toString( ) );
		callback();
	}

	protected void callback(){}
}
