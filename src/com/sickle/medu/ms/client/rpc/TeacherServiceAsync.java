package com.sickle.medu.ms.client.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sickle.pojo.edu.Teacher;


public interface TeacherServiceAsync
{

	void addTeacher( Teacher Teacher, AsyncCallback<Teacher> callback );

	void deleteTeacher( Teacher Teacher, AsyncCallback<Teacher> callback );

	void listAllTeacher( int startIndex,int length , AsyncCallback<List<Teacher>> callback );

}
