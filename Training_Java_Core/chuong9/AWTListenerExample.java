package chuong9;

import javax.swing.*;
import java.awt.*;

public class AWTListenerExample {
    public static void main(String[] args) {
        Frame screen = new Frame();
        screen.addWindowListener((WindowClosing)(e)->System.exit(0));
        JButton button = new JButton("Press me");
        screen.add(button);


//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null,"Welcome to java Example",
//                        "Java Example",JOptionPane.INFORMATION_MESSAGE);
//            }
//        });
//        screen.setSize(250,400);
//        screen.setVisible(true);
        button.addActionListener(e ->{
            JOptionPane.showMessageDialog(null,"Info Box: Welcome to java Example!"
                    ,"Java Example",JOptionPane.INFORMATION_MESSAGE);
        });
        screen.setSize(250,400);
        screen.setVisible(true);
    }
}
