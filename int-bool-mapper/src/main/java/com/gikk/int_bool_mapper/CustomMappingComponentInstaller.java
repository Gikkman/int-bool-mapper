package com.gikk.int_bool_mapper;

import com.speedment.Speedment;
import com.speedment.component.ComponentConstructor;

public final class CustomMappingComponentInstaller implements ComponentConstructor<CustomMappingComponent> {

    @Override
    public CustomMappingComponent create(Speedment speedment) {
    	return new CustomMappingComponent(speedment);      	
    }
}
