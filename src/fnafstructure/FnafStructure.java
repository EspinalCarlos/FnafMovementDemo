package fnafstructure;

import java.util.ArrayList;

public class FnafStructure {

    static ArrayList<ArrayList<Animatronico>> rooms = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Animatronico> backstage = new ArrayList<>();
        ArrayList<Animatronico> diner1 = new ArrayList<>();
        ArrayList<Animatronico> diner2 = new ArrayList<>();
        rooms.add(backstage);
        rooms.add(diner1);
        rooms.add(diner2);
        BonnieNight1 bn1 = new BonnieNight1(5,"Bonnie");
        (rooms.get(0)).add(bn1);
        ThreadNoche1 tn1 = new ThreadNoche1(bn1, rooms);
        tn1.start();
        

    }

}
