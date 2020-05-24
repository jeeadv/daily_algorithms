//Fizz Buzz Multithreaded
//https://leetcode.com/problems/fizz-buzz-multithreaded/

// simple

class FizzBuzz {
    private int n;
    private int i = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(i <= n) {
            if(onlyDivisibleBy3(i)) {
                printFizz.run();
                i++;
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(i <= n) {
            if(onlyDivisibleBy5(i)) {
                printBuzz.run();
                i++;
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(i <= n) {
            if(divisibleBy3And5(i)) {
                printFizzBuzz.run();
                i++;
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(i <= n) {
            if(divisibleByOther(i)) {
                printNumber.accept(i);
                i++;
            }
        }
    }
    
    public boolean onlyDivisibleBy3(int i) {
        return i % 3 == 0 && i % 5 != 0;
    }
    
    public boolean onlyDivisibleBy5(int i) {
        return i % 3 != 0 && i % 5 == 0;
    }
    
    public boolean divisibleBy3And5(int i) {
        return i % 3 == 0 && i % 5 == 0;
    }
    
    public boolean divisibleByOther(int i) {
        return !onlyDivisibleBy3(i) && !onlyDivisibleBy5(i) && !divisibleBy3And5(i);
    }
}

//wait notify

class FizzBuzz {
    private int n;
    private int i = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(i <= n) {
            synchronized(this){
                if(onlyDivisibleBy3(i)) {
                    printFizz.run();
                    i++;
                    this.notifyAll();
                }
                else {
                    this.wait();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(i <= n) {
            synchronized(this){
                if(onlyDivisibleBy5(i)) {
                    printBuzz.run();
                    i++;
                    this.notifyAll();
                }
                else {
                    this.wait();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(i <= n) {
            synchronized(this){
                if(divisibleBy3And5(i)) {
                    printFizzBuzz.run();
                    i++;
                    this.notifyAll();
                }
                else {
                    this.wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(i <= n) {
            synchronized(this){
                if(divisibleByOther(i)) {
                    printNumber.accept(i);
                    i++;
                    this.notifyAll();
                }
                else {
                    this.wait();
                }
            }
        }
    }
    
    public boolean onlyDivisibleBy3(int i) {
        return i % 3 == 0 && i % 5 != 0;
    }
    
    public boolean onlyDivisibleBy5(int i) {
        return i % 3 != 0 && i % 5 == 0;
    }
    
    public boolean divisibleBy3And5(int i) {
        return i % 3 == 0 && i % 5 == 0;
    }
    
    public boolean divisibleByOther(int i) {
        return !onlyDivisibleBy3(i) && !onlyDivisibleBy5(i) && !divisibleBy3And5(i);
    }
}


// Semphore

class FizzBuzz {
    private int n;
    private int i = 1;
    private Semaphore s3 = new Semaphore(0);
    private Semaphore s5 = new Semaphore(0);
    private Semaphore s35 = new Semaphore(0);
    private Semaphore s = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(i <= n) {
        	//System.out.println("fizz waiting!");
            s3.acquire();
            //System.out.println("fizz running!");
            if(i <= n) {
                printFizz.run();
                i++;
                if(i > n) {
                	s.release();
                	s3.release();
                	s5.release();
                	s35.release();
                }
                else if(i % 15 == 0) {
                    s35.release();
                }
                else if(i % 5 == 0) {
                    s5.release();
                }
                else if(i % 3 == 0) {
                    s3.release();
                }
                else {
                    s.release();
                }
            }
            
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(i <= n) {
        	//System.out.println("buzz waiting!");
            s5.acquire();
            //System.out.println("buzz running!");
            if(i <= n) {
                printBuzz.run();
                i++;
                if(i > n) {
                	s.release();
                	s3.release();
                	s5.release();
                	s35.release();
                }
                else if(i % 15 == 0) {
                    s35.release();
                }
                else if(i % 5 == 0) {
                    s5.release();
                }
                else if(i % 3 == 0) {
                    s3.release();
                }
                else {
                    s.release();
                }
            }
            
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(i <= n) {
        	//System.out.println("fizzbuzz waiting!");
            s35.acquire();
            //System.out.println("fizzbuzz running!");
            if(i <= n) {
                printFizzBuzz.run();
                i++;
                if(i > n) {
                	s.release();
                	s3.release();
                	s5.release();
                	s35.release();
                }
                else if(i % 15 == 0) {
                    s35.release();
                }
                else if(i % 5 == 0) {
                    s5.release();
                }
                else if(i % 3 == 0) {
                    s3.release();
                }
                else {
                    s.release();
                }
            }
            
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(i <= n) {
        	//System.out.println("number waiting!");
            s.acquire();
            //System.out.println("number running!");
            if(i <= n) {
                printNumber.accept(i);
                i++;
                if(i > n) {
                	s.release();
                	s3.release();
                	s5.release();
                	s35.release();
                }
                else if(i % 15 == 0) {
                    s35.release();
                }
                else if(i % 5 == 0) {
                    s5.release();
                }
                else if(i % 3 == 0) {
                    s3.release();
                }
                else {
                    s.release();
                }
            }
            
        }
    }
}
