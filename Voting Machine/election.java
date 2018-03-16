import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class election implements ActionListener
{

    JRadioButton buttonA, buttonB, buttonC, buttonD, extra ;
    JButton vote, results ;
    JPanel panel ;
    JLabel label ;
    ButtonGroup group ;

    public static int countA, countB, countC, countD ;

    election()
    {
        countA = countB = countC = countD = 0 ;
        JFrame votingMachine = new JFrame("Voting Machine") ;
        panel = new JPanel() ;
        panel.setLayout(null) ;
        group = new ButtonGroup() ;
        label = new JLabel("XYZ ELECTIONS") ;
        label.setBounds(240,20,520,40) ;
        panel.add(label) ;
        
        buttonA = new JRadioButton() ;
        buttonA.setForeground(Color.BLACK) ;
        buttonA.setBounds(230, 70, 520, 40) ;
        buttonA.setText("Candidate A") ;
        buttonA.setActionCommand("A") ;
        
        buttonB = new JRadioButton() ;
        buttonB.setForeground(Color.BLACK) ;
        buttonB.setBounds(230, 120, 520, 40) ;
        buttonB.setText("Candidate B") ;
        buttonB.setActionCommand("B") ;
        
        buttonC = new JRadioButton() ;
        buttonC.setForeground(Color.BLACK) ;
        buttonC.setBounds(230, 170, 520, 40) ;
        buttonC.setText("Candidate C") ;
        buttonC.setActionCommand("C") ;
        
        buttonD = new JRadioButton() ;
        buttonD.setForeground(Color.BLACK) ;
        buttonD.setBounds(230, 220, 520, 40) ;
        buttonD.setText("Candidate D") ;
        buttonD.setActionCommand("D") ;

        extra = new JRadioButton() ;
        extra.setForeground(Color.WHITE) ;
        extra.setActionCommand("X") ;

        vote = new JButton("VOTE") ;
        vote.setForeground(Color.BLACK) ;
        vote.setBounds(180, 300, 220, 40) ;

        results = new JButton("Results") ;
        results.setForeground(Color.BLACK) ;
        results.setBounds(180, 400, 220, 40) ;

        group.add(buttonA) ;
        group.add(buttonB) ;
        group.add(buttonC) ;
        group.add(buttonD) ;
        group.add(extra) ;

        panel.add(buttonA) ;
        panel.add(buttonB) ;
        panel.add(buttonC) ;
        panel.add(buttonD) ;
        panel.add(extra) ;
        panel.add(vote) ;
        panel.add(results) ;
        
        vote.addActionListener(this) ;
        results.addActionListener(this) ;

        votingMachine.add(panel) ;
        votingMachine.setSize(600, 600) ;
        votingMachine.setLocationRelativeTo(null) ;
        votingMachine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
        votingMachine.setVisible(true) ;            

    }

    public void actionPerformed(ActionEvent x)
    {
        if(x.getSource() == vote)
        {
            int y = JOptionPane.showConfirmDialog(null, "Are you sure ? (this action cannot be undone) ") ;
            if(y == JOptionPane.YES_OPTION)
            {
                JOptionPane.showMessageDialog(null, "Your Vote has been Cast") ;
                String cmd = group.getSelection().getActionCommand() ;
                if(cmd == "A"){ countA++ ; }
                else if(cmd == "B"){ countB++ ; }
                else if(cmd == "C"){ countC++ ; }
                else{ countD++ ; }
            }
            extra.setSelected(true) ;
        }
        else
        {
            if(countA > countB && countA > countC && countA > countD)
            {
                JOptionPane.showMessageDialog(null, " Candidate A is the winner ") ;
            }
            else if(countB > countA && countB > countC && countB > countD)
            {
                JOptionPane.showMessageDialog(null, " Candidate B is the winner ") ;
            }
            else if(countC > countA && countC > countB && countC > countD)
            {
                JOptionPane.showMessageDialog(null, " Candidate C is the winner ") ;
            }
            else if(countD > countA && countD > countB && countD > countC)
            {
                JOptionPane.showMessageDialog(null, " Candidate D is the winner ") ;
            }
            else
            {
                JOptionPane.showMessageDialog(null, " Nobody Won. It's a TIE ") ;
            }
            System.exit(0) ;
        }
    }

	public static void main(String[] args)
	{
	   new election() ;
	}
}