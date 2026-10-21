
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DiceSimulator extends JFrame {

    private JLabel diceLabel;
    private JLabel statsLabel;
    private JButton rollButton;

    private int rollCount = 0;
    private int total = 0;

    private Random random = new Random();

    public DiceSimulator() {
        // 視窗設定
        setTitle("骰子模擬器");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // 上方：顯示擲骰次數、總和與平均
        statsLabel = new JLabel(
                "已擲 0 次，總和 0，平均 0.00",
                SwingConstants.CENTER
        );
        statsLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
        add(statsLabel, BorderLayout.NORTH);

        // 中央：顯示骰子點數
        diceLabel = new JLabel("-", SwingConstants.CENTER);
        diceLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 60));
        diceLabel.setForeground(Color.BLACK);
        add(diceLabel, BorderLayout.CENTER);

        // 下方：擲骰子按鈕
        rollButton = new JButton("擲骰子");
        rollButton.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
        rollButton.addActionListener(e -> rollDice());

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(rollButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // 顯示視窗
        setVisible(true);
    }

    // 擲骰子
    private void rollDice() {
        // 隨機產生 1 到 6 的點數
        int point = random.nextInt(6) + 1;

        // 更新擲骰次數與總和
        rollCount++;
        total += point;

        // 更新中央點數
        diceLabel.setText(String.valueOf(point));

        // 依照點數改變文字顏色
        if (point == 6) {
            diceLabel.setForeground(Color.GREEN);
        } else if (point == 1) {
            diceLabel.setForeground(Color.RED);
        } else {
            diceLabel.setForeground(Color.BLACK);
        }

        // 計算平均值
        double average = (double) total / rollCount;

        // 更新上方統計資訊
        statsLabel.setText(String.format(
                "已擲 %d 次，總和 %d，平均 %.2f",
                rollCount, total, average
        ));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DiceSimulator());
    }
}
