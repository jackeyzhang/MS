package com.sickle.medu.ms.client.datasource.field;

import com.smartgwt.client.data.SimpleType;
import com.smartgwt.client.data.fields.DataSourceSimpleTypeField;


public class MaskField extends DataSourceSimpleTypeField implements Comparable<MaskField>
{

	private int mask,index = -1;
	
	public static final String STYPE = "stype", MASK = "smask";
	
	/**
	 * @param name
	 * @param simpleType
	 * @param title
	 */
	public MaskField( String name, String simpleType, String title, int index)
	{
		this(name,simpleType,title,-1,index);
	}
	
	
	
	/**
	 * @param name
	 * @param simpleType
	 * @param title
	 */
	public MaskField( String name, String simpleType, String title, int mask,int _index )
	{
		super( name, new SimpleType(), title );
		this.mask = mask;
		this.index = _index;
		this.setAttribute( STYPE, simpleType );
		this.setAttribute( MASK, mask );
	}


	
	/**
	 * @return the mask
	 */
	public int getMask( )
	{
		return mask;
	}

	
	/**
	 * @param mask the mask to set
	 */
	public void setMask( int mask )
	{
		this.mask = mask;
		this.setAttribute( MASK, mask );
	}



	@Override
	public int compareTo( MaskField o )
	{
		return this.index - o.index ;
	}
	
	
	
}
