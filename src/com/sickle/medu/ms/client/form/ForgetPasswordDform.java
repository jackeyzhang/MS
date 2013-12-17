/**
 * 
 */
package com.sickle.medu.ms.client.form;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sickle.medu.ms.client.rpc.UserManageService;
import com.sickle.medu.ms.client.ui.form.DefaultTextItem;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.SC;
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

	private TextItem username;
	
	
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
		this.setPadding(15);
		this.setTitleOrientation( TitleOrientation.TOP );
		
		username = new DefaultTextItem();
		username.setWidth( columnwidth[1] );
		username.setTitle("请输入您的用户名,我们将向您的注册邮箱发送密码");
		username.setRequired(true);
		
		setFields(new FormItem[] {username});
	}

	@Override
	public void submit( )
	{
		super.submit( );
		UserManageService.Util.getInstance().sendMail(username.getValueAsString(), new AsyncCallback<Boolean>() {
			@Override
			public void onSuccess(Boolean result) {
				SC.say("发送成功，请查收邮件.");
			}
			
			@Override
			public void onFailure(Throwable caught) {
				SC.say("发送邮件失败，请检查您有信息填写是否正确.");
			}
		});
	}
	
}
