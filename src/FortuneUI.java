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
    JLabel labelName = new JLabel("Name:");
    JTextField nameTextField = new JTextField(20);
    JComboBox<String> comboBox = new JComboBox<>(zodiacSign);
    JLabel labelZodiacSign = new JLabel("Zodiac Sign:");
    JTextArea ResultTextArea = new JTextArea(2,10);
    JButton button = new JButton("Proceed");
    FortuneUI(){
        frame.setVisible(true);
        frame.setSize(300, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(new FlowLayout());
        frame.add(labelName);
        frame.add(nameTextField);
        frame.add(labelZodiacSign);
        frame.add(comboBox);
        frame.add(button);
        nameTextField.addActionListener(this);
        button.addActionListener(this);
        ResultTextArea.setEditable(false);
        frame.getContentPane().setBackground(Color.gray);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.add(ResultTextArea);
        if(e.getSource() == button) {
            i1 = nameTextField.getText().length();
            i2 = zodiacSign[comboBox.getSelectedIndex()].length();
            if (i1 != 0 && i2 != 0) {
                sum = (i1 + i2);
                sum = sum % fortunes.length;
                ResultTextArea.setText(nameTextField.getText() + " ur fortune according to your zodiac sign\n" + zodiacSign[comboBox.getSelectedIndex()] + " tells that->\n " + fortunes[sum]);
            } else {
                ResultTextArea.setText("ERROR!!! No field inputs to calculate.\nEnter something to calculate your fortune");
            }
        }

    }
    public static void main(String[] args) {
        new FortuneUI();
    }

}
