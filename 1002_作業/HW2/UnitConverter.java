
import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class UnitConverter extends JFrame {

    private JComboBox<String> typeCombo;
    private JComboBox<String> fromCombo;
    private JComboBox<String> toCombo;

    private JTextField inputField;
    private JTextField resultField;

    private JButton convertButton;

    private String[][] units = {
        {"公尺", "公分", "英吋", "英尺"},
        {"公斤", "公克", "磅", "盎司"},
        {"攝氏", "華氏", "克氏"}
    };

    public UnitConverter() {
        // 視窗設定
        setTitle("單位換算器");
        setSize(480, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // NORTH：選擇換算類型
        typeCombo = new JComboBox<>(
            new String[]{"長度", "重量", "溫度"}
        );

        JPanel northPanel = new JPanel();
        northPanel.add(new JLabel("換算類型："));
        northPanel.add(typeCombo);

        add(northPanel, BorderLayout.NORTH);

        // CENTER：兩列輸入欄位與單位選單
        inputField = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);

        fromCombo = new JComboBox<>(units[0]);
        toCombo = new JComboBox<>(units[0]);

        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        centerPanel.add(inputField);
        centerPanel.add(fromCombo);

        centerPanel.add(resultField);
        centerPanel.add(toCombo);

        centerPanel.setBorder(
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        );

        add(centerPanel, BorderLayout.CENTER);

        // SOUTH：換算按鈕
        convertButton = new JButton("換算");

        JPanel southPanel = new JPanel();
        southPanel.add(convertButton);

        add(southPanel, BorderLayout.SOUTH);

        // 切換換算類型時，更新單位選項
        typeCombo.addActionListener(e -> updateUnits());

        // 按下按鈕執行換算
        convertButton.addActionListener(e -> convert());

        setVisible(true);
    }

    // 更新來源單位與目標單位
    private void updateUnits() {
        int type = typeCombo.getSelectedIndex();

        fromCombo.setModel(new DefaultComboBoxModel<>(units[type]));
        toCombo.setModel(new DefaultComboBoxModel<>(units[type]));

        resultField.setText("");
    }

    // 執行單位換算
    private void convert() {
        try {
            double value = Double.parseDouble(inputField.getText().trim());

            int type = typeCombo.getSelectedIndex();
            int from = fromCombo.getSelectedIndex();
            int to = toCombo.getSelectedIndex();

            double result;

            if (type == 0) {
                // 長度：先換算成公尺，再換成目標單位
                double[] factors = {1.0, 0.01, 0.0254, 0.3048};

                result = value * factors[from] / factors[to];

            } else if (type == 1) {
                // 重量：先換算成公斤，再換成目標單位
                double[] factors = {1.0, 0.001, 0.45359237, 0.028349523125};

                result = value * factors[from] / factors[to];

            } else {
                // 溫度：先換算成攝氏，再換算成目標單位
                double celsius;

                if (from == 0) {
                    celsius = value;
                } else if (from == 1) {
                    celsius = (value - 32) * 5.0 / 9.0;
                } else {
                    celsius = value - 273.15;
                }

                if (to == 0) {
                    result = celsius;
                } else if (to == 1) {
                    result = celsius * 9.0 / 5.0 + 32;
                } else {
                    result = celsius + 273.15;
                }
            }

            // 顯示換算結果
            resultField.setText(
                String.format(Locale.US, "%.4f", result)
            );

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this,
                "請輸入有效的數字！",
                "輸入錯誤",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UnitConverter());
    }
}
