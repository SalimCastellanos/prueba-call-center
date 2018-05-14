package co.com.almundo.callcenter.manager;

import java.util.concurrent.ExecutionException;

import co.com.almundo.callcenter.models.ResponseModel;

public interface DispatcherManager {
	
	public ResponseModel dispatchCall() throws InterruptedException, ExecutionException;

}
