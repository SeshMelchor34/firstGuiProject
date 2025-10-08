package firstGuiPackage;

/* Version 0.1
   FirstGuiApp
   Seshat Melchor
   Mr.M Di Tomasso
   Two buttons are displayed, one with a smiling face and one with a sad face
   when pressed each send different messages as well as there being two text fields one editable one uneditable, a
   group of radio buttons is also displayed giving the option to change a textfield's font style.
   */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class firstGuiPgm {
    /**
     * Declare objects
     */
    static JLabel label;
    static JTextField editableText, uneditableText, textField;
    static JButton sadBtn;
    static JButton happyBtn;
    static ImageIcon smileyFacePng, sadFacePng;
    static Font plainFont, boldFont,
            italicFont, boldItalicFont;
    static JRadioButton plain, bold, italic, boldItalic;
    static ButtonGroup radioGroup;
    //method to create GUI

    private static void guiApp() {

        //Create and set up the window.
        JFrame frame = new JFrame("Simple GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create and set up components
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        label = new JLabel("Selection Text");

        sadFacePng = new ImageIcon("C:\\Users\\melchos730\\IdeaProjects\\firstGuiProject\\images\\img_1.png");
        Image sadFace = ((ImageIcon) sadFacePng).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        sadFacePng = new ImageIcon(sadFace);
        //create a usable image icon and resize it to 50x50 resolution

        sadBtn = new JButton(sadFacePng);
        sadBtn.setActionCommand("Sad");
        panel.add(sadBtn);

        smileyFacePng = new ImageIcon("C:\\Users\\melchos730\\IdeaProjects\\firstGuiProject\\images\\img.png");
        Image smileyFace = ((ImageIcon) smileyFacePng).getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        smileyFacePng = new ImageIcon(smileyFace);
        //create a usable image icon and resize it to 50x50 resolution

        happyBtn = new JButton(smileyFacePng);
        happyBtn.setActionCommand("Happy");
        panel.add(happyBtn);

        //create a new ButtonHandler instance
        ButtonHandler onClick = new ButtonHandler();
        sadBtn.addActionListener(onClick);
        happyBtn.addActionListener(onClick);

        //textfields are created with a preset message
        editableText = new JTextField("Programmers rock!", 20);
        uneditableText = new JTextField("Uneditable text field", 15);
        uneditableText.setEditable(false);
        panel.add(label);
        panel.add(editableText);
        panel.add(uneditableText);

        //textfield is created with a preset message
        textField = new JTextField("Watch the font style change", 25);
        panel.add(textField);

        // Create radio buttons
        plain = new JRadioButton("Plain", true);
        panel.add(plain);
        bold = new JRadioButton("Bold", false);
        panel.add(bold);
        italic = new JRadioButton("Italic", false);
        panel.add(italic);
        boldItalic = new JRadioButton("Bold/Italic", false);
        panel.add(boldItalic);

        // register events
        RadioButtonHandler handler = new RadioButtonHandler();
        plain.addItemListener(handler);
        bold.addItemListener(handler);
        italic.addItemListener(handler);
        boldItalic.addItemListener(handler);

        // create logical relationship between JRadioButtons
        radioGroup = new ButtonGroup();
        radioGroup.add(plain);
        radioGroup.add(bold);
        radioGroup.add(italic);
        radioGroup.add(boldItalic);

        //create instances of new font styles
        plainFont = new Font( "TimesRoman", Font.PLAIN, 14 );
        boldFont = new Font( "TimesRoman", Font.BOLD, 14 );
        italicFont = new Font( "TimesRoman", Font.ITALIC, 14 );
        boldItalicFont =
                new Font( "TimesRoman", Font.BOLD + Font.ITALIC, 14 );
        textField.setFont( plainFont );

        frame.add(panel);
        frame.setSize(250, 100);
        frame.setVisible(true);
    }

    //create custom event handler
    private static class RadioButtonHandler implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (e.getSource() == plain)
                textField.setFont(plainFont);
            else if (e.getSource() == bold)
                textField.setFont(boldFont);
            else if (e.getSource() == italic)
                textField.setFont(italicFont);
            else if (e.getSource() == boldItalic)
                textField.setFont(boldItalicFont);

            textField.repaint();
        }
    }

    //create custom event handler
    private static class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent evt){
            //which button?
            String command = evt.getActionCommand();
            //give message
            if(command.equals("Sad")){
                label.setText("You picked the Sad button");
            } else {
                label.setText("You picked the Happy Button!");
            }
        }
    }

    //main method to run the GUI
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                guiApp();
            }
        });
    }
}
