class ProducerThread extends Thread{
	A a;

	ProducerThread(A a){
		this.a=a;
	}

	void produce(){
		synchronized (a)
		{
			a.count++;
			a.notify();
		}
		
	}
	public void run(){
		while(true)
			{
				produce();
				System.out.println("producer "+a.count);
			}

	}
}

class ConsumerThread extends Thread{
	A a;

	ConsumerThread(A a){
		this.a=a;
	}

	void consume()throws InterruptedException{

		synchronized (a)
		{
			if (a.count==0) {
				a.wait();
			}
			else a.count--;
		}
		
	}
	public void run(){
		try{
			while(true)
			{
				consume();
				System.out.println("consumer "+a.count);	
			}
				
		}catch (InterruptedException e) {
			System.out.println(e);

		}
	}
}

class ProducerConsumerProblem{

	public static void main(String[] args)throws Exception {
		Integer count=0;
		A a=new A();
		a.count=0;
		ProducerThread pt=new ProducerThread(a);
		ConsumerThread ct=new ConsumerThread(a);
		pt.start();
		ct.start();
	}

	
}

class A{
	Integer count;
}