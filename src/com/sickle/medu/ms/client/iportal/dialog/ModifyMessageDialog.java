package com.sickle.medu.ms.client.iportal.dialog;

import com.sickle.medu.ms.client.form.MessageForm;
import com.sickle.medu.ms.client.ui.dialog.AbstractDialog;
import com.sickle.medu.ms.client.ui.widget.button.MButton;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


public class ModifyMessageDialog extends AbstractDialog
{
	public ModifyMessageDialog( )
	{
		super( "修改消息" );
	}

	@Override
	public Canvas getView( )
	{
		VLayout wholepanel = getDefaultVLayout();
		final DynamicForm form = new MessageForm().getModifyForm( );
		wholepanel.addMember( form );
		
		HLayout buttonpanel = new HLayout();
		buttonpanel.setMargin( 5 );
		buttonpanel.setMembersMargin( 10 );
		buttonpanel.setAlign( Alignment.CENTER );
		
		VLayout warp = new VLayout();
		warp.setWidth( 500 );
		warp.setAlign( VerticalAlignment.CENTER );
		
		MButton confirm = new MButton("确认" )
		{
			@Override
			public void handleClick( )
			{
				boolean validate = form.validate( );
				if( !validate )
				{
					return;
				}
				form.submit( new DSCallback( ) {
					@Override
					public void execute( DSResponse dsResponse, Object data, DSRequest dsRequest )
					{
						if( dsResponse.getErrors( )== null || dsResponse.getErrors( ).isEmpty( )){
							SC.say( "成功！" );
						}else{
							SC.say( "失败！" );
						}
						ModifyMessageDialog.this.hide();
					}
				} );					
			}
			
		};
		
		MButton cancel = new MButton("取消" ){
			@Override
			public void handleClick( )
			{
				ModifyMessageDialog.this.hide();				
			}
		};
		
		buttonpanel.addMember( confirm );
		buttonpanel.addMember( cancel );
		
		warp.addMember( buttonpanel );
		
		wholepanel.addMember( warp );
		return wholepanel;
	}
}