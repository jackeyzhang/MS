/**
 * 
 */
package com.sickle.medu.ms.client.form;

import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;


/**
 * 忘記密碼表单
 * 
 * @author chenhao
 *
 */
public class ForgetPasswordDform extends DynamicForm
{

	private TextItem email;
	
	
	public ForgetPasswordDform( int width)
	{
		this( width, width/5, width - width/5 );
	}
	
	public ForgetPasswordDform()
	{
		this( 500, 200, 300 );
	}
	
	public ForgetPasswordDform(int width,int... columnwidth)
	{
		this.setWidth( width );
		this.setFixedColWidths( true );
		this.setColWidths( columnwidth );
		this.setMargin( 10 );
		this.setTitleOrientation( TitleOrientation.TOP );
		
		email = new TextItem("email");
		email.setWidth( columnwidth[1] );
		email.setTitleStyle( "h2" );
		email.setTitle("请输入你注册时的邮箱,我们将向该邮箱发送您的密码");
		email.setRequired(true);
		
		setFields(new FormItem[] {email});
	}

	@Override
	public void submit( )
	{
		super.submit( );
	}
	
}