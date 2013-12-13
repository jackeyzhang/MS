/**
 * 
 */
package com.sickle.medu.ms.client.iportal.dialog;

import com.sickle.medu.ms.client.form.StudentDform;
import com.sickle.medu.ms.client.ui.dialog.AbstractDialog;
import com.sickle.medu.ms.client.ui.widget.button.MButton;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * 学生信息编辑对话框
 * 
 * @author chenhao
 *
 */
public class StudentDialog extends AbstractDialog
{
	
	private static final String TITLE = "学生信息";
	
	private StudentDform studentform ;
	
	public StudentDialog()
	{
		super( TITLE, true,true,true );
	}

	@Override
	public Canvas getView( )
	{
		VLayout mainpanel = new VLayout();
		mainpanel.setWidth100( );
		
		studentform = new StudentDform();
		mainpanel.addMember( studentform );
		
		HLayout buttonpanel = new HLayout();
		buttonpanel.setPadding( 10 );
		buttonpanel.setMembersMargin( 10 );
		buttonpanel.setAlign( Alignment.CENTER );
		
		VLayout warp = new VLayout();
		warp.setWidth( 400 );
		warp.setAlign( VerticalAlignment.CENTER );
		
		MButton okbutton = new MButton("确认")
		{
			@Override
			public void handleClick( )
			{
				boolean isValidate = studentform.validate( );
				if( isValidate == false)
				{
					return;
				}
				studentform.submit( new DSCallback(){
					@Override
					public void execute( DSResponse dsResponse, Object data,
							DSRequest dsRequest )
					{
						submitcallback();
						SC.say( "操作成功" );	
					}
				} );
				StudentDialog.this.hide();
			}
		};
		okbutton.setWidth( 50 );
		
		MButton cancelbutton = new MButton("取消"){
			@Override
			public void handleClick( )
			{
				studentform.cancel( );
				StudentDialog.this.hide();			
			}
		};
		cancelbutton.setWidth( 50 );
		
		buttonpanel.addMember( okbutton );
		buttonpanel.addMember( cancelbutton );
		
		warp.addMember( buttonpanel );
		
		mainpanel.addMember( warp );
		return mainpanel;
	}

	
	/**
	 * @return the studentform
	 */
	public StudentDform getStudentform( )
	{
		return studentform;
	}


	public void submitcallback(){}
}
