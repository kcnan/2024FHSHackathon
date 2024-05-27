import javax.swing.JLabel;
import javax.swing.JPanel;

public class Results extends JPanel {
    public Results(int fat, int protein, int carbs, int breakfast, int lunch, int dinner) {
        JLabel results = new JLabel();
        
        // begin the ternary mess (i wish there was a better way to do this)
        // (yes i tried doing if statements and it was equally bad with more repitition + variables)
        String[] resultData = {
            fat < 10 ? "Your fat intake is too low (aim for 10-20g)" :
            fat > 20 ? "Your fat intake is too high (aim for 10-20g)" :
            "Well done! Your fat intake is in recommended range!",

            protein < 15 ? "Your protein intake is too low (aim for 15-30g)" :
            protein > 30 ? "Your protein intake is too high (aim for 15-30g)" :
            "Well done! Your protein intake is in recommended range!",

            carbs < 225 ? "Your carb intake is too low (aim for 60-75)" :
            carbs > 325 ? "Your carb intake is too high (aim for 60-75g)" :
            "Well done! Your carb intake is in recommended range!",

            breakfast == 8 || breakfast == 7 ?
            "Good! You are eating at good time for breakfast!" :
            "Try to have breakfast from 7 to 8 if possible",

            lunch == 12 || lunch == 1 || lunch == 2 ?
            "Good! You are eating at good time for lunch!" :
            "Try to have lunch from 12 to 2 if possible",

            dinner == 6 || dinner == 7 || dinner == 8 ?
            "Good! You are eating at good time for dinner!" :
            "Try to have lunch from 6 to 8 if possible"
        };

        results.setText("<html>- " + String.join("<br> - ", resultData) + "</html>");
        add(results);
    }
}
