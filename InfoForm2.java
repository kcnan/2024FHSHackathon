import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class InfoForm2 extends JPanel {
    Integer[] times = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    
    JComboBox<Integer> breakfast;
    JComboBox<Integer> lunch;
    JComboBox<Integer> dinner;
    JButton submitBtn;
    public InfoForm2(Consumer<String> switcher, JPanel parent, int fat, int protein, int carbs) {
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 0;
        c.gridx = 0;

        breakfast = new JComboBox<Integer>(times);
        lunch = new JComboBox<Integer>(times);
        dinner = new JComboBox<Integer>(times);
        submitBtn = new JButton("Submit!");

        submitBtn.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                parent.add(new Results(
                    fat, protein, carbs,
                    (int)breakfast.getSelectedItem(),
                    (int)lunch.getSelectedItem(),
                    (int)dinner.getSelectedItem()), "results");
                switcher.accept("results");
            }
        });

        JLabel breakfastLbl = new JLabel();
        breakfastLbl.setText("Breakfast Time (AM): ");
        JLabel lunchLbl = new JLabel();
        lunchLbl.setText("Lunch Time (PM): ");
        JLabel dinnerLbl = new JLabel();
        dinnerLbl.setText("Dinner Time (PM): ");

        add(breakfastLbl, c);
        c.gridy++;
        add(lunchLbl, c);
        c.gridy++;
        add(dinnerLbl, c);

        c.anchor = GridBagConstraints.WEST;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridy = 0;
        c.gridx++;

        add(breakfast, c);
        c.gridy++;
        add(lunch, c);
        c.gridy++;
        add(dinner, c);

        c.gridy++;
        c.gridx++;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.EAST;
        c.weightx = 0;
        add(submitBtn, c);
    }
}
