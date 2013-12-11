/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.Student/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.sickle.medu.ms.client.rpc;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.sickle.pojo.edu.Student;

@RemoteServiceRelativePath("StudentService")
public interface StudentService extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static StudentServiceAsync instance;
		public static StudentServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(StudentService.class);
			}
			return instance;
		}
	}
	
	public List<Student> listAllStudent(int startIndex,int length );
	
	public List<Student> listStudent(int[] ids);
	
	public Student addStudent(int classid,Student student) throws Exception;
	
	public Student modifyStudent(Student Student) throws Exception;
	
	public Student deleteStudent(int classid, Student Student)throws Exception;
	
	public Student findStudent(int id)throws Exception;
}
