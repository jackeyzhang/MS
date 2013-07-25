/**
 * 
 */
package com.sickle.medu.ms.client.form;

import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.TextItem;


/**
 * 注册表单
 * 
 * @author chenhao
 *
 */
public class RegisterDform extends DynamicForm
{

	private TextItem username;
	private TextItem emailItem;
	private PasswordItem password;
	private PasswordItem confirmpassword;
	
	public RegisterDform()
	{
		this.setWidth100( );
		username = new TextItem();
		username.setTitle("username");
		username.setRequired(true);
		
        emailItem = new TextItem();
        emailItem.setTitle("email");
        emailItem.setRequired(true);
        emailItem.setDefaultValue("zhangsan@XXX.com");

		password = new PasswordItem();
		password.setTitle("password");
		password.setRequired(true);	
		
		confirmpassword = new PasswordItem();
		confirmpassword.setTitle("password again");
		confirmpassword.setRequired(true);
		confirmpassword.setType("password");
		
		setFields(new FormItem[] {username, emailItem, password,confirmpassword});
	}

	
	/**
	 * @return the username
	 */
	public TextItem getUsername( )
	{
		return username;
	}

	
	/**
	 * @return the emailItem
	 */
	public TextItem getEmailItem( )
	{
		return emailItem;
	}

	
	/**
	 * @return the password
	 */
	public PasswordItem getPassword( )
	{
		return password;
	}

	
	/**
	 * @return the confirmpassword
	 */
	public PasswordItem getConfirmpassword( )
	{
		return confirmpassword;
	}

}
