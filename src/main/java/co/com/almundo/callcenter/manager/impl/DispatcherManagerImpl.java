package co.com.almundo.callcenter.manager.impl;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.stereotype.Component;

import co.com.almundo.callcenter.manager.DispatcherManager;
import co.com.almundo.callcenter.models.Charges;
import co.com.almundo.callcenter.models.Operator;
import co.com.almundo.callcenter.models.ResponseModel;

@Component
public class DispatcherManagerImpl implements DispatcherManager {

	private static final int NUMERO_MAXIMO_LLAMADAS_CONCURRENTES = 10;

	private static ExecutorService callPool = Executors.newFixedThreadPool(NUMERO_MAXIMO_LLAMADAS_CONCURRENTES);

	@Override
	public ResponseModel dispatchCall() throws InterruptedException, ExecutionException {

		Future<ResponseModel> answer;

		Callable<ResponseModel> callable = new Callable<ResponseModel>() {
			@Override
			public ResponseModel call() {

				processCall();

				Operator operator = new Operator();
				operator.setName("Salim Castellanos");
				operator.setCharge(Charges.SUPERVISOR);

				ResponseModel response = new ResponseModel();
				response.setOperator(operator);
				response.setCallDurationInSeconds(43);

				return response;
			}
		};

		answer = callPool.submit(callable);
		
		while(!answer.isDone()) {
		    System.out.println("Calculating...");
		    Thread.sleep(300);
		}
		
		ResponseModel answerCall = (ResponseModel) answer.get();

		return answerCall;
	}

	private void processCall() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
