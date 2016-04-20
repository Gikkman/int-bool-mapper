package com.gikk.int_bool_mapper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.stream.Stream;

import com.speedment.Speedment;
import com.speedment.component.Component;
import com.speedment.internal.core.platform.component.impl.AbstractComponent;
import com.speedment.internal.license.AbstractSoftware;
import com.speedment.license.License;
import com.speedment.license.Software;

public final class CustomMappingComponent extends AbstractComponent {
    CustomMappingComponent(Speedment speedment) {
        super(speedment);
    }


    public void onResolve() {
        getSpeedment().getTypeMapperComponent()
            .install(IntegerToBooleanMapper::new);
    }


    public Class<CustomMappingComponent> getComponentClass() {
        return CustomMappingComponent.class;
    }


    public Software asSoftware() {    	
        return AbstractSoftware.with(
            "Custom Mapping Component", 
            "1.0", 
            new MyLicense()
        );
    }


    public Component defaultCopy(Speedment speedment) {
        return new CustomMappingComponent(speedment);
    }
    
    private final class MyLicense implements License{
    	private final LinkedList<URL> url = new LinkedList<URL>();
    	
    	MyLicense(){
			try {
				URL temp = new URL("https://tldrlegal.com/license/mit-license");
				url.add( temp );
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}    		
    	}
    	
		public Type getType() {
			return Type.OPEN_SOURCE;
		}			
		public Stream<URL> getSources() {
			return url.stream();
		}			
		public String getName() {
			return "MIT License";
		}
	};
}
