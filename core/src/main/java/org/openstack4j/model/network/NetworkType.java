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
package org.openstack4j.model.network;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * The type of Network
 * 
 * @author Jeremy Unruh
 */
public enum NetworkType {
  LOCAL,
  FLAT,
  VLAN,
  VXLAN,
  GRE
	;
	
	@JsonCreator
	public static NetworkType forValue(String value) {
		if (value != null)
		{
			for (NetworkType s : NetworkType.values()) {
				if (s.name().equalsIgnoreCase(value))
					return s;
			}
		}
		return null;
	}
	
	@JsonValue
	public String toJson() {
		return name().toLowerCase();
	}
	
}
