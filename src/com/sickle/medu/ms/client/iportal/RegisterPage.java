/**
 * 
 */
package com.sickle.medu.ms.client.iportal;

import com.google.gwt.user.client.History;
import com.sickle.medu.ms.client.form.RegisterDform;
import com.sickle.medu.ms.client.ui.IPageConst;
import com.sickle.medu.ms.client.ui.page.AbstractPage;
import com.sickle.medu.ms.client.util.ScreenUtil;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.BooleanCallback;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


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
		HLayout registerpage = new HLayout();
		registerpage.setWidth100( );
		registerpage.setHeight( ScreenUtil.getHeightInt( IPageConst.REGISTER_HEIGHT_PER ) );
		registerpage.setAlign( Alignment.CENTER );
		registerpage.setStyleName( "registerpage" );
		
		VLayout contentpage = new VLayout();
		contentpage.setWidth( ScreenUtil.getWidthInt( IPageConst.REGISTER_WIDTH_PER ) );
		contentpage.setHeight( ScreenUtil.getHeightInt( IPageConst.REGISTER_HEIGHT_PER )  );
		contentpage.setStyleName( "registerpage-content" );
		
		final RegisterDform registerform = new RegisterDform( ScreenUtil.getWidthInt( IPageConst.REGISTER_WIDTH_PER ) );
		contentpage.addMember( registerform );
		
		HLayout buttonpanel = new HLayout();
		buttonpanel.setPadding( 10 );
		buttonpanel.setMembersMargin( 10 );
		buttonpanel.setAlign( Alignment.CENTER );
		
		Button okbutton = new Button("注册");
		okbutton.setWidth( 50 );
		okbutton.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				boolean isValidate = registerform.validate( );
				if( isValidate == false)
				{
					return;
				}
				registerform.submit( );
				SC.say( "注册成功", new BooleanCallback( ) {
					@Override
					public void execute( Boolean value )
					{
						History.newItem( IPageConst.PAGE_MEDU );
					}
				} );
				
			}
		} );
		
		Button cancelbutton = new Button("返回首页");
		cancelbutton.setWidth( 50 );
		cancelbutton.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				registerform.cancel( );
				History.newItem( IPageConst.PAGE_MEDU );
			}
		} );
		
		buttonpanel.addMember( okbutton );
		buttonpanel.addMember( cancelbutton );
		contentpage.addMember( buttonpanel );
		
		registerpage.addMember( contentpage );
		
		return registerpage;
	}

}
