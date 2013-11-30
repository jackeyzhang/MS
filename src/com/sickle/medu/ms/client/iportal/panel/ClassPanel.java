/**
 * 
 */
package com.sickle.medu.ms.client.iportal.panel;

import com.sickle.medu.ms.client.form.ClassesForm;
import com.sickle.medu.ms.client.iportal.list.ClassList;
import com.sickle.medu.ms.client.ui.dialog.AbstractDialog;
import com.sickle.medu.ms.client.ui.widget.MButton;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * 班级面板
 * 
 * @author chenhao
 *
 */
public class ClassPanel extends HLayout
{
	
	private ClassList list = new ClassList();
	
	private VLayout buttonpanel = new VLayout();
	
	public ClassPanel()
	{
		setWidth100( );
		setHeight100( );
		setStyleName( "messagepanel" );
		
		addMember( list );
		addMember( buttonpanel );
		
		init();
	}

	
	private void init()
	{
		buttonpanel.setPadding( 10 );
		buttonpanel.setMembersMargin( 10 );
		buttonpanel.addMember( new MButton("查看班级"){
			@Override
			public void handleClick( )
			{
				if ( list.getSelectedRecords( ).length == 0 )
				{
					SC.say( "请先选中一条要删除的记录" );
					return;
				}
				//TODO show class
			}} );
		buttonpanel.addMember( new MButton("创建班级"){
			@Override
			public void handleClick( )
			{
				new CreateClassDialog().show( );
			}} );
		buttonpanel.addMember( new MButton("删除班级"){
			@Override
			public void handleClick( )
			{
				if ( list.getSelectedRecords( ).length == 0 )
				{
					SC.say( "请先选中一条要删除的记录" );
					return;
				}
				list.getDataSource( ).removeData( list.getSelectedRecord( ) );
			}} );
		buttonpanel.addMember( new MButton("修改班级"){
			@Override
			public void handleClick( )
			{
				if ( list.getSelectedRecords( ).length == 0 )
				{
					SC.say( "请先选中一条要修改的记录" );
					return;
				}
			}} );
	}
	
	
	class CreateClassDialog extends AbstractDialog
	{
		public CreateClassDialog( )
		{
			super( "创建班级" );
		}

		@Override
		public Canvas getView( )
		{
			VLayout wholepanel = getDefaultVLayout();
			
			final DynamicForm form = new ClassesForm().getAddForm( );
			wholepanel.addMember( form );
			
			HLayout buttonpanel = new HLayout();
			buttonpanel.setWidth( 500 );
			buttonpanel.setMargin( 5 );
			buttonpanel.setMembersMargin( 10 );
			buttonpanel.setAlign( Alignment.CENTER );
			IButton confirm = new IButton("确认" );
			confirm.addClickHandler( new ClickHandler( ) {
				@Override
				public void onClick( ClickEvent event )
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
							CreateClassDialog.this.hide( );
						}
					} );					
				}
			} );
			IButton cancel = new IButton("取消" );
			cancel.addClickHandler( new ClickHandler( ) {
				@Override
				public void onClick( ClickEvent event )
				{
					CreateClassDialog.this.hide();
				}
			} );
			buttonpanel.addMember( confirm );
			buttonpanel.addMember( cancel );
			wholepanel.addMember( buttonpanel );
			return wholepanel;
		}
	}
	
}
