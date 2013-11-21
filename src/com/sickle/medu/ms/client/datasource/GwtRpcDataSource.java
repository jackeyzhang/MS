/**
 * 
 */

package com.sickle.medu.ms.client.datasource;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.core.client.JavaScriptObject;
import com.gwtent.reflection.client.ClassType;
import com.gwtent.reflection.client.Field;
import com.gwtent.reflection.client.TypeOracle;
import com.sickle.uireflect.FieldType;
import com.sickle.uireflect.Mask;
import com.sickle.uireflect.Reflect_Field;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceDateField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourcePasswordField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.types.DSDataFormat;
import com.smartgwt.client.types.DSProtocol;
import com.smartgwt.client.util.JSOHelper;
import com.smartgwt.client.widgets.grid.ListGridRecord;

/**
 * GWt异步返回datasource
 * 
 * @author chenhao
 * 
 */
public abstract class GwtRpcDataSource extends AbstractDataSource
{

	@SuppressWarnings("rawtypes")
	private static Map<Class, DataSource> cache = new HashMap<Class, DataSource>( );

	private DataSource datasource;

	public GwtRpcDataSource( )
	{
		datasource = new DataSource( ) {

			@Override
			protected Object transformRequest( DSRequest request )
			{
				String requestId = request.getRequestId( );
				DSResponse response = new DSResponse( );
				response.setAttribute( "clientContext",
						request.getAttributeAsObject( "clientContext" ) );
				// Asume success
				response.setStatus( 0 );
				switch ( request.getOperationType( ) )
				{
					case FETCH :
						executeFetch( requestId, request, response );
						break;
					case ADD :
						executeAdd( requestId, request, response );
						break;
					case UPDATE :
						executeUpdate( requestId, request, response );
						break;
					case REMOVE :
						executeRemove( requestId, request, response );
						break;
					default :
						break;
				}
				return request.getData( );
			}

		};
		datasource.setDataProtocol( DSProtocol.CLIENTCUSTOM );
		datasource.setDataFormat( DSDataFormat.CUSTOM );
		datasource.setClientOnly( false );
	}

	protected abstract void executeFetch( String requestId, DSRequest request,
			DSResponse response );

	protected abstract void executeAdd( String requestId, DSRequest request,
			DSResponse response );

	protected abstract void executeUpdate( String requestId, DSRequest request,
			DSResponse response );

	protected abstract void executeRemove( String requestId, DSRequest request,
			DSResponse response );

	@Override
	public <T> DataSource getDataSource( Class<T> cls )
	{
		if ( cache.containsKey( cls ) )
		{
			return cache.get( cls );
		}
		ClassType<T> classType = TypeOracle.Instance.getClassType( cls );
		Field[] fs = classType.getFields( );
		for ( Field f : fs )
		{
			Reflect_Field field = f.getAnnotation( Reflect_Field.class );
			if ( field == null || field.isshow( ) == false)
			{
				continue;
			}
			DataSourceField newfield = new DataSourceTextField( f.getName( ),
					field.title( ) );
			
			if ( field.type( ).equals( FieldType.Integer ) )
			{
				newfield = new DataSourceIntegerField( f.getName( ),
						field.title( ) );
			}
			else if ( field.type( ).equals( FieldType.Password ) )
			{
				newfield = new DataSourcePasswordField( f.getName( ), field.title( ) );
			}
			else if ( field.type( ).equals( FieldType.Date ) )
			{
				newfield = new DataSourceDateField( f.getName( ), field.title( ) );
			}
			else if ( field.type( ).equals( FieldType.Email ) )
			{
				newfield = new DataSourceTextField( f.getName( ), field.title( ) );
				newfield.setValidators( emailValidator );
			}
			
			formatField(newfield,field.mask( ));
			
			if ( field.isId( ) )
			{
				newfield.setPrimaryKey( true );
				newfield.setHidden( true );
			}
			
			if( field.reqiured( ))
			{
				newfield.setRequired( true );
			}
			
			datasource.addField( newfield );
		}
		cache.put( cls, datasource );
		return datasource;
	}
	
	private void formatField(DataSourceField field,Integer mask){
		if( (mask.byteValue( ) & Mask.showInAdd.getValue( ).byteValue( )) == 0)
		{
			field.setCanEdit( true );
		}else{
			field.setCanEdit( false );
		}
	}

	public <T> void copyValues( T from, ListGridRecord to )
	{
		@SuppressWarnings("unchecked")
		ClassType<T> classType = TypeOracle.Instance.getClassType( from
				.getClass( ).getName( ) );
		Field[] fs = classType.getFields( );
		for ( Field f : fs )
		{
			Reflect_Field field = f.getAnnotation( Reflect_Field.class );
			if ( field == null )
			{
				continue;
			}
			to.setAttribute( f.getName( ), f.getFieldValue( from ) );
		}
	}

	public <T> void copyValues( ListGridRecord from, T to )
	{
		@SuppressWarnings("unchecked")
		ClassType<T> classType = TypeOracle.Instance.getClassType( to
				.getClass( ).getName( ) );
		Field[] fs = classType.getFields( );
		for ( Field f : fs )
		{
			Reflect_Field field = f.getAnnotation( Reflect_Field.class );
			if ( field == null )
			{
				continue;
			}
			String value = from.getAttributeAsString( f.getName( ) );
			if( field.isId( )){
				if( value == null || value.isEmpty( ))
				{
					f.setFieldValue( to, 12345 );
				}
				else
				{
					f.setFieldValue( to, Integer.decode( value ) );
				}
			}
			else if ( field.type( ).equals( FieldType.Integer ) )
			{
				f.setFieldValue( to, Integer.decode( value == null ? "-1" : value ) );
			}
			else if ( field.type( ).equals( FieldType.Password ) )
			{
				f.setFieldValue( to, value == null ? "-1" : value );
			}
			else if ( field.type( ).equals( FieldType.Date ) )
			{
				f.setFieldValue( to, value == null ? "-1" : value );
			}
			else if ( field.type( ).equals( FieldType.Float ) )
			{
				f.setFieldValue( to, Float.parseFloat( value == null ? "-1" : value ) );
			}
			else
			{
				f.setFieldValue( to, value == null ? "null" : value );
			}
			
		}
	}

	protected ListGridRecord getEditedRecord( DSRequest request )
	{
		// Retrieving values before edit
		JavaScriptObject oldValues = request
				.getAttributeAsJavaScriptObject( "oldValues" );
		// Creating new record for combining old values with changes
		ListGridRecord newRecord = new ListGridRecord( );
		// Copying properties from old record
		JSOHelper.apply( oldValues, newRecord.getJsObj( ) );
		// Retrieving changed values
		JavaScriptObject data = request.getData( );
		// Apply changes
		JSOHelper.apply( data, newRecord.getJsObj( ) );
		return newRecord;
	}
}
