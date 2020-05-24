//Print Zero Even Odd
//https://leetcode.com/problems/print-zero-even-odd/

// wait() notify() monitor

class ZeroEvenOdd {
    private int n;
    private int i = 1;
    private String step = "zero";
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while(i <= n) {
            synchronized(this) {
                if("zero".equals(step)) {
                    printNumber.accept(0);
                    if(i % 2 == 0) {
                        step = "even";
                    }
                    else {
                        step = "odd";
                    }
                    this.notifyAll();
                }
                else {
                    this.wait();
                }
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while(i <= n) {
            synchronized(this) {
                if("even".equals(step)) {
                    printNumber.accept(i);
                    i++;
                    step = "zero";
                    this.notifyAll();
                }
                else {
                    this.wait();
                }
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while(i <= n) {
            synchronized(this) {
                if("odd".equals(step)) {
                    printNumber.accept(i);
                    i++;
                    step = "zero";
                    this.notifyAll();
                }
                else {
                    this.wait();
                }
            }
        }
    }
}

// Semaphore

class ZeroEvenOdd {
    private int n;
    private int i = 1;
    private Semaphore sZero = new Semaphore(1);
    private Semaphore sOdd = new Semaphore(0);
    private Semaphore sEven = new Semaphore(0);
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while(i <= n) {
            sZero.acquire();
            if(i <= n) {
                printNumber.accept(0);
                if(i % 2 == 0) {
                    sEven.release();
                }
                else {
                    sOdd.release();
                }
            }
            else {
                sEven.release();
                sOdd.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while(i <= n) {
            sEven.acquire();
            if(i <= n) {
                printNumber.accept(i);
                i++;
                sZero.release();
            }
            else {
                sZero.release();
                sOdd.release();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while(i <= n) {
            sOdd.acquire();
            if(i <= n) {
                printNumber.accept(i);
                i++;
                sZero.release();
            }
            else {
                sZero.release();
                sEven.release();
            }
        }
    }
}
