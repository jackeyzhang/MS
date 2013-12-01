/**
 * 
 */
package com.sickle.medu.ms.client.form;

import com.sickle.medu.ms.client.datasource.MemberDataSource;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;


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
	private TextItem chart;
	
	private TextItem telephone;
	private RadioGroupItem sex;
	private TextAreaItem resume;
	private ComboBoxItem city;
	private ComboBoxItem area;
	
	
	public StudentDform( int width)
	{
		this( width, width/3, width - width/3 );
	}
	
	public StudentDform()
	{
		this( 400, 120, 280 );
	}
	
	public StudentDform(int width,int... columnwidth)
	{
		this.setWidth( width );
		this.setColWidths( columnwidth );
		this.setPadding( 20 );
		
		username = new TextItem("name");
		username.setWidth( columnwidth[1] );
		username.setTitleStyle( "h2" );
		username.setTitle("学生名字");
		username.setRequired(true);
		
		icon = new TextItem("icon");
		icon.setWidth( columnwidth[1] );
		icon.setTitleStyle( "h2" );
		icon.setVisible( false );
		
        emailItem = new TextItem("email");
        emailItem.setWidth( columnwidth[1] );
        emailItem.setTitleStyle( "h2" );
        emailItem.setTitle("邮箱");
        emailItem.setRequired(true);

		password = new PasswordItem("password");
		password.setWidth( columnwidth[1] );
		password.setTitleStyle( "h2" );
		password.setTitle("密码");
		password.setRequired(true);	
		
		confirmpassword = new PasswordItem("password");
		confirmpassword.setWidth( columnwidth[1] );
		confirmpassword.setTitleStyle( "h2" );
		confirmpassword.setTitle("确认密码");
		confirmpassword.setRequired(true);
		confirmpassword.setType("password");
		
		sex = new RadioGroupItem( "sex" );
		sex.setVertical( false );
		sex.setValueMap( "男","女" );
		sex.setValue( "男" );
		sex.setTitleStyle( "h2" );
		sex.setTitle("性别");
		sex.setRequired(true);
		
		chart = new TextItem( "character" );
		chart.setVisible( false );
		chart.setValue( "student" );
		
		telephone = new TextItem("contact");
		telephone.setWidth( columnwidth[1] );
		telephone.setTitleStyle( "h2" );
		telephone.setTitle("电话");
		
		resume = new TextAreaItem("resume");
		resume.setWidth( columnwidth[1] );
		resume.setTitleStyle( "h2" );
		resume.setTitle("备注");
		
		city = new ComboBoxItem("city");
		city.setWidth( columnwidth[1] );
		city.setTitleStyle( "h2" );
		city.setTitle("城市");
		city.setValueMap( FormConst.CITY );
		
		area = new ComboBoxItem("area");
		area.setWidth( columnwidth[1] );
		area.setTitleStyle( "h2" );
		area.setTitle("区县");
		
		city.addChangedHandler( new ChangedHandler( ) {
			@Override
			public void onChanged( ChangedEvent event )
			{
				updateArea();
				area.clearValue( );
			}
		} );
		
		
		setFields(new FormItem[] {username, icon,emailItem, sex,password,confirmpassword,chart,city,area,telephone,resume});
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

	
	/**
	 * @return the icon
	 */
	public TextItem getIcon( )
	{
		return icon;
	}

	
	/**
	 * @param icon the icon to set
	 */
	public void setIcon( String icon )
	{
		this.icon.setValue( icon );
	}
	
	public void updateArea()
	{
		if(city.getValueAsString( ).equals( "上海" ))
		{
			area.setValueMap( FormConst.AREA_SH );
		}
		else if(city.getValueAsString( ).equals( "北京" ))
		{
			area.setValueMap( FormConst.AREA_BJ );
		}
	}
	
}
