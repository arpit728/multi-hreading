class MyThread implements Runnable{

	public void run()
	{		
		for(int i=0;i<10;i++){
			System.out.println("Child Thread");
		}
		
	}
}

class ThreadDemo{
	
	public static void main(String[]args){

		MyThread runnable=new MyThread();

		Thread t=new Thread(runnable);
		t.setPriority(10);
		t.start();
		for(int i=0;i<10;i++){
			System.out.println("Main Thread");
		}
		

	}
}