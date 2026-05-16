import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {

    // Components
    TextField tfDisplay;
    Button[]  numButtons;
    Button    btnAdd, btnSub, btnMul, btnDiv, btnMod;
    Button    btnEquals, btnClear, btnBackspace, btnDot, btnExit;

    // Calculator state
    double  firstNumber  = 0;
    double  secondNumber = 0;
    String  operator     = "";
    boolean newInput     = true;

    Calculator() {

        // Display
        tfDisplay = new TextField("0");
        tfDisplay.setEditable(false);
        tfDisplay.setFont(new Font("Courier", Font.BOLD, 22));
        tfDisplay.setBackground(Color.BLACK);
        tfDisplay.setForeground(Color.GREEN);
        tfDisplay.setAlignment(TextField.RIGHT);

        // Number buttons 0–9
        numButtons = new Button[10];
        for (int i = 0; i <= 9; i++) {
            numButtons[i] = new Button(String.valueOf(i));
            numButtons[i].setFont(new Font("Arial", Font.BOLD, 14));
            numButtons[i].setBackground(new Color(240, 240, 240));
            numButtons[i].addActionListener(this);
        }

        // Operator buttons
        btnAdd = makeBtn("+", new Color(100, 180, 255));
        btnSub = makeBtn("-", new Color(100, 180, 255));
        btnMul = makeBtn("*", new Color(100, 180, 255));
        btnDiv = makeBtn("/", new Color(100, 180, 255));
        btnMod = makeBtn("%", new Color(100, 180, 255));
        btnDot = makeBtn(".", new Color(200, 200, 200));

        // Special buttons
        btnEquals    = makeBtn("=",    Color.ORANGE);
        btnClear     = makeBtn("C",    Color.RED);
        btnBackspace = makeBtn("<-",   Color.YELLOW);
        btnExit      = makeBtn("Exit", Color.DARK_GRAY);
        btnExit.setForeground(Color.WHITE);
        btnClear.setForeground(Color.WHITE);

        // Layout
        setLayout(new BorderLayout(5, 5));
        add(tfDisplay, BorderLayout.NORTH);

        // Number pad — 4 rows x 3 cols
        Panel numPanel = new Panel(new GridLayout(4, 3, 4, 4));
        numPanel.add(numButtons[7]); numPanel.add(numButtons[8]); numPanel.add(numButtons[9]);
        numPanel.add(numButtons[4]); numPanel.add(numButtons[5]); numPanel.add(numButtons[6]);
        numPanel.add(numButtons[1]); numPanel.add(numButtons[2]); numPanel.add(numButtons[3]);
        numPanel.add(btnDot);        numPanel.add(numButtons[0]); numPanel.add(btnBackspace);

        // Operator panel — 6 rows x 1 col
        Panel opPanel = new Panel(new GridLayout(6, 1, 4, 4));
        opPanel.add(btnAdd);
        opPanel.add(btnSub);
        opPanel.add(btnMul);
        opPanel.add(btnDiv);
        opPanel.add(btnMod);
        opPanel.add(btnEquals);

        // Bottom panel
        Panel bottomPanel = new Panel(new GridLayout(1, 2, 4, 4));
        bottomPanel.add(btnClear);
        bottomPanel.add(btnExit);

        add(numPanel,    BorderLayout.CENTER);
        add(opPanel,     BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);

        setTitle("Java AWT Calculator");
        setSize(320, 380);
        setBackground(new Color(50, 50, 50));
        setResizable(false);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    // Helper to create styled button
    Button makeBtn(String label, Color bg) {
        Button b = new Button(label);
        b.setFont(new Font("Arial", Font.BOLD, 14));
        b.setBackground(bg);
        b.addActionListener(this);
        return b;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String cmd = ae.getActionCommand();

        // Digit pressed
        if (cmd.matches("[0-9]")) {
            if (newInput) {
                tfDisplay.setText(cmd);
                newInput = false;
            } else {
                String cur = tfDisplay.getText();
                tfDisplay.setText(cur.equals("0") ? cmd : cur + cmd);
            }

        // Decimal point
        } else if (cmd.equals(".")) {
            if (!tfDisplay.getText().contains(".")) {
                tfDisplay.setText(tfDisplay.getText() + ".");
            }

        // Operator
        } else if ("+-*/%".contains(cmd)) {
            firstNumber = Double.parseDouble(tfDisplay.getText());
            operator    = cmd;
            newInput    = true;

        // Equals
        } else if (cmd.equals("=")) {
            secondNumber  = Double.parseDouble(tfDisplay.getText());
            double result = calculate(firstNumber, secondNumber, operator);
            // Show whole numbers without .0
            if (result == (long) result) {
                tfDisplay.setText(String.valueOf((long) result));
            } else {
                tfDisplay.setText(String.valueOf(result));
            }
            operator = "";
            newInput = true;

        // Clear
        } else if (cmd.equals("C")) {
            tfDisplay.setText("0");
            firstNumber = secondNumber = 0;
            operator    = "";
            newInput    = true;

        // Backspace
        } else if (cmd.equals("<-")) {
            String cur = tfDisplay.getText();
            if (cur.length() > 1) {
                tfDisplay.setText(cur.substring(0, cur.length() - 1));
            } else {
                tfDisplay.setText("0");
                newInput = true;
            }

        // Exit
        } else if (cmd.equals("Exit")) {
            System.exit(0);
        }
    }

    double calculate(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) { tfDisplay.setText("Error:Div0"); newInput = true; return 0; }
                return a / b;
            case "%": return a % b;
            default:  return 0;
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
