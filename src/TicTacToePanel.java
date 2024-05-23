import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToePanel extends JPanel implements ActionListener {
    private static final int GRID_SIZE = 3;
    private JButton[][] buttons = new JButton[GRID_SIZE][GRID_SIZE];
    private char currentPlayer = 'X';
    private boolean gameEnded = false;

    TicTacToePanel() {
        this.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
        initializeButtons();
    }

    private void initializeButtons() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                buttons[row][col] = new JButton("");
                buttons[row][col].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[row][col].setFocusable(false);
                buttons[row][col].addActionListener(this);
                this.add(buttons[row][col]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();
        if (buttonClicked.getText().equals("") && !gameEnded) {
            buttonClicked.setText(String.valueOf(currentPlayer));
            if (checkForWin()) {
                gameEnded = true;
                JOptionPane.showMessageDialog(this, "Игрок " + currentPlayer + " победил!");
                int response = JOptionPane.showConfirmDialog(this, "Хотите сыграть снова?", "Игра окончена", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    resetBoard();
                }
            } else if (isBoardFull()) {
                gameEnded = true;
                JOptionPane.showMessageDialog(this, "Ничья!");
                int response = JOptionPane.showConfirmDialog(this, "Хотите сыграть снова?", "Игра окончена", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    resetBoard();
                }
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    private boolean checkForWin() {
        for (int i = 0; i < GRID_SIZE; i++) {
            if (buttons[i][0].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[i][1].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[i][2].getText().equals(String.valueOf(currentPlayer))) {
                return true;
            }
            if (buttons[0][i].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[1][i].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[2][i].getText().equals(String.valueOf(currentPlayer))) {
                return true;
            }
        }

        if (buttons[0][0].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[2][2].getText().equals(String.valueOf(currentPlayer))) {
            return true;
        }

        if (buttons[0][2].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[2][0].getText().equals(String.valueOf(currentPlayer))) {
            return true;
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (buttons[row][col].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void resetBoard() {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                buttons[row][col].setText("");
            }
        }
        currentPlayer = 'X';
        gameEnded = false;
    }
}
