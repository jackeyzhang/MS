/**
 * 
 */
package com.sickle.medu.ms.client.form;

import com.sickle.medu.ms.client.datasource.MemberDataSource;
import com.sickle.pojo.edu.Member;
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
		this.setWidth( 300 );
		this.setTitleWidth( "30%" );
		this.setPadding( 20 );
		
		username = new TextItem("name");
		username.setTitleStyle( "h1" );
		username.setTitle("用户名");
		username.setRequired(true);
		
        emailItem = new TextItem("email");
        emailItem.setTitleStyle( "h1" );
        emailItem.setTitle("邮箱");
        emailItem.setRequired(true);
        emailItem.setDefaultValue("zhangsan@XXX.com");

		password = new PasswordItem("password");
		password.setTitleStyle( "h1" );
		password.setTitle("密码");
		password.setRequired(true);	
		
		confirmpassword = new PasswordItem();
		confirmpassword.setTitleStyle( "h1" );
		confirmpassword.setTitle("确认密码");
		confirmpassword.setRequired(true);
		confirmpassword.setType("password");
		
		setFields(new FormItem[] {username, emailItem, password,confirmpassword});
		setDataSource( MemberDataSource.getInstance( ).getDataSource( Member.class ) );
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
