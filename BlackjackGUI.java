//************************************************************//  BlackjackGUI.java       ////  Provides a graphical user interface for a blackjack game//  using the Blackjack class to provide the functionality//  of the game//************************************************************import javax.swing.*;import java.awt.*;import java.awt.event.*;import java.util.*;public class BlackjackGUI extends JPanel{  /** Components for GUI */  JPanel topPanel = new JPanel();  JPanel dcardPanel = new JPanel();  JPanel pcardPanel = new JPanel();  JTextPane winLoseBox = new JTextPane();  JButton hitButton = new JButton();  JButton dealButton = new JButton();  JButton stayButton = new JButton();  JButton playAgainButton = new JButton();  JLabel dealerLabel = new JLabel();  JLabel playerLabel = new JLabel();  Hand dealer = new Hand();    //holds the dealer's cards  Hand player = new Hand();    //holds the player's cards  Blackjack game = new Blackjack(dealer,player);   /** Labels to represent the cards for the game. */  JLabel playerCard1;  JLabel playerCard2;  JLabel playerCardHit;  JLabel dealerCard0;  JLabel dealerCard2;  JLabel dealerCard1;  JLabel dealerCardHit;  /***********************************************************     Constructs the screen.  ***********************************************************/  public BlackjackGUI ()   {    topPanel.setBackground(new Color(0, 122, 0));    dcardPanel.setBackground(new Color(0, 122, 0));    pcardPanel.setBackground(new Color(0, 122, 0));    topPanel.setLayout(new FlowLayout());    winLoseBox.setEditable(false);    winLoseBox.setPreferredSize(new Dimension(120,30));    winLoseBox.setFont(new java.awt.Font                      ("Helvetica Bold", 1, 20));        dealButton.setText("  Deal");    dealButton.addActionListener(new dealButton());    hitButton.setText("  Hit");    hitButton.addActionListener(new hitButton());    hitButton.setEnabled(false);    stayButton.setText("  Stay");    stayButton.addActionListener(new stayButton());       stayButton.setEnabled(false);    playAgainButton.setText("  Play Again");    playAgainButton.addActionListener(new playAgainButton());    playAgainButton.setEnabled(false);         dealerLabel.setText("  Dealer:  ");    playerLabel.setText("  Player:  ");    topPanel.add(winLoseBox);    topPanel.add(dealButton);    topPanel.add(hitButton);    topPanel.add(stayButton);    topPanel.add(playAgainButton);    pcardPanel.add(playerLabel);    dcardPanel.add(dealerLabel);        setLayout(new BorderLayout());    add(topPanel,BorderLayout.NORTH);    add(dcardPanel,BorderLayout.CENTER);    add(pcardPanel,BorderLayout.SOUTH);  }  /***********************************************************     Displays the main application frame.  ***********************************************************/  public void display()   {    JFrame myFrame = new JFrame("BlackJack");    myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    myFrame.setContentPane(this);    myFrame.setPreferredSize(new Dimension(550,400));    myFrame.pack();    myFrame.setVisible(true);  }  /***********************************************************    Represents action listener for dealButton.  ***********************************************************/  private class dealButton implements ActionListener   {    /*****************************************************      Gets dealer and player cards from Hand and the      imgage associated with that random card and puts      them on the screen.    *****************************************************/    public void actionPerformed(ActionEvent e)    {      dcardPanel.add(dealerLabel);      pcardPanel.add(playerLabel);      dealerCard0 = new JLabel(new ImageIcon("back.jpg"));            game.dealInitialCards();            /** iterate set and get current dealer cards */      Card dCard=null;      Iterator<Card> dScan = (dealer.inHand).iterator();      int count = 0;      while (dScan.hasNext())      {        dCard = dScan.next();        if(count==0)          dealerCard1 = new JLabel(dCard.getImage());        else          dealerCard2 = new JLabel(dCard.getImage());                count++;      }            /** iterate set and get current player cards */      Iterator<Card> pScan = (player.inHand).iterator();      count = 0;      while (pScan.hasNext())      {        Card pCard = pScan.next();        if(count==0)          playerCard1 = new JLabel(pCard.getImage());        else          playerCard2 = new JLabel(pCard.getImage());                count++;      }            dcardPanel.add(dealerCard0);      dcardPanel.add(dealerCard2);      pcardPanel.add(playerCard1);      pcardPanel.add(playerCard2);            dealerLabel.setText("  Dealer:  "+ dCard.getValue());      playerLabel.setText("  Player:  "+ game.handValue(player));            hitButton.setEnabled(true);      stayButton.setEnabled(true);      dealButton.setEnabled(false);            if(game.blackj())           {        hitButton.setEnabled(false);        stayButton.setEnabled(false);        dealButton.setEnabled(false);        playAgainButton.setEnabled(true);        winLoseBox.setText("BlackJack");      }            add(dcardPanel,BorderLayout.CENTER);      add(pcardPanel,BorderLayout.SOUTH);    }  }    /***********************************************************    Represents an action listener for hitButton.  ***********************************************************/  private class hitButton implements ActionListener  {    /*****************************************************         Gets another card every time player selects "hit"      until hand value is over 21.      @param e Hit button pressed    *****************************************************/    public void actionPerformed(ActionEvent e)    {      Card hitCard = game.hit(player);      playerCardHit = new JLabel(hitCard.getImage());      pcardPanel.add(playerCardHit);      pcardPanel.repaint();            if(game.bust(player))      {        winLoseBox.setText("Bust");        hitButton.setEnabled(false);        dealButton.setEnabled(false);        stayButton.setEnabled(false);        playAgainButton.setEnabled(true);       }              playerLabel.setText("  Player:   "+ game.handValue(player));     }   }     /***********************************************************    Represents an action listener for stayButton.  ***********************************************************/  private class stayButton implements ActionListener  {    /*****************************************************      Dealer must hit on 16 or lower - determines      winner - player wins if under 21 and above dealer.    *****************************************************/    public void actionPerformed(ActionEvent e)    {      dcardPanel.remove(dealerCard0);      dcardPanel.add(dealerCard1);            dealer = game.dealerPlays();      dcardPanel.removeAll();      dcardPanel.add(dealerLabel);      dealerLabel.setText(" " + dealerLabel.getText());            /** iterate through cards and re-display */      Card dHitCard = null;      Iterator<Card> scan = (dealer.inHand).iterator();      while (scan.hasNext())      {        dHitCard = scan.next();        dealerCardHit = new JLabel(dHitCard.getImage());        dcardPanel.add(dealerCardHit);      }            dealerLabel.setText("Dealer: " + game.handValue(dealer));      playerLabel.setText("Player: " + game.handValue(player));            winLoseBox.setText(game.winner());      hitButton.setEnabled(false);      stayButton.setEnabled(false);      playAgainButton.setEnabled(true);    }  }    /***********************************************************    Represents an action listener for playAgainButton.  ***********************************************************/  private class playAgainButton implements ActionListener  {    /*****************************************************      Resets screen.    *****************************************************/    public void actionPerformed(ActionEvent e)    {      dealerLabel.setText("Dealer: ");      playerLabel.setText("Player: ");      winLoseBox.setText("");            dealer = new Hand();      player = new Hand();      game=new Blackjack(dealer, player);            dcardPanel.removeAll();      pcardPanel.removeAll();            hitButton.setEnabled(false);      stayButton.setEnabled(false);      playAgainButton.setEnabled(false);      dealButton.setEnabled(true);    }  }}