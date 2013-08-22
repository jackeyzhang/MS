/**
 * 
 */
package com.sickle.medu.ms.client.form;

import com.sickle.medu.ms.client.datasource.TeacherDataSource;
import com.sickle.pojo.edu.Teacher;
import com.smartgwt.client.data.DataSource;


/**
 * 教师表单
 * 
 * @author chenhao
 *
 */
public class TeacherDForm extends AbstractListDForm 
{

	public TeacherDForm()
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
		return TeacherDataSource.getInstance( ).getDataSource( Teacher.class );
	}

	@Override
	public String getQueryName( )
	{
		return TeacherDataSource.getInstance( ).getQueryName( );
	}

	@Override
	public String getAddButtonTitle( )
	{
		return "增加新教师";
	}

	@Override
	public String getModifyButtonTitle( )
	{
		return "修改教师";
	}

	@Override
	public String getRemoveButtonTitle( )
	{
		return "删除教师";
	}

	@Override
	public String getSearchButtonTitle( )
	{
		return "根据名字查找";
	}
	
	
}
