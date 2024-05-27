import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class WelcomePane extends JPanel {
    public WelcomePane(Consumer<String> switcher) {
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.VERTICAL;
        c.gridy = 0;

        JLabel label = new JLabel();
        label.setText("Welcome to PlanIt!");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        ImageIcon logo = new ImageIcon(new ImageIcon("logo.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));

        JButton btn = new JButton("Enter your desired intake!");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switcher.accept("infoForm");
            }
        });

        c.ipadx = 30;
        c.ipady = 30;
        add(label, c);
        c.gridy++;
        add(new JLabel(logo), c);
        c.gridy++;
        add(btn, c);
    }
}
