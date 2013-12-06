/**
 * 
 */
package com.sickle.medu.ms.client.ui.form;

import com.smartgwt.client.widgets.form.fields.PasswordItem;


/**
 * default password item for form
 * 
 * @author chenhao
 *
 */
public class DefaultPasswordItem extends PasswordItem
{

	
	
	public DefaultPasswordItem( )
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
	public DefaultPasswordItem( String name, String title )
	{
		super( name, title );
		setTitleStyle( "h2" );
		setTextBoxStyle( "form_textbox" );
		setShowFocused( false );
	}

	/**
	 * @param name
	 */
	public DefaultPasswordItem( String name )
	{
		super( name );
		setTitleStyle( "h2" );
		setTextBoxStyle( "form_textbox" );
		setShowFocused( false );
	}
	
	

}
