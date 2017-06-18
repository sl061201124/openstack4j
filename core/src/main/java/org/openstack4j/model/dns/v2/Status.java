/*******************************************************************************
 * 	Copyright 2016 ContainX and OpenStack4j                                          
 * 	                                                                                 
 * 	Licensed under the Apache License, Version 2.0 (the "License"); you may not      
 * 	use this file except in compliance with the License. You may obtain a copy of    
 * 	the License at                                                                   
 * 	                                                                                 
 * 	    http://www.apache.org/licenses/LICENSE-2.0                                   
 * 	                                                                                 
 * 	Unless required by applicable law or agreed to in writing, software              
 * 	distributed under the License is distributed on an "AS IS" BASIS, WITHOUT        
 * 	WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the         
 * 	License for the specific language governing permissions and limitations under    
 * 	the License.                                                                     
 *******************************************************************************/
package org.openstack4j.model.dns.v2;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Status of a designate v2 recordset
 */
public enum Status {

	PENDING_CREATE, ACTIVE, PENDING_DELETE, ERROR;

	@JsonValue
	public String value() {
		return name().toUpperCase();
	}

	//default to PRIMARY
	@JsonCreator
	public static Status value(String v)
	{
		if (v == null) return ERROR;
		try {
			return valueOf(v.toUpperCase());
		} catch (IllegalArgumentException e) {
			return ERROR;
		}
	}

}