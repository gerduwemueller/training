package info.javateam;

import javax.swing.JFrame;

public class HelloWorld {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,100);
        frame.show();
    }
}
