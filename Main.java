import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class Main {
    public static String APPNAME = "PlanIt Application";
    public static void main(String[] args) {
        JFrame frame = new JFrame(APPNAME);
        frame.setVisible(true);
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel cards = new JPanel(new CardLayout());
        CardLayout cl = (CardLayout)cards.getLayout();

        Consumer<String> switcher = (windowName) -> cl.show(cards, windowName);
        cards.add(new WelcomePane(switcher), "welcomePage");
        cards.add(new InfoForm(switcher, cards), "infoForm");

        cl.first(cards);
        frame.add(cards);
    }
}