
package fnafstructure;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

public class ThreadNoche1 extends Thread{
    private int cont = 0;
    private boolean isAlive = true;
    private BonnieNight1 b;
    public ArrayList<ArrayList<Animatronico>> pos;
    
    
    public ThreadNoche1() {}
    

    public ThreadNoche1(BonnieNight1 b, ArrayList<ArrayList<Animatronico>> pos) {
        this.b = b;
        this.pos = pos;
    }
    
    
    public boolean checkMovement(){
        Random rand = new Random();
        int randomNum = rand.nextInt(1,21);
        System.out.println("Numero Random: "+ randomNum + " Bonnie Level: "+ b.getAiLevel());
        if (b.getAiLevel() >= randomNum) {
            return true;
        } else{
            return false;
        }
    }
    public int checkAnimatronicRoom(){
        int contanim = 0;
        int contained = 0;
        boolean temp = false;
        for (ArrayList<Animatronico> po : pos) {
            for (Animatronico animatronico : po) {
                if (animatronico instanceof BonnieNight1) {
                    temp = true;
                }
            }
            if (temp) {
                contained = pos.indexOf(po);
                break;
            }
        }
        return contained;
    }
    public int checkAnimatronicPosinRoom(){
        int contained = 0;
        boolean temp = false;
        for (ArrayList<Animatronico> po : pos) {
            for (Animatronico animatronico : po) {
                if (animatronico instanceof BonnieNight1) {
                    contained = po.indexOf(animatronico);
                    temp = true;
                }
            }
            if (temp) {
                break;
            }
        }
        return contained;
    }

    @Override
    public void run(){
        while(isAlive){
            
            if (cont % 10 == 0 && cont != 0) {
                if (checkMovement()) {
                    int bonroomin = checkAnimatronicRoom();
                    int bonposinroom = checkAnimatronicPosinRoom();
                    Animatronico bontomove = (pos.get(bonroomin)).get(bonposinroom);
                    pos.get(bonroomin).remove(bontomove);
                    pos.get(bonroomin+1).add(bontomove);
                    System.out.println("El animatronico " + bontomove.nombre + " se ha movido a " + checkAnimatronicRoom() + "!\n\n");
                } else{
                    System.out.println("aun no el pepe ete sech \n\n");
                }
            }
            
            
            
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadNoche1.class.getName()).log(Level.SEVERE, null, ex);
            }
            cont++;
            if (cont == 500) {
               isAlive = false;
            }
        }
    }
}
