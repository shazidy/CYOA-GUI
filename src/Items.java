import java.util.ArrayList;
import java.util.jar.JarOutputStream;

public class Items {
    //String [] playerItem = new String[10];
    ArrayList<String> playerItem = new ArrayList<>();
    String item;
UI ui;
    public Items(UI userInterface){
        ui = userInterface;

    }


    public void addItem(){






        int i = 0;

        while(!playerItem.get(i).equals("") && i < 9) {
            i++;
                System.out.println("er");
            }
        if (playerItem.get(i).equals("")){
            playerItem.add(i,item);

            System.out.println(playerItem);
            ui.item0.setText(playerItem.get(0));
            ui.item1.setText(playerItem.get(1));
            ui.item2.setText(playerItem.get(2));
            ui.item3.setText(playerItem.get(3));
            ui.item4.setText(playerItem.get(4));
            ui.item5.setText(playerItem.get(5));
            ui.item6.setText(playerItem.get(6));
            ui.item7.setText(playerItem.get(7));
            ui.item8.setText(playerItem.get(8));
            ui.item9.setText(playerItem.get(9));

            if (ui.item0.getText().equals("")){ ui.item0.setVisible(false); }
            if (ui.item1.getText().equals("")){ ui.item1.setVisible(false); }
            if (ui.item2.getText().equals("")){ ui.item2.setVisible(false); }
            if (ui.item3.getText().equals("")){ ui.item3.setVisible(false); }
            if (ui.item4.getText().equals("")){ ui.item4.setVisible(false); }
            if (ui.item5.getText().equals("")){ ui.item5.setVisible(false); }
            if (ui.item6.getText().equals("")){ ui.item6.setVisible(false); }
            if (ui.item7.getText().equals("")){ ui.item7.setVisible(false); }
            if (ui.item8.getText().equals("")){ ui.item8.setVisible(false); }
            if (ui.item9.getText().equals("")){ ui.item9.setVisible(false); }

            if (!ui.item0.getText().equals("")){ ui.item0.setVisible(true); }
            if (!ui.item1.getText().equals("")){ ui.item1.setVisible(true); }
            if (!ui.item2.getText().equals("")){ ui.item2.setVisible(true); }
            if (!ui.item3.getText().equals("")){ ui.item3.setVisible(true); }
            if (!ui.item4.getText().equals("")){ ui.item4.setVisible(true); }
            if (!ui.item5.getText().equals("")){ ui.item5.setVisible(true); }
            if (!ui.item6.getText().equals("")){ ui.item6.setVisible(true); }
            if (!ui.item7.getText().equals("")){ ui.item7.setVisible(true); }
            if (!ui.item8.getText().equals("")){ ui.item8.setVisible(true); }
            if (!ui.item9.getText().equals("")){ ui.item9.setVisible(true); }

        }

        }


    public void itemUsed(int slotNumber){
        switch(playerItem.get(slotNumber)){
            case "Potion" : //ui.chapterLabel.setText("<HTML>CHAPTER II:<BR/>THE TOWER</HTML>");
                break;
        }
    }
}
