public class Loop {
    public void while_loop(String string) {
        int i = 1;
        while (i <= 5) {
            System.out.println("While Loops " + string + " " + i);
            i++;
        }
    }

    public void for_loop(String string) { 
        for (int i = 1; i <= 5; i++) {
            System.out.println("For Loop "+ string + " " + i);
        }
    }

    public void do_while_loop(String string) {
        int i = 1;
        do { 
            System.out.println("Do_While " + string + " " + i);
            i++;
        } 
        while (i <= 5);
    }
}