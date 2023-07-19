import controller.QueueController;
import model.QueueModel;
import view.QueueView;

import java.util.LinkedList;

public class App {
    public static void main(String[] args) {
        QueueModel<Integer> queueModel = new QueueModel<>();
        QueueView view=new QueueView();
        QueueController controller= new QueueController(queueModel,view);
         view.setVisible(true);
    }
}
