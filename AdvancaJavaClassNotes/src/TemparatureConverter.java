import javax.swing.*;
import java.awt.*;

// Use Swing API to design a "Temperature Converter"
// where provide JComboBox to select the Unit of Input
// Type, Output type and TextField to read the value to
// be converted and Display the result in a non-editable
// field.

public class TemparatureConverter {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(600, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(Color.YELLOW);

        JPanel panel = new JPanel();
        f.add(panel);
        panel.setLayout(new GridLayout(5, 2));

        JLabel inputLabel = new JLabel("Input Unit", SwingConstants.CENTER);
        panel.add(inputLabel, SwingConstants.CENTER);

        String[] units = { "Celsius", "Fahrenheit", "Kelvin" };
        JComboBox<String> inputUnit = new JComboBox<>(units);
        panel.add(inputUnit);

        JLabel outputLabel = new JLabel("Output Unit");
        panel.add(outputLabel);

        JComboBox<String> outputUnit = new JComboBox<>(units);
        panel.add(outputUnit);

        JLabel input = new JLabel("Input Value");
        panel.add(input);

        JTextField inputValue = new JTextField();
        panel.add(inputValue);

        JLabel output = new JLabel("Output Value");
        panel.add(output);

        JTextField outputValue = new JTextField();
        outputValue.setEditable(false);
        panel.add(outputValue);

        JButton convert = new JButton("Convert");
        // make the column span 2it will take 2 columns
        panel.add(convert, "2");
        

        convert.addActionListener(e -> {
            String inputUnitValue = (String) inputUnit.getSelectedItem();
            String outputUnitValue = (String) outputUnit.getSelectedItem();
            double inputValueValue = Double.parseDouble(inputValue.getText());
            double outputValueValue = 0;

            if (inputUnitValue.equals("Celsius") && outputUnitValue.equals("Fahrenheit")) {
                outputValueValue = (inputValueValue * 9 / 5) + 32;
            } else if (inputUnitValue.equals("Celsius") && outputUnitValue.equals("Kelvin")) {
                outputValueValue = inputValueValue + 273.15;
            } else if (inputUnitValue.equals("Fahrenheit") && outputUnitValue.equals("Celsius")) {
                outputValueValue = (inputValueValue - 32) * 5 / 9;
            } else if (inputUnitValue.equals("Fahrenheit") && outputUnitValue.equals("Kelvin")) {
                outputValueValue = (inputValueValue - 32) * 5 / 9 + 273.15;
            } else if (inputUnitValue.equals("Kelvin") && outputUnitValue.equals("Celsius")) {
                outputValueValue = inputValueValue - 273.15;
            } else if (inputUnitValue.equals("Kelvin") && outputUnitValue.equals("Fahrenheit")) {
                outputValueValue = (inputValueValue - 273.15) * 9 / 5 + 32;
            } else {
                outputValueValue = inputValueValue;
            }

            outputValue.setText(String.valueOf(outputValueValue));
        });

        f.setVisible(true);
    }

}
