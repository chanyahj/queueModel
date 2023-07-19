package controller;

import model.QueueModel;
import view.QueueForm;
import view.QueueView;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
    * enqueue button adds int to rear of queue
    * dequeue button removes int from front of queue
    * when buttons pressed labels update
    * save+load functionality
    * @throw for invalid text fields
 */
public class QueueController {
private QueueModel<Integer> queue;
private QueueView view;

        public QueueController( QueueModel<Integer> q, QueueView view1){
            this.queue=q;
            this.view=view1;

            QueueForm form = view.getForm();

                    //enqueue button
                form.getEnButton().addActionListener(e -> {
                    String number = form.getEnField().getText();
                    if(!isValidField(number)){
                        JOptionPane.showMessageDialog(view, "Field must be Integer");
                        return;
                    }
                    else {
                        queue.enqueue(Integer.parseInt(number));
                        form.getQueueValue().setText(String.valueOf(queue));
                        form.getFrontLabel().setText(String.valueOf(queue.peekFront()));
                        form.getRearLabel().setText(String.valueOf(queue.peekRear()));
                    }
                });

                    //dequeue button
                form.getDequeueButton().addActionListener(e -> {
                    queue.dequeue();
                    form.getQueueValue().setText(String.valueOf(queue));
                    form.getFrontLabel().setText(String.valueOf(queue.peekFront()));
                    form.getRearLabel().setText(String.valueOf(queue.peekRear()));
                });
                    //save button
                form.getSaveButton().addActionListener(e -> {
                    queue.writeFile();    });

                form.getClearAndLoadButton().addActionListener(e -> {
                    //clears file
                    queue.clear();
                    form.getQueueValue().setText(String.valueOf(queue));
                    form.getFrontLabel().setText(String.valueOf(queue.peekFront()));
                    form.getRearLabel().setText(String.valueOf(queue.peekRear()));

                            //file reader
                    try(Scanner scan=new Scanner(new File("contents.txt"))){
                        while(scan.hasNextLine()){
                            queue.enqueue(Integer.parseInt(scan.nextLine()));
                        }
                    }
                    catch (FileNotFoundException fne) {
                        JOptionPane.showMessageDialog(view,"Problem reading from file");

                    }
                    form.getQueueValue().setText(String.valueOf(queue));
                    form.getFrontLabel().setText(String.valueOf(queue.peekFront()));
                    form.getRearLabel().setText(String.valueOf(queue.peekRear()));

                });



        }
    public static boolean isValidField(String isInt) {
        try {
           int number= Integer.parseInt(isInt);
           return true;

        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
