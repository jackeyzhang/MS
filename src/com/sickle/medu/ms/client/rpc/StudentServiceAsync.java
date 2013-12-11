package com.sickle.medu.ms.client.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sickle.pojo.edu.Student;


public interface StudentServiceAsync
{

	void addStudent( int classid, Student student,
			AsyncCallback<Student> callback );

	void deleteStudent(int classid,  Student Student, AsyncCallback<Student> callback );

	void findStudent( int id, AsyncCallback<Student> callback );

	void listAllStudent( int startIndex, int length,
			AsyncCallback<List<Student>> callback );

	void listStudent( int[] ids, AsyncCallback<List<Student>> callback );

	void modifyStudent( Student Student, AsyncCallback<Student> callback );

}
