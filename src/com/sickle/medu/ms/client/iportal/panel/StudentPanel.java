package com.sickle.medu.ms.client.iportal.panel;

import com.sickle.medu.ms.client.iportal.dialog.StudentDialog;
import com.sickle.medu.ms.client.iportal.list.MemberList;
import com.sickle.medu.ms.client.ui.widget.MButton;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


public class StudentPanel extends HLayout
{

	private VLayout buttonlayout = new VLayout();
	
	private MemberList memberlist;
	
	public StudentPanel()
	{
		setHeight( 300 );
		
		memberlist = new MemberList();
		
		MButton add = new MButton("增加学生"){
			@Override
			public void handleClick( )
			{
				new StudentDialog( ).show( );
			}
		};
		
		MButton del = new MButton("删除学生"){
			@Override
			public void handleClick( )
			{
				if ( memberlist.getSelectedRecords( ).length == 0 )
				{
					SC.say( "请先选中一条要删除的记录" );
					return;
				}
				new StudentDialog( ).show( );
			}
		};
		
		MButton remove = new MButton("移除学生"){
			@Override
			public void handleClick( )
			{
				if ( memberlist.getSelectedRecords( ).length == 0 )
				{
					SC.say( "请先选中一条要删除的记录" );
					return;
				}
				new StudentDialog( ).show( );
			}
		};
		
		MButton modify = new MButton("修改学生"){
			@Override
			public void handleClick( )
			{
				if ( memberlist.getSelectedRecords( ).length == 0 )
				{
					SC.say( "请先选中一条要删除的记录" );
					return;
				}
				new StudentDialog( ).show( );
			}
		};
		
		buttonlayout.setMembersMargin( 5 );
		
		buttonlayout.addMember( add );
		buttonlayout.addMember( modify );
		buttonlayout.addMember( remove );
		buttonlayout.addMember( del );
		
		addMember( memberlist );
		addMember( buttonlayout );
	}
	
	
}
