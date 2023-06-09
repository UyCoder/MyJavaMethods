package dev.ahmed.ui;

import dev.ahmed.util.AhmedUtils;
import dev.ahmed.util.MyUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author Ahmed Bughra
 * @create 2023-01-05  6:51 PM
 */

public class ChatFrame extends JFrame {
    private JTextField inputField;
    private JTextArea chatHistory;
    private JButton sendButton;

    public ChatFrame() {
        // Set up the frame
        setTitle("OpenAI Chat");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the chat history area and add it to the frame
        chatHistory = new JTextArea(10, 20);
        chatHistory.setEditable(false);
        add(chatHistory, BorderLayout.NORTH);

        // Create the input field and send button and add them to the frame
        JPanel inputPanel = new JPanel();
        inputField = new JTextField(20);
        inputPanel.add(inputField);
        sendButton = new JButton("Send");
        inputPanel.add(sendButton);
        add(inputPanel, BorderLayout.SOUTH);



        // Add an action listener to the button
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String token = System.getenv("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");
                // Get the input string
                String input = inputField.getText();
                String output = null;
                try {
                    output = AhmedUtils.callOpenAi(input,
                            token,
                            "txt",
                            "ug",
                            "en");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                } catch (NoSuchFieldException ex) {
                    throw new RuntimeException(ex);
                }

                // Clear the output area
                chatHistory.setText("");

                // Split the string into characters
                try {
                    addMessage(input,Color.BLUE);
                    addMessage(output,Color.GREEN);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }

        });
    }

    public String addMessage(String message, Color color) {
        // Set the text color
        chatHistory.setForeground(color);
        // Append the message to the chat history
        chatHistory.setText(chatHistory.getText() + message + "\n");
        return message;
    }
}