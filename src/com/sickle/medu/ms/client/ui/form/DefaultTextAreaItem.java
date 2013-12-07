/**
 * 
 */
package com.sickle.medu.ms.client.ui.form;

import com.smartgwt.client.widgets.form.fields.TextAreaItem;


/**
 * default textarea item for form
 * 
 * @author chenhao
 *
 */
public class DefaultTextAreaItem extends TextAreaItem
{
	
	public DefaultTextAreaItem( )
	{
		super( );
		setTitleStyle( "h2" );
	}

	/**
	 * @param name
	 * @param title
	 */
	public DefaultTextAreaItem( String name, String title )
	{
		super( name, title );
		setTitleStyle( "h2" );
	}

	/**
	 * @param name
	 */
	public DefaultTextAreaItem( String name )
	{
		super( name );
		setTitleStyle( "h2" );
	}

}
