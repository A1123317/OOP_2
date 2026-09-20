import javax.swing.*;
import java.awt.*;

public class DiceSimulator extends JFrame {

    public week1_hw1() {

        setTitle("骰子模擬器");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 開啟時置中
        setLocationRelativeTo(null);

        // 中央顯示目前點數
        JLabel lblNumber = new JLabel("1");
        lblNumber.setFont(new Font("Dialog", Font.PLAIN, 60));
        lblNumber.setHorizontalAlignment(SwingConstants.CENTER);

        // 擲骰子按鈕
        JButton btnDice = new JButton("擲骰子");

        // 使用 BorderLayout 配置元件
        setLayout(new BorderLayout());
        add(lblNumber, BorderLayout.CENTER);
        add(btnDice, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        DiceSimulator frm = new DiceSimulator();
        frm.setVisible(true);
    }
}