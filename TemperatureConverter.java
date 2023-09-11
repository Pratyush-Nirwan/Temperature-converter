import java.awt.*;
import java.awt.event.*;

public class TemperatureConverter extends Frame implements ActionListener {

  // Declare UI elements
  private Label inputLabel;
  private TextField inputField;
  private Button celsiusButton;
  private Button fahrenheitButton;
  private Label outputLabel;
  private TextField outputField;
  private Button exitButton;

  public TemperatureConverter() {
    // Set the frame's title and layout
    setTitle("Temperature Converter");
    setLayout(new BorderLayout());

    // Create the input panel
    Panel inputPanel = new Panel();
    inputPanel.setLayout(new FlowLayout());
    inputLabel = new Label("Temperature:");
    inputField = new TextField(10);
    celsiusButton = new Button("Convert to Celsius");
    fahrenheitButton = new Button("Convert to Fahrenheit");
    inputPanel.add(inputLabel);
    inputPanel.add(inputField);
    inputPanel.add(celsiusButton);
    inputPanel.add(fahrenheitButton);

    // Create the output panel
    Panel outputPanel = new Panel();
    outputPanel.setLayout(new FlowLayout());
    outputLabel = new Label("Result:");
    outputField = new TextField(10);
    outputField.setEditable(false);
    outputPanel.add(outputLabel);
    outputPanel.add(outputField);

    // Create the button panel
    Panel buttonPanel = new Panel();
    buttonPanel.setLayout(new FlowLayout());
    exitButton = new Button("Exit");
    buttonPanel.add(exitButton);

    // Add the input and output panels to the frame
    add(inputPanel, BorderLayout.NORTH);
    add(outputPanel, BorderLayout.SOUTH);
    add(buttonPanel, BorderLayout.CENTER);

    // Add action listeners for the buttons
    celsiusButton.addActionListener(this);
    fahrenheitButton.addActionListener(this);
    exitButton.addActionListener(this);

    // Set the frame to pack and show
    setSize(500, 200);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    // Check which button was clicked
    if (e.getSource() == celsiusButton || e.getSource() == fahrenheitButton) {
      // Get the temperature from the input field
      double temperature = Double.parseDouble(inputField.getText());

      // Convert the temperature based on the button clicked
      if (e.getSource() == celsiusButton) {
        temperature = (temperature - 32) * (5.0 / 9.0);
      } else if (e.getSource() == fahrenheitButton) {
        temperature = (temperature * (9.0 / 5.0)) + 32;
      }

      // Set the result in the output field
      outputField.setText(String.format("%.2f", temperature));
    } else if (e.getSource() == exitButton) {
      // Close the program
      System.exit(0);
    }
  }
  public static void main(String[] args) {
    new TemperatureConverter();
  }
}