
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Thread Havuzları ve Excecutor Service kullanımları == 

bizim bu yapılara neden ihtiyacımız var ? 

büyük projelerde yüzlerce thread olabilir bunların kontrollerini sağlamak programcı açısından sıkıntı oluşturabilir.

bu threadlerin aynı anda çalışması belleğimizi gereksiz yere yorabilir.

bunların kontrolunü kendimiz yapmak yerine executorservice'e vererek kod sayımız azalıyor.Hata sayısında ve zamandan kazanc elde etmiş oluyoruz.
bu projece 5 task ve 5 thread olacak. 
*/
public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker("1", 1));
        Thread t2 = new Thread(new Worker("2", 2));
        Thread t3 = new Thread(new Worker("3", 3));
        Thread t4 = new Thread(new Worker("4", 4));
        Thread t5 = new Thread(new Worker("5", 5));
        System.out.println("Bütün işler teslim edildi...");
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();//bu iki yapı bitene kadar devam etmiyoruz.Buranın amacı budur.
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        t3.start();
        t4.start();
            try {
            t3.join();
            t4.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
            t5.start();
                try {
            t5.join();
          
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Bütün işler tamamlandı...");
     
    }
    //buradaki işlemleri kısaltmak için thread havuzlarını ve executorservice kullanıyoruz.
    
    
}
