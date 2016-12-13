class ThreadYieldDemo{

	public static void main(String[] args) {
		MyThreadYield mt=new MyThreadYield();
		mt.setPriority(Thread.MAX_PRIORITY);
		mt.start();

		for (int i=0; i<10; i++) {
			System.out.println("Main Thread");
		}
	}
}