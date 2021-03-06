/**
 * 
 */
package com.sickle.medu.ms.client.form;

import com.sickle.medu.ms.client.datasource.MemberDataSource;
import com.sickle.medu.ms.client.ui.form.DefaultCheckboxItem;
import com.sickle.medu.ms.client.ui.form.DefaultComboBoxItem;
import com.sickle.medu.ms.client.ui.form.DefaultPasswordItem;
import com.sickle.medu.ms.client.ui.form.DefaultRadioGroupItem;
import com.sickle.medu.ms.client.ui.form.DefaultTextAreaItem;
import com.sickle.medu.ms.client.ui.form.DefaultTextItem;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.form.fields.ComboBoxItem;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.form.validator.MatchesFieldValidator;


/**
 * 注册表单
 * 
 * @author chenhao
 *
 */
public class MemberDform extends DynamicForm
{

	private TextItem username;
	private TextItem icon;
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
	private ComboBoxItem city;
	private ComboBoxItem area;
	
	
	public MemberDform( int width)
	{
		this( width, width/4, width - width/3 );
	}
	
	public MemberDform()
	{
		this( 400, 120, 280 );
	}
	
	public MemberDform(int width,int... columnwidth)
	{
		this.setWidth( width );
		this.setColWidths( columnwidth );
		this.setNumCols( 3 );
		
		username = new DefaultTextItem("name");
		username.setWidth( columnwidth[1] );
		username.setTitle("用户名");
		username.setRequired(true);
		
		icon = new DefaultTextItem("icon");
		icon.setWidth( columnwidth[1] );
		icon.setVisible( false );
		
        emailItem = new DefaultTextItem("email");
        emailItem.setWidth( columnwidth[1] );
        emailItem.setTitle("邮箱");
        emailItem.setRequired(true);

		password = new DefaultPasswordItem("password");
		password.setWidth( columnwidth[1] );
		password.setTitle("密码");
		password.setRequired(true);	
		
		confirmpassword = new DefaultPasswordItem("passwordagian");
		confirmpassword.setWidth( columnwidth[1] );
		confirmpassword.setTitle("确认密码");
		confirmpassword.setRequired(true);
		confirmpassword.setType("password");
		
		MatchesFieldValidator matchesValidator = new MatchesFieldValidator();  
        matchesValidator.setOtherField("password");  
        matchesValidator.setErrorMessage("两次密码不一致");          
        confirmpassword.setValidators(matchesValidator);  
		
		sex = new DefaultRadioGroupItem( "sex" );
		sex.setVertical( false );
		sex.setValueMap( "男","女" );
		sex.setValue( "男" );
		sex.setTitle("性别");
		sex.setRequired(true);
		
		isteacher = new DefaultCheckboxItem( "forhelp" );
		isteacher.setTitle("填写老师信息？");
		
		chart = new DefaultTextItem( "character" );
		chart.setRequired(true);
		chart.setVisible( false );
		
		telephone = new DefaultTextItem("contact");
		telephone.setWidth( columnwidth[1] );
		telephone.setTitle("电话");
		telephone.setRequired(true);
		telephone.setVisible( false );
		
		resume = new DefaultTextAreaItem("resume");
		resume.setWidth( columnwidth[1] );
		resume.setTitle("简介");
		resume.setRequired(true);
		resume.setVisible( false );
		
		orgname = new DefaultTextItem("orgname");
		orgname.setWidth( columnwidth[1] );
		orgname.setTitle("工作单位");
		orgname.setRequired(true);
		orgname.setVisible( false );
		
		title = new DefaultTextItem("title");
		title.setWidth( columnwidth[1] );
		title.setTitle("职位");
		title.setRequired(true);
		title.setVisible( false );
		
		
		city = new DefaultComboBoxItem("city");
		city.setWidth( columnwidth[1] );
		city.setTitle("城市");
		city.setRequired(true);
		city.setVisible( false );
		city.setValueMap( FormConst.CITY );
		
		
		area = new DefaultComboBoxItem("area");
		area.setWidth( columnwidth[1] );
		area.setTitle("区县");
		area.setRequired(true);
		area.setVisible( false );
		
		city.addChangedHandler( new ChangedHandler( ) {
			@Override
			public void onChanged( ChangedEvent event )
			{
				updateArea();
				area.clearValue( );
			}
		} );
		
		
		isteacher.addChangedHandler( new ChangedHandler( ) {
			@Override
			public void onChanged( ChangedEvent event )
			{
				if(isteacher.getValueAsBoolean( ) )
				{
					showTeacherField();
				}
				else
				{//not teacher ,hide and remove
					hideTeacherField();
					telephone.clearValue( );
					resume.clearValue( );
					orgname.clearValue(  );
					title.clearValue(  );
					city.clearValue( );
					area.clearValue( );
				}
			}
		} );
		
		setFields(new FormItem[] {username, icon,emailItem, sex,password,confirmpassword,isteacher,chart,city,area,telephone,resume,orgname,title});
		setDataSource( MemberDataSource.getInstance( ).getDataSource( Member.class ) );
	
	}

	public void hideTeacherField()
	{
		telephone.hide( );
		resume.hide(  );
		orgname.hide(  );
		title.hide(  );
		city.hide( );
		area.hide( );
		chart.setValue( "normal" );
	}

	public void showTeacherField()
	{
		telephone.show( );
		resume.show(  );
		orgname.show(  );
		title.show(  );
		city.show( );
		area.show( );
		chart.setValue( "teacher" );
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
		if( city.getValueAsString( ) == null )
		{
			return;
		}
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
