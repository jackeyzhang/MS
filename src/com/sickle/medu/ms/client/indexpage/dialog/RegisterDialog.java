/**
 * 
 */
package com.sickle.medu.ms.client.indexpage.dialog;

import com.sickle.medu.ms.client.datasource.MemberDataSource;
import com.sickle.medu.ms.client.form.RegisterDform;
import com.sickle.medu.ms.client.ui.dialog.AbstractDialog;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Button;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * 注册对话框
 * 
 * @author chenhao
 *
 */
public class RegisterDialog extends AbstractDialog
{
	
	private static final String TITLE = "新用户注册";

	public RegisterDialog()
	{
		super( TITLE );
	}

	@Override
	public Canvas getView( )
	{
		VLayout mainpanel = new VLayout();
		mainpanel.setWidth100( );
		mainpanel.setHeight100( );
		final RegisterDform registerform = new RegisterDform();
		mainpanel.addMember( registerform );
		
		HLayout buttonpanel = new HLayout();
		buttonpanel.setAlign( Alignment.CENTER );
		buttonpanel.setWidth100( );
		
		Button okbutton = new Button("注册");
		okbutton.setWidth( 50 );
		okbutton.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				registerform.submit( );
				hide();
			}
		} );
		Button cancelbutton = new Button("取消");
		cancelbutton.setWidth( 50 );
		cancelbutton.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				registerform.cancel( );
				hide();
			}
		} );
		
		buttonpanel.addMember( okbutton );
		buttonpanel.addMember( cancelbutton );
		mainpanel.addMember( buttonpanel );
		return mainpanel;
	}

}
