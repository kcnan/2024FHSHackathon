import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class InfoForm extends JPanel {
    int protien = 20;
    int fat = 15;
    int carbs = 275;
    JSlider proteinSlider;
    JSlider fatSlider;
    JSlider carbsSlider;
    public InfoForm(Consumer<String> switcher, JPanel parent) {
        setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        // c.gridwidth = GridBagConstraints.REMAINDER;
        // c.fill = GridBagConstraints.VERTICAL;
        c.gridy = 0;
        c.gridx = 0;

        JLabel protienLbl = new JLabel();
        protienLbl.setText("Protien: " + protien + "(g)");
        JLabel fatLbl = new JLabel();
        fatLbl.setText("Fat: " + fat + "(g)");
        JLabel carbLbl = new JLabel();
        carbLbl.setText("Carbs: " + carbs + "(g)");

        // yes this WAS necessary and i hate java for it
        InfoForm form = this;

        proteinSlider = new JSlider(5, 50);
        proteinSlider.setValue(protien);
        proteinSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                form.protien = proteinSlider.getValue();
                protienLbl.setText("Protien: " + form.protien + "(g)");
                protienLbl.setForeground(
                    form.protien < 15 || form.protien > 30 ? new Color(255, 0, 0) : new Color(0, 255, 0));
            }
        });
        fatSlider = new JSlider(5, 40);
        fatSlider.setValue(fat);
        fatSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                form.fat = fatSlider.getValue();
                fatLbl.setText(
                    "Fat: "
                    + form.fat
                    + "(g)");
                fatLbl.setForeground(
                    form.fat < 10 || form.fat > 20 ? new Color(255, 0, 0) : new Color(0, 255, 0));
            }
        });
        carbsSlider = new JSlider(150, 500);
        carbsSlider.setValue(carbs);
        carbsSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                form.carbs = carbsSlider.getValue();
                carbLbl.setText("Carbs: " + form.carbs + "(g)");
                carbLbl.setForeground(
                    form.carbs < 225 || form.carbs > 325 ? new Color(255, 0, 0) : new Color(0, 255, 0));
            }
        });

        JButton submitBtn = new JButton("Next");
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.add(new InfoForm2(switcher, parent, fat, protien, carbs), "infoForm2");
                switcher.accept("infoForm2");
            }
        });

        add(protienLbl, c);
        c.gridy++;
        add(fatLbl, c);
        c.gridy++;
        add(carbLbl, c);

        c.anchor = GridBagConstraints.WEST;
        c.gridy = 0;
        c.gridx++;
        c.gridwidth = GridBagConstraints.REMAINDER;

        add(proteinSlider, c);
        c.gridy++;
        add(fatSlider, c);
        c.gridy++;
        add(carbsSlider, c);

        c.gridy++;
        c.gridx++;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.EAST;
        c.weightx = 0;
        add(submitBtn, c);
    }
}
