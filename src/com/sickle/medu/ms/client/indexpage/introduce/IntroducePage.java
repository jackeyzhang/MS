/**
 * 
 */
package com.sickle.medu.ms.client.indexpage.introduce;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.sickle.medu.ms.client.indexpage.MeduIndexPage;
import com.sickle.medu.ms.client.ui.dialog.UILoginDialog;


/**
 * @author chenhao
 *
 */
public class IntroducePage extends Anchor
{

	
	public IntroducePage(String introduce)
	{
		super(introduce);
		this.setStyleName( "introducepage" );
		this.addClickHandler( new ClickHandler( ) {
			@Override
			public void onClick( ClickEvent event )
			{
				MeduIndexPage.getInstance( ).clear( );
				UILoginDialog.getInstance( ).show( );
			}
		} );
	}
	
}
