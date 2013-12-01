package com.sickle.medu.ms.client.iportal.list;

import com.sickle.medu.ms.client.datasource.MemberDataSource;
import com.sickle.medu.ms.client.form.withwidget.AbstractListGrid;
import com.sickle.pojo.edu.Member;
import com.smartgwt.client.data.DataSource;


public class MemberList extends AbstractListGrid
{

	public MemberList()
	{
		setWidth( "90%" );
		setHeight( "90%" );
		setAutoFetchData( true );
		maskAndSetFields( getDataSource() );
	}
	
	public DataSource getDataSource( )
	{
		return MemberDataSource.getInstance( ).getDataSource( Member.class );
	}
}
