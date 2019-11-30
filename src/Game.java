import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
//    ChoiceHandler cHandler = new ChoiceHandler();
//    UI ui = new UI();
//    Tower tower = new Tower(/*this, ui*/);

//    String choice1, choice2, choice3, choice4;

/*
    public Game(){
        ui.createUI(cHandler);
    }

*/

    public static void main(String[] args) {
        new Game();



        //Tower tower = new Tower();
        UI ui = new UI();
        ui.createUI();
        //tower.start();


/*
        System.out.println("   _____  ______________________________________ __________________  .____    .___  _________\n" +
                "  /     \\ \\_   _____\\__    ___\\______   \\_____  \\\\______   \\_____  \\ |    |   |   |/   _____/\n" +
                " /  \\ /  \\ |    __)_  |    |   |       _//   |   \\|     ___//   |   \\|    |   |   |\\_____  \\ \n" +
                "/    Y    \\|        \\ |    |   |    |   /    |    |    |   /    |    |    |___|   |/        \\\n" +
                "\\____|__  /_______  / |____|   |____|_  \\_______  |____|   \\_______  |_______ |___/_______  /\n" +
                "        \\/        \\/                  \\/        \\/                 \\/        \\/           \\/ ");

*/


        // Tower tower = new Tower();

        // tower.start();





    }
    /*
    public class ChoiceHandler implements ActionListener {
 @Override
        public void actionPerformed(ActionEvent event) {

        String yourChoice = event.getActionCommand();
        switch (yourChoice){
            case "c1" : tower.choice(choice1); break;
            case "c2" : tower.choice(choice2); break;
            case "c3" : tower.choice(choice3); break;
            case "c4" : tower.choice(choice4); break;
        }
        }
    }

     */


}

