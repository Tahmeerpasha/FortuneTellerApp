import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class FortuneUI implements ActionListener{
     JFrame frame = new JFrame("Fortune Teller");
    public static String[] fortunes = {
            "A dubious friend may be an enemy in camouflage.",
            "Your success will astonish everyone.",
            "You will soon be surrounded by good friends and\nlaughter.",
            "Many will travel to hear you speak.",
            "Now is a good time to buy stock.",
            "Physical activity will dramatically improve your\noutlook today.",
            "Say hello to others. You will have a happier day.",
            "You should be able to undertake and complete anything.",
            "You will be pleasantly surprised tonight.",
            "You will be traveling and coming into a fortune.",
            "Your work interests can capture the highest status\nor prestige",
            "A beautiful, smart, and loving person will be coming\n into your life."};
    String[] zodiacSign = {"","Aries","Libra","Capricorn","Cancer","Taurus","Scorpio","Leo",
                            "Aquarius","Gemini","Sagittarius","Virgo","Pisces"};
    public int i1=0, i2=0;
    public int sum;
    JLabel label = new JLabel("Name:");
    JTextField t1 = new JTextField(20);
    JComboBox comboBox = new JComboBox(zodiacSign);
    JLabel label1 = new JLabel("Zodiac Sign:");
    JLabel label2 =  new JLabel();
    JTextArea t3 = new JTextArea(2,10);
    JButton button = new JButton("Proceed");
    FortuneUI(){
        frame.setVisible(true);
        frame.setSize(300, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());
        frame.add(label);
        frame.add(t1);
        frame.add(label1);
        frame.add(comboBox);
        frame.add(button);
        frame.getContentPane().setBackground( new Color(128, 128, 128, 168));
        t1.addActionListener(this);
        button.addActionListener(this);
        t3.setEditable(false);
    }
    public static void main(String[] args) {
        new FortuneUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.add(label2);
        frame.add(t3);
        if (e.getSource() == button)
            i1 = t1.getText().length();
        i2 = zodiacSign[comboBox.getSelectedIndex()].length();
        if (i1 != 0 && i2 != 0) {
            sum = (i1 + i2);
            sum = sum % fortunes.length;
            t3.setText(t1.getText()+" ur fortune according to your zodiac sign\n"+zodiacSign[comboBox.getSelectedIndex()]+" tells that->\n "+fortunes[sum]);
        } else {
            t3.setText("ERROR!!! No field inputs to calculate. \nEnter something to calculate your fortune");
        }
    }
}
