/**
 * 
 */
package com.sickle.medu.ms.client.ui.form;

import com.smartgwt.client.widgets.form.fields.RadioGroupItem;


/**
 * default RadioGroupItem for form
 * 
 * @author chenhao
 *
 */
public class DefaultRadioGroupItem extends RadioGroupItem
{
	
	public DefaultRadioGroupItem( )
	{
		super( );
		setTitleStyle( "form_texttitle" );
		setTextBoxStyle( "form_radio" );
		setShowFocused( false );
	}

	/**
	 * @param name
	 * @param title
	 */
	public DefaultRadioGroupItem( String name, String title )
	{
		super( name, title );
		setTitleStyle( "form_texttitle" );
		setTextBoxStyle( "form_radio" );
		setShowFocused( false );
	}

	/**
	 * @param name
	 */
	public DefaultRadioGroupItem( String name )
	{
		super( name );
		setTitleStyle( "form_texttitle" );
		setTextBoxStyle( "form_radio" );
		setShowFocused( false );
	}

	
}
