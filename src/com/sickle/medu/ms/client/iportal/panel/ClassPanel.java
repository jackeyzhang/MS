/**
 * 
 */
package com.sickle.medu.ms.client.iportal.panel;

import com.sickle.medu.ms.client.form.ClassesForm;
import com.sickle.medu.ms.client.iportal.list.ClassList;
import com.sickle.medu.ms.client.ui.dialog.AbstractDialog;
import com.sickle.medu.ms.client.ui.widget.button.MButton;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.ListGrid;
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
	
	private DynamicForm form = new ClassesForm().getAddForm( );
	
	private VLayout buttonpanel = new VLayout();
	
	private int memberid;
	
	public ClassPanel()
	{
		setWidth100( );
		setHeight100( );
		setStyleName( "classpanel" );
		
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
					SC.say( "请先选中一条要查看的班级" );
					return;
				}
				list.expandRecord( list.getSelectedRecord( ) );
			}} );
		buttonpanel.addMember( new MButton("创建班级"){
			@Override
			public void handleClick( )
			{
				new CreateClassDialog(){
					@Override
					public void callback( int memberid)
					{
						list.fetchClassByMemberid( memberid );
					}
				}.show( );
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
				list.removeSelectedData();
				list.fetchData();
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
				new ModifyClassDialog( list ){
					@Override
					public void callback( int memberid )
					{
						list.fetchClassByMemberid( memberid );
					}
				}.show( );
			}} );
	}
	
	public void fillPanel(Member member )
	{
		memberid = member.getId();
		list.fetchClassByMemberid( member.getId( ) );
		form.setValue( "memberid", member.getId( ) );
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
			
			form = new ClassesForm().getAddForm( );
			form.setValue( "memberid", memberid );
			wholepanel.addMember( form );
			
			HLayout buttonpanel = new HLayout();
			buttonpanel.setMargin( 5 );
			buttonpanel.setMembersMargin( 10 );
			buttonpanel.setAlign( Alignment.CENTER );
			
			
			VLayout warp = new VLayout();
			warp.setWidth( 400 );
			warp.setAlign( VerticalAlignment.CENTER );
			
			MButton confirm = new MButton("确认" ){
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
								callback( memberid );
							}else{
								SC.say( "失败！" );
							}
							CreateClassDialog.this.hide( );
						}
					} );					
				}
			};
			MButton cancel = new MButton("取消" ){
				@Override
				public void handleClick( )
				{
					CreateClassDialog.this.hide();					
				}
			};
			buttonpanel.addMember( confirm );
			buttonpanel.addMember( cancel );
			warp.addMember( buttonpanel );
			wholepanel.addMember( warp );
			return wholepanel;
		}
		
		public void callback(int memberid){}
	}
	
	class ModifyClassDialog extends AbstractDialog
	{
		
		private ListGrid gird;
		
		public ModifyClassDialog(ListGrid gird )
		{
			super( "修改班级" );
			this.gird = gird;
			form.editSelectedData( gird );
		}

		@Override
		public Canvas getView( )
		{
			VLayout wholepanel = getDefaultVLayout();
			form.reset();
			wholepanel.addMember( form );
			
			HLayout buttonpanel = new HLayout();
			buttonpanel.setMembersMargin( 10 );
			buttonpanel.setAlign( Alignment.CENTER );
			
			
			VLayout warp = new VLayout();
			warp.setWidth( 400 );
			warp.setAlign( VerticalAlignment.CENTER );
			
			MButton confirm = new MButton("确认" ){
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
								callback( memberid );
							}else{
								SC.say( "失败！" );
							}
							ModifyClassDialog.this.hide( );
						}
					} );					
				}
				
			};
			MButton cancel = new MButton("取消" ){
				@Override
				public void handleClick( )
				{
					ModifyClassDialog.this.hide( );
				}
			};
			
			buttonpanel.addMember( confirm );
			buttonpanel.addMember( cancel );
			warp.addMember( buttonpanel );
			wholepanel.addMember( warp );
			return wholepanel;
		}

		
		/**
		 * @return the gird
		 */
		public ListGrid getGird( )
		{
			return gird;
		}
		
		public void callback(int memberid){}
	}

	
	/**
	 * @return the list
	 */
	public ClassList getList( )
	{
		return list;
	}
	
}
