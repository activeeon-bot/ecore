package org.occiware.clouddesigner.occi.docker.connector.dockermachine.aspect;

import java.util.Map;
import org.occiware.clouddesigner.occi.docker.Machine_Google_Compute_Engine;
import org.occiware.clouddesigner.occi.docker.connector.dockermachine.aspect.MachineGoogleComputeEngineAspectMachine_Google_Compute_EngineAspectProperties;

@SuppressWarnings("all")
public class MachineGoogleComputeEngineAspectMachine_Google_Compute_EngineAspectContext {
  public final static MachineGoogleComputeEngineAspectMachine_Google_Compute_EngineAspectContext INSTANCE = new MachineGoogleComputeEngineAspectMachine_Google_Compute_EngineAspectContext();
  
  public static MachineGoogleComputeEngineAspectMachine_Google_Compute_EngineAspectProperties getSelf(final Machine_Google_Compute_Engine _self) {
    		if (!INSTANCE.map.containsKey(_self))
    			INSTANCE.map.put(_self, new org.occiware.clouddesigner.occi.docker.connector.dockermachine.aspect.MachineGoogleComputeEngineAspectMachine_Google_Compute_EngineAspectProperties());
    		return INSTANCE.map.get(_self);
  }
  
  private Map<Machine_Google_Compute_Engine, MachineGoogleComputeEngineAspectMachine_Google_Compute_EngineAspectProperties> map = new java.util.WeakHashMap<org.occiware.clouddesigner.occi.docker.Machine_Google_Compute_Engine, org.occiware.clouddesigner.occi.docker.connector.dockermachine.aspect.MachineGoogleComputeEngineAspectMachine_Google_Compute_EngineAspectProperties>();
  
  public Map<Machine_Google_Compute_Engine, MachineGoogleComputeEngineAspectMachine_Google_Compute_EngineAspectProperties> getMap() {
    return map;
  }
}