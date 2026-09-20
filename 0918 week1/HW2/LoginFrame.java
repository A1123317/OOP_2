import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginFrame() {

        // 視窗設定
        setTitle("登入頁面");
        setSize(350, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 外層容器，保留適當邊距
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;

        // 帳號標籤
        JLabel usernameLabel = new JLabel("帳號：");

        // 帳號輸入框
        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(160, 28));

        // 密碼標籤
        JLabel passwordLabel = new JLabel("密碼：");

        // 密碼輸入框
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(160, 28));

        // 登入按鈕
        loginButton = new JButton("登入");
        loginButton.setPreferredSize(new Dimension(80, 28));

        // 帳號
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        mainPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(usernameField, gbc);

        // 密碼
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(passwordField, gbc);

        // 登入按鈕
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 5, 5, 5);
        mainPanel.add(loginButton, gbc);

        // 加入主面板
        add(mainPanel);

        // 登入按鈕事件
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (username.equals("admin") && password.equals("1234")) {
                    JOptionPane.showMessageDialog(
                            LoginFrame.this,
                            "登入成功！"
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            LoginFrame.this,
                            "帳號或密碼錯誤！"
                    );
                }
            }
        });

        // 顯示視窗
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}