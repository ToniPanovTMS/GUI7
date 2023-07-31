import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


public class GUI7 extends Canvas {
    static String str="";

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        JTextField textField = new JTextField(20);
        frame.getContentPane().add(textField, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Не хитрое движение");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(dim.width / 2 - 300 / 2, dim.height / 2 - 100 / 2, 300, 100);
        frame.setVisible(true);

        File file = new File("src\\text.txt");

        KeyListener listener = new KeyListener() {
            @Override
            public void keyReleased(KeyEvent keyEvent) {
            }

            @Override
            public void keyTyped(KeyEvent keyEvent) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                char key = e.getKeyChar();
                str+=key;
                try {
                    input(file);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        textField.addKeyListener(listener);

    }

    public static void input(File file) throws IOException {
        PrintWriter pw = new PrintWriter(file);
        pw.println(str);
        pw.close();
    }
}