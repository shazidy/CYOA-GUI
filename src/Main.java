import java.util.Calendar;

public class Main extends GUI {






    public static void main(String[] args) {
        new Main();
        GUI gui = new GUI();
        Tower tower = new Tower();
        gui.gui();
        tower.start();



        System.out.println("   _____  ______________________________________ __________________  .____    .___  _________\n" +
                "  /     \\ \\_   _____\\__    ___\\______   \\_____  \\\\______   \\_____  \\ |    |   |   |/   _____/\n" +
                " /  \\ /  \\ |    __)_  |    |   |       _//   |   \\|     ___//   |   \\|    |   |   |\\_____  \\ \n" +
                "/    Y    \\|        \\ |    |   |    |   /    |    |    |   /    |    |    |___|   |/        \\\n" +
                "\\____|__  /_______  / |____|   |____|_  \\_______  |____|   \\_______  |_______ |___/_______  /\n" +
                "        \\/        \\/                  \\/        \\/                 \\/        \\/           \\/ ");




        // Tower tower = new Tower();

        // tower.start();





    }


}

