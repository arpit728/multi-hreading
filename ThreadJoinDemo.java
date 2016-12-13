class MyThread extends Thread{

	public void run(){
	
		for (int i=0; i<10; i++) {
			System.out.println("Seeta Thread");
			try{
			Thread.sleep(1000);
			}
			catch(InterruptedException e){

			}
		}
	}
}
class ThreadJoinDemo{
	
	public static void main(String[] args)throws InterruptedException {
		
		MyThread mt=new MyThread();
		mt.start();
		mt.join();

		for (int i=0; i<10; i++)
			System.out.println("Rama Thread");
	}
}