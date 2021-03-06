/**
 * 
 */

package com.sickle.medu.ms.client.iportal.page;

import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Anchor;
import com.sickle.medu.ms.client.form.LoginDform;
import com.sickle.medu.ms.client.iportal.IPageConst;
import com.sickle.medu.ms.client.iportal.banner.AdvertBanner;
import com.sickle.medu.ms.client.rpc.UserManageService;
import com.sickle.medu.ms.client.rpc.UserManageServiceAsync;
import com.sickle.medu.ms.client.ui.page.AbstractPage;
import com.sickle.medu.ms.client.ui.util.AsyncCallbackWithStatus;
import com.sickle.medu.ms.client.ui.util.ScreenUtil;
import com.sickle.medu.ms.client.ui.widget.button.MButton;
import com.sickle.medu.ms.client.ui.widget.label.H1Gray;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
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
		middlepanel.setHeight( 450 );

		// banner
		VLayout banner = new VLayout( );
		banner.setStyleName( "loginpage_bannerpanel" );
		banner.setHeight100( );
		banner.addMember( new AdvertBanner( 0.65, 0.33 ) );
		middlepanel.addMember( banner );
		
		// 登陆panel
		VLayout loginpanel = new VLayout( );
		loginpanel.setWidth( ScreenUtil.getWidth( 0.29 ) );
		loginpanel.setHeight( 450 );
		middlepanel.addMember( loginpanel );

		// 欢迎词
		HLayout welcomepanel = new HLayout();
		welcomepanel.setHeight( 100);
		H1Gray welcome = new H1Gray( "欢迎登录爱师网" );
		welcome.setWidth(  ScreenUtil.getWidth( 0.3 ) );
		welcomepanel.setPadding( 20 );
		welcomepanel.setWidth(  ScreenUtil.getWidth( 0.3 ) );
		welcomepanel.setAlign( Alignment.CENTER );
		welcomepanel.addMember( welcome );
		loginpanel.addMember( welcomepanel );
		
		// 登陆对话框的表单
		loginform = new LoginDform( );
		String cachename = Cookies.getCookie( "medu-remeber-name");
		if( cachename != null )
		{
			loginform.setValue( "name", cachename );
		}
		loginpanel.addMember( loginform );

		
		//记住用户名 忘记密码
		HLayout forgetpasswordPanel = new HLayout();
		forgetpasswordPanel.setHeight(50);
		forgetpasswordPanel.setWidth( ScreenUtil.getWidth( 0.3 ) );
		forgetpasswordPanel.setAlign( Alignment.CENTER );
		forgetpasswordPanel.setMembersMargin( 10 );
		
		DynamicForm remform = new DynamicForm();
		final CheckboxItem remembername = new CheckboxItem( "remeber" );
		remembername.setTitle( "记住用户名" );
		if( cachename != null )
		{
			remembername.setValue( true );
		}
		remform.setFields( remembername );
		
		remembername.addChangedHandler( new ChangedHandler( ) {
			@Override
			public void onChanged( ChangedEvent event )
			{
				boolean ischeck = remembername.getValueAsBoolean( );
				if( ischeck )
				{
					Cookies.setCookie( "medu-remeber", "yes" );
				}
				else
				{
					Cookies.removeCookie( "medu-remeber" );
				}
			}
		} );
		
		Anchor forgetpassword = new Anchor( "忘记密码" );
		forgetpassword.setHeight("20px");
		forgetpassword.addClickHandler( new com.google.gwt.event.dom.client.ClickHandler( ) {

			@Override
			public void onClick(
					com.google.gwt.event.dom.client.ClickEvent event )
			{
				History.newItem( IPageConst.PAGE_FORGETPASSWORD );
			}
		} );

		forgetpasswordPanel.addMember( remform );
		
		VLayout fpwd = new VLayout();
		fpwd.setWidth( 60 );
		fpwd.setHeight( 30 );
		fpwd.setAlign(VerticalAlignment.CENTER);
		fpwd.addMember(forgetpassword);
		
		forgetpasswordPanel.addMember( fpwd );
		loginpanel.addMember( forgetpasswordPanel );
		
		// 登陆对话框的登陆按钮
		HLayout formlayout = new HLayout( );
		formlayout.setWidth( ScreenUtil.getWidth( 0.3 ) );
		formlayout.setHeight( 30);
		formlayout.setAlign( Alignment.CENTER );
		formlayout.setMembersMargin( 10 );
		
		MButton loginButton = new MButton( "登录" ){
			@Override
			public void handleClick( )
			{
				boolean validate = loginform.validate( );
				if ( validate )
				{
					commitform( );
				}				
			}
			
		};
		loginButton.setWidth( 60 );

		MButton register = new MButton( "新用户注册" ){
			@Override
			public void handleClick( )
			{
				History.newItem( IPageConst.PAGE_REGISTER );
			}
		};
		register.setWidth( "70px" );
		
		formlayout.addMember( loginButton );
		formlayout.addMember( register );
		
		loginpanel.addMember( formlayout );
		
		
		HLayout loginresultpanel = new HLayout();
		loginresultpanel.setWidth100( );
		loginresultpanel.setHeight( 30);
		loginresultpanel.setAlign( Alignment.CENTER );
		
		loginResult = new Label("");
		loginResult.setWidth( 200 );
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
				new AsyncCallbackWithStatus<Member>( loginResult ) {
			
					@Override
					protected void callingshow( )
					{
						loginResult.setStyleName( "loginpage_logininglabel" );
						loginResult.setContents( "登录中..." );
					}

					@Override
					public void call( Member member )
					{
						if ( member != null )
						{
							//登陆成功 保存用户名
							Cookies.removeCookie( "medu-remeber-name" );
							if( Cookies.getCookie( "medu-remeber" ) != null && 
									Cookies.getCookie( "medu-remeber" ).equalsIgnoreCase( "yes" ))
							{
								Cookies.setCookie( "medu-remeber-name", loginform.getValueAsString( "name" ) );
							}
							freshpage( member );
							//登录完毕 清空密码
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

	private void freshpage( Member member )
	{
		History.newItem( IPageConst.PAGE_MEDU );
		IndexPage.getInstance( ).getTopbar( ).setMember( member );
		callback( );
	}

	protected void callback( )
	{
	}
}
