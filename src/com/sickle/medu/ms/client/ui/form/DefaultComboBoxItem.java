/**
 * 
 */
package com.sickle.medu.ms.client.ui.form;

import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.events.BlurEvent;
import com.smartgwt.client.widgets.form.fields.events.BlurHandler;
import com.smartgwt.client.widgets.form.fields.events.FocusEvent;
import com.smartgwt.client.widgets.form.fields.events.FocusHandler;


/**
 * default ComboBoxItem for form
 * 
 * @author chenhao
 *
 */
public class DefaultComboBoxItem extends ComboBoxItem
{

	
	
	public DefaultComboBoxItem( )
	{
		super( );
		setTitleStyle( "form_texttitle" );
		setTextBoxStyle( "form_combobox" );
		setShowFocused( false );
		initActions();
	}

	/**
	 * @param name
	 * @param title
	 */
	public DefaultComboBoxItem( String name, String title )
	{
		super( name, title );
		setTitleStyle( "form_texttitle" );
		setTextBoxStyle( "form_combobox" );
		setShowFocused( false );
		initActions();
	}

	/**
	 * @param name
	 */
	public DefaultComboBoxItem( String name )
	{
		super( name );
		setTitleStyle( "form_texttitle" );
		setTextBoxStyle( "form_combobox" );
		setShowFocused( false );
		initActions();
	}

	
	private void initActions()
	{
		addFocusHandler( new FocusHandler( ) {
			@Override
			public void onFocus( FocusEvent event )
			{
				setTextBoxStyle( "form_combobox_focus" );
			}
		} );
		
		addBlurHandler( new BlurHandler( ) {
			@Override
			public void onBlur( BlurEvent event )
			{
				setTextBoxStyle( "form_combobox" );				
			}
		} );
	}
}
