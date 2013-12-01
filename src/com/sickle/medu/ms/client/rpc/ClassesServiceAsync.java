package com.sickle.medu.ms.client.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sickle.pojo.edu.Cls;


public interface ClassesServiceAsync
{

	void addClasses( Cls Classes, AsyncCallback<Cls> callback );

	void deleteClasses( Cls Classes, AsyncCallback<Cls> callback );

	void listAllClasses( int startIndex, int length,
			AsyncCallback<List<Cls>> callback );

	void modifyClasses( Cls Cls, AsyncCallback<Cls> callback );

}
