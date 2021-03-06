/**
 * 
 */

package com.sickle.medu.ms.client.form;

import com.sickle.medu.ms.client.datasource.StudentDataSource;
import com.sickle.medu.ms.client.ui.form.DefaultDateItem;
import com.sickle.medu.ms.client.ui.form.DefaultPasswordItem;
import com.sickle.medu.ms.client.ui.form.DefaultTextAreaItem;
import com.sickle.medu.ms.client.ui.form.DefaultTextItem;
import com.sickle.pojo.edu.Student;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.DateItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.MatchesFieldValidator;

/**
 * 学生注册表单
 * 
 * @author chenhao
 * 
 */
public class StudentDform extends DynamicForm
{

	private TextItem username;
	private TextItem icon;
	private TextItem emailItem;
	private PasswordItem password;
	private PasswordItem confirmpassword;

	private TextItem telephone;
	private RadioGroupItem sex;

	private DateItem birthday;
	private TextAreaItem parents;
	private TextAreaItem detail1;

	public StudentDform( int width )
	{
		this( width, width / 4, width - width / 3 );
	}

	public StudentDform( )
	{
		this( 400, 120, 280 );
	}

	public StudentDform( int width, int... columnwidth )
	{
		this.setWidth( width );
		this.setColWidths( columnwidth );
		this.setNumCols( 3 );
		this.setPadding( 20 );

		username = new DefaultTextItem( "name" );
		username.setWidth( columnwidth[1] );
		username.setTitle( "学生名字" );
		username.setRequired( true );

		icon = new DefaultTextItem( "icon" );
		icon.setWidth( columnwidth[1] );
		icon.setVisible( false );

		emailItem = new DefaultTextItem( "email" );
		emailItem.setWidth( columnwidth[1] );
		emailItem.setTitle( "邮箱" );
		emailItem.setRequired( true );

		password = new DefaultPasswordItem( "password" );
		password.setWidth( columnwidth[1] );
		password.setTitle( "密码" );
		password.setRequired( true );

		confirmpassword = new DefaultPasswordItem( "passwordagian" );
		confirmpassword.setWidth( columnwidth[1] );
		confirmpassword.setTitle( "确认密码" );
		confirmpassword.setRequired( true );

		MatchesFieldValidator matchesValidator = new MatchesFieldValidator( );
		matchesValidator.setOtherField( "password" );
		matchesValidator.setErrorMessage( "两次密码不一致" );
		confirmpassword.setValidators( matchesValidator );

		sex = new RadioGroupItem( "sex" );
		sex.setTitleStyle( "form_texttitle" );
		sex.setVertical( false );
		sex.setValueMap( "男", "女" );
		sex.setValue( "男" );
		sex.setTitleStyle( "form_texttitle" );
		sex.setTitle( "性别" );
		sex.setRequired( true );

		telephone = new DefaultTextItem( "contact" );
		telephone.setWidth( columnwidth[1] );
		telephone.setTitle( "联系方式" );

		birthday = new DefaultDateItem( "birthday", "出生日期" );
		birthday.setWidth( columnwidth[1] );

		parents = new DefaultTextAreaItem( "parents", "父母情况" );
		parents.setWidth( columnwidth[1] );

		detail1 = new DefaultTextAreaItem( "detail1", "备注" );
		detail1.setWidth( columnwidth[1] );

		setFields( new FormItem[]{username, icon, emailItem, sex, password,
				confirmpassword, telephone, birthday, parents, detail1} );
		setDataSource( StudentDataSource.getInstance( ).getDataSource(
				Student.class ) );
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

	/**
	 * @return the icon
	 */
	public TextItem getIcon( )
	{
		return icon;
	}

	/**
	 * @param icon
	 *            the icon to set
	 */
	public void setIcon( String icon )
	{
		this.icon.setValue( icon );
	}

}
