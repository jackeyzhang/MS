/**
 * 
 */

package com.sickle.medu.ms.client.iportal.dialog;

import com.sickle.medu.ms.client.form.LoginDform;
import com.sickle.medu.ms.client.iportal.IPageConst;
import com.sickle.medu.ms.client.iportal.page.IndexPage;
import com.sickle.medu.ms.client.rpc.UserManageService;
import com.sickle.medu.ms.client.rpc.UserManageServiceAsync;
import com.sickle.medu.ms.client.ui.dialog.AbstractDialog;
import com.sickle.medu.ms.client.ui.util.AsyncCallbackWithStatus;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
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
public class LoginDialog extends AbstractDialog
{

	private LoginDform loginform;
	

	public LoginDialog( )
	{
		super( IPageConst.SITE_NAME, false, false, false );
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
		img.setHoverWidth( 120 );
		img.setHoverOpacity( 75 );
		img.setHoverStyle( "interactImageHover" );
		layout.addMember( img );

		// 登陆对话框的表单
		loginform = new LoginDform( );
		layout.addMember( loginform );

		// 登陆对话框的登陆按钮
		HLayout formlayout = new HLayout( );
		formlayout.setPadding( 20 );
		formlayout.setWidth100( );
		formlayout.setHeight100( );
		formlayout.setAlign( Alignment.CENTER );
		formlayout.setMembersMargin( 10 );
		IButton loginButton = new IButton( "登录" );
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
		IButton cancelButton = new IButton( "取消" );
		cancelButton.addClickHandler( new ClickHandler( ) {

			@Override
			public void onClick( ClickEvent event )
			{
					hide( );
			}
		} );
		formlayout.addMember( loginButton );
		formlayout.addMember( cancelButton );
		
		layout.addMember( formlayout );

		return layout;
	}

	/**
	 * 提交登陆表单
	 */
	private void commitform( )
	{
		String username = loginform.getUsername( ).getValue( ).toString( );
		String password = loginform.getPassword( ).getValue( ).toString( );
		UserManageServiceAsync service = (UserManageServiceAsync)UserManageService.Util.getInstance( );
		service.login( username, password, new AsyncCallbackWithStatus<Member>( "登录中..." ) {
			@Override
			public void call( Member result )
			{
				if( result != null )
				{
					freshpage(result);
				}
				else
				{
					SC.say( "用户名或密码错误!" );
				}
			}
			
		} );
		
	}
	
	
	private void freshpage( Member member )
	{
		IndexPage.getInstance( ).getTopbar( ).setMember( member );
		callback();
	}

	protected void callback(){}
}
