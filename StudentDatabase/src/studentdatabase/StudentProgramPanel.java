package studentdatabase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentProgramPanel extends JPanel {
    public int CALC_WIDTH = 800;
    public int CALC_HEIGHT = 800;
    public JButton addTopicButton, findTopicButton, addStudentButton, findStudentButton, printAllRecordsButton, clearAllRecordsButton,
            awardPrize;
    public JComboBox degreeComboBox, gradeComboBox;
    public JPanel panel1, panel2, panel3, studentDetailsWrapperPanel, topicDetailsWrapperPanel, studentDetailsPanel, topicDetailsPanel,
            degreeOptionsWrapperPanel, degreeOptionsPanel, awardPrizesWrapperPanel, awardPrizesPanel;
    public JLabel title, studentNumber, familyName, givenName, degree, artsMajor, artsMinor;
    public JScrollPane scroll;
    public JTextArea textArea;
    public JTextField studentNumberTextField, familyNameTextField, givenNameTextField, artsMajorTextField, artsMinorTextField;


    public StudentProgramPanel() {

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
        studentNumber = new JLabel("Student Number");
        studentNumberTextField = new JTextField();
        studentDetailsPanel.add(studentNumber);
        studentDetailsPanel.add(studentNumberTextField);
        familyName = new JLabel("Family Name");
        familyNameTextField = new JTextField();
        studentDetailsPanel.add(familyName);
        studentDetailsPanel.add(familyNameTextField);
        givenName = new JLabel("Given Name(s)");
        givenNameTextField = new JTextField();
        studentDetailsPanel.add(givenName);
        studentDetailsPanel.add(givenNameTextField);
        degree = new JLabel("Degree");
        String[] degreeOptions = {"Arts", "Medicine", "Science"};
        degreeComboBox = new JComboBox(degreeOptions);
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
        topicDetailsPanel.add(new JTextField());
        topicDetailsPanel.add(new JLabel("Grade"));
        String[] gradeOptions = {"HD", "DN", "CR", "PS", "FL"};
        gradeComboBox = new JComboBox(gradeOptions);
        topicDetailsPanel.add(gradeComboBox);
        topicDetailsPanel.add(new JLabel("Mark"));
        topicDetailsPanel.add(new JTextField());
        addTopicButton = new JButton("Add Topic Result");
        findTopicButton = new JButton("Find Topic Result");
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
        artsMajor = new JLabel("Arts Major");
        artsMajorTextField = new JTextField();
        degreeOptionsPanel.add(artsMajor);
        degreeOptionsPanel.add(artsMajorTextField);
        artsMinor = new JLabel("Arts Minor");
        artsMinorTextField = new JTextField();
        degreeOptionsPanel.add(artsMinor);
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
        addStudentButton.addActionListener(new StudentProgramPanel.StudentFunctionButtonListener());
        addStudentButton.setActionCommand("add student");
        findStudentButton = new JButton("Find Student");
        findStudentButton.addActionListener(new StudentProgramPanel.StudentFunctionButtonListener());
        findStudentButton.setActionCommand("find student");
        printAllRecordsButton = new JButton("Print All Records");
        printAllRecordsButton.addActionListener(new StudentProgramPanel.StudentFunctionButtonListener());
        printAllRecordsButton.setActionCommand("print records");
        clearAllRecordsButton = new JButton("Clear All Records");
        clearAllRecordsButton.addActionListener(new StudentProgramPanel.StudentFunctionButtonListener());
        clearAllRecordsButton.setActionCommand("clear records");

        // Set up the panel 3
        panel3.add(addStudentButton);
        panel3.add(findStudentButton);
        panel3.add(printAllRecordsButton);
        panel3.add(clearAllRecordsButton);

        add(panel3);
    }

    public class StudentFunctionButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equals("add student")) {
                // Firstly find the student in the database
                StudentDatabase studentDB = new StudentDatabase();
                String studentID = studentNumberTextField.getText();
                Student existingStudent = studentDB.findStudent(studentID);
                // If the student is new, add student to the studentDB
                if (existingStudent == null) {
                    String familyName = familyNameTextField.getText();
                    String givenName = givenNameTextField.getText();
                    String degree = (String) degreeComboBox.getSelectedItem();

                    switch (degree) {
                        case "Arts" -> {
                            String artMajor = artsMajorTextField.getText();
                            String artMinor = artsMinorTextField.getText();
                            studentDB.addStudent(studentID + "," + familyName + "," + givenName + "," + artMajor + "," + artMinor);
                        }
                        case "Medicine" -> {
                            String medPrize = textArea.getText();
                            studentDB.addStudent(studentID + "," + familyName + "," + givenName + "," + medPrize);
                        }
                        case "Science" -> studentDB.addStudent(studentID + "," + familyName + "," + givenName);
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
        private void clearFields() {
            studentNumberTextField.setText("");
            familyNameTextField.setText("");
            givenNameTextField.setText("");
            degreeComboBox.setSelectedIndex(0);
            artsMajorTextField.setText("");
            artsMinorTextField.setText("");
            textArea.setText("");
        }
    }
}
