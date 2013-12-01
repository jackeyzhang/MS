package com.sickle.medu.ms.client.iportal.panel;

import com.sickle.medu.ms.client.iportal.dialog.RegisterDialog;
import com.sickle.medu.ms.client.iportal.list.MemberList;
import com.sickle.medu.ms.client.ui.widget.MButton;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


public class StudentPanel extends HLayout
{

	private VLayout buttonlayout = new VLayout();
	
	public StudentPanel()
	{
		setHeight( 300 );
		
		MemberList memberlist = new MemberList();
		
		MButton add = new MButton("增加学生"){
			@Override
			public void handleClick( )
			{
				new RegisterDialog( ).show( );
			}
		};
		
		MButton del = new MButton("删除学生"){
			@Override
			public void handleClick( )
			{
				new RegisterDialog( ).show( );
			}
		};
		
		MButton modify = new MButton("修改学生"){
			@Override
			public void handleClick( )
			{
				new RegisterDialog( ).show( );
			}
		};
		
		buttonlayout.setMembersMargin( 5 );
		buttonlayout.addMember( add );
		buttonlayout.addMember( modify );
		buttonlayout.addMember( del );
		
		addMember( memberlist );
		addMember( buttonlayout );
	}
	
	
}
