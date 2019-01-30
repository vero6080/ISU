import Data.Attack;
import Data.Boost;
import Data.Heal;
import Data.Lower;
import Data.Player;
import Data.Pokemon;
import Data.PokemonList.Bulbasaur;
import Data.PokemonList.Caterpie;
import Data.PokemonList.Chansey;
import Data.PokemonList.Charmander;
import Data.PokemonList.Clefairy;
import Data.PokemonList.Dratini;
import Data.PokemonList.Eevee;
import Data.PokemonList.Ekans;
import Data.PokemonList.Electabuzz;
import Data.PokemonList.Machop;
import Data.PokemonList.Magikarp;
import Data.PokemonList.Magmar;
import Data.PokemonList.Mew;
import Data.PokemonList.Nidoran;
import Data.PokemonList.Pikachu;
import Data.PokemonList.Pinsir;
import Data.PokemonList.Rattata;
import Data.PokemonList.Sandshrew;
import Data.PokemonList.Squirtle;
import Data.PokemonList.Tangela;
import Data.Trainer;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import javax.swing.JOptionPane;

public final class Party extends javax.swing.JFrame {
    
    Pokemon generatePoke(int randMin, int randMax) {
        //Select a random pokemon with a level between randMin and randMax and return it.
        int randRange = (randMax - randMin) + 1;
        int randId = (int)(Math.random() * 20);
        int randLevel = (int)(Math.random() * randRange + randMin);
        HashMap<Integer, Pokemon> pokeList = new HashMap<>();
        pokeList.put(0, new Bulbasaur(randLevel));
        pokeList.put(1, new Caterpie(randLevel));
        pokeList.put(2, new Chansey(randLevel));
        pokeList.put(3, new Charmander(randLevel));
        pokeList.put(4, new Clefairy(randLevel));
        pokeList.put(5, new Dratini(randLevel));
        pokeList.put(6, new Eevee(randLevel));
        pokeList.put(7, new Ekans(randLevel));
        pokeList.put(8, new Electabuzz(randLevel));
        pokeList.put(9, new Machop(randLevel));
        pokeList.put(10, new Magikarp(randLevel));
        pokeList.put(11, new Magmar(randLevel));
        pokeList.put(12, new Mew(randLevel));
        pokeList.put(13, new Nidoran(randLevel));
        pokeList.put(14, new Pikachu(randLevel));
        pokeList.put(15, new Pinsir(randLevel));
        pokeList.put(16, new Rattata(randLevel));
        pokeList.put(17, new Sandshrew(randLevel));
        pokeList.put(18, new Squirtle(randLevel));
        pokeList.put(19, new Tangela(randLevel));
        if(pokeList.containsKey(randId)) return pokeList.get(randId);
        //If pokemon id fails return element 0 (Bulbasaur).
        else return pokeList.get(0);
    }
    
    void gameInit(Player player, Queue <Trainer> trainers) {
        //Fill player's party with pokemon level 15 to 35.
        int minLevel = 15; 
        int maxLevel = 35;
        for(int i = 0; i < 6; i++) {
            player.addPoke(generatePoke(minLevel, maxLevel));
        }
        //Create trainers.
        trainers.add(new Trainer("Brock"));
        trainers.add(new Trainer("Misty"));
        trainers.add(new Trainer("Lt. Surge"));
        trainers.add(new Trainer("Erika"));
        trainers.add(new Trainer("Koga"));
        trainers.add(new Trainer("Sabrina"));
        trainers.add(new Trainer("Blaine"));
        trainers.add(new Trainer("Giovanni"));
        //Fill trainer's parties with pokemon appropriate for their stage.
        for(int i = 0; i < 8; i++) {
            Trainer tempTrainer = trainers.poll();
            minLevel += 2;
            maxLevel += 3;
            for(int j = 0; j < 6; j++) {
                tempTrainer.addPoke(generatePoke(minLevel, maxLevel));
            }
            trainers.add(tempTrainer);
        }
    }
    
    public void updatePartyInfo() {
        //Update move button text
        btnmove1.setText(player.getParty()[currentPoke].getMove()[0].getName());
        btnmove2.setText(player.getParty()[currentPoke].getMove()[1].getName());
        btnmove3.setText(player.getParty()[currentPoke].getMove()[2].getName());
        btnmove4.setText(player.getParty()[currentPoke].getMove()[3].getName());
        //Update stats text
        lblhp.setText(Integer.toString(player.getParty()[currentPoke].getHealth()));
        lblattack.setText(Integer.toString(player.getParty()[currentPoke].getAttack()));
        lbldefense.setText(Integer.toString(player.getParty()[currentPoke].getDefense()));
        lblspeed.setText(Integer.toString(player.getParty()[currentPoke].getSpeed()));
        lblaccuracy.setText(Integer.toString(player.getParty()[currentPoke].getAccuracy()));
        //Update pokemon's image
        lblimage.setIcon(player.getParty()[currentPoke].getImage());
        //Display pokemon's name
        lblname.setText(player.getParty()[currentPoke].getName());
        //Display pokemon's level
        lbllevel.setText(Integer.toString(player.getParty()[currentPoke].getLevel()));
        //Display pokemon's type
        switch(player.getParty()[currentPoke].getType()) {
            case water:
                 lbltype.setText("water");
                break;
            case fire:
                lbltype.setText("fire");
                break;
            case grass:
                lbltype.setText("grass");
                break;
            case electric:
                lbltype.setText("electric");
                break;
            case normal:
                lbltype.setText("normal");
                break;
        }
        //Update current pokemon index number 
        lblcurrentIndex.setText(Integer.toString(currentPoke + 1));
        //Update player's party length 
        lblnumOfPoke.setText(Integer.toString(player.getParty().length));
        //Update stage number 
        lblstage.setText(Integer.toString((8 - trainers.size()) + 1) + "/8");
    }
    
    static Player player = new Player();
    static Queue <Trainer> trainers = new ArrayDeque();
    //Pokemon to be displayed 
    int currentPoke;

    public Party() {
        initComponents();
        gameInit(player, trainers);
        currentPoke = 0;
        updatePartyInfo();
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Party.player = player;
    }

    public static Queue<Trainer> getTrainers() {
        return trainers;
    }

    public static void setTrainers(Queue<Trainer> trainers) {
        Party.trainers = trainers;
    }

    public int getCurrentPoke() {
        return currentPoke;
    }

    public void setCurrentPoke(int currentPoke) {
        this.currentPoke = currentPoke;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnmove1 = new javax.swing.JButton();
        btnmove2 = new javax.swing.JButton();
        btnmove3 = new javax.swing.JButton();
        btnmove4 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblhp = new javax.swing.JLabel();
        lblattack = new javax.swing.JLabel();
        lbldefense = new javax.swing.JLabel();
        lblspeed = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblaccuracy = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblname = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbltype = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbllevel = new javax.swing.JLabel();
        lblimage = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnfirst = new javax.swing.JButton();
        btnlast = new javax.swing.JButton();
        btnprevious = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        lblcurrentIndex = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblnumOfPoke = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblstage = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnubattle = new javax.swing.JMenuItem();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnmove1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnmove1.setText("Move #1");
        btnmove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmove1ActionPerformed(evt);
            }
        });

        btnmove2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnmove2.setText("Move #2");
        btnmove2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmove2ActionPerformed(evt);
            }
        });

        btnmove3.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnmove3.setText("Move #3");
        btnmove3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmove3ActionPerformed(evt);
            }
        });

        btnmove4.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnmove4.setText("Move #4");
        btnmove4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmove4ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Moves");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnmove1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnmove2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(btnmove3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnmove4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnmove1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnmove2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnmove3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnmove4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel1.setText("HP:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel2.setText("Attack:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel3.setText("Defense:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel4.setText("Speed:");

        lblhp.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lblhp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblhp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblattack.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lblattack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblattack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbldefense.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbldefense.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldefense.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblspeed.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lblspeed.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblspeed.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Stats");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jLabel5.setText("Accuracy:");

        lblaccuracy.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lblaccuracy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblaccuracy.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblattack, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(lbldefense, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblspeed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblaccuracy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblhp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblhp, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(lblattack, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbldefense, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblspeed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblaccuracy, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblname.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        lblname.setText("Name of Pokemon");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setText("Type:");

        lbltype.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbltype.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltype.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("Level:");

        lbllevel.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        lbllevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbllevel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(lbltype, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbllevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbltype, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbllevel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lblimage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblimage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnfirst.setText("|<");
        btnfirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfirstActionPerformed(evt);
            }
        });

        btnlast.setText(">|");
        btnlast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlastActionPerformed(evt);
            }
        });

        btnprevious.setText("<");
        btnprevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpreviousActionPerformed(evt);
            }
        });

        btnnext.setText(">");
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel17.setText("Current Index:");

        lblcurrentIndex.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblcurrentIndex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcurrentIndex.setText("0");
        lblcurrentIndex.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel18.setText("Number of Pokemon:");

        lblnumOfPoke.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblnumOfPoke.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnumOfPoke.setText("0");
        lblnumOfPoke.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel7.setText("Stage:");

        lblstage.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblstage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblstage.setText("0");
        lblstage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnfirst)
                .addGap(38, 38, 38)
                .addComponent(btnprevious)
                .addGap(50, 50, 50)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblcurrentIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblnumOfPoke, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblstage, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnnext)
                .addGap(39, 39, 39)
                .addComponent(btnlast)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnfirst)
                            .addComponent(btnlast)
                            .addComponent(btnprevious)
                            .addComponent(btnnext))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcurrentIndex)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(lblnumOfPoke)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblstage))))
                .addContainerGap())
        );

        jMenu1.setText("Battle");

        mnubattle.setText("Battle");
        mnubattle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnubattleActionPerformed(evt);
            }
        });
        jMenu1.add(mnubattle);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblimage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblimage, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnfirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfirstActionPerformed
        //Go to the first pokemon 
        currentPoke = 0;
        updatePartyInfo();
    }//GEN-LAST:event_btnfirstActionPerformed

    private void btnlastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlastActionPerformed
        //Go to the last pokemon
        currentPoke = player.getParty().length - 1;
        updatePartyInfo();
    }//GEN-LAST:event_btnlastActionPerformed

    private void btnpreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpreviousActionPerformed
        //Go to the previous pokemon
        if(--currentPoke < 0) currentPoke = 0;
        updatePartyInfo();
    }//GEN-LAST:event_btnpreviousActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        //Go to the next pokemon 
        if(++currentPoke > player.getParty().length - 1) currentPoke = player.getParty().length - 1;
         updatePartyInfo();
    }//GEN-LAST:event_btnnextActionPerformed

    private String generateMoveInfo(int moveIndex) {
        //Create a string to display the player's current pokemon's move[moveIndex] info (the popup menu).
        String returnString = "Name: " + player.getParty()[currentPoke].getMove()[moveIndex].getName() + "\nPower: " + player.getParty()[currentPoke].getMove()[moveIndex].getPower() + "\nMove Type: ";
        //Attack
        if(player.getParty()[currentPoke].getMove()[moveIndex] instanceof Attack) {
            returnString += "Attack\nStatus Modifier: ";
            switch(player.getParty()[currentPoke].getMove()[moveIndex].getStatusModifier()) {
                case none:
                    returnString += "None";
                    break;
                case poison:
                    returnString += "Poison";
                    break;
                case burn:
                    returnString += "Burn";
                    break;
                case freeze:
                    returnString += "Freeze";
                    break;
                case sleep:
                    returnString += "Sleep";
                    break;
                case paralyze:
                    returnString += "Paralyze";
                    break;
            }
        }
        //Boost
        else if(player.getParty()[currentPoke].getMove()[moveIndex] instanceof Boost) {
            returnString += "Boost\nTrait Modifier: ";
            switch(player.getParty()[currentPoke].getMove()[moveIndex].getTrait()) {
                case attack:
                    returnString += "Attack";
                    break;
                case defense:
                    returnString += "Defense";
                    break;
                case speed:
                    returnString += "Speed";
                    break;
                case accuracy:
                    returnString += "Accuracy";
                    break;
            }
        }
        //Lower
        else if(player.getParty()[currentPoke].getMove()[moveIndex] instanceof Lower) {
            returnString += "Lower\nTrait Modifier: ";
            switch(player.getParty()[currentPoke].getMove()[moveIndex].getTrait()) {
                case attack:
                    returnString += "Attack";
                    break;
                case defense:
                    returnString += "Defense";
                    break;
                case speed:
                    returnString += "Speed";
                    break;
                case accuracy:
                    returnString += "Accuracy";
                    break;
            }
        }
        //Heal
        else if(player.getParty()[currentPoke].getMove()[moveIndex] instanceof Heal) returnString += "Heal";
        return returnString;
    }
    
    //Show move details when clicked 
    private void btnmove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmove1ActionPerformed
         JOptionPane.showMessageDialog(this, generateMoveInfo(0));
    }//GEN-LAST:event_btnmove1ActionPerformed

    private void btnmove2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmove2ActionPerformed
        JOptionPane.showMessageDialog(this, generateMoveInfo(1));
    }//GEN-LAST:event_btnmove2ActionPerformed

    private void btnmove3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmove3ActionPerformed
        JOptionPane.showMessageDialog(this, generateMoveInfo(2));
    }//GEN-LAST:event_btnmove3ActionPerformed

    private void btnmove4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmove4ActionPerformed
        JOptionPane.showMessageDialog(this, generateMoveInfo(3));
    }//GEN-LAST:event_btnmove4ActionPerformed
        //Enter a battle
    private void mnubattleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnubattleActionPerformed
        //Create a new 'Battle' instance and show it
        setVisible(false);
        Battle battleScreen = new Battle(this, true, player, trainers);
        battleScreen.setVisible(true);
        boolean loop = true;
        //Wait for the exit flag to be set inside the battle screen 
        while(loop) {
            //Set the Party class variables to the modified Battle class varriables (this is mainly to maintain the levels and xp) 
            if(battleScreen.isExit()) {          
                player = battleScreen.getPlayer();
                if(!battleScreen.isDied()) trainers = battleScreen.getTrainers();
                player.healAll();
                loop = false;
            }
        }
        //If you've beaten all the trainers, exit the game
        if(trainers.isEmpty()) System.exit(0);
        //Set up the Party screen
        battleScreen.setVisible(false);
        battleScreen = null;
        setVisible(true);
        updatePartyInfo();
    }//GEN-LAST:event_mnubattleActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Party.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Party.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Party.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Party.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Party().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnfirst;
    private javax.swing.JButton btnlast;
    private javax.swing.JButton btnmove1;
    private javax.swing.JButton btnmove2;
    private javax.swing.JButton btnmove3;
    private javax.swing.JButton btnmove4;
    private javax.swing.JButton btnnext;
    private javax.swing.JButton btnprevious;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblaccuracy;
    private javax.swing.JLabel lblattack;
    private javax.swing.JLabel lblcurrentIndex;
    private javax.swing.JLabel lbldefense;
    private javax.swing.JLabel lblhp;
    private javax.swing.JLabel lblimage;
    private javax.swing.JLabel lbllevel;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblnumOfPoke;
    private javax.swing.JLabel lblspeed;
    private javax.swing.JLabel lblstage;
    private javax.swing.JLabel lbltype;
    private javax.swing.JMenuItem mnubattle;
    // End of variables declaration//GEN-END:variables
}
