import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MakeGui {
    /** WINDOW **/
    CalcWindow window;
    final int WINDOW_WIDTH;
    final int WINDOW_HEIGHT;

    MakeGui() { // constructor
        WINDOW_WIDTH = 450;
        WINDOW_HEIGHT = 400;
        window = new CalcWindow();
    }
    void makeWindow() {
        window.createFrame(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.createMenu();
    }

    void makeComponents() {
        window.addOutputScreen();
        window.addButtons(450, 600);
        window.setVisible(true);
    }

    void addListeners() {
        // listeners
        window.num0.addActionListener(window.mouse);
        window.num1.addActionListener(window.mouse);
        window.num2.addActionListener(window.mouse);
        window.num3.addActionListener(window.mouse);
        window.num4.addActionListener(window.mouse);
        window.num5.addActionListener(window.mouse);
        window.num6.addActionListener(window.mouse);
        window.num7.addActionListener(window.mouse);
        window.num8.addActionListener(window.mouse);
        window.num9.addActionListener(window.mouse);
        window.plus.addActionListener(window.mouse);
        window.minus.addActionListener(window.mouse);
        window.times.addActionListener(window.mouse);
        window.equals.addActionListener(window.mouse);
        window.divide.addActionListener(window.mouse);
        window.AC.addActionListener(window.mouse);
        window.equals.addActionListener(window.mouse);
        window.mntmNew.addActionListener(window.mouse);
        window.mntmExit.addActionListener(window.mouse);
        window.mntmAbout.addActionListener(window.mouse);
    }
}

@SuppressWarnings("serial")
class CalcWindow extends JFrame {
    /** MENU BAR **/
    JPanel contentPane;
    JMenuBar menuBar;
    JMenuItem mntmAbout;
    JMenuItem mntmNew;
    JMenuItem mntmExit;
    JMenu mnExtra;

    /** Output Screen **/
    JLabel output;
    double sum;
    double tempNum1Int;
    double tempNum2Int;

    CalcWindow window; // reference for mouse class

    String[][] buttonString = {{"7", "8", "9", "+"},
                               { "4", "5", "6", "-"},
                               {"1", "2", "3", "*"},
                               {"AC", ".", "0", "="},
                               {" ", "/", " ", " "}};

    JButton num7, num8, num9, plus,
            num4, num5, num6, minus,
            num1, num2, num3, times,
            divide, AC, equals,
            num0;

    /** MOUSE **/
    MouseListener mouse;

    CalcWindow() { // constructor
        mouse = new MouseListener();
        window = this;
        sum = 0;
        tempNum1Int = 0;
        tempNum2Int = 0;

        // intiliaze buttons
        num1 = new JButton("1");
        num2 = new JButton("2");
        num3 = new JButton("3");
        num4 = new JButton("4");
        num5 = new JButton("5");
        num6 = new JButton("6");
        num7 = new JButton("7");
        num8 = new JButton("8");
        num9 = new JButton("9");
        plus = new JButton("+");
        minus = new JButton("-");
        times = new JButton("*");
        divide = new JButton("/");
        AC = new JButton("AC");
        equals = new JButton("=");
        num0 = new JButton("0");
    }

    void createFrame(int WINDOW_WIDTH, int WINDOW_HEIGHT) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - WINDOW_WIDTH) / 2);
        int y = (int) ((dimension.getHeight() - WINDOW_HEIGHT) / 2);

        this.setBounds(x, y, WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBackground(Color.LIGHT_GRAY);
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.X_AXIS));

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setPreferredSize(new Dimension(100,100));
    }

    void createMenu() {
        menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        JMenu mnGame = new JMenu("File");
        menuBar.add(mnGame);

        mntmNew = new JMenuItem("New");
        mnGame.add(mntmNew);

        mntmExit = new JMenuItem("Close");
        mnGame.add(mntmExit);

        mnExtra = new JMenu("Extra");
        menuBar.add(mnExtra);

        mntmAbout = new JMenuItem("About");
        mnExtra.add(mntmAbout);
    }

    void addOutputScreen() {
        JPanel title = new JPanel();
        JLabel text = new JLabel("Calculator");
        title.setPreferredSize(new Dimension(300, 30));

        output = new JLabel(Integer.toString((int) tempNum1Int), SwingConstants.CENTER);
        output.setPreferredSize(new Dimension(350,50));
        TitledBorder title1 = new TitledBorder("");
        output.setBorder(title1);
        output.setBackground(Color.WHITE);
        output.setOpaque(true);

        JPanel buffer = new JPanel();
        buffer.setPreferredSize(new Dimension(400,10));

        title.add(text);
        add(title);
        contentPane.add(output);
        contentPane.add(buffer);
    }

    void addButtons(int width, int height) {
        int cellHeight = width/buttonString.length - 40;    // switch
        int cellWidth = height/buttonString[0].length - 50; // switch

        for(int i = 0; i < buttonString.length; i++) {
            for (int j = 0; j < buttonString[0].length; j++) {
                if(buttonString[i][j].equals(num0.getText())) {
                    num0.setPreferredSize(new Dimension(cellWidth, cellHeight));
                    contentPane.add(num0);
                } else if(buttonString[i][j].equals(num1.getText())) {
                    num1.setPreferredSize(new Dimension(cellWidth, cellHeight));
                    contentPane.add(num1);
                } else if(buttonString[i][j].equals(num2.getText())) {
                    num2.setPreferredSize(new Dimension(cellWidth, cellHeight));
                    contentPane.add(num2);
                } else if(buttonString[i][j].equals(num3.getText())) {
                    num3.setPreferredSize(new Dimension(cellWidth, cellHeight));
                    contentPane.add(num3);
                } else if(buttonString[i][j].equals(num4.getText())) {
                    num4.setPreferredSize(new Dimension(cellWidth, cellHeight));
                    contentPane.add(num4);
                } else if(buttonString[i][j] == num5.getText()) {
                    num5.setPreferredSize(new Dimension(cellWidth, cellHeight));
                    contentPane.add(num5);
                } else if(buttonString[i][j] == num6.getText()) {
                    num6.setPreferredSize(new Dimension(cellWidth, cellHeight));
                    contentPane.add(num6);
                } else if(buttonString[i][j] == num7.getText()) {
                    num7.setPreferredSize(new Dimension(cellWidth, cellHeight));
                    contentPane.add(num7);
                } else if(buttonString[i][j] == num8.getText()) {
                    num8.setPreferredSize(new Dimension(cellWidth, cellHeight));
                    contentPane.add(num8);
                } else if(buttonString[i][j] == num9.getText()) {
                    num9.setPreferredSize(new Dimension(cellWidth, cellHeight));
                    contentPane.add(num9);
                } else if(buttonString[i][j] == plus.getText()) {
                    plus.setPreferredSize(new Dimension(cellWidth, cellHeight));
                    contentPane.add(plus);
                } else if(buttonString[i][j] == minus.getText()) {
                    minus.setPreferredSize(new Dimension(cellWidth, cellHeight));
                    contentPane.add(minus);
                } else if(buttonString[i][j] == times.getText()) {
                    times.setPreferredSize(new Dimension(cellWidth, cellHeight));
                    contentPane.add(times);
                } else if(buttonString[i][j] == divide.getText()) {
                    divide.setPreferredSize(new Dimension(cellWidth, cellHeight));
                    contentPane.add(divide);
                } else if(buttonString[i][j] == AC.getText()) {
                    AC.setPreferredSize(new Dimension(cellWidth, cellHeight));
                    contentPane.add(AC);
                } else if(buttonString[i][j] == equals.getText()) {
                    equals.setPreferredSize(new Dimension(cellWidth, cellHeight));
                    contentPane.add(equals);
                }
            }
        }
    }

    private class MouseListener extends MouseAdapter implements ActionListener {
        String operation;
        String tempNum1String;
        String tempNum2String;

        MouseListener() {
            operation = "";
            tempNum1String = "";
            tempNum2String = "";
        }
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == num0) {
                if(operation.length() == 0) {
                    tempNum1String += "0";
                    output.setText(tempNum1String);
                    //tempNum1Int = 0;
                    //output.setText(Integer.toString((int)tempNum1Int));
                } else {
                    tempNum2String += "0";
                    output.setText(tempNum2String);
                    //tempNum2Int = 0;
                    //output.setText(Integer.toString((int)tempNum2Int));
                }
            } else if(e.getSource() == num1) {
                if(operation.length() == 0) {
                    tempNum1String += "1";
                    output.setText(tempNum1String);
                    //tempNum1Int = 1;
                    //output.setText(Integer.toString((int)tempNum1Int));
                } else {
                    tempNum2String += "1";
                    output.setText(tempNum2String);
                    //tempNum2Int = 1;
                    //output.setText(Integer.toString((int)tempNum2Int));
                }
            } else if(e.getSource() == num2) {
                if(operation.length() == 0) {
                    tempNum1String += "2";
                    output.setText(tempNum1String);
                    //tempNum1Int = 2;
                    //output.setText(Integer.toString((int)tempNum1Int));
                } else {
                    tempNum2String += "2";
                    output.setText(tempNum2String);
                    //tempNum2Int = 2;
                    //output.setText(Integer.toString((int)tempNum2Int));
                }
            } else if(e.getSource() == num3) {
                if(operation.length() == 0) {
                    tempNum1String += "3";
                    output.setText(tempNum1String);
                    //tempNum1Int = 3;
                    //output.setText(Integer.toString((int)tempNum1Int));
                } else {
                    tempNum2String += "3";
                    output.setText(tempNum2String);
                    //tempNum2Int = 3;
                    //output.setText(Integer.toString((int)tempNum2Int));
                }
            } else if(e.getSource() == num4) {
                if(operation.length() == 0) {
                    tempNum1String += "4";
                    output.setText(tempNum1String);
                    //tempNum1Int = 4;
                    //output.setText(Integer.toString((int)tempNum1Int));
                } else {
                    tempNum2String += "4";
                    output.setText(tempNum2String);
                    //tempNum2Int = 4;
                    //output.setText(Integer.toString((int)tempNum2Int));
                }
            } else if(e.getSource() == num5) {
                if(operation.length() == 0) {
                    tempNum1String += "5";
                    output.setText(tempNum1String);
                    //tempNum1Int = 5;
                    //output.setText(Integer.toString((int)tempNum1Int));
                } else {
                    tempNum2String += "5";
                    output.setText(tempNum2String);
                    //tempNum2Int = 5;
                    //output.setText(Integer.toString((int)tempNum2Int));
                }
            } else if(e.getSource() == num6) {
                if(operation.length() == 0) {
                    tempNum1String += "6";
                    output.setText(tempNum1String);
                    //tempNum1Int = 6;
                    //output.setText(Integer.toString((int)tempNum1Int));
                } else {
                    tempNum2String += "6";
                    output.setText(tempNum2String);
                    //tempNum2Int = 6;
                    //output.setText(Integer.toString((int)tempNum2Int));
                }
            } else if(e.getSource() == num7) {
                if(operation.length() == 0) {
                    tempNum1String += "7";
                    output.setText(tempNum1String);
                    //tempNum1Int = 7;
                    //output.setText(Integer.toString((int)tempNum1Int));
                } else {
                    tempNum2String += "7";
                    output.setText(tempNum2String);
                    //tempNum2Int = 7;
                    //output.setText(Integer.toString((int)tempNum2Int));
                }
            } else if(e.getSource() == num8) {
                if(operation.length() == 0) {
                    tempNum1String += "8";
                    output.setText(tempNum1String);
                    //tempNum1Int = 8;
                    //output.setText(Integer.toString((int)tempNum1Int));
                } else {
                    tempNum2String += "8";
                    output.setText(tempNum2String);
                    //tempNum2Int = 8;
                    //output.setText(Integer.toString((int)tempNum2Int));
                }
            } else if(e.getSource() == num9) {
                if(operation.length() == 0) {
                    tempNum1String += "9";
                    output.setText(tempNum1String);
                    //tempNum1Int = 9;
                    //output.setText(Integer.toString((int)tempNum1Int));
                } else {
                    tempNum2String += "9";
                    output.setText(tempNum2String);
                    //tempNum2Int = 9;
                    //output.setText(Integer.toString((int)tempNum2Int));
                }
            } else if(e.getSource() == plus) {
                operation = plus.getText();
            } else if(e.getSource() == minus) {
                operation = minus.getText();
            } else if(e.getSource() == times) {
                operation = times.getText();
            } else if(e.getSource() == divide) {
                operation = divide.getText();
            } else if(e.getSource() == AC || e.getSource() == mntmNew) {
                sum = 0;
                tempNum1String = ""; tempNum1Int = 0;// empty
                tempNum2String = ""; tempNum2Int = 0;// empty
                output.setText(Integer.toString((int)sum));
            } else if(e.getSource() == equals) {
                if(tempNum1String.length() > 0 && tempNum2String.length() > 0) { //precondition
                    tempNum1Int = Double.parseDouble(tempNum1String);
                    tempNum2Int = Double.parseDouble(tempNum2String);
                    if(operation.equals(plus.getText())) {
                        sum = tempNum1Int + tempNum2Int;
                    } else if(operation.equals(minus.getText())) {
                        sum = tempNum1Int - tempNum2Int;
                    } else if(operation.equals(times.getText())) {
                        sum = tempNum1Int * tempNum2Int;
                    } else if(operation.equals(divide.getText())) {
                        sum = tempNum1Int / tempNum2Int;
                    }
                    operation = ""; // reset
                    tempNum1Int = sum; tempNum1String = Double.toString(tempNum1Int);
                    tempNum2Int = 0;   tempNum2String = "";
                    if(sum % 1 != 0) // decimal
                        output.setText(Double.toString(sum));
                    else  // whole number
                        output.setText(Integer.toString((int)sum));
                }
            } else if(e.getSource() == mntmExit) { // close the window
                window.dispose();
            } else if(e.getSource() == mntmAbout) { // open about html
                try {
                    JEditorPane helpContent = new JEditorPane(new URL("file:src/about.html"));
                    JScrollPane helpPane = new JScrollPane(helpContent);
                    JOptionPane.showMessageDialog(null, helpPane, "How To Play", JOptionPane.PLAIN_MESSAGE, null);
                } catch(MalformedURLException a) {
                    System.out.println("file not found! " + a.getMessage());
                    a.getStackTrace();
                } catch(IOException b) {
                    System.out.println("Error: " + b.getMessage());
                    b.getStackTrace();
                }
            }
        }
    }
}