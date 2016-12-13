class MyThread extends Thread{

	public void run(){

		try{
			for (int i=0; i<10; i++) {
				System.out.println("I am a lazy thread.");
				Thread.sleep(1000);
			}
		}
		catch (InterruptedException e) {
			System.out.println("I got Interrupted");
		}
	}
}

class ThreadInterruptDemo{

	public static void main(String[] args) {
		
		MyThread mt=new MyThread();
		mt.start();
		mt.interrupt();
		System.out.println("End of main thread");
	}
}