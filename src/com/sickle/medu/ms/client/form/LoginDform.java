/**
 * 
 */
package com.sickle.medu.ms.client.form;

import com.sickle.medu.ms.client.ui.form.DefaultPasswordItem;
import com.sickle.medu.ms.client.ui.form.DefaultTextItem;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;


/**
 * 登陆表单
 * 
 * @author chenhao
 *
 */
public class LoginDform extends DynamicForm
{

	private TextItem username;
	private TextItem password;
	
	public LoginDform()
	{
		this.setWidth100( );
		this.setPadding( 10 );
		this.setColWidths( 100,200 );
		
		username = new DefaultTextItem("name");
		username.setTitle("用户名");
		username.setRequired(true);
		username.setWidth( 200 );

		password = new DefaultPasswordItem("password");
		password.setTitle("密码");
		password.setRequired(true);	
		password.setWidth( 200 );
		
		setFields(new FormItem[] {username, password});
	}

	
	/**
	 * @return the username
	 */
	public TextItem getUsername( )
	{
		return username;
	}

	
	/**
	 * @return the password
	 */
	public TextItem getPassword( )
	{
		return password;
	}

}
