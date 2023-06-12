package studentdatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StudentProgramPanel extends JPanel {
    private StudentDatabase studentDB;
    private String filePath;
    public int CALC_WIDTH = 800;
    public int CALC_HEIGHT = 500;
    public JButton addTopicButton, findTopicButton, addStudentButton, findStudentButton, printAllRecordsButton, clearAllRecordsButton,
            awardPrize;
    public JComboBox<String> degreeComboBox;
    public JComboBox<String> gradeComboBox;
    public JPanel panel1, panel2, panel3, studentDetailsWrapperPanel, topicDetailsWrapperPanel, studentDetailsPanel, topicDetailsPanel,
            degreeOptionsWrapperPanel, degreeOptionsPanel, awardPrizesWrapperPanel, awardPrizesPanel;
    public JLabel title, degree;
    public JScrollPane scroll;
    public JTextArea textArea;
    public JTextField studentNumberTextField, familyNameTextField, givenNameTextField, artsMajorTextField, artsMinorTextField, topicCodeTextField,
            markTextField;

    public StudentProgramPanel(StudentDatabase studentDB, String filePath) {
        this.studentDB = studentDB;
        this.filePath = filePath;
        // Set the whole panel size
        setPreferredSize(new Dimension(CALC_WIDTH, CALC_HEIGHT));


        //------------------------------------------------------------------------------
        // Panel 1 contains a title, a student details panel and a topic details panel.
        //------------------------------------------------------------------------------


        // Set up the title for the program
        title = new JLabel("Student Database Program", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));

        // Set up the student details panel
        studentDetailsPanel = new JPanel(new GridLayout(4, 2));
        studentDetailsPanel.setPreferredSize(new Dimension(350, 150));
        studentDetailsPanel.setBorder(BorderFactory.createTitledBorder("Student Details"));
        studentDetailsPanel.add(new JLabel("Student Number"));
        studentNumberTextField = new JTextField();
        studentDetailsPanel.add(studentNumberTextField);
        studentDetailsPanel.add(new JLabel("Family Name"));
        familyNameTextField = new JTextField();
        studentDetailsPanel.add(familyNameTextField);
        studentDetailsPanel.add(new JLabel("Given Name(s)"));
        givenNameTextField = new JTextField();
        studentDetailsPanel.add(givenNameTextField);
        degree = new JLabel("Degree");
        String[] degreeOptions = {"Arts", "Medicine", "Science"};
        degreeComboBox = new JComboBox<>(degreeOptions);
        studentDetailsPanel.add(degree);
        studentDetailsPanel.add(degreeComboBox);

        // Set up a wrapper panel for studentDetailsPanel
        studentDetailsWrapperPanel = new JPanel();
        studentDetailsWrapperPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        studentDetailsWrapperPanel.add(studentDetailsPanel, BorderLayout.CENTER);

        // Set up the topicDetailsPanel
        topicDetailsPanel = new JPanel(new GridLayout(4, 2));
        topicDetailsPanel.setPreferredSize(new Dimension(350, 150));
        topicDetailsPanel.setBorder(BorderFactory.createTitledBorder("Topic Details"));
        topicDetailsPanel.add(new JLabel("Topic Code"));
        topicCodeTextField = new JTextField();
        topicDetailsPanel.add(topicCodeTextField);
        topicDetailsPanel.add(new JLabel("Grade"));
        String[] gradeOptions = {"HD", "DN", "CR", "PS", "FL"};
        gradeComboBox = new JComboBox<>(gradeOptions);
        topicDetailsPanel.add(gradeComboBox);
        topicDetailsPanel.add(new JLabel("Mark"));
        markTextField = new JTextField();
        topicDetailsPanel.add(markTextField);
        addTopicButton = new JButton("Add Topic Result");
        addTopicButton.addActionListener(new StudentProgramPanel.AddTopicButton());
        addTopicButton.setActionCommand("add topic result");
        findTopicButton = new JButton("Find Topic Result");
        findTopicButton.addActionListener(new StudentProgramPanel.FindTopicResultButton());
        findTopicButton.setActionCommand("find topic result");
        topicDetailsPanel.add(addTopicButton);
        topicDetailsPanel.add(findTopicButton);

        // Set up a wrapper panel for topicDetailsPanel
        topicDetailsWrapperPanel = new JPanel();
        topicDetailsWrapperPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        topicDetailsWrapperPanel.add(topicDetailsPanel, BorderLayout.CENTER);

        // Set up the panel 1
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.add(title, BorderLayout.NORTH);
        panel1.add(studentDetailsWrapperPanel, BorderLayout.WEST);
        panel1.add(topicDetailsWrapperPanel, BorderLayout.EAST);

        add(panel1);


        //---------------------------------------------------------------------
        // Panel 2 contains a degree options panel and an award prizes panel.
        //---------------------------------------------------------------------


        degreeOptionsPanel = new JPanel(new GridLayout(3, 2));
        degreeOptionsPanel.setPreferredSize(new Dimension(350, 150));
        degreeOptionsPanel.setBorder(BorderFactory.createTitledBorder("Degree Options"));
        degreeOptionsPanel.add(new JLabel("Arts Major"));
        artsMajorTextField = new JTextField();
        degreeOptionsPanel.add(artsMajorTextField);
        degreeOptionsPanel.add(new JLabel("Arts Minor"));
        artsMinorTextField = new JTextField();
        degreeOptionsPanel.add(artsMinorTextField);

        degreeOptionsPanel.add(new JLabel("Medicine Prizes"));

        // Set up a textArea to display prizes
        textArea = new JTextArea(10, 10);
        textArea.setBackground(Color.white);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        //textArea.setEditable(false);

        // Set up a JScrollPane to contain textArea
        scroll = new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        degreeOptionsPanel.add(scroll);

        // Set up a wrapper panel for degreeOptionsPanel
        degreeOptionsWrapperPanel = new JPanel(new BorderLayout());
        degreeOptionsWrapperPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        degreeOptionsWrapperPanel.add(degreeOptionsPanel, BorderLayout.CENTER);

        // Set up the award prize panel
        awardPrizesPanel = new JPanel(new GridLayout(4, 2));
        awardPrizesPanel.setPreferredSize(new Dimension(350, 150));
        awardPrizesPanel.setBorder(BorderFactory.createTitledBorder("Award Prizes"));
        awardPrizesPanel.add(new JLabel("Prize Name"));
        awardPrizesPanel.add(new JTextField());
        awardPrizesPanel.add(new JLabel("Template"));
        awardPrizesPanel.add(new JTextField());
        awardPrizesPanel.add(new JLabel("Numbers of Topics"));
        awardPrizesPanel.add(new JTextField());
        awardPrize = new JButton("Award Prize");
        awardPrizesPanel.add(awardPrize);

        // Set up a wrapper panel for awardPrizesPanel
        awardPrizesWrapperPanel = new JPanel(new BorderLayout());
        awardPrizesWrapperPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        awardPrizesWrapperPanel.add(awardPrizesPanel, BorderLayout.CENTER);

        // Set up the panel 2
        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.add(degreeOptionsWrapperPanel, BorderLayout.WEST);
        panel2.add(awardPrizesWrapperPanel, BorderLayout.EAST);
        add(panel2);

        //--------------------------------
        // Panel 3 contains four buttons.
        //--------------------------------

        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT, 60, 2));
        addStudentButton = new JButton("Add Student");
        addStudentButton.addActionListener(new StudentProgramPanel.AddStudentButton());
        addStudentButton.setActionCommand("add student");
        findStudentButton = new JButton("Find Student");
        findStudentButton.addActionListener(new StudentProgramPanel.FindStudentButton());
        findStudentButton.setActionCommand("find student");
        printAllRecordsButton = new JButton("Print All Records");
        printAllRecordsButton.addActionListener(new StudentProgramPanel.PrintAllRecordsButton());
        printAllRecordsButton.setActionCommand("print records");
        clearAllRecordsButton = new JButton("Clear All Records");
        clearAllRecordsButton.addActionListener(new StudentProgramPanel.ClearAllRecordsButton());
        clearAllRecordsButton.setActionCommand("clear records");

        // Set up the panel 3
        panel3.add(addStudentButton);
        panel3.add(findStudentButton);
        panel3.add(printAllRecordsButton);
        panel3.add(clearAllRecordsButton);

        add(panel3);
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public class AddStudentButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            // Add student button listener
            if (e.getActionCommand().equals("add student")) {
                // Firstly find the student in the database
                String studentID = studentNumberTextField.getText();
                Student existingStudent = studentDB.findStudent(studentID);
                // If the student is new, add student to the studentDB
                if (existingStudent == null) {
                    String familyName = familyNameTextField.getText();
                    String givenName = givenNameTextField.getText();
                    String degree = (String) degreeComboBox.getSelectedItem();
                    String artMajor = artsMajorTextField.getText();
                    String artMinor = artsMinorTextField.getText();
                    String medPrize = textArea.getText();

                    String s;
                    switch (degree) {
                        case "Arts" ->
                                s = "A," + studentID + "," + familyName + "," + givenName + "," + artMajor + "," + artMinor;
                        case "Medicine" -> s = "M," + studentID + "," + familyName + "," + givenName + "," + medPrize;
                        case "Science" -> s = "S," + studentID + "," + familyName + "," + givenName;
                        default -> s = "";
                    }

                    studentDB.addStudent(s);

                    // Save the student records to the file
                    try {
                        FileWriter fileWriter = new FileWriter(filePath, true); // "true" appends to the existing file
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        bufferedWriter.write(s);
                        bufferedWriter.newLine();
                        bufferedWriter.close();
                    } catch (IOException exception) {
                        // Handle the exception
                        exception.printStackTrace();
                    }

                    // Display information message, update button label, and clear fields
                    JOptionPane.showMessageDialog(StudentProgramPanel.this, "Student has been added to the database.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    addStudentButton.setText("Enter New Student");
                    addStudentButton.setActionCommand("enter new student");
                    clearFields();

                } else {
                    // Student already exists, display error message and clear fields
                    JOptionPane.showMessageDialog(StudentProgramPanel.this, "Student already exists in the database.", "Error", JOptionPane.ERROR_MESSAGE);
                    clearFields();
                }
            } else if (e.getActionCommand().equals("enter new student")) {
                // Change button label and clear fields
                addStudentButton.setText("Add Student");
                addStudentButton.setActionCommand("add student");
                clearFields();
            }
        }
    }

    private void clearFields() {
        studentNumberTextField.setText("");
        familyNameTextField.setText("");
        givenNameTextField.setText("");
        degreeComboBox.setSelectedIndex(0);
        artsMajorTextField.setText("");
        artsMinorTextField.setText("");
        textArea.setText("");
    }


    public class FindStudentButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("find student")) {
                String studentID = studentNumberTextField.getText();
                Student existingStudent = studentDB.findStudent(studentID);

                if (existingStudent == null) {
                    JOptionPane.showMessageDialog(StudentProgramPanel.this, "Student not found in the database.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Update the student details fields with the values from the existing student
                    familyNameTextField.setText(existingStudent.getFamilyName());
                    givenNameTextField.setText(existingStudent.getGivenNames());
                    // Check the type of student and update the degree combo box value
                    if (existingStudent instanceof ArtsStudent artsStudent) {
                        degreeComboBox.setSelectedItem("Arts");
                        artsMajorTextField.setText(artsStudent.getMajor());
                        artsMinorTextField.setText(artsStudent.getMinor());
                    } else if (existingStudent instanceof MedStudent medStudent) {
                        degreeComboBox.setSelectedItem("Medicine");
                        textArea.setText(medStudent.getPrize());
                    } else {
                        degreeComboBox.setSelectedItem("Science");
                    }
                }
            }
        }
    }


    public class AddTopicButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("add topic result")) {
                String topicCode = topicCodeTextField.getText();
                String grade = (String) gradeComboBox.getSelectedItem();
                String mark = markTextField.getText();
                String studentID = studentNumberTextField.getText();
                if (studentID.isEmpty() || topicCode.isEmpty()) {
                    JOptionPane.showMessageDialog(StudentProgramPanel.this, "Please enter a student ID and topic code.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Add the topic result for the student
                    Student existingStudent = studentDB.findStudent(studentID);
                    String r;

                    if (existingStudent != null) {  // If studentDB has this student
                        if (mark.isEmpty()) {
                            r = "R," + studentID + "," + topicCode + "," + grade;
                        } else {
                            r = "R," + studentID + "," + topicCode + "," + grade + "," + mark;
                        }
                        studentDB.addResult(r);

                        try {
                            FileWriter fileWriter = new FileWriter(filePath, true); // "true" appends to the existing file
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                            bufferedWriter.write(r);
                            bufferedWriter.newLine();
                            bufferedWriter.close();
                            JOptionPane.showMessageDialog(StudentProgramPanel.this, "Topic result has been added to the database.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } catch (IOException exception) {
                            // Handle the exception
                            exception.printStackTrace();
                            JOptionPane.showMessageDialog(StudentProgramPanel.this, "An error occurred while writing to the file.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(StudentProgramPanel.this, "Student not found in the database.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }


    public class FindTopicResultButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Find topic result button listener
            if (e.getActionCommand().equals("find topic result")) {
                String studentID = studentNumberTextField.getText();
                String topicCode = topicCodeTextField.getText();
                Student existingStudent = studentDB.findStudent(studentID);
                Result result;
                if (studentID.isEmpty() || topicCode.isEmpty()) {
                    JOptionPane.showMessageDialog(StudentProgramPanel.this, "Please enter a student ID and topic code.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    result = studentDB.findResult(studentID, topicCode);
                    if (result != null) {
                        gradeComboBox.setSelectedItem(result.getGrade());
                        markTextField.setText(String.valueOf(result.getMark()));
                    } else {
                        gradeComboBox.setSelectedIndex(0);
                        markTextField.setText("");
                        JOptionPane.showMessageDialog(StudentProgramPanel.this, "No matching topic result found.", "Message", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }
    }

    public class PrintAllRecordsButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public class ClearAllRecordsButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}