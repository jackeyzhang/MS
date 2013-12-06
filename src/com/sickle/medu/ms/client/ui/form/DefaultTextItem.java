/**
 * 
 */
package com.sickle.medu.ms.client.ui.form;

import com.smartgwt.client.widgets.form.fields.TextItem;


/**
 * default text item for form
 * 
 * @author chenhao
 *
 */
public class DefaultTextItem extends TextItem
{

	
	
	public DefaultTextItem( )
	{
		super( );
		setTitleStyle( "h2" );
		setTextBoxStyle( "form_textbox" );
		setShowFocused( false );
	}

	/**
	 * @param name
	 * @param title
	 */
	public DefaultTextItem( String name, String title )
	{
		super( name, title );
		setTitleStyle( "h2" );
		setTextBoxStyle( "form_textbox" );
		setShowFocused( false );
	}

	/**
	 * @param name
	 */
	public DefaultTextItem( String name )
	{
		super( name );
		setTitleStyle( "h2" );
		setTextBoxStyle( "form_textbox" );
		setShowFocused( false );
	}
	
	

}
