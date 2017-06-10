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
package org.openstack4j.openstack.telemetry.internal;

import org.openstack4j.api.telemetry.CapabilitiesService;
import org.openstack4j.model.telemetry.Capabilities;
import org.openstack4j.openstack.telemetry.domain.CeilometerCapabilities;

/**
 * Provides Measurements for Telemetry capabilities within an OpenStack deployment
 * 
 * @author Shital Patil
 */
public class CapabilitiesServiceImpl extends BaseTelemetryServices implements CapabilitiesService {

    /**
     * {@inheritDoc}
     */
    @Override
    public Capabilities get() {
        CeilometerCapabilities capabilities = get(CeilometerCapabilities.class, uri("/capabilities")).execute();
        return capabilities;
    }

}
