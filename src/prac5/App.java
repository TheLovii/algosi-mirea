package prac5;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    private int milan = 0;
    private int madrid = 0;

    private final JLabel result = new JLabel("Result: 0 X 0", SwingConstants.CENTER);
    private final JLabel lastScorer = new JLabel("Last Scorer: N/A", SwingConstants.CENTER);
    private final JLabel winner = new JLabel("Winner: DRAW", SwingConstants.CENTER);

    public App() {
        super("AC Milan vs Real Madrid");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(420, 220);
        setLocationRelativeTo(null);

        JButton btnMilan = new JButton("AC Milan");
        JButton btnMadrid = new JButton("Real Madrid");

        // Кнопки сверху
        JPanel top = new JPanel(new GridLayout(1, 2, 8, 0));
        top.add(btnMilan);
        top.add(btnMadrid);

        // Текстовые метки по центру
        JPanel center = new JPanel(new GridLayout(3, 1, 0, 6));
        center.add(result);
        center.add(lastScorer);
        center.add(winner);

        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);

        btnMilan.addActionListener(e -> {
            milan++;
            lastScorer.setText("Last Scorer: AC Milan");
            refresh();
        });

        btnMadrid.addActionListener(e -> {
            madrid++;
            lastScorer.setText("Last Scorer: Real Madrid");
            refresh();
        });
    }

    private void refresh() {
        result.setText("Result: " + milan + " X " + madrid);
        if (milan > madrid) {
            winner.setText("Winner: AC Milan");
        } else if (madrid > milan) {
            winner.setText("Winner: Real Madrid");
        } else {
            winner.setText("Winner: DRAW");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App().setVisible(true));
    }
}
