import javax.swing.JFrame;

public class TicTacToeFrame extends JFrame {
    TicTacToeFrame() {
        this.add(new TicTacToePanel());
        this.setTitle("Крестики-нолики");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
