/**
 * 
 */
package com.sickle.medu.ms.client.ui.form;

import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;


/**
 * default CheckboxItem for form
 * 
 * @author chenhao
 *
 */
public class DefaultCheckboxItem extends CheckboxItem
{
	
	public DefaultCheckboxItem( )
	{
		super( );
		setTextBoxStyle( "form_checkbox" );
		setVAlign( VerticalAlignment.CENTER );
		setShowFocused( false );
	}

	/**
	 * @param name
	 * @param title
	 */
	public DefaultCheckboxItem( String name, String title )
	{
		super( name, title );
		setTextBoxStyle( "form_checkbox" );
		setVAlign( VerticalAlignment.CENTER );
		setShowFocused( false );
	}

	/**
	 * @param name
	 */
	public DefaultCheckboxItem( String name )
	{
		super( name );
		setTextBoxStyle( "form_checkbox" );
		setVAlign( VerticalAlignment.CENTER );
		setShowFocused( false );
	}

}
