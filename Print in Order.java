//Print in Order
//https://leetcode.com/problems/print-in-order/

class Foo {

    public Foo() {
        
    }
    
    public static int step = 1;

    public void first(Runnable printFirst) throws InterruptedException {
        while(true) {
            if(step == 1) {
                printFirst.run();
                step = 2;
                break;
            }
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(true) {
            if(step == 2) {
                printSecond.run();
                step = 3;
                break;
            }
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(true) {
            if(step == 3) {
                printThird.run();
                step = 1;
                break;
            }
        }
    }
}


class Foo {

    public Foo() {
        
    }
    
    public static int step = 1;

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized(this) {
            while(step != 1) {
                this.wait();
            }
            
            printFirst.run();
            step = 2;
            this.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized(this) {
            while(step != 2) {
                this.wait();
            }
            
            printSecond.run();
            step = 3;
            this.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized(this) {
            while(step != 3) {
                this.wait();
            }
            
            printThird.run();
            step = 1;
            this.notifyAll();
        }
    }
}
