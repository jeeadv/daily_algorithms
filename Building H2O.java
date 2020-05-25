//Building H2O
//https://leetcode.com/problems/building-h2o/

class H2O {

    public H2O() {
        
    }
    
    Semaphore hydro = new Semaphore(2);
    Semaphore oxy = new Semaphore(0);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		
        hydro.acquire();
        releaseHydrogen.run();
        oxy.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        
	    oxy.acquire(2);
        releaseOxygen.run();
        hydro.release(2);
    }
}
