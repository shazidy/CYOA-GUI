//When EnemySetup is called, initial stats are set. These can be altered through getters and setters, which are handled
//by Battle.battleSetup() method. These values are set for each enemy-encounter and choices handles the values depending
//on the player values and choices. Identifiers are set in the EnemySetups parameters to make initialization easier.

public class Enemy {

    public static int HP, ATK, DEF;
    //private int ATK; // must be 2 or above
    //private int DEF;
    public static String name, ITM;
  //  private String ITM;
  //  private String DEATH;
  //  private int XP;



    public Enemy(String name, int HP, int ATK, int DEF, int XP, String ITM, String DEATH) {
        this.name = name;
        this.ATK = ATK;
        this.HP = HP;
        this.DEF = DEF;
        this.ITM = ITM;
      //  this.DEATH = DEATH;
      //  this.XP = XP;
    }
//Getters and Setters to change stats for enemy
/*
    //to chance HP
    public int getHP() { return HP; }
    public void setHP(int HP) { this.HP = HP; }
    //to change ATK
    public int getATK() { return ATK; }
    public void setATK(int ATK) { this.ATK = ATK; }
    //to change DEF
    public int getDEF() { return DEF; }
    public void setDEF(int DEF) { this.DEF = DEF; }
    //to change ITEM (if needed)
    public String getITM() { return ITM; }
    public void setITM(String ITM) { this.ITM = ITM; }
    //to change name (if needed)
    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }
    public String getDEATH() { return DEATH; }
    public void setDEATH(String DEATH) { this.DEATH = DEATH; }

    public int getXP() { return XP; }
    public void setXP(int XP) { this.XP = XP; }

 */

    //prints out the status of Enemy and sets conditions - is used in Battle.battleSetup() to keep track of when the
//battle is over
    public static void status() {
        String visual = "▒";
        System.out.println(Enemy.name + " - HP is:");
        for (int i = 0; i < Enemy.HP ; i++) {
            System.out.print(visual); }
        System.out.print(" " + Enemy.HP);
        if (Enemy.HP < 1) {
            System.out.println("\nYou Win!!!\n\n");
            Inventory.inventory.add(Inventory.item = Enemy.ITM);
            System.out.println("You found " + Enemy.ITM);
            //Location.inventory.add(Location.enemySetup.getITM());
            //System.out.println("\nYou found " + Location.enemySetup.getITM());
            //System.out.println(Inventory.inventory);

        }
    }

}
