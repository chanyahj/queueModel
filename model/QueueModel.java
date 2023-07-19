package model;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;

/* METHODS
      *   enqueue, dequeue, peekFront, peekRear,
      *   getWrappedQueue, clear, toString
      *  comment big O runtime
       */
public class QueueModel<T> {
            private Queue<T> queue;

            public QueueModel(){this.queue=new LinkedList<>();}

            public void enqueue(T element){queue.add(element);} // O(1)

            public T dequeue(){return queue.poll();} //O(n)

            public T peekFront(){return queue.peek();} // O(1)


     public T peekRear(){         //O(1)
                /*
            use Linked List to get last element
                 */
             try {return ((LinkedList<T>) queue).getLast();}
             catch(NoSuchElementException e){return null;}
            }
                            //O(1)
             public Queue<T> getWrappedQueue() {return this.queue;}

             public void clear(){queue.clear();} //O(n)

        public void writeFile() {
            try (
                    PrintWriter writer = new PrintWriter(new File("contents.txt"))) {
                for (T item : queue) {
                    writer.println(item);
                }
            }catch (FileNotFoundException fne)
            {
                System.out.println("Problem writing to file");
            }
        }




    @Override
    public String toString() { //O(1)
        return this.queue.toString();
    }
}
