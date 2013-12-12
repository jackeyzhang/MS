/**
 * 
 */
package com.sickle.medu.ms.client.ui.form;

import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.events.BlurEvent;
import com.smartgwt.client.widgets.form.fields.events.BlurHandler;
import com.smartgwt.client.widgets.form.fields.events.FocusEvent;
import com.smartgwt.client.widgets.form.fields.events.FocusHandler;


/**
 * default IntegerItem for form
 * 
 * @author chenhao
 *
 */
public class DefaultIntegerItem extends IntegerItem
{

	
	
	public DefaultIntegerItem( )
	{
		super( );
		setTitleStyle( "form_texttitle" );
		setTextBoxStyle( "form_textbox" );
		setShowFocused( false );
		initActions();
	}

	/**
	 * @param name
	 * @param title
	 */
	public DefaultIntegerItem( String name, String title )
	{
		super( name, title );
		setTitleStyle( "form_texttitle" );
		setTextBoxStyle( "form_textbox" );
		setShowFocused( false );
		initActions();
	}

	/**
	 * @param name
	 */
	public DefaultIntegerItem( String name )
	{
		super( name );
		setTitleStyle( "form_texttitle" );
		setTextBoxStyle( "form_textbox" );
		setShowFocused( false );
		initActions();
	}

	
	private void initActions()
	{
		addFocusHandler( new FocusHandler( ) {
			@Override
			public void onFocus( FocusEvent event )
			{
				setTextBoxStyle( "form_textbox_focus" );
			}
		} );
		
		addBlurHandler( new BlurHandler( ) {
			@Override
			public void onBlur( BlurEvent event )
			{
				setTextBoxStyle( "form_textbox" );				
			}
		} );
	}
}
