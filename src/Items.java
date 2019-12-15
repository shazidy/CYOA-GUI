public class Items {
    Game game;
    UI ui;
    String [] playerItem = new String[10];
    public Items(Game g, UI userInterface){
        game = g;
        ui = userInterface;
    }

    public void itemUsed(int slotNumber){
        switch(playerItem[slotNumber]){
            case "Potion" : ui.chapterLabel.setText("<HTML>CHAPTER II:<BR/>THE TOWER</HTML>");
        }
    }
}
