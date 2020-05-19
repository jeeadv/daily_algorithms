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
