package game;


import java.util.ArrayList;

public class ItemText {

    ArrayList<String> itemText = new ArrayList<>();
    public String Potion ="A plastic water bottle that glows with an eerily pale blue color.\n Heals 5 HP.";

    public void items(){

        itemText.add("•Potion:\n\nA plastic water bottle that glows with an eerily pale blue color.\n\nHeals 5 MP.");
        itemText.add("•Potia:\n\nA glass water bottle that glows with an eerily pale red color.\n\nHeals 5 HP.");
    }

}
