/**
 * 
 */
package com.sickle.medu.ms.client.form;

import com.sickle.medu.ms.client.datasource.MemberDataSource;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
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
	private TextItem telephone;
	private RadioGroupItem sex;
	private TextAreaItem resume;
	private TextItem orgname;
	private TextItem title;
	
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
		
		telephone = new TextItem("contact");
		telephone.setTitleStyle( "h1" );
		telephone.setTitle("电话");
		telephone.setRequired(true);
		
		sex = new RadioGroupItem( "sex" );
		sex.setTitleStyle( "h1" );
		sex.setTitle("性别");
		sex.setRequired(true);
		
		resume = new TextAreaItem("resume");
		resume.setTitleStyle( "h1" );
		resume.setTitle("简介");
		resume.setRequired(true);
		
		orgname = new TextItem("orgname");
		orgname.setTitleStyle( "h1" );
		orgname.setTitle("工作单位");
		orgname.setRequired(true);
		
		title = new TextItem("title");
		title.setTitleStyle( "h1" );
		title.setTitle("职位");
		title.setRequired(true);
		
		setFields(new FormItem[] {username, emailItem, password,confirmpassword,telephone,sex,resume,orgname,title});
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
