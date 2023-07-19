package view;

import javax.swing.*;

public class QueueForm {
    private JTextField enField;
    private JButton enButton;
    private JButton dequeueButton;
    private JPanel myPanel;
    private JLabel frontLabel;
    private JLabel rearLabel;
    private JLabel queueValue;
    private JButton clearAndLoadButton;
    private JButton saveButton;


    public JTextField getEnField() {
        return enField;
    }

    public JButton getEnButton() {
        return enButton;
    }

    public JButton getDequeueButton() {
        return dequeueButton;
    }

    public JPanel getMyPanel() {
        return myPanel;
    }

    public JLabel getFrontLabel() {
        return frontLabel;
    }

    public JLabel getRearLabel() {
        return rearLabel;
    }

    public JLabel getQueueValue() {
        return queueValue;
    }

    public JButton getClearAndLoadButton() {
        return clearAndLoadButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }
}
