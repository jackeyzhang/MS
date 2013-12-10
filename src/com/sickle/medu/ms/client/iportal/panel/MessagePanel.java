/**
 * 
 */
package com.sickle.medu.ms.client.iportal.panel;

import java.util.Date;

import com.sickle.medu.ms.client.iportal.dialog.SendMessageDialog;
import com.sickle.medu.ms.client.iportal.list.MessageList;
import com.sickle.medu.ms.client.iportal.page.IndexPage;
import com.sickle.medu.ms.client.ui.widget.button.MButton;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


/**
 * message panel
 * 
 * @author chenhao
 *
 */
public class MessagePanel extends HLayout
{

	private MessageList list = new MessageList();
	
	private VLayout buttonpanel = new VLayout();
	
	public MessagePanel()
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
		
		buttonpanel.addMember( new MButton("回复消息"){
			@Override
			public void handleClick( )
			{
				SendMessageDialog messagedialog = new SendMessageDialog( ){
					@Override
					public void preSubmit( DynamicForm form )
					{
						Member send = IndexPage.getInstance( ).getTopbar( ).getMember( );
						form.setValue( "send", send == null ? 97 : send.getId( ) );
						form.setValue( "receiver", 97 );
						form.setValue( "receivetime", new Date() );
					}
				};
				messagedialog.getForm( );
				messagedialog.show();
			}} );
		
		buttonpanel.addMember( new MButton("删除消息"){
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
		
		buttonpanel.addMember( new MButton("修改消息"){
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
	
}
