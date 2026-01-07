// Poker Game Program (AKA Analog Poker)
// By: Henry Smith
// Started: May 6, 2025
// Finished: May 12, 2025


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.stream.Collectors;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class gameMain extends JFrame implements ActionListener {

    private int player1CardSum, player2CardSum, player3CardSum, player4CardSum;
    private int p1HandsLeft, p2HandsLeft, p3HandsLeft, p4HandsLeft;
    private int p1DiscardsLeft, p2DiscardsLeft, p3DiscardsLeft, p4DiscardsLeft;
    private int pSel1, pSel2, pSel3, pSel4;
    private int p1CurrentScore, p2CurrentScore, p3CurrentScore, p4CurrentScore;
    private int p1TotalScore;
    private int p2TotalScore;
    private int p3TotalScore;
    private int p4TotalScore;
    private int equalValAmn;
    private int handStartIndex;
    private int handEndIndex;
    private int playerCount;
    private int roundAmount;
    private JLabel gameInfo1;
    private JLabel gameInfo2;
    private JButton confirmSettings;
    private List<cardClass> playerDeck1;
    private List<cardClass> playerDeck2;
    private List<cardClass> playerDeck3;
    private List<cardClass> playerDeck4;
    private List<cardClass> Deck;
    private deckClass TheDeck;
    private List<cardClass> NewDeck;
    private JFrame gameWindowLoad;
    private JFrame gameWindow1;
    private JFrame gameWindow2;
    private JFrame gameWindow3;
    private JFrame gameWindow4;
    private JFrame gameWindow5;
    private JFrame playerWindow1;
    private JFrame playerWindow2;
    private JFrame playerWindow3;
    private JFrame playerWindow4;
    private JPanel gameDisplayWindowLoad;
    private JPanel gameDisplayWindow1;
    private JPanel gameDisplayWindow2; 
    private JPanel gameDisplayWindow3;  
    private JPanel gameDisplayWindow4; 
    private JPanel gameDisplayWindow5; 
    private JPanel playerDisplayWindow1;
    private JPanel playerDisplayWindow2;
    private JPanel playerDisplayWindow3;
    private JPanel playerDisplayWindow4;
    private List<JButton> playerSelectBList;
    private List<JButton> playerDiscardBList;
    private int indexA;
    private JButton pause1GameB;
    private JButton pause2GameB;
    private JButton pause3GameB;
    private JButton pause4GameB;
    private JButton quit1GameB;
    private JButton quit2GameB;
    private JButton quit3GameB;
    private JButton quit4GameB;
    private JButton playHand1B;
    private JButton playHand2B;
    private JButton playHand3B;
    private JButton playHand4B;
    private JButton playerSwitchB;
    private JButton confPauseGameB;
    private JButton confQuitGameB;
    private JButton denyPauseGameB;
    private JButton denyQuitGameB;
    private JButton confLoadB;
    private JButton denyLoadB;
    private JLabel pauseGameL;
    private JLabel quitGameL;
    private JLabel playerSwitchL;
    private JLabel loadGamePrompt;
    private JLabel player1HandsDisplay;
    private JLabel player2HandsDisplay;
    private JLabel player3HandsDisplay;
    private JLabel player4HandsDisplay;
    private JLabel player1SelectionDisplay;
    private JLabel player2SelectionDisplay;
    private JLabel player3SelectionDisplay;
    private JLabel player4SelectionDisplay;
    private List<cardClass> selectedCards;
    private JButton player1Select;
    private JButton player2Select;
    private JButton player3Select;
    private JButton player4Select;
    private JButton player1Discard;
    private JButton player2Discard;
    private JButton player3Discard;
    private JButton player4Discard;
    

    public gameMain () {

        player1CardSum = 0; 
        player2CardSum = 0; 
        player3CardSum = 0;
        player4CardSum = 0;
        pSel1 = 0;
        pSel2 = 0;
        pSel3 = 0;
        pSel4 = 0;
        p1CurrentScore = 0;
        p2CurrentScore = 0;
        p3CurrentScore = 0;
        p4CurrentScore = 0;
        p1DiscardsLeft = 5;
        p2DiscardsLeft = 5;
        p3DiscardsLeft = 5;
        p4DiscardsLeft = 5;
        p1TotalScore = 0;
        p2TotalScore = 0;
        p3TotalScore = 0;
        p4TotalScore = 0;
        equalValAmn = 0;
        p1HandsLeft = 3; 
        p2HandsLeft = 3;
        p3HandsLeft = 3;
        p4HandsLeft = 3;
        handStartIndex = 0;
        handEndIndex = 7;
        playerCount = 4;
        roundAmount = 3;
        playerSelectBList = new ArrayList<>();
        playerDiscardBList = new ArrayList<>();
        selectedCards = new ArrayList<>();

        Font menloFont = new Font("Menlo", Font.PLAIN,12);

        // Window for loading a saved game
        gameWindowLoad = new JFrame("Game Notification - Load Game");
        gameWindowLoad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindowLoad.setSize(500, 300);
        gameWindowLoad.setLocationRelativeTo(null);
        gameWindowLoad.setResizable(false);
        gameDisplayWindowLoad = new JPanel();
        gameDisplayWindowLoad.setLayout(null);

        // Window for starting a new game
        gameWindow1 = new JFrame("Game Instructions");
        gameWindow1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow1.setSize(500, 500);
        gameWindow1.setLocationRelativeTo(null);
        gameWindow1.setResizable(false);
        gameDisplayWindow1 = new JPanel();
        gameDisplayWindow1.setLayout(null);

        // Window for switching between players
        gameWindow2 = new JFrame("Game Notification - Player Switch");
        gameWindow2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow2.setSize(300, 250);
        gameWindow2.setLocationRelativeTo(null);
        gameWindow2.setResizable(false);
        gameDisplayWindow2 = new JPanel();
        gameDisplayWindow2.setLayout(null);

        // Window for the game results screen
        gameWindow3 = new JFrame("Game Notification - Results");
        gameWindow3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow3.setSize(950, 600);
        gameWindow3.setLocationRelativeTo(null);
        gameWindow3.setResizable(false);
        gameDisplayWindow3 = new JPanel();
        gameDisplayWindow3.setLayout(null);
        
        // Window for the pause function
        gameWindow4 = new JFrame("Game Notification - Pause");
        gameWindow4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow4.setSize(300, 250);
        gameWindow4.setLocationRelativeTo(null);
        gameWindow4.setResizable(false);
        gameDisplayWindow4 = new JPanel();
        gameDisplayWindow4.setLayout(null);

        // Window for the quit function
        gameWindow5 = new JFrame("Game Notification - Quit");
        gameWindow5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow5.setSize(300, 250);
        gameWindow5.setLocationRelativeTo(null);
        gameWindow5.setResizable(false);
        gameDisplayWindow5 = new JPanel();
        gameDisplayWindow5.setLayout(null);

        // Window for player 1
        playerWindow1 = new JFrame("Player 1");
        playerWindow1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        playerWindow1.setSize(950, 600);
        playerWindow1.setLocationRelativeTo(null);
        playerWindow1.setResizable(false);
        playerDisplayWindow1 = new JPanel();
        playerDisplayWindow1.setLayout(null);

        // Window for player 2
        playerWindow2 = new JFrame("Player 2");
        playerWindow2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        playerWindow2.setSize(950, 600);
        playerWindow2.setLocationRelativeTo(null);
        playerWindow2.setResizable(false);
        playerDisplayWindow2 = new JPanel();
        playerDisplayWindow2.setLayout(null);

        // Window for player 3
        playerWindow3 = new JFrame("Player 3");
        playerWindow3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        playerWindow3.setSize(950, 600);
        playerWindow3.setLocationRelativeTo(null);
        playerWindow3.setResizable(false);
        playerDisplayWindow3 = new JPanel();
        playerDisplayWindow3.setLayout(null);

        // Window for player 4
        playerWindow4 = new JFrame("Player 4");
        playerWindow4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        playerWindow4.setSize(950, 600);
        playerWindow4.setLocationRelativeTo(null);
        playerWindow4.setResizable(false);
        playerDisplayWindow4 = new JPanel();
        playerDisplayWindow4.setLayout(null);

        // Text label for start screen
        gameInfo1 = new JLabel("-=// ANALOG POKER: Game Instructions //=-");
        gameInfo1.setBounds(0, 20,500,25);
        gameInfo1.setHorizontalAlignment(SwingConstants.CENTER);
        gameDisplayWindow1.add(gameInfo1);

        // Text label for game instructions (as soon as I find a good way of formatting it)
        gameInfo2 = new JLabel(" COMING SOON ");
        gameInfo2.setBounds(0, 70,500,25);
        gameInfo2.setHorizontalAlignment(SwingConstants.CENTER);
        gameDisplayWindow1.add(gameInfo2);

        // Starts the game
        confirmSettings = new JButton("Start Game");
        confirmSettings.setBounds(200, 310,100,25);
        confirmSettings.addActionListener(this);
        gameDisplayWindow1.add(confirmSettings);
        
        // Displays the amount of hands left for player 1
        player1HandsDisplay = new JLabel("Hands Left: 3");
        player1HandsDisplay.setBounds(25, 500,100,20);
        player1HandsDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        player1HandsDisplay.setFont(menloFont);
        playerDisplayWindow1.add(player1HandsDisplay);

        // Displays the amount of hands left for player 2
        player2HandsDisplay = new JLabel("Hands Left: 3");
        player2HandsDisplay.setBounds(25, 500,100,20);
        player2HandsDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        player2HandsDisplay.setFont(menloFont);
        playerDisplayWindow2.add(player2HandsDisplay);

        // Displays the amount of hands left for player 3
        player3HandsDisplay = new JLabel("Hands Left: 3");
        player3HandsDisplay.setBounds(25, 500,100,20);
        player3HandsDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        player3HandsDisplay.setFont(menloFont);
        playerDisplayWindow3.add(player3HandsDisplay);

        // Displays the amount of hands left for player 4
        player4HandsDisplay = new JLabel("Hands Left: 3");
        player4HandsDisplay.setBounds(25, 500,100,20);
        player4HandsDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        player4HandsDisplay.setFont(menloFont);
        playerDisplayWindow4.add(player4HandsDisplay);

        // Displays the card selection for player 1
        player1SelectionDisplay = new JLabel("{ [   ] }");
        player1SelectionDisplay.setBounds(0, 430,950,20);
        player1SelectionDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        player1SelectionDisplay.setFont(menloFont);
        playerDisplayWindow1.add(player1SelectionDisplay);

        // Displays the card selection for player 2
        player2SelectionDisplay = new JLabel("{ [   ] }");
        player2SelectionDisplay.setBounds(0, 430,950,20);
        player2SelectionDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        player2SelectionDisplay.setFont(menloFont);
        playerDisplayWindow2.add(player2SelectionDisplay);
        
        // Displays the card selection for player 3
        player3SelectionDisplay = new JLabel("{ [   ] }");
        player3SelectionDisplay.setBounds(0, 430,950,20);
        player3SelectionDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        player3SelectionDisplay.setFont(menloFont);
        playerDisplayWindow3.add(player3SelectionDisplay);

        // Displays the card selection for player 4
        player4SelectionDisplay = new JLabel("{ [   ] }");
        player4SelectionDisplay.setBounds(0, 430,950,20);
        player4SelectionDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        player4SelectionDisplay.setFont(menloFont);
        playerDisplayWindow4.add(player4SelectionDisplay);

        // Pause Button
        pause1GameB = new JButton("Pause");
        pause1GameB.setBounds(25, 530,100,20);
        pause1GameB.setHorizontalAlignment(SwingConstants.CENTER);
        pause1GameB.setFont(menloFont);
        pause1GameB.addActionListener(this);
        playerDisplayWindow1.add(pause1GameB);

         // Play Hand Button
        playHand1B = new JButton("Play Hand");
        playHand1B.setBounds(375, 530,100,20);
        playHand1B.setHorizontalAlignment(SwingConstants.CENTER);
        playHand1B.setFont(menloFont);
        playHand1B.addActionListener(this);
        playerDisplayWindow1.add(playHand1B);

        playHand2B = new JButton("Play Hand");
        playHand2B.setBounds(375, 530,100,20);
        playHand2B.setHorizontalAlignment(SwingConstants.CENTER);
        playHand2B.setFont(menloFont);
        playHand2B.addActionListener(this);
        playerDisplayWindow2.add(playHand2B);

        playHand3B = new JButton("Play Hand");
        playHand3B.setBounds(375, 530,100,20);
        playHand3B.setHorizontalAlignment(SwingConstants.CENTER);
        playHand3B.setFont(menloFont);
        playHand3B.addActionListener(this);
        playerDisplayWindow3.add(playHand3B);

        playHand4B = new JButton("Play Hand");
        playHand4B.setBounds(375, 530,100,20);
        playHand4B.setHorizontalAlignment(SwingConstants.CENTER);
        playHand4B.setFont(menloFont);
        playHand4B.addActionListener(this);
        playerDisplayWindow4.add(playHand4B);

        pause2GameB = new JButton("Pause");
        pause2GameB.setBounds(25, 530,100,20);
        pause2GameB.setHorizontalAlignment(SwingConstants.CENTER);
        pause2GameB.setFont(menloFont);
        pause2GameB.addActionListener(this);
        playerDisplayWindow2.add(pause2GameB);

        pause3GameB = new JButton("Pause");
        pause3GameB.setBounds(25, 530,100,20);
        pause3GameB.setHorizontalAlignment(SwingConstants.CENTER);
        pause3GameB.setFont(menloFont);
        pause3GameB.addActionListener(this);
        playerDisplayWindow3.add(pause3GameB);

        pause4GameB = new JButton("Pause");
        pause4GameB.setBounds(25, 530,100,20);
        pause4GameB.setHorizontalAlignment(SwingConstants.CENTER);
        pause4GameB.setFont(menloFont);
        pause4GameB.addActionListener(this);
        playerDisplayWindow4.add(pause4GameB);
        
        quit1GameB = new JButton("Quit");
        quit1GameB.setBounds(145, 530,100,20);
        quit1GameB.setHorizontalAlignment(SwingConstants.CENTER);
        quit1GameB.setFont(menloFont);
        quit1GameB.addActionListener(this);
        playerDisplayWindow1.add(quit1GameB);

        quit2GameB = new JButton("Quit");
        quit2GameB.setBounds(145, 530,100,20);
        quit2GameB.setHorizontalAlignment(SwingConstants.CENTER);
        quit2GameB.setFont(menloFont);
        quit2GameB.addActionListener(this);
        playerDisplayWindow2.add(quit2GameB);

        quit3GameB = new JButton("Quit");
        quit3GameB.setBounds(145, 530,100,20);
        quit3GameB.setHorizontalAlignment(SwingConstants.CENTER);
        quit3GameB.setFont(menloFont);
        quit3GameB.addActionListener(this);
        playerDisplayWindow3.add(quit3GameB);

        quit4GameB = new JButton("Quit");
        quit4GameB.setBounds(145, 530,100,20);
        quit4GameB.setHorizontalAlignment(SwingConstants.CENTER);
        quit4GameB.setFont(menloFont);
        quit4GameB.addActionListener(this);
        playerDisplayWindow4.add(quit4GameB);

        playerSwitchB = new JButton("OK");
        playerSwitchB.setBounds(150, 100,100,20);
        playerSwitchB.setHorizontalAlignment(SwingConstants.CENTER);
        playerSwitchB.setFont(menloFont);
        playerSwitchB.addActionListener(this);
        gameDisplayWindow2.add(playerSwitchB);

        confPauseGameB = new JButton("Yes");
        confPauseGameB.setBounds(25, 100,100,20);
        confPauseGameB.setHorizontalAlignment(SwingConstants.CENTER);
        confPauseGameB.setFont(menloFont);
        confPauseGameB.addActionListener(this);
        gameDisplayWindow4.add(confPauseGameB);

        confQuitGameB = new JButton("Yes");
        confQuitGameB.setBounds(25, 100,100,20);
        confQuitGameB.setHorizontalAlignment(SwingConstants.CENTER);
        confQuitGameB.setFont(menloFont);
        confQuitGameB.addActionListener(this);
        gameDisplayWindow5.add(confQuitGameB);

        confLoadB = new JButton("Yes");
        confLoadB.setBounds(25, 100,100,20);
        confLoadB.setHorizontalAlignment(SwingConstants.CENTER);
        confLoadB.setFont(menloFont);
        confLoadB.addActionListener(this);
        gameDisplayWindowLoad.add(confLoadB);

        denyLoadB = new JButton("No");
        denyLoadB.setBounds(155, 100,100,20);
        denyLoadB.setHorizontalAlignment(SwingConstants.CENTER);
        denyLoadB.setFont(menloFont);
        denyLoadB.addActionListener(this);
        gameDisplayWindowLoad.add(denyLoadB);

        denyPauseGameB = new JButton("No");
        denyPauseGameB.setBounds(155, 100,100,20);
        denyPauseGameB.setHorizontalAlignment(SwingConstants.CENTER);
        denyPauseGameB.setFont(menloFont);
        denyPauseGameB.addActionListener(this);
        gameDisplayWindow4.add(denyPauseGameB);

        denyQuitGameB = new JButton("No");
        denyQuitGameB.setBounds(155, 100,100,20);
        denyQuitGameB.setHorizontalAlignment(SwingConstants.CENTER);
        denyQuitGameB.setFont(menloFont);
        denyQuitGameB.addActionListener(this);
        gameDisplayWindow5.add(denyQuitGameB);

        pauseGameL = new JLabel("Pause the game? (SAVES GAME PROGRESS)");
        pauseGameL.setBounds(0, 20,300,25);
        pauseGameL.setHorizontalAlignment(SwingConstants.CENTER);
        gameDisplayWindow4.add(pauseGameL);

        quitGameL = new JLabel("Quit the game? (LOSES GAME PROGRESS)");
        quitGameL.setBounds(0, 20,300,25);
        quitGameL.setHorizontalAlignment(SwingConstants.CENTER);
        gameDisplayWindow5.add(quitGameL);

        playerSwitchL = new JLabel("Switch to next player and press OK when ready!");
        playerSwitchL.setBounds(0, 20,300,25);
        playerSwitchL.setHorizontalAlignment(SwingConstants.CENTER);
        gameDisplayWindow2.add(playerSwitchL);

        playerSwitchL = new JLabel("Switch to next player and press OK when ready!");
        playerSwitchL.setBounds(0, 20,300,25);
        playerSwitchL.setHorizontalAlignment(SwingConstants.CENTER);
        gameDisplayWindow2.add(playerSwitchL);

        loadGamePrompt = new JLabel("A game save is available. Load Game?");
        loadGamePrompt.setBounds(0, 20,500,25);
        loadGamePrompt.setHorizontalAlignment(SwingConstants.CENTER);
        gameDisplayWindowLoad.add(loadGamePrompt);


        File saveCheck = new File("gameData.txt");
        if (saveCheck.length() >= 1) {
            gameWindowLoad.setContentPane(gameDisplayWindow1);
            gameWindowLoad.setVisible(true);
        } else {
            gameWindow1.setContentPane(gameDisplayWindow1);
            gameWindow1.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == quit1GameB) {
            gameDisplayWindow5.setVisible(true);
        }
        if (e.getSource() == quit2GameB) {
            gameDisplayWindow5.setVisible(true);
        }
        if (e.getSource() == quit3GameB) {
            gameDisplayWindow5.setVisible(true);
        }
        if (e.getSource() == quit4GameB) {
            gameDisplayWindow5.setVisible(true);
        }
        if (e.getSource() == pause1GameB) {
            gameDisplayWindow4.setVisible(true);
        }
        if (e.getSource() == pause1GameB) {
            gameDisplayWindow4.setVisible(true);
        }
        if (e.getSource() == pause1GameB) {
            gameDisplayWindow4.setVisible(true);
        }
        if (e.getSource() == pause1GameB) {
            gameDisplayWindow4.setVisible(true);
        }
        if (e.getSource() == denyQuitGameB) {
            System.exit(0);
        }
        if (e.getSource() == confQuitGameB) {
            gameDisplayWindow5.setVisible(false);
        }
        if (e.getSource() == confPauseGameB) {
            File sDirect = new File("gameData.txt");
            saveGame(sDirect, playerDeck1, playerDeck2, playerDeck3, playerDeck4, NewDeck, p1HandsLeft, p2HandsLeft, p3HandsLeft, p4HandsLeft, p1DiscardsLeft, p2DiscardsLeft, p3DiscardsLeft, p4DiscardsLeft, p1CurrentScore, p2CurrentScore, p3CurrentScore, p4CurrentScore, roundAmount, playerDisplayWindow1.isVisible(), playerDisplayWindow2.isVisible(),playerDisplayWindow3.isVisible(),playerDisplayWindow4.isVisible());
            System.exit(0);
        }
        if (e.getSource() == denyPauseGameB) {
            gameDisplayWindow4.setVisible(false);
        }
        if (p1HandsLeft == 0) {
            playerDisplayWindow1.setVisible(false);
            playerDisplayWindow2.setVisible(false);
            playerDisplayWindow3.setVisible(false);
            playerDisplayWindow4.setVisible(false);

            JLabel player1Stats = new JLabel("Player 1 Score: " + p1CurrentScore);
            player1Stats.setBounds(50, 40,300,25);
            player1Stats.setHorizontalAlignment(SwingConstants.CENTER);
            gameDisplayWindow3.add(player1Stats);

            JLabel player2Stats = new JLabel("Player 2 Score: " + p2CurrentScore);
            player2Stats.setBounds(50, 65,300,25);
            player2Stats.setHorizontalAlignment(SwingConstants.CENTER);
            gameDisplayWindow3.add(player2Stats);

            JLabel player3Stats = new JLabel("Player 3 Score: " + p3CurrentScore);
            player3Stats.setBounds(50, 90,300,25);
            player3Stats.setHorizontalAlignment(SwingConstants.CENTER);
            gameDisplayWindow3.add(player3Stats);

            JLabel player4Stats = new JLabel("Player 4 Score: " + p4CurrentScore);
            player4Stats.setBounds(50, 115,300,25);
            player4Stats.setHorizontalAlignment(SwingConstants.CENTER);
            gameDisplayWindow3.add(player4Stats);

            gameWindow5.setVisible(true);
        }
        if (e.getSource() == confLoadB) {
            File sDirect = new File("gameData.txt");
            loadGame(sDirect);
            try {
                serverCommand(0, 0);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == confirmSettings) {
            try {
                gameWindow1.setVisible(false);
                gameStart();
                serverCommand(0, 0);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        if (playerSelectBList != null) {
            if (playerSelectBList.contains((JButton)e.getSource()) == true) {
                try {
                    indexA = Integer.parseInt(e.getActionCommand());
                } catch (NumberFormatException e6) {
                    e6.printStackTrace();
                }
                if (indexA != -1) {
                    int newCommand = indexA;
                    newCommand += 1;
                    int playerIdentifier;
                    if (newCommand <= 7) {
                        playerIdentifier = 1;
                    } else if (newCommand > 7 && newCommand <= 14) {
                        playerIdentifier = 2;
                    } else if (newCommand > 14 && newCommand <= 21) {
                        playerIdentifier = 3;
                    } else {
                        playerIdentifier = 4;
                    } 
                    try {
                        cardSelector(newCommand, playerIdentifier);
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
            }
        }
        if (e.getSource() == playerSwitchB) {
            if (playerWindow1.isVisible() == true && playerWindow2.isVisible() == false && playerWindow3.isVisible() == false && playerWindow4.isVisible() == false) {
                playerWindow1.setVisible(false);
                playerWindow2.setContentPane(playerDisplayWindow2);
                playerWindow2.setVisible(true);
            } else if (playerWindow1.isVisible() == false && playerWindow2.isVisible() == true && playerWindow3.isVisible() == false && playerWindow4.isVisible() == false) {
                playerWindow2.setVisible(false);
                playerWindow3.setContentPane(playerDisplayWindow3);
                playerWindow3.setVisible(true);
            } else if (playerWindow1.isVisible() == false && playerWindow2.isVisible() == false && playerWindow3.isVisible() == true && playerWindow4.isVisible() == false) {
                playerWindow3.setVisible(false);
                playerWindow4.setContentPane(playerDisplayWindow4);
                playerWindow4.setVisible(true);
            } else if (playerWindow1.isVisible() == false && playerWindow2.isVisible() == false && playerWindow3.isVisible() == false && playerWindow4.isVisible() == true) {
                playerWindow4.setVisible(false);
                playerWindow1.setContentPane(playerDisplayWindow1);
                playerWindow1.setVisible(true);
            }

        } 
        if (playerDiscardBList != null) {
            if (playerDiscardBList.contains((JButton)e.getSource()) == true) {
                try {
                    indexA = Integer.parseInt(e.getActionCommand());
                } catch (NumberFormatException e6) {
                    e6.printStackTrace();
                }
                if (indexA != -1) {
                    int newCommand = indexA;
                    newCommand += 1;
                    int playerIdentifier;
                    if (newCommand <= 7) {
                        playerIdentifier = 1;
                    } else if (newCommand > 7 && newCommand <= 14) {
                        playerIdentifier = 2;
                    } else if (newCommand > 14 && newCommand <= 21) {
                        playerIdentifier = 3;
                    } else {
                        playerIdentifier = 4;
                    } 
                    try {
                        cardSelector(newCommand, playerIdentifier);
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
            }
        }
        if (e.getSource() == playHand4B) {
            if (selectedCards != null && selectedCards.isEmpty() == false) {
                if (selectedCards.size() == 5) {
                    for (cardClass c : selectedCards) {
                        player4CardSum += c.getValue();
                    } 
                    List<String> allSuits = selectedCards.stream()
                        .map(cardClass::getSuit)
                        .collect(Collectors.toList());
                    List<Integer> allValues = selectedCards.stream()
                        .map(cardClass::getValue)
                        .collect(Collectors.toList());
                    String allValueOld = allValues.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "));
                    String allSuitsOld = allSuits.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "));
                    String allHandValues = String.join("", "[", allValueOld, "]");
                    String allHandSuits = String.join("", "[", allSuitsOld, "]");
                    p4TotalScore += player4CardSum;
                        if (scoreManager.checkFlush(allHandSuits) == true) {
                            p4TotalScore *= 5;
                            player4SelectionDisplay.setText("+ FLUSH (x5 Mult)");
                        }
                        if (scoreManager.checkStraight(allHandValues) == true) {
                            p4TotalScore *= 6;
                            player4SelectionDisplay.setText("+ STRAIGHT (x6 Mult)");
                        }
                        equalValAmn = scoreManager.checkOther(allHandValues);
                        if (scoreManager.checkPair(equalValAmn) == true) {
                            p4TotalScore *= 2;
                            player4SelectionDisplay.setText("+ PAIR (x2 Mult)");
                        }
                        if (scoreManager.checkTwoPair(equalValAmn) == true) {
                            p4TotalScore *= 3.5;
                            player4SelectionDisplay.setText("+ TWO PAIR (x3.5 Mult)");
                        }
                        if (scoreManager.checkFullHouse(equalValAmn) == true) {
                            p4TotalScore *= 6;
                            player4SelectionDisplay.setText("+ FULL HOUSE (x5 Mult)");
                        }
                    p4CurrentScore += p4TotalScore;
                    selectedCards.clear();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e4) {
                        e4.printStackTrace();
                    }
                    player4SelectionDisplay.setText("{ [  ] }");
                } else {
                    playHand4B.setText("Needs 5 Cards");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e4) {
                        e4.printStackTrace();
                    }
                    playHand4B.setText("Play Hand");
                }
            } else {
                playHand4B.setText("None Selected");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e4) {
                    e4.printStackTrace();
                }
                playHand4B.setText("Play Hand");
            }
        }
        
        if (e.getSource() == playHand3B) {
            if (selectedCards != null && selectedCards.isEmpty() == false) {
                if (selectedCards.size() == 5) {
                    for (cardClass c : selectedCards) {
                        player3CardSum += c.getValue();
                    } 
                    List<String> allSuits = selectedCards.stream()
                        .map(cardClass::getSuit)
                        .collect(Collectors.toList());
                    List<Integer> allValues = selectedCards.stream()
                        .map(cardClass::getValue)
                        .collect(Collectors.toList());
                    String allValueOld = allValues.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "));
                    String allSuitsOld = allSuits.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "));
                    String allHandValues = String.join("", "[", allValueOld, "]");
                    String allHandSuits = String.join("", "[", allSuitsOld, "]");
                    p3TotalScore += player3CardSum;
                        if (scoreManager.checkFlush(allHandSuits) == true) {
                            p3TotalScore *= 5;
                            player3SelectionDisplay.setText("+ FLUSH (x5 Mult)");
                        }
                        if (scoreManager.checkStraight(allHandValues) == true) {
                            p3TotalScore *= 6;
                            player3SelectionDisplay.setText("+ STRAIGHT (x6 Mult)");
                        }
                        equalValAmn = scoreManager.checkOther(allHandValues);
                        if (scoreManager.checkPair(equalValAmn) == true) {
                            p3TotalScore *= 2;
                            player3SelectionDisplay.setText("+ PAIR (x2 Mult)");
                        }
                        if (scoreManager.checkTwoPair(equalValAmn) == true) {
                            p3TotalScore *= 3.5;
                            player3SelectionDisplay.setText("+ TWO PAIR (x3.5 Mult)");
                        }
                        if (scoreManager.checkFullHouse(equalValAmn) == true) {
                            p3TotalScore *= 6;
                            player3SelectionDisplay.setText("+ FULL HOUSE (x5 Mult)");
                        }
                    p3CurrentScore += p3TotalScore;
                    selectedCards.clear();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                    player3SelectionDisplay.setText("{ [  ] }");
                } else {
                    playHand3B.setText("Needs 5 Cards");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                    playHand3B.setText("Play Hand");
                }
            } else {
                playHand3B.setText("None Selected");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e3) {
                    e3.printStackTrace();
                }
                playHand3B.setText("Play Hand");
            }
        }
        
        if (e.getSource() == playHand2B) {
            if (selectedCards != null && selectedCards.isEmpty() == false) {
                if (selectedCards.size() == 5) {
                    for (cardClass c : selectedCards) {
                        player2CardSum += c.getValue();
                    } 
                    List<String> allSuits = selectedCards.stream()
                        .map(cardClass::getSuit)
                        .collect(Collectors.toList());
                    List<Integer> allValues = selectedCards.stream()
                        .map(cardClass::getValue)
                        .collect(Collectors.toList());
                    String allValueOld = allValues.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "));
                    String allSuitsOld = allSuits.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "));
                    String allHandValues = String.join("", "[", allValueOld, "]");
                    String allHandSuits = String.join("", "[", allSuitsOld, "]");
                    p2TotalScore += player2CardSum;
                        if (scoreManager.checkFlush(allHandSuits) == true) {
                            p2TotalScore *= 5;
                            player2SelectionDisplay.setText("+ FLUSH (x5 Mult)");
                        }
                        if (scoreManager.checkStraight(allHandValues) == true) {
                            p2TotalScore *= 6;
                            player2SelectionDisplay.setText("+ STRAIGHT (x6 Mult)");
                        }
                        equalValAmn = scoreManager.checkOther(allHandValues);
                        if (scoreManager.checkPair(equalValAmn) == true) {
                            p2TotalScore *= 2;
                            player2SelectionDisplay.setText("+ PAIR (x2 Mult)");
                        }
                        if (scoreManager.checkTwoPair(equalValAmn) == true) {
                            p2TotalScore *= 3.5;
                            player2SelectionDisplay.setText("+ TWO PAIR (x3.5 Mult)");
                        }
                        if (scoreManager.checkFullHouse(equalValAmn) == true) {
                            p2TotalScore *= 6;
                            player2SelectionDisplay.setText("+ FULL HOUSE (x5 Mult)");
                        }
                    p2CurrentScore += p2TotalScore;
                    selectedCards.clear();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    player2SelectionDisplay.setText("{ [  ] }");
                } else {
                    playHand2B.setText("Needs 5 Cards");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    playHand2B.setText("Play Hand");
                }
            } else {
                playHand2B.setText("None Selected");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                playHand2B.setText("Play Hand");
            }
        }

        if (e.getSource() == playHand1B) {
            if (selectedCards != null && selectedCards.isEmpty() == false) {
                if (selectedCards.size() == 5) {
                    for (cardClass c : selectedCards) {
                        player1CardSum += c.getValue();
                    } 
                    List<String> allSuits = selectedCards.stream()
                        .map(cardClass::getSuit)
                        .collect(Collectors.toList());
                    List<Integer> allValues = selectedCards.stream()
                        .map(cardClass::getValue)
                        .collect(Collectors.toList());
                    String allValueOld = allValues.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "));
                    String allSuitsOld = allSuits.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", "));
                    String allHandValues = String.join("", "[", allValueOld, "]");
                    String allHandSuits = String.join("", "[", allSuitsOld, "]");
                    p1TotalScore += player1CardSum;
                        if (scoreManager.checkFlush(allHandSuits) == true) {
                            p1TotalScore *= 5;
                            player1SelectionDisplay.setText("+ FLUSH (x5 Mult)");
                        }
                        if (scoreManager.checkStraight(allHandValues) == true) {
                            p1TotalScore *= 6;
                            player1SelectionDisplay.setText("+ STRAIGHT (x6 Mult)");
                        }
                        equalValAmn = scoreManager.checkOther(allHandValues);
                        if (scoreManager.checkPair(equalValAmn) == true) {
                            p1TotalScore *= 2;
                            player1SelectionDisplay.setText("+ PAIR (x2 Mult)");
                        }
                        if (scoreManager.checkTwoPair(equalValAmn) == true) {
                            p1TotalScore *= 3.5;
                            player1SelectionDisplay.setText("+ TWO PAIR (x3.5 Mult)");
                        }
                        if (scoreManager.checkFullHouse(equalValAmn) == true) {
                            p1TotalScore *= 6;
                            player1SelectionDisplay.setText("+ FULL HOUSE (x5 Mult)");
                        }
                    p1CurrentScore += p1TotalScore;
                    selectedCards.clear();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    player1SelectionDisplay.setText("{ [  ] }");

                    gameWindow2.setContentPane(gameDisplayWindow2);
                    gameWindow2.setVisible(true);
                } else {
                    playHand1B.setText("Needs 5 Cards");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                    playHand1B.setText("Play Hand");
                }
            } else {
                playHand1B.setText("None Selected");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                playHand1B.setText("Play Hand");
            }
        }
    }

    private void cardSelector(int iCommand,int playerNumber) throws IOException {
        if (selectedCards.contains(NewDeck.get(iCommand))) {
            selectedCards.remove(NewDeck.get(iCommand));
        } else {
            selectedCards.add(NewDeck.get(iCommand));
        }
        if (playerNumber == 1) {
            String cardSelection = "";
            for (cardClass c : selectedCards) {
                cardSelection += "[" + c.getNumber() + " " + c.getSuit() + "]";
            }
            player1SelectionDisplay.setText(cardSelection);
        } else if (playerNumber == 2) {
            String cardSelection = "";
            for (cardClass c : selectedCards) {
                cardSelection += "[" + c.getNumber() + " " + c.getSuit() + "]";
            }
            player2SelectionDisplay.setText(cardSelection);
        } else if (playerNumber == 3) {
            String cardSelection = "";
            for (cardClass c : selectedCards) {
                cardSelection += "[" + c.getNumber() + " " + c.getSuit() + "]";
            }
            player3SelectionDisplay.setText(cardSelection);
        } else if (playerNumber == 4) {
            String cardSelection = "";
            for (cardClass c : selectedCards) {
                cardSelection += "[" + c.getNumber() + " " + c.getSuit() + "]";
            }
            player4SelectionDisplay.setText(cardSelection);
        } else {
            System.out.println("Error: Selector Out of Bounds");
        }
        
    }

    private void cardRemover(int iCommand,int playerNumber) throws IOException {
        if (selectedCards.contains(NewDeck.get(iCommand))) {
            selectedCards.remove(NewDeck.get(iCommand));
        } else {
            selectedCards.add(NewDeck.get(iCommand));
        }
        if (playerNumber == 1) {
            String cardSelection = "";
            for (cardClass c : selectedCards) {
                cardSelection += c;
            }
            player1SelectionDisplay.setText(cardSelection);
        } else if (playerNumber == 2) {
            String cardSelection = "";
            for (cardClass c : selectedCards) {
                cardSelection += c;
            }
            player2SelectionDisplay.setText(cardSelection);
        } else if (playerNumber == 3) {
            String cardSelection = "";
            for (cardClass c : selectedCards) {
                cardSelection += c;
            }
            player3SelectionDisplay.setText(cardSelection);
        } else if (playerNumber == 4) {
            String cardSelection = "";
            for (cardClass c : selectedCards) {
                cardSelection += c;
            }
            player4SelectionDisplay.setText(cardSelection);
        } else {
            System.out.println("Error: Selector Out of Bounds");
        }
        
    }

    private void serverCommand(int iCommand,int playerNumber) throws IOException {
        switch (iCommand) {
            case 0:
                Font menloFont = new Font("Menlo", Font.PLAIN,12);
                String new1UI = "";
                String new2UI = "";
                String new3UI = "";
                String new4UI = "";  
                int spacing1 = -394;
                int spacingB1 = 25;
                JLabel infoUI1 = new JLabel("-= Selection =-");
                infoUI1.setBounds(0, 350,950,100);
                infoUI1.setHorizontalAlignment(SwingConstants.CENTER);
                infoUI1.setFont(menloFont);
                playerDisplayWindow1.add(infoUI1);
                for (cardClass Card : playerDeck1) {
                    new1UI = Card.toString();
                    JLabel player1UI = new JLabel("");
                    player1UI.setBounds(spacing1, -50,950,400);
                    player1UI.setHorizontalAlignment(SwingConstants.CENTER);
                    player1UI.setFont(menloFont);
                    playerDisplayWindow1.add(player1UI);
                    player1UI.setText(new1UI);
                    player1Select = new JButton();                 
                    player1Select.setBounds(spacingB1, 270,100,20);
                    player1Select.setHorizontalAlignment(SwingConstants.CENTER);
                    player1Select.setFont(menloFont);
                    player1Select.setText("^ Select ^");
                    playerDisplayWindow1.add(player1Select);
                    player1Discard = new JButton();                 
                    player1Discard.setBounds(spacingB1, 320,100,20);
                    player1Discard.setHorizontalAlignment(SwingConstants.CENTER);
                    player1Discard.setFont(menloFont);
                    player1Discard.setText("Discard");
                    playerDisplayWindow1.add(player1Discard);
                    JLabel player1CardSel = new JLabel("");
                    player1CardSel.setBounds(spacing1, -170,950,400);
                    player1CardSel.setHorizontalAlignment(SwingConstants.CENTER);
                    player1CardSel.setFont(menloFont);
                    playerDisplayWindow1.add(player1CardSel);
                    player1CardSel.setText(Card.getNumber() + " " + Card.getSuit());
                    playerSelectBList.add(player1Select);
                    playerDiscardBList.add(player1Discard);
                    spacing1 += 132;
                    spacingB1 += 132;
                } 

                int spacing2 = -394;
                int spacingB2 = 25;
                JLabel infoUI2 = new JLabel("-= Selection =-");
                infoUI2.setBounds(0, 350,950,100);
                infoUI2.setHorizontalAlignment(SwingConstants.CENTER);
                infoUI2.setFont(menloFont);
                playerDisplayWindow2.add(infoUI2);
                for (cardClass Card : playerDeck2) {
                    new2UI = Card.toString();
                    JLabel player2UI = new JLabel("");
                    player2UI.setBounds(spacing2, -50,950,400);
                    player2UI.setHorizontalAlignment(SwingConstants.CENTER);
                    player2UI.setFont(menloFont);
                    playerDisplayWindow2.add(player2UI);
                    player2UI.setText(new2UI);
                    player2Select = new JButton();                 
                    player2Select.setBounds(spacingB2, 170,100,20);
                    player2Select.setHorizontalAlignment(SwingConstants.CENTER);
                    player2Select.setFont(menloFont);
                    player2Select.setText("^ Select ^");
                    playerDisplayWindow2.add(player2Select);
                    player2Discard = new JButton();                 
                    player2Discard.setBounds(spacingB2, 320,100,20);
                    player2Discard.setHorizontalAlignment(SwingConstants.CENTER);
                    player2Discard.setFont(menloFont);
                    player2Discard.setText("Discard");
                    playerDisplayWindow2.add(player2Discard);
                    JLabel player2CardSel = new JLabel("");
                    player2CardSel.setBounds(spacing2, -170,950,400);
                    player2CardSel.setHorizontalAlignment(SwingConstants.CENTER);
                    player2CardSel.setFont(menloFont);
                    playerDisplayWindow2.add(player2CardSel);
                    player2CardSel.setText(Card.getNumber() + " " + Card.getSuit());
                    playerSelectBList.add(player2Select);
                    playerDiscardBList.add(player2Discard);
                    spacing2 += 132;
                    spacingB2 += 132;
                }  

                int spacing3 = -394;
                int spacingB3 = 25;
                JLabel infoUI3 = new JLabel("-= Selection =-");
                infoUI3.setBounds(0, 350,950,100);
                infoUI3.setHorizontalAlignment(SwingConstants.CENTER);
                infoUI3.setFont(menloFont);
                playerDisplayWindow3.add(infoUI3);
                for (cardClass Card : playerDeck3) {
                    new3UI = Card.toString();
                    JLabel player3UI = new JLabel("");
                    player3UI.setBounds(spacing3, -50,950,400);
                    player3UI.setHorizontalAlignment(SwingConstants.CENTER);
                    player3UI.setFont(menloFont);
                    playerDisplayWindow3.add(player3UI);
                    player3UI.setText(new3UI);
                    player3Select = new JButton();                 
                    player3Select.setBounds(spacingB3, 170,100,20);
                    player3Select.setHorizontalAlignment(SwingConstants.CENTER);
                    player3Select.setFont(menloFont);
                    player3Select.setText("^ Select ^");
                    playerDisplayWindow3.add(player3Select);
                    player3Discard = new JButton();                 
                    player3Discard.setBounds(spacingB3, 320,100,20);
                    player3Discard.setHorizontalAlignment(SwingConstants.CENTER);
                    player3Discard.setFont(menloFont);
                    player3Discard.setText("Discard");
                    playerDisplayWindow3.add(player3Discard);
                    JLabel player3CardSel = new JLabel("");
                    player3CardSel.setBounds(spacing3, -170,950,400);
                    player3CardSel.setHorizontalAlignment(SwingConstants.CENTER);
                    player3CardSel.setFont(menloFont);
                    playerDisplayWindow3.add(player3CardSel);
                    player3CardSel.setText(Card.getNumber() + " " + Card.getSuit());
                    playerSelectBList.add(player3Select);
                    playerDiscardBList.add(player3Discard);
                    spacing3 += 132;
                    spacingB3 += 132;
                }

                int spacing4 = -394;
                int spacingB4 = 25;
                JLabel infoUI4 = new JLabel("-= Selection =-");
                infoUI4.setBounds(0, 350,950,100);
                infoUI4.setHorizontalAlignment(SwingConstants.CENTER);
                infoUI4.setFont(menloFont);
                playerDisplayWindow4.add(infoUI4);
                for (cardClass Card : playerDeck4) {
                    new4UI = Card.toString();
                    JLabel player4UI = new JLabel("");
                    player4UI.setBounds(spacing4, -50,950,400);
                    player4UI.setHorizontalAlignment(SwingConstants.CENTER);
                    player4UI.setFont(menloFont);
                    playerDisplayWindow4.add(player4UI);
                    player4UI.setText(new4UI);
                    player4Select = new JButton();                 
                    player4Select.setBounds(spacingB4, 170,100,20);
                    player4Select.setHorizontalAlignment(SwingConstants.CENTER);
                    player4Select.setFont(menloFont);
                    player4Select.setText("^ Select ^");
                    playerDisplayWindow4.add(player4Select);
                    player4Discard = new JButton();                 
                    player4Discard.setBounds(spacingB4, 320,100,20);
                    player4Discard.setHorizontalAlignment(SwingConstants.CENTER);
                    player4Discard.setFont(menloFont);
                    player4Discard.setText("Discard");
                    playerDisplayWindow4.add(player4Discard);
                    JLabel player4CardSel = new JLabel("");
                    player4CardSel.setBounds(spacing4, -170,950,400);
                    player4CardSel.setHorizontalAlignment(SwingConstants.CENTER);
                    player4CardSel.setFont(menloFont);
                    playerDisplayWindow4.add(player4CardSel);
                    player4CardSel.setText(Card.getNumber() + " " + Card.getSuit());
                    playerSelectBList.add(player4Select);
                    playerDiscardBList.add(player4Discard);
                    spacing4 += 132;
                    spacingB4 += 132;
                }

                int i1 = 0;
                for (JButton sb : playerSelectBList) {
                    sb.addActionListener(this);
                    sb.setActionCommand(i1+"");
                    i1 += 1;
                }

                int i2 = 1;
                for (JButton db : playerDiscardBList) {
                    db.addActionListener(this);
                    db.setActionCommand(i2+"");
                    i2 += 1;
                }

                playerWindow1.setContentPane(playerDisplayWindow1);
                playerWindow1.setVisible(true);
            }
    }

    private void gameStart() throws IOException {
        TheDeck = new deckClass();
        Deck = TheDeck.fillTheDeck();
        NewDeck = new ArrayList<>();
        NewDeck.addAll(Deck);
        Collections.shuffle(NewDeck); 
        playerDeck1 = new ArrayList<>(); {
            playerDeck1.addAll(NewDeck.subList(handStartIndex, handEndIndex));
            handStartIndex += 7;
            handEndIndex += 7;
        }
        playerDeck2 = new ArrayList<>(); {
            playerDeck2.addAll(NewDeck.subList(0, 7));
            handStartIndex += 7;
            handEndIndex += 7;
        }
        playerDeck3 = new ArrayList<>(); {
            playerDeck3.addAll(NewDeck.subList(0, 7));
            handStartIndex += 7;
            handEndIndex += 7;
        }
        playerDeck4 = new ArrayList<>(); {
            playerDeck4.addAll(NewDeck.subList(0, 7));
            handStartIndex += 7;
            handEndIndex += 7;
        }
    }

    

    public static boolean saveGame(File sDirect, List<cardClass> gameDeckS, List<cardClass> player1DeckS, List<cardClass> player2DeckS, 
        List<cardClass> player3DeckS, List<cardClass> player4DeckS, int p1HandsLeftS, int p2HandsLeftS, int p3HandsLeftS, int p4HandsLeftS, 
        int p1DiscardsLeftS, int p2DiscardsLeftS, int p3DiscardsLeftS, int p4DiscardsLeftS, int p1CurrentScoreS, int p2CurrentScoreS,
        int p3CurrentScoreS, int p4CurrentScoreS, int roundAmountS, boolean isP1Turn, boolean isP2Turn, boolean isP3Turn, boolean isP4Turn)  {

        boolean operationStatus = false;
        if (sDirect.exists() && sDirect.length() <= 1 ) {
            try (PrintWriter writer = new PrintWriter(sDirect)) {
                writer.close();
            } catch (FileNotFoundException a) {
                a.printStackTrace();
            }
            try (FileOutputStream userFile = new FileOutputStream(sDirect, true);
                ObjectOutputStream objOut = new ObjectOutputStream(userFile)) {
                for (cardClass cardObj : gameDeckS) {
                    objOut.writeObject(cardObj);
                }
                for (cardClass cardObj : player1DeckS) {
                    objOut.writeObject(cardObj);
                }
                for (cardClass cardObj : player2DeckS) {
                    objOut.writeObject(cardObj);
                }
                for (cardClass cardObj : player3DeckS) {
                    objOut.writeObject(cardObj);
                }
                for (cardClass cardObj : player4DeckS) {
                    objOut.writeObject(cardObj);
                }
                objOut.writeObject(p1HandsLeftS);
                objOut.writeObject(p2HandsLeftS);
                objOut.writeObject(p3HandsLeftS);
                objOut.writeObject(p4HandsLeftS);
                objOut.writeObject(p1DiscardsLeftS);
                objOut.writeObject(p2DiscardsLeftS);
                objOut.writeObject(p3DiscardsLeftS);
                objOut.writeObject(p4DiscardsLeftS);
                objOut.writeObject(p1HandsLeftS);
                objOut.writeObject(p2HandsLeftS);
                objOut.writeObject(p3HandsLeftS);
                objOut.writeObject(p4HandsLeftS);
                objOut.writeObject(roundAmountS);
                operationStatus = true;
            } catch (IOException b) {
                System.err.println("Error: " + b.getMessage());
            }
        } else {
            try (FileOutputStream userFile = new FileOutputStream(sDirect, true);
                ObjectOutputStream objOut = new ObjectOutputStream(userFile)) {
                    for (cardClass cardObj : gameDeckS) {
                        objOut.writeObject(cardObj);
                    }
                    for (cardClass cardObj : player1DeckS) {
                        objOut.writeObject(cardObj);
                    }
                    for (cardClass cardObj : player2DeckS) {
                        objOut.writeObject(cardObj);
                    }
                    for (cardClass cardObj : player3DeckS) {
                        objOut.writeObject(cardObj);
                    }
                    for (cardClass cardObj : player4DeckS) {
                        objOut.writeObject(cardObj);
                    }
                    objOut.writeObject(p1HandsLeftS);
                    objOut.writeObject(p2HandsLeftS);
                    objOut.writeObject(p3HandsLeftS);
                    objOut.writeObject(p4HandsLeftS);
                    objOut.writeObject(p1DiscardsLeftS);
                    objOut.writeObject(p2DiscardsLeftS);
                    objOut.writeObject(p3DiscardsLeftS);
                    objOut.writeObject(p4DiscardsLeftS);
                    objOut.writeObject(p1CurrentScoreS);
                    objOut.writeObject(p2CurrentScoreS);
                    objOut.writeObject(p3CurrentScoreS);
                    objOut.writeObject(p4CurrentScoreS);
                    objOut.writeObject(roundAmountS);
                    objOut.writeObject(isP1Turn);
                    objOut.writeObject(isP2Turn);
                    objOut.writeObject(isP3Turn);
                    objOut.writeObject(isP4Turn);
                operationStatus = true;
            } catch (IOException b) {
                System.err.println("Error: " + b.getMessage());
            }
        }
        return operationStatus;
    }

    public void loadGame(File sDirect)  {
            try (PrintWriter writer = new PrintWriter(sDirect)) {
            } catch (FileNotFoundException a) {
                a.printStackTrace();
            }
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sDirect))) {
                List<cardClass> readDeck = new ArrayList<>();
                List<cardClass> newPlayer1Deck = new ArrayList<>();
                List<cardClass> newPlayer2Deck = new ArrayList<>();
                List<cardClass> newPlayer3Deck = new ArrayList<>();
                List<cardClass> newPlayer4Deck = new ArrayList<>();
                int newP1HandsLeft = 0;
                int newP2HandsLeft = 0;
                int newP3HandsLeft = 0;
                int newP4HandsLeft = 0;
                int newP1DiscardsLeft = 0;
                int newP2DiscardsLeft = 0;
                int newP3DiscardsLeft = 0;
                int newP4DiscardsLeft = 0;
                int newP1CurrentScore = 0;
                int newP2CurrentScore = 0;
                int newP3CurrentScore = 0;
                int newP4CurrentScore = 0;
                int newRoundAmount = 0;
                boolean cisP1Turn = false;
                boolean cisP2Turn = false;
                boolean cisP3Turn = false;
                boolean cisP4Turn = false;
                for (int x = 1; x <= 52; x++) {
                    Object obj = ois.readObject();
                    if (obj instanceof cardClass) {
                        final cardClass card = (cardClass) obj;
                        readDeck.add(card);
                    }
                }
                for (int x = 1; x <= 7; x++) {
                    Object obj = ois.readObject();
                    if (obj instanceof cardClass) {
                        final cardClass card = (cardClass) obj;
                        newPlayer1Deck.add(card);
                    }
                }
                for (int x = 1; x <= 7; x++) {
                    Object obj = ois.readObject();
                    if (obj instanceof cardClass) {
                        final cardClass card = (cardClass) obj;
                        newPlayer2Deck.add(card);
                    }
                }
                for (int x = 1; x <= 7; x++) {
                    Object obj = ois.readObject();
                    if (obj instanceof cardClass) {
                        final cardClass card = (cardClass) obj;
                        newPlayer3Deck.add(card);
                    }
                }
                for (int x = 1; x <= 7; x++) {
                    Object obj = ois.readObject();
                    if (obj instanceof cardClass) {
                        final cardClass card = (cardClass) obj;
                        newPlayer4Deck.add(card);
                    }
                }

                Object obj1 = ois.readObject();
                if (obj1 instanceof int) {
                    final int variable = (int) obj1;
                    newP1HandsLeft = variable;
                }
                Object obj2 = ois.readObject();
                if (obj2 instanceof int) {
                    final int variable = (int) obj2;
                    newP2HandsLeft = variable;
                }
                Object obj3 = ois.readObject();
                if (obj3 instanceof int) {
                    final int variable = (int) obj3;
                    newP3HandsLeft = variable;
                }
                Object obj4 = ois.readObject();
                if (obj4 instanceof int) {
                    final int variable = (int) obj4;
                    newP4HandsLeft = variable;
                }
                Object obj5 = ois.readObject();
                if (obj5 instanceof int) {
                    final int variable = (int) obj5;
                    newP1DiscardsLeft = variable;
                }
                Object obj6 = ois.readObject();
                if (obj6 instanceof int) {
                    final int variable = (int) obj6;
                    newP2DiscardsLeft = variable;
                }
                Object obj7 = ois.readObject();
                if (obj7 instanceof int) {
                    final int variable = (int) obj7;
                    newP3DiscardsLeft = variable;
                }
                Object obj8 = ois.readObject();
                if (obj8 instanceof int) {
                    final int variable = (int) obj8;
                    newP4DiscardsLeft = variable;
                }
                Object obj9 = ois.readObject();
                if (obj9 instanceof int) {
                    final int variable = (int) obj9;
                    newP1CurrentScore = variable;
                }
                Object obj10 = ois.readObject();
                if (obj10 instanceof int) {
                    final int variable = (int) obj10;
                    newP2CurrentScore = variable;
                }
                Object obj11 = ois.readObject();
                if (obj11 instanceof int) {
                    final int variable = (int) obj11;
                    newP3CurrentScore = variable;
                }
                Object obj12 = ois.readObject();
                if (obj12 instanceof int) {
                    final int variable = (int) obj12;
                    newP4CurrentScore = variable;
                }
                Object obj13 = ois.readObject();
                if (obj13 instanceof int) {
                    final int variable = (int) obj13;
                    newRoundAmount = variable;
                }
                Object obj14 = ois.readObject();
                if (obj14 instanceof boolean ) {
                    final boolean variable = (boolean ) obj14;
                    cisP1Turn = variable;
                }
                Object obj15 = ois.readObject();
                if (obj15 instanceof boolean ) {
                    final boolean variable = (boolean) obj15;
                    cisP2Turn  = variable;
                }
                Object obj16 = ois.readObject();
                if (obj16 instanceof boolean ) {
                    final boolean variable = (boolean ) obj16;
                    cisP3Turn  = variable;
                }
                Object obj17 = ois.readObject();
                if (obj17 instanceof boolean ) {
                    final boolean variable = (boolean ) obj17;
                    cisP4Turn  = variable;
                }
                NewDeck.addAll(readDeck);
                playerDeck1.addAll(newPlayer1Deck);
                playerDeck2.addAll(newPlayer2Deck);
                playerDeck3.addAll(newPlayer3Deck);
                playerDeck4.addAll(newPlayer4Deck);
                p1HandsLeft = newP1HandsLeft; 
                p2HandsLeft = newP2HandsLeft;
                p3HandsLeft = newP3HandsLeft;
                p4HandsLeft = newP4HandsLeft;
                p1DiscardsLeft = newP1DiscardsLeft;
                p2DiscardsLeft = newP2DiscardsLeft;
                p3DiscardsLeft = newP3DiscardsLeft;
                p4DiscardsLeft = newP4DiscardsLeft;
                p1CurrentScore = newP1CurrentScore;
                p2CurrentScore = newP2CurrentScore;
                p3CurrentScore = newP3CurrentScore;
                p4CurrentScore = newP4CurrentScore;
                roundAmount = newRoundAmount;
                roundAmount = newRoundAmount;
                boolean isP1Turn = cisP1Turn;
                boolean isP2Turn = cisP2Turn;
                boolean isP3Turn = cisP3Turn;
                boolean isP4Turn = cisP4Turn;
                if (isP1Turn == true) {
                    playerWindow1.setContentPane(playerDisplayWindow1);
                    playerWindow1.setVisible(true);
                }
                if (isP2Turn == true) {
                    playerWindow2.setContentPane(playerDisplayWindow1);
                    playerWindow2.setVisible(true);
                }
                if (isP3Turn == true) {
                    playerWindow3.setContentPane(playerDisplayWindow1);
                    playerWindow3.setVisible(true);
                }
                if (isP4Turn == true) {
                    playerWindow4.setContentPane(playerDisplayWindow1);
                    playerWindow4.setVisible(true);
                }

            } catch (IOException | ClassNotFoundException b) {
                System.err.println("Error: " + b.getMessage());
            }
        }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(gameMain::new);
    }
}
