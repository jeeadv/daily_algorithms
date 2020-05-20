//Fizz Buzz Multithreaded
//https://leetcode.com/problems/fizz-buzz-multithreaded/

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
