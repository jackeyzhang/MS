/**
 * 
 */
package com.sickle.medu.ms.client.form;

import com.sickle.medu.ms.client.datasource.OrgDataSource;
import com.sickle.pojo.edu.Org;
import com.smartgwt.client.data.DataSource;


/**
 * 公司表单
 * 
 * @author chenhao
 *
 */
public class OrgDForm extends AbstractListDForm 
{

	public OrgDForm()
	{
		super();
	}

	@Override
	public int getOP( )
	{
		return -1;
	}

	@Override
	public DataSource getDataSource( )
	{
		return OrgDataSource.getInstance( ).getDataSource( Org.class );
	}

	@Override
	public String getQueryName( )
	{
		return OrgDataSource.getInstance( ).getQueryName( );
	}

	@Override
	public String getAddButtonTitle( )
	{
		return "增加新公司";
	}

	@Override
	public String getModifyButtonTitle( )
	{
		return "修改公司";
	}

	@Override
	public String getRemoveButtonTitle( )
	{
		return "删除公司";
	}

	@Override
	public String getSearchButtonTitle( )
	{
		return "根据名字查找";
	}
	
	
}
