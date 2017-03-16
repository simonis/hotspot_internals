package org.simonis;

public class NullCheck_CompOops {
    
    NullCheck_CompOops nc;

    public static void getField_1(NullCheck_CompOops n1, NullCheck_CompOops n2) {
        long tmp = n1.nc.l0001;
        n1.l0001 = n2.l0001;
        n2.l0001 = tmp;
    }

    static void prompt(String msg) {
        System.out.println("==========================================");
        System.out.println(msg);
        System.out.println("==========================================");
        System.console().readLine();        
    }
    public static void main(String[] args) {

        NullCheck_CompOops n1 = new NullCheck_CompOops();
        n1.nc = n1;
        NullCheck_CompOops n2 = new NullCheck_CompOops();
        prompt("Press <RETURN>");

        prompt("Calling getField_1() to JIT-compile it:");
        for (int i = 0; i < 20_000; i++) {
            getField_1(n1, n1);
        }
        for (int i = 1; i < 6; i++) {
            prompt(i + ": calling getField_1() with a NULL field:");
            try {
                getField_1(n2, n1);                
            } catch (NullPointerException npe) { npe.printStackTrace(System.out); }
        }
        prompt("Calling getField_1() to JIT-compile it again:");
        for (int i = 0; i < 20_000; i++) {
            getField_1(n1, n1);
        }
    }

    long l0000, l0001, l0002, l0003, l0004, l0005, l0006, l0007, l0008, l0009;
}
