/**
 * 
 */
package com.sickle.medu.ms.client.ui.form;

import com.smartgwt.client.types.FormErrorOrientation;
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
		init();
	}

	/**
	 * @param name
	 * @param title
	 */
	public DefaultCheckboxItem( String name, String title )
	{
		super( name, title );
		init();
	}

	/**
	 * @param name
	 */
	public DefaultCheckboxItem( String name )
	{
		super( name );
		init();
	}

	private void init()
	{
		setTextBoxStyle( "form_checkbox" );
		setVAlign( VerticalAlignment.CENTER );
		setShowFocused( false );
		setShowErrorText(true);
		setShowErrorStyle( false );
		setErrorOrientation( FormErrorOrientation.RIGHT );
		setRequiredMessage( "不能为空" );
	}
}
