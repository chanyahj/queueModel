package view;

import javax.swing.*;

public class QueueView extends JFrame {

    private QueueForm form;

    public QueueView(){
        this.form=new QueueForm();
        JPanel content= form.getMyPanel();
        this.setContentPane(content);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public QueueForm getForm(){
        return form;
    }

    }

