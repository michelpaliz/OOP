package testing.TreasureHunting;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

    final int originalTitleSize = 16;
    final int scale = 3;

    final int tileSize = originalTitleSize * scale;// 48 * 48
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 48*16 = 768
    final int screenHeight = tileSize * maxScreenRow;// 48*12 = 576
        

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

}
