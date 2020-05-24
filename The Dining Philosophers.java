//The Dining Philosophers
//https://leetcode.com/problems/the-dining-philosophers/

class DiningPhilosophers {

    public DiningPhilosophers() {
        
    }
    
    Semaphore s0 = new Semaphore(1);
    Semaphore s1 = new Semaphore(1);
    Semaphore s2 = new Semaphore(1);
    Semaphore s3 = new Semaphore(1);
    Semaphore s4 = new Semaphore(1);

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        if(philosopher == 0) {
            s0.acquire();
            s1.acquire();
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            s0.release();
            s1.release();
        }
        else if(philosopher == 1) {
            s1.acquire();
            s2.acquire();
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            s1.release();
            s2.release();
        }
        else if(philosopher == 2) {
            s2.acquire();
            s3.acquire();
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            s2.release();
            s3.release();
        }
        else if(philosopher == 3) {
            s3.acquire();
            s4.acquire();
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            s3.release();
            s4.release();
        }
        else {
            s4.acquire();
            s0.acquire();
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
            s4.release();
            s0.release();
        }
    }
}
