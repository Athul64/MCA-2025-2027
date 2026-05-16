import java.awt.*;
import java.awt.event.*;

public class MaxOfThree extends Frame implements ActionListener {

    // Component declarations (instance variables)
    Label     titleLabel;
    Label     lblNum1, lblNum2, lblNum3, lblResult;
    TextField tfNum1, tfNum2, tfNum3, tfResult;
    Button    btnFind, btnClear, btnExit;

    MaxOfThree() {

        titleLabel = new Label("  Maximum of Three Numbers  ");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setAlignment(Label.CENTER);

        lblNum1   = new Label("Enter Number 1 :");
        lblNum2   = new Label("Enter Number 2 :");
        lblNum3   = new Label("Enter Number 3 :");
        lblResult = new Label("Maximum Number :");

        tfNum1   = new TextField(15);
        tfNum2   = new TextField(15);
        tfNum3   = new TextField(15);
        tfResult = new TextField(15);
        tfResult.setEditable(false);
        tfResult.setBackground(Color.CYAN);

        btnFind  = new Button("Find Maximum");
        btnClear = new Button("Clear");
        btnExit  = new Button("Exit");

        btnFind.setBackground(Color.GREEN);
        btnClear.setBackground(Color.YELLOW);
        btnExit.setBackground(Color.RED);
        btnExit.setForeground(Color.WHITE);

        btnFind.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);

        setLayout(new BorderLayout(10, 10));

        Panel topPanel = new Panel();
        topPanel.add(titleLabel);

        Panel centerPanel = new Panel(new GridLayout(4, 2, 8, 8));
        centerPanel.add(lblNum1);  centerPanel.add(tfNum1);
        centerPanel.add(lblNum2);  centerPanel.add(tfNum2);
        centerPanel.add(lblNum3);  centerPanel.add(tfNum3);
        centerPanel.add(lblResult); centerPanel.add(tfResult);

        Panel btnPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        btnPanel.add(btnFind);
        btnPanel.add(btnClear);
        btnPanel.add(btnExit);

        add(topPanel,    BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(btnPanel,    BorderLayout.SOUTH);

        setTitle("Maximum of Three Numbers");
        setSize(420, 280);
        setBackground(new Color(230, 245, 255));
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String cmd = ae.getActionCommand();

        if (cmd.equals("Find Maximum")) {
            try {
                double n1  = Double.parseDouble(tfNum1.getText().trim());
                double n2  = Double.parseDouble(tfNum2.getText().trim());
                double n3  = Double.parseDouble(tfNum3.getText().trim());
                double max;

                if (n1 >= n2 && n1 >= n3) {
                    max = n1;
                } else if (n2 >= n1 && n2 >= n3) {
                    max = n2;
                } else {
                    max = n3;
                }

                tfResult.setText(String.valueOf(max));
                tfResult.setBackground(Color.GREEN);

            } catch (NumberFormatException ex) {
                tfResult.setText("Invalid Input!");
                tfResult.setBackground(Color.RED);
            }

        } else if (cmd.equals("Clear")) {
            tfNum1.setText("");
            tfNum2.setText("");
            tfNum3.setText("");
            tfResult.setText("");
            tfResult.setBackground(Color.CYAN);
            tfNum1.requestFocus();

        } else if (cmd.equals("Exit")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new MaxOfThree();
    }
}
