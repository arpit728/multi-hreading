class A{

	public synchronized void d1(B b){
		System.out.println("Thread-1 starts execution");
		
		try
		{
			Thread.sleep(2000);
		}
		catch(InterruptedException e){}
		System.out.println("Thread-1 trying to call B's last method");
		b.last();
	}

	public synchronized void last(){
		System.out.println("Inside A, This is last method");
	}
}

class B{

	public synchronized void d2(A a){
		System.out.println("Thread-2 starts execution");
		try{
			Thread.sleep(2000);
		}
		catch(InterruptedException e){}
		System.out.println("Thread-2 trying to call A's last method");
		a.last();
	}

	public synchronized void last(){
		System.out.println("Inside B, This is last method");
	}
}


class DeadLockDemo extends Thread{
	A a=new A();
	B b=new B();

	void m1(){
		this.start();
		a.d1(b);//This line is executed by main thread.
	}

	public void run(){
		b.d2(a);
	}

	public static void main(String[] args) {
		DeadLockDemo d=new DeadLockDemo();
		d.m1();
	}
}