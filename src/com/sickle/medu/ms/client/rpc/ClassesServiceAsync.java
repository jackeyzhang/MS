package com.sickle.medu.ms.client.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sickle.pojo.edu.Classes;


public interface ClassesServiceAsync
{

	void addClasses( Classes Classes, AsyncCallback<Classes> callback );

	void deleteClasses( Classes Classes, AsyncCallback<Classes> callback );

	void listAllClasses( int startIndex, int length,
			AsyncCallback<List<Classes>> callback );

}
