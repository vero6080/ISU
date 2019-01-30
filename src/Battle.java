import Data.Player;
import Data.Pokemon;
import Data.Trainer;
import Data.status_t;
import java.util.Queue;

public final class Battle extends javax.swing.JDialog {
    
    void updateScreen() {
        //Name of player's current pokemon
        lblplayername.setText(player.getParty()[currentPoke].getName());
        //Player's current pokemon's level
        lblplayerlevel.setText(Integer.toString(player.getParty()[currentPoke].getLevel()));
        //Player's current pokemon's health
        lblplayerhp.setText(Integer.toString(player.getParty()[currentPoke].getHealth()));
        //Player's current pokemon's xp
        lblplayerxp.setText(Integer.toString(player.getParty()[currentPoke].getXp()) + "/" + Integer.toString(player.getParty()[currentPoke].getXpMax()));
        //Player's current pokemon's status
        switch(player.getParty()[currentPoke].getStatus()) {
                case none:
                    lblplayerstatus.setText("None");
                    break;
                case poison:
                    lblplayerstatus.setText("Poison");
                    break;
                case burn:
                    lblplayerstatus.setText("Burn");
                    break;
                case freeze:
                    lblplayerstatus.setText("Freeze");
                    break;
                case sleep:
                    lblplayerstatus.setText("Sleep");
                    break;
                case paralyze:
                    lblplayerstatus.setText("Paralyze");
                    break;
        }
        //Player's current pokemon's image
        lblplayerpic.setIcon(player.getParty()[currentPoke].getImage());
        //Name of enemies current pokemon
        lblenemyname.setText(trainers.peek().getParty().peek().getName());
        //Enemies current pokemon's level
        lblenemylevel.setText(Integer.toString(trainers.peek().getParty().peek().getLevel()));
        //Enemies current pokemon's health
        lblenemyhp.setText(Integer.toString(trainers.peek().getParty().peek().getHealth()));
        //Enemies current pokemon's status
        switch(trainers.peek().getParty().peek().getStatus()) {
                case none:
                    lblenemystatus.setText("None");
                    break;
                case poison:
                    lblenemystatus.setText("Poison");
                    break;
                case burn:
                    lblenemystatus.setText("Burn");
                    break;
                case freeze:
                    lblenemystatus.setText("Freeze");
                    break;
                case sleep:
                    lblenemystatus.setText("Sleep");
                    break;
                case paralyze:
                    lblenemystatus.setText("Paralyze");
                    break;
        }
        //Enemies current pokemon's image
        lblenemypic.setIcon(trainers.peek().getParty().peek().getImage());
        //Menu buttons
        mnum1.setText(player.getParty()[currentPoke].getMove()[0].getName());
        mnum2.setText(player.getParty()[currentPoke].getMove()[1].getName());
        mnum3.setText(player.getParty()[currentPoke].getMove()[2].getName());
        mnum4.setText(player.getParty()[currentPoke].getMove()[3].getName());
        mnup1.setText(player.getParty()[0].getName());
        mnup2.setText(player.getParty()[1].getName());
        mnup3.setText(player.getParty()[2].getName());
        mnup4.setText(player.getParty()[3].getName());
        mnup5.setText(player.getParty()[4].getName());
        mnup6.setText(player.getParty()[5].getName());
    }
    
    void trainerAct() {
        /*
        for(int i = 0; i < trainers.peek().getParty().peek().getMove().length; i++) {
            if (trainers.peek().getParty().peek().getMove()[i] == trainers.peek().determineAction(player.getParty()[currentPoke])) {
                trainers.peek().getParty().peek().getMove()[i].use(trainers.peek().getParty().peek(), player.getParty()[currentPoke]);
                txtoutput.append(trainers.peek().getParty().peek().getName() + " used " + trainers.peek().getParty().peek().getMove()[i].getName() + "\n");
            }
        }
        */
        //Pick random move for trainer's pokemon
        int randVal = (int)(Math.random() * trainers.peek().getParty().peek().getMove().length);
        if(trainers.peek().getParty().peek().getStatus() == status_t.freeze || trainers.peek().getParty().peek().getStatus() == status_t.paralyze || trainers.peek().getParty().peek().getStatus() == status_t.sleep) txtoutput.append(trainers.peek().getName() + ": Can not move.\n");
        else {
            trainers.peek().getParty().peek().getMove()[randVal].use(trainers.peek().getParty().peek(), player.getParty()[currentPoke]);
            txtoutput.append(trainers.peek().getName() + ": " + trainers.peek().getParty().peek().getName() + " used " + trainers.peek().getParty().peek().getMove()[randVal].getName() + ".\n");
            /*
            if(trainers.peek().getParty().peek().getMove()[randVal].getStatusModifier() != status_t.none) {
                txtoutput.append("Player: Has been inflicted with ");
                switch(trainers.peek().getParty().peek().getMove()[randVal].getStatusModifier()) {
                    case poison:
                        txtoutput.append("poison");
                        break;
                    case burn:
                        txtoutput.append("burn");
                        break;
                    case freeze:
                        txtoutput.append("freeze");
                        break;
                    case sleep:
                        txtoutput.append("sleep");
                        break;
                    case paralyze:
                        txtoutput.append("paralyze");
                        break;
                }
                txtoutput.append(".\n");
            }
            */
            if(trainers.peek().getParty().peek().getMove()[randVal].isMissedAttack()) txtoutput.append(trainers.peek().getName() + ": Attack missed.\n");
            if(player.getParty()[currentPoke].getHealth() <= 0) txtoutput.append("Player: " + player.getParty()[currentPoke].getName() + " has fainted.\n");
        }
        if(trainers.peek().getParty().peek().getHealth() <= 0) txtoutput.append(trainers.peek().getName() + ": " + trainers.peek().getParty().peek().getName() + " has fainted.\n");
        trainers.peek().getParty().peek().enforceStatus();
        healthCheck();
    }
    
    void healthCheck() {
        //Removes the trainer's pokemon if it has died
        if(trainers.peek().getParty().peek().getHealth() <= 0) trainers.peek().getParty().remove();
        //Return to the Party screen after defeating all the trainer's pokemon 
        if(trainers.peek().getParty().isEmpty()) {
            trainers.remove();
            died = false;
            exit = true;
            dispose();
        }
        //Return to the Party screen after all of your pokemon have died 
        int tempCounter = 0;
        for(int i = 0; i < player.getParty().length; i++) {
            if(player.getParty()[i].getHealth() > 0) {
                tempCounter++;
            }
        }
        if(tempCounter < 1) {
            died = true;
            exit = true;
            dispose();
        }
    }
    
    static Player player;
    static Queue <Trainer> trainers;
    int currentPoke;
    //The 'died' bool determines wether you won or lost 
    boolean died;
    //Exits the Battle scene when set to true 
    boolean exit;
    
    public Battle(java.awt.Frame parent, boolean modal, Player playerArg, Queue <Trainer> trainersArg) {
        super(parent, modal);
        initComponents();
        player = playerArg;
        trainers = trainersArg;
        currentPoke = 0;
        died = true;
        exit = false;
        updateScreen();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        Battle.player = player;
    }

    public Queue<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(Queue<Trainer> trainers) {
        Battle.trainers = trainers;
    }
    
    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public boolean isDied() {
        return died;
    }

    public void setDied(boolean died) {
        this.died = died;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblplayerpic = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblplayername = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblplayerlevel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblplayerhp = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblplayerxp = new javax.swing.JLabel();
        lblenemypic = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblenemyname = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblenemylevel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblenemyhp = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtoutput = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        lblplayerstatus = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblenemystatus = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnum1 = new javax.swing.JMenuItem();
        mnum2 = new javax.swing.JMenuItem();
        mnum3 = new javax.swing.JMenuItem();
        mnum4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnup1 = new javax.swing.JMenuItem();
        mnup2 = new javax.swing.JMenuItem();
        mnup3 = new javax.swing.JMenuItem();
        mnup4 = new javax.swing.JMenuItem();
        mnup5 = new javax.swing.JMenuItem();
        mnup6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnurun = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblplayerpic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblplayerpic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblplayername.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        lblplayername.setText("Name of Pokemon");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel4.setText("Level:");

        lblplayerlevel.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblplayerlevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblplayerlevel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel6.setText("HP:");

        lblplayerhp.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblplayerhp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblplayerhp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel8.setText("XP:");

        lblplayerxp.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblplayerxp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblplayerxp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblplayername, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblplayerlevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblplayerhp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblplayerxp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblplayername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblplayerlevel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblplayerhp, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblplayerxp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        lblenemypic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblenemypic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblenemyname.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        lblenemyname.setText("Name of Pokemon");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel11.setText("Level:");

        lblenemylevel.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblenemylevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblenemylevel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel13.setText("HP:");

        lblenemyhp.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblenemyhp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblenemyhp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblenemyname, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblenemylevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblenemyhp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblenemyname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblenemylevel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblenemyhp, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtoutput.setColumns(20);
        txtoutput.setFont(new java.awt.Font("Monospaced", 0, 20)); // NOI18N
        txtoutput.setRows(5);
        txtoutput.setKeymap(null);
        jScrollPane1.setViewportView(txtoutput);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel1.setText("Status:");

        lblplayerstatus.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblplayerstatus.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel3.setText("Status:");

        lblenemystatus.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        lblenemystatus.setText("jLabel5");

        jMenu1.setText("Fight");

        mnum1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.SHIFT_MASK));
        mnum1.setText("Move #1");
        mnum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnum1ActionPerformed(evt);
            }
        });
        jMenu1.add(mnum1);

        mnum2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.SHIFT_MASK));
        mnum2.setText("Move #2");
        mnum2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnum2ActionPerformed(evt);
            }
        });
        jMenu1.add(mnum2);

        mnum3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.SHIFT_MASK));
        mnum3.setText("Move #3");
        mnum3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnum3ActionPerformed(evt);
            }
        });
        jMenu1.add(mnum3);

        mnum4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.SHIFT_MASK));
        mnum4.setText("Move #4");
        mnum4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnum4ActionPerformed(evt);
            }
        });
        jMenu1.add(mnum4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Pokemon");

        mnup1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        mnup1.setText("Pokemon #1");
        mnup1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnup1ActionPerformed(evt);
            }
        });
        jMenu2.add(mnup1);

        mnup2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        mnup2.setText("Pokemon #2");
        mnup2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnup2ActionPerformed(evt);
            }
        });
        jMenu2.add(mnup2);

        mnup3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        mnup3.setText("Pokemon #3");
        mnup3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnup3ActionPerformed(evt);
            }
        });
        jMenu2.add(mnup3);

        mnup4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        mnup4.setText("Pokemon #4");
        mnup4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnup4ActionPerformed(evt);
            }
        });
        jMenu2.add(mnup4);

        mnup5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_MASK));
        mnup5.setText("Pokemon #5");
        mnup5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnup5ActionPerformed(evt);
            }
        });
        jMenu2.add(mnup5);

        mnup6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.event.InputEvent.CTRL_MASK));
        mnup6.setText("Pokemon #6");
        mnup6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnup6ActionPerformed(evt);
            }
        });
        jMenu2.add(mnup6);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Run");

        mnurun.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        mnurun.setText("Run");
        mnurun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnurunActionPerformed(evt);
            }
        });
        jMenu3.add(mnurun);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblplayerpic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblenemypic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblplayerstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblenemystatus, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblplayerpic, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(lblenemypic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblplayerstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblenemystatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnum2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnum2ActionPerformed
        //If the player's pokemon is still alive atempt to attack the enemy. If the player has a move restricting status or the attack misses don't deal damage.
        if(player.getParty()[currentPoke].getHealth() > 0) {
            player.getParty()[currentPoke].enforceStatus();
            if(player.getParty()[currentPoke].getStatus() == status_t.freeze || player.getParty()[currentPoke].getStatus() == status_t.paralyze || player.getParty()[currentPoke].getStatus() == status_t.sleep) 
                txtoutput.append("Player: " + player.getParty()[currentPoke].getName() + " Can not move.\n");
            else {
                player.getParty()[currentPoke].getMove()[1].use(player.getParty()[currentPoke], trainers.peek().getParty().peek());
                txtoutput.append("Player: " + player.getParty()[currentPoke].getName() +" used " + player.getParty()[currentPoke].getMove()[1].getName() + ".\n");
                if(player.getParty()[currentPoke].getMove()[1].isMissedAttack()) txtoutput.append("Player: Attack missed.\n");
                if(trainers.peek().getParty().peek().getHealth() <= 0) txtoutput.append(trainers.peek().getName() + ": " + trainers.peek().getParty().peek().getName() + " has fainted.\n");
            }
            healthCheck();
            trainerAct();
        }
        else if(player.getParty()[currentPoke].getHealth() <= 0) txtoutput.append("Player: " + player.getParty()[currentPoke].getName() + " has fainted.\n");
        healthCheck();
        updateScreen();
    }//GEN-LAST:event_mnum2ActionPerformed

    private void mnum1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnum1ActionPerformed
        if(player.getParty()[currentPoke].getHealth() > 0) {
            player.getParty()[currentPoke].enforceStatus();
            if(player.getParty()[currentPoke].getStatus() == status_t.freeze || player.getParty()[currentPoke].getStatus() == status_t.paralyze || player.getParty()[currentPoke].getStatus() == status_t.sleep) 
                txtoutput.append("Player: " + player.getParty()[currentPoke].getName() + " Can not move.\n");
            else {
                player.getParty()[currentPoke].getMove()[0].use(player.getParty()[currentPoke], trainers.peek().getParty().peek());
                txtoutput.append("Player: " + player.getParty()[currentPoke].getName() +" used " + player.getParty()[currentPoke].getMove()[0].getName() + ".\n");
                if(player.getParty()[currentPoke].getMove()[0].isMissedAttack()) txtoutput.append("Player: Attack missed.\n");
                if(trainers.peek().getParty().peek().getHealth() <= 0) txtoutput.append(trainers.peek().getName() + ": " + trainers.peek().getParty().peek().getName() + " has fainted.\n");
            }
            healthCheck();
            trainerAct();
        }
        else if(player.getParty()[currentPoke].getHealth() <= 0) txtoutput.append("Player: " + player.getParty()[currentPoke].getName() + " has fainted.\n");
        healthCheck();
        updateScreen();
    }//GEN-LAST:event_mnum1ActionPerformed

    private void mnum3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnum3ActionPerformed
        if(player.getParty()[currentPoke].getHealth() > 0) {
            player.getParty()[currentPoke].enforceStatus();
            if(player.getParty()[currentPoke].getStatus() == status_t.freeze || player.getParty()[currentPoke].getStatus() == status_t.paralyze || player.getParty()[currentPoke].getStatus() == status_t.sleep) 
                txtoutput.append("Player: " + player.getParty()[currentPoke].getName() + " Can not move.\n");
            else {
                player.getParty()[currentPoke].getMove()[2].use(player.getParty()[currentPoke], trainers.peek().getParty().peek());
                txtoutput.append("Player: " + player.getParty()[currentPoke].getName() +" used " + player.getParty()[currentPoke].getMove()[2].getName() + ".\n");
                if(player.getParty()[currentPoke].getMove()[2].isMissedAttack()) txtoutput.append("Player: Attack missed.\n");
                if(trainers.peek().getParty().peek().getHealth() <= 0) txtoutput.append(trainers.peek().getName() + ": " + trainers.peek().getParty().peek().getName() + " has fainted.\n");
            }
            healthCheck();
            trainerAct();
        }
        else if(player.getParty()[currentPoke].getHealth() <= 0) txtoutput.append("Player: " + player.getParty()[currentPoke].getName() + " has fainted.\n");
        healthCheck();
        updateScreen();
    }//GEN-LAST:event_mnum3ActionPerformed

    private void mnum4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnum4ActionPerformed
        if(player.getParty()[currentPoke].getHealth() > 0) {
            player.getParty()[currentPoke].enforceStatus();
            if(player.getParty()[currentPoke].getStatus() == status_t.freeze || player.getParty()[currentPoke].getStatus() == status_t.paralyze || player.getParty()[currentPoke].getStatus() == status_t.sleep) 
                txtoutput.append("Player: " + player.getParty()[currentPoke].getName() + " Can not move.\n");
            else {
                player.getParty()[currentPoke].getMove()[3].use(player.getParty()[currentPoke], trainers.peek().getParty().peek());
                txtoutput.append("Player: " + player.getParty()[currentPoke].getName() +" used " + player.getParty()[currentPoke].getMove()[3].getName() + ".\n");
                if(player.getParty()[currentPoke].getMove()[3].isMissedAttack()) txtoutput.append("Player: Attack missed.\n");
                if(trainers.peek().getParty().peek().getHealth() <= 0) txtoutput.append(trainers.peek().getName() + ": " + trainers.peek().getParty().peek().getName() + " has fainted.\n");
            }
            healthCheck();
            trainerAct();
        }
        else if(player.getParty()[currentPoke].getHealth() <= 0) txtoutput.append("Player: " + player.getParty()[currentPoke].getName() + " has fainted.\n");
        healthCheck();
        updateScreen();
    }//GEN-LAST:event_mnum4ActionPerformed

    private void mnup1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnup1ActionPerformed
        //Can switch pokemon only if the one you're switching to is not dead 
        if(player.getParty()[0].getHealth() > 0) {
            currentPoke = 0;
            //Enemy gets a free attack after you switch pokemon 
            trainerAct();
            healthCheck();
            updateScreen();
        }
    }//GEN-LAST:event_mnup1ActionPerformed

    private void mnup2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnup2ActionPerformed
        if(player.getParty()[1].getHealth() > 0) {
            currentPoke = 1;
            trainerAct();
            healthCheck();
            updateScreen();   
        }
    }//GEN-LAST:event_mnup2ActionPerformed

    private void mnup3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnup3ActionPerformed
        if(player.getParty()[2].getHealth() > 0) {
            currentPoke = 2;
            trainerAct();
            healthCheck();
            updateScreen();      
        }
    }//GEN-LAST:event_mnup3ActionPerformed

    private void mnup4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnup4ActionPerformed
        if(player.getParty()[3].getHealth() > 0) {
            currentPoke = 3;
            trainerAct();
            healthCheck();
            updateScreen();
        }
    }//GEN-LAST:event_mnup4ActionPerformed

    private void mnup5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnup5ActionPerformed
        if(player.getParty()[4].getHealth() > 0) {
            currentPoke = 4;
            trainerAct();
            healthCheck();
            updateScreen();
        }
    }//GEN-LAST:event_mnup5ActionPerformed

    private void mnup6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnup6ActionPerformed
        if(player.getParty()[5].getHealth() > 0) {
            currentPoke = 5;
            trainerAct();
            healthCheck();
            updateScreen();
        }
    }//GEN-LAST:event_mnup6ActionPerformed

    private void mnurunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnurunActionPerformed
        //Close the battle window
        died = true;
        exit = true;
        dispose();
        //dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_mnurunActionPerformed

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
            java.util.logging.Logger.getLogger(Battle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Battle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Battle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Battle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Battle dialog = new Battle(new javax.swing.JFrame(), true, player, trainers);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblenemyhp;
    private javax.swing.JLabel lblenemylevel;
    private javax.swing.JLabel lblenemyname;
    private javax.swing.JLabel lblenemypic;
    private javax.swing.JLabel lblenemystatus;
    private javax.swing.JLabel lblplayerhp;
    private javax.swing.JLabel lblplayerlevel;
    private javax.swing.JLabel lblplayername;
    private javax.swing.JLabel lblplayerpic;
    private javax.swing.JLabel lblplayerstatus;
    private javax.swing.JLabel lblplayerxp;
    private javax.swing.JMenuItem mnum1;
    private javax.swing.JMenuItem mnum2;
    private javax.swing.JMenuItem mnum3;
    private javax.swing.JMenuItem mnum4;
    private javax.swing.JMenuItem mnup1;
    private javax.swing.JMenuItem mnup2;
    private javax.swing.JMenuItem mnup3;
    private javax.swing.JMenuItem mnup4;
    private javax.swing.JMenuItem mnup5;
    private javax.swing.JMenuItem mnup6;
    private javax.swing.JMenuItem mnurun;
    private javax.swing.JTextArea txtoutput;
    // End of variables declaration//GEN-END:variables
}
