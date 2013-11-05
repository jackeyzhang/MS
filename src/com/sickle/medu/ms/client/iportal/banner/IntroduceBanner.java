/**
 * 
 */
package com.sickle.medu.ms.client.iportal.banner;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.sickle.medu.ms.client.iportal.MeduIndexPage;
import com.sickle.medu.ms.client.ui.dialog.UILoginDialog;


/**
 * @author chenhao
 *
 */
public class IntroduceBanner extends Anchor
{

	
	public IntroduceBanner(String introduce)
	{
		super(introduce);
		this.setStyleName( "introducepage" );
		this.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				onClickHandler();
			}
		} );
	}
	
	protected void onClickHandler()
	{
		MeduIndexPage.getInstance( ).clear( );
		UILoginDialog.getInstance( ).show( );
	}
	
}
