package test;

public class SieveOfErastosthenes {

    private static void sieve(int n) {
        long a = System.nanoTime();
        boolean[] prime = new boolean[n+1];  //make boolean array and initialise to true
        for(int i = 0; i <= n; i++) prime[i] = true;

        for(int p = 2; p * p <= n; p++) {
            if(prime[p]) {
                for(int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }

        long current = System.nanoTime() - a;
        System.out.println(current);
        for(int i = 2; i <= n; i++) {
            if(prime[i]) System.out.print(i + " ");
        }
    }
    private static void sieve(int limit, boolean myWay) {
        long a = System.nanoTime();

        boolean[] prime = new boolean[limit+1]; //+1 to offset zero start
        for (int i = 0; i <= limit; i++) prime[i] = true;
        for (int i = 3; i * i <= limit ; i+=2) prime[i] = false;
        for (int i = 2; i <= limit ; i++)
            if(prime[i]) System.out.print(i + ", ");

        long time = System.nanoTime() - a;
        System.out.println(time);
    }


    public static void main(String[] args) {
        sieve(10000);
        System.out.println();
        sieve(10000, true);
    }
}
