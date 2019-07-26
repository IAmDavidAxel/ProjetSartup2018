package server.context;

import utility.ApplicationConfiguration;

import java.util.ArrayList;
import java.util.List;

public abstract class Context {

	protected List<Object> resourceContext = new ArrayList<>();

	public static Context create(){
		if(ApplicationConfiguration.mode != "dev" ){
			return new DevelopmentContext();
		}else {
			throw new UnknownModeServerException();
		}
	}

	public abstract void registerService();
	public abstract void initialiseService();

	public List<Object> getResourceContext() {
		return resourceContext;
	}
}
