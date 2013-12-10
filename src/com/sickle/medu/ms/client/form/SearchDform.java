/**
 * 
 */

package com.sickle.medu.ms.client.form;

import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.BlurEvent;
import com.smartgwt.client.widgets.form.fields.events.BlurHandler;
import com.smartgwt.client.widgets.form.fields.events.FocusEvent;
import com.smartgwt.client.widgets.form.fields.events.FocusHandler;

/**
 * 查找表单
 * 
 * @author chenhao
 * 
 */
public class SearchDform extends DynamicForm
{

	private TextItem username;

	public SearchDform( )
	{
		setPadding( 0 );
		setMargin( 0 );
		username = new TextItem( "name" );
		username.setTextBoxStyle( "searchform" );
		username.setTitleStyle( "searchformtitle" );
		username.setShowFocused( false );
		username.setTitle( "搜老师/课程" );
		username.setWidth( 200 );
		username.setShowTitle( false );

		username.addFocusHandler( new FocusHandler( ) {

			@Override
			public void onFocus( FocusEvent event )
			{
				username.setTextBoxStyle( "searchform-focus" );
			}
		} );

		username.addBlurHandler( new BlurHandler( ) {

			@Override
			public void onBlur( BlurEvent event )
			{
				username.setTextBoxStyle( "searchform" );
			}
		} );

		setFields( new FormItem[]{username} );
	}

	/**
	 * @return the username
	 */
	public TextItem getUsername( )
	{
		return username;
	}

}
