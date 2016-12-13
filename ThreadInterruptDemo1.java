class MyThread extends Thread{

	public void run(){

		for (int i=0; i<500; i++) {
			System.out.println("I am a lazy thread.");
		}
		try{
			System.out.println("I am entering sleeping state.");
			Thread.sleep(4000);
		}
		catch(InterruptedException e) {
			System.out.println("I got interrupted.");
		}
	}
}

class ThreadInterruptDemo1{
	public static void main(String[] args) {
		MyThread mt=new MyThread();
		mt.start();
		mt.interrupt();
		System.out.println("End of main thread.");
	}
}