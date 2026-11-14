
import javax.swing.*;
import java.awt.*;

public class MyHouse extends JPanel {

    public MyHouse() {
        setPreferredSize(new Dimension(500, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 1. 天空與草地
        g.setColor(new Color(135, 206, 235));
        g.fillRect(0, 0, 500, 250);

        g.setColor(Color.GREEN);
        g.fillRect(0, 250, 500, 150);

        // 2. 太陽
        g.setColor(Color.YELLOW);
        g.fillOval(390, 30, 80, 80);

        // 太陽光線，至少 8 條
        g.setColor(Color.ORANGE);

        for (int i = 0; i < 8; i++) {
            double angle = Math.PI * 2 * i / 8;

            int x1 = 430 + (int)(50 * Math.cos(angle));
            int y1 = 70 + (int)(50 * Math.sin(angle));

            int x2 = 430 + (int)(70 * Math.cos(angle));
            int y2 = 70 + (int)(70 * Math.sin(angle));

            g.drawLine(x1, y1, x2, y2);
        }

        // 3. 雲朵
        g.setColor(Color.WHITE);
        g.fillOval(60, 55, 70, 55);
        g.fillOval(95, 35, 75, 65);
        g.fillOval(135, 55, 65, 55);

        // 4. 房屋主體
        g.setColor(new Color(255, 228, 181));
        g.fillRect(150, 180, 200, 150);

        g.setColor(Color.BLACK);
        g.drawRect(150, 180, 200, 150);

        // 5. 屋頂（三條線段）
        g.setColor(Color.RED);
        g.drawLine(125, 180, 250, 90);
        g.drawLine(250, 90, 375, 180);
        g.drawLine(375, 180, 125, 180);

        // 6. 門
        g.setColor(new Color(139, 69, 19));
        g.fillRoundRect(225, 250, 50, 80, 12, 12);

        // 門把
        g.setColor(Color.YELLOW);
        g.fillOval(262, 290, 8, 8);

        // 7. 左邊窗戶
        g.setColor(Color.WHITE);
        g.fillRect(170, 210, 50, 50);

        g.setColor(Color.BLACK);
        g.drawRect(170, 210, 50, 50);
        g.drawLine(195, 210, 195, 260);
        g.drawLine(170, 235, 220, 235);

        // 右邊窗戶
        g.setColor(Color.WHITE);
        g.fillRect(280, 210, 50, 50);

        g.setColor(Color.BLACK);
        g.drawRect(280, 210, 50, 50);
        g.drawLine(305, 210, 305, 260);
        g.drawLine(280, 235, 330, 235);

        // 8. 學號與姓名
        g.setColor(Color.BLACK);
        g.drawString("A1123317 何晨禎", 390, 385);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("我的小房子");

        MyHouse panel = new MyHouse();

        frame.add(panel);

        frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
