/**
 * 
 */
package com.sickle.medu.ms.client.form;

import com.sickle.medu.ms.client.datasource.MemberDataSource;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;


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
	private CheckboxItem isteacher;
	private TextItem chart;
	
	private TextItem telephone;
	private RadioGroupItem sex;
	private TextAreaItem resume;
	private TextItem orgname;
	private TextItem title;
	private TextItem city;
	private TextItem area;
	
	
	public RegisterDform( int width)
	{
		this( width, width/4, width - width/2 );
	}
	
	public RegisterDform()
	{
		this( 500, 200, 300 );
	}
	
	public RegisterDform(int width,int... columnwidth)
	{
		this.setWidth( width );
		this.setFixedColWidths( true );
		this.setColWidths( columnwidth );
		this.setPadding( 20 );
		
		username = new TextItem("name");
		username.setWidth( columnwidth[1] );
		username.setTitleStyle( "h2" );
		username.setTitle("用户名");
		username.setRequired(true);
		
        emailItem = new TextItem("email");
        emailItem.setWidth( columnwidth[1] );
        emailItem.setTitleStyle( "h2" );
        emailItem.setTitle("邮箱");
        emailItem.setRequired(true);
        emailItem.setDefaultValue("zhangsan@XXX.com");

		password = new PasswordItem("password");
		password.setWidth( columnwidth[1] );
		password.setTitleStyle( "h2" );
		password.setTitle("密码");
		password.setRequired(true);	
		
		confirmpassword = new PasswordItem();
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
		
		isteacher = new CheckboxItem( "forhelp" );
		isteacher.setTitleStyle( "h2" );
		isteacher.setTitle("填写老师信息？");
		
		chart = new TextItem( "character" );
		chart.setRequired(true);
		chart.setVisible( false );
		
		telephone = new TextItem("contact");
		telephone.setWidth( columnwidth[1] );
		telephone.setTitleStyle( "h2" );
		telephone.setTitle("电话");
		telephone.setRequired(true);
		telephone.setVisible( false );
		
		resume = new TextAreaItem("resume");
		resume.setWidth( columnwidth[1] );
		resume.setTitleStyle( "h2" );
		resume.setTitle("简介");
		resume.setRequired(true);
		resume.setVisible( false );
		
		orgname = new TextItem("orgname");
		orgname.setWidth( columnwidth[1] );
		orgname.setTitleStyle( "h2" );
		orgname.setTitle("工作单位");
		orgname.setRequired(true);
		orgname.setVisible( false );
		
		title = new TextItem("title");
		title.setWidth( columnwidth[1] );
		title.setTitleStyle( "h2" );
		title.setTitle("职位");
		title.setRequired(true);
		title.setVisible( false );
		
		
		city = new TextItem("city");
		city.setWidth( columnwidth[1] );
		city.setTitleStyle( "h2" );
		city.setTitle("城市");
		city.setRequired(true);
		city.setVisible( false );
		
		
		area = new TextItem("area");
		area.setWidth( columnwidth[1] );
		area.setTitleStyle( "h2" );
		area.setTitle("区县");
		area.setRequired(true);
		area.setVisible( false );
		
		
		isteacher.addChangedHandler( new ChangedHandler( ) {
			@Override
			public void onChanged( ChangedEvent event )
			{
				if(isteacher.getValueAsBoolean( ) )
				{
					telephone.show( );
					resume.show(  );
					orgname.show(  );
					title.show(  );
					city.show( );
					area.show( );
					chart.setValue( "teacher" );
				}
				else
				{
					telephone.hide( );
					resume.hide(  );
					orgname.hide(  );
					title.hide(  );
					city.hide( );
					area.hide( );
					chart.setValue( "normal" );
				}
			}
		} );
		
		setFields(new FormItem[] {username, emailItem, sex,password,confirmpassword,isteacher,chart,city,area,telephone,resume,orgname,title});
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
