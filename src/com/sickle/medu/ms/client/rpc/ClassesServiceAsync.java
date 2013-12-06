package com.sickle.medu.ms.client.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sickle.pojo.edu.Cls;
import com.sickle.pojo.edu.Member;


public interface ClassesServiceAsync
{

	void addClasses( Cls Classes, AsyncCallback<Cls> callback );

	void deleteClasses( Cls Classes, AsyncCallback<Cls> callback );

	void listAllClasses( int startIndex, int length,
			AsyncCallback<List<Cls>> callback );

	void modifyClasses( Cls Cls, AsyncCallback<Cls> callback );

	void findClass( int classid, AsyncCallback<Cls> callback );

	void findStudents( int classsid, AsyncCallback<List<Member>> callback );

	void listClasses( int memberid, AsyncCallback<List<Cls>> callback );

	void addClass( int memberid, Cls Cls, AsyncCallback<Cls> callback );

}
