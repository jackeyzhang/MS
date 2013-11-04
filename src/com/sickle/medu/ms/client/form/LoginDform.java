/**
 * 
 */
package com.sickle.medu.ms.client.form;

import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
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
		username = new TextItem();
		username.setTitle("用户名");
		username.setRequired(true);
		username.setDefaultValue("yourname@163.com");

		password = new PasswordItem();
		password.setTitle("密码");
		password.setRequired(true);	
		
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
