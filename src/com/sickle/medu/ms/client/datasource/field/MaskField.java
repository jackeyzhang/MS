package com.sickle.medu.ms.client.datasource.field;

import com.smartgwt.client.data.SimpleType;
import com.smartgwt.client.data.fields.DataSourceSimpleTypeField;


public class MaskField extends DataSourceSimpleTypeField
{

	private int mask;
	
	public static final String STYPE = "stype", MASK = "smask";
	
	/**
	 * @param name
	 * @param simpleType
	 * @param title
	 */
	public MaskField( String name, String simpleType, String title)
	{
		this(name,simpleType,title,-1);
	}
	
	
	
	/**
	 * @param name
	 * @param simpleType
	 * @param title
	 */
	public MaskField( String name, String simpleType, String title, int mask )
	{
		super( name, new SimpleType(), title );
		this.mask = mask;
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
	
}
