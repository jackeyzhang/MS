/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.Teacher/legal/epl-v10.html
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
import com.sickle.pojo.edu.Teacher;

@RemoteServiceRelativePath("TeacherService")
public interface TeacherService extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static TeacherServiceAsync instance;
		public static TeacherServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(TeacherService.class);
			}
			return instance;
		}
	}
	
	public List<Teacher> listAllTeacher(int startIndex);
	
	public Teacher addTeacher(Teacher Teacher) throws Exception;
	
	public Teacher deleteTeacher(Teacher Teacher)throws Exception;
}
