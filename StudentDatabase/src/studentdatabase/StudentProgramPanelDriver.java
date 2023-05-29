package studentdatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentProgramPanelDriver {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Database Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openFileMenuItem = new JMenuItem("Open File");
        openFileMenuItem.addActionListener(new fileChooseListener());
        openFileMenuItem.setActionCommand("openFile");

        fileMenu.add(openFileMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        StudentProgramPanel panel = new StudentProgramPanel();
        frame.getContentPane().add(panel);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.pack();
    }

    private static class fileChooseListener implements ActionListener {

        /**
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equals("openFile")) {
                StudentDatabase studentDB = new StudentDatabase();
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Open File");
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    // use try-catch block to handle the possibility that the file is not found
                    try {
                        Scanner scan = new Scanner(selectedFile);
                        while (scan.hasNextLine()) {
                            String s = scan.nextLine();
                            if (!s.isEmpty()) {
                                if (s.charAt(0) == 'A' || s.charAt(0) == 'S' || s.charAt(0) == 'M') {
                                    studentDB.addStudent(s);
                                } else if (s.charAt(0) == 'R') {
                                    studentDB.addResult(s);
                                }
                            }
                        }
                        scan.close();
                    } catch (FileNotFoundException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }
}



