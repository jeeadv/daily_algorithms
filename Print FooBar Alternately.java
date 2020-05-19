//Print FooBar Alternately
//https://leetcode.com/problems/print-foobar-alternately/
class FooBar {
    private int n;
    public static boolean even = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	while(true) {
                if(even) {
                    printFoo.run();
                    even = !even;
                    break;
                }
            }
        	
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            while(true) {
                if(!even) {
                    printBar.run();
                    even = !even;
                    break;
                }
            }
        }
    }
}


class FooBar {
    private int n;
    private boolean even = true;

    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	if(!this.even) {
                this.wait();
            }
            
            printFoo.run();
            this.even = !this.even;
            this.notify();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            if(this.even) {
                this.wait();
            }
            
            printBar.run();
            this.even = !this.even;
            this.notify();
        }
    }
}


class FooBar {
    private int n;
    private boolean even = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized(this) {
                if(!this.even) {
                    this.wait();
                }

                printFoo.run();
                this.even = !this.even;
                this.notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            synchronized(this) {
                if(this.even) {
                    this.wait();
                }

                printBar.run();
                this.even = !this.even;
                this.notify();
            }
        }
    }
}

class FooBar {
    private int n;
    private Semaphore foo = new Semaphore(1);
    private Semaphore bar = new Semaphore(0);
    
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            foo.acquire();
        	printFoo.run();
            bar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            bar.acquire();
        	printBar.run();
            foo.release();
        }
    }
}
