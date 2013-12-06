/**
 * 
 */
package com.sickle.medu.ms.client.iportal.page;

import com.google.gwt.user.client.History;
import com.sickle.medu.ms.client.form.ForgetPasswordDform;
import com.sickle.medu.ms.client.iportal.IPageConst;
import com.sickle.medu.ms.client.ui.page.AbstractPage;
import com.sickle.medu.ms.client.ui.util.ScreenUtil;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * 找回密码界面
 * 
 * @author chenhao
 *
 */
public class ForgetPasswordPage extends AbstractPage
{

	private static ForgetPasswordPage instance = new ForgetPasswordPage();
	
	
	public static ForgetPasswordPage getInstance()
	{
		return instance;
	}
	
	private ForgetPasswordPage()
	{
		super( IPageConst.PAGE_FORGETPASSWORD );
		init();
	}
	

	private void init( )
	{
		this.setWidth100( );
		this.setHeight100( );

		//上部分
		this.addMember( getDefaultTopPanel() );
		//中间部分
		this.addMember( getFogetPasswordPanel() );
		//下部分
		this.addMember( getDefaultVersionPanel() ) ;
	}
	
	private Canvas getFogetPasswordPanel()
	{
		HLayout fprpage = new HLayout();
		fprpage.setWidth100( );
		fprpage.setHeight( ScreenUtil.getHeightInt( IPageConst.FP_HEIGHT_PER ) );
		fprpage.setAlign( Alignment.CENTER );
		fprpage.setStyleName( "registerpage" );
		
		VLayout contentpage = new VLayout();
		contentpage.setAlign( VerticalAlignment.CENTER );
		contentpage.setWidth( ScreenUtil.getWidthInt( IPageConst.FP_WIDTH_PER ) );
		contentpage.setHeight( ScreenUtil.getHeightInt( IPageConst.FP_HEIGHT_PER )  );
		contentpage.setStyleName( "registerpage-content" );
		
		HLayout forgetpasswordpanel = new HLayout();
		final ForgetPasswordDform form = new ForgetPasswordDform();
		forgetpasswordpanel.addMember( form );
		
		HLayout buttonpanel = new HLayout();
		buttonpanel.setPadding( 10 );
		buttonpanel.setMembersMargin( 10 );
		buttonpanel.setAlign( Alignment.CENTER );
		
		Button okbutton = new Button("发送");
		okbutton.setWidth( 50 );
		okbutton.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				boolean isValidate = form.validate( );
				if( isValidate == false)
				{
					return;
				}
				form.submit( );
			}
		} );
		
		Button cancelbutton = new Button("返回登陆");
		cancelbutton.setWidth( 50 );
		cancelbutton.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				History.newItem( IPageConst.PAGE_LOGIN );
			}
		} );
		
		buttonpanel.addMember( okbutton );
		buttonpanel.addMember( cancelbutton );
		
		contentpage.addMember( forgetpasswordpanel );
		contentpage.addMember( buttonpanel );
		
		
		fprpage.addMember( contentpage );
		
		return fprpage;
	}

}
