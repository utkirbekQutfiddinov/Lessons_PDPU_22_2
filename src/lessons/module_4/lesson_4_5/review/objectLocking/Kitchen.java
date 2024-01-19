package lessons.module_4.lesson_4_5.review.objectLocking;

public class Kitchen {
    int mantilar=10;
    public synchronized void eat(){
        while(true){
            if(mantilar<0){
                try {
                    System.out.println("Manti tugapti, uxlayman...");
                    notifyAll();
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("Bor edi "+mantilar+", qoldi: "+(--mantilar));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public synchronized void cook(){
        while(true){
            if(mantilar>0){
                try {
                    System.out.println("Manti bor ekan, uxlayman...");
                    notifyAll();
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("Manti tayyorlayman...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Bor edi "+mantilar+", bo'ldi: "+(++mantilar));

            }
        }
    }
}
