package co.com.almundo.callcenter.threads;

public class CallThread implements Runnable {

	private void processCall() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
