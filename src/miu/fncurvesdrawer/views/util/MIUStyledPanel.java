package miu.fncurvesdrawer.views.util;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Graphics;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import miu.fncurvesdrawer.util.MIUConfigManager;
import org.joda.time.DateTime;

/**
 *
 * @author Ndadji Maxime
 */
public class MIUStyledPanel extends JPanel{
    private int style = 1;
    public static final int SQUARED_ROUNDED = 3,
                            MIUNIVERSE = 2,
                            TITLED_BORDER = 4,
                            SIMPLE = 5,
                            SIMPLE_GRAY = 1,
                            SIMPLE_CHRISTMAS = 6;
    private MIUConfigManager config;
    private Color simpleColor = new Color(250, 250, 250);

    public MIUStyledPanel(MIUConfigManager config){
        this.config = config;
    }

    public MIUStyledPanel(int style, MIUConfigManager config){
        this(config);
        this.style = style;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(style == MIUNIVERSE){
            g.setColor(new Color(238, 238, 238));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(config.getTheme().getBgColor());
            g.drawRoundRect(2, 2, this.getWidth() - 4, this.getHeight() - 4, 5, 5);
            ImageIcon icon = new ImageIcon(getClass().getResource("/miu/fncurvesdrawer/resources/images/miu.png"));
            int x1 = (((this.getWidth() - 500) / 2) - 70) / 2;
            int x2 = (((this.getWidth() - 500) / 2) - 70) / 2 + 500 + (this.getWidth() - 500) / 2;
            g.drawImage(icon.getImage(), (x1 >= 12) ? x1 : 12, 12, this);
            g.drawImage(icon.getImage(), (x2 <= this.getWidth() - 72) ? x2 : this.getWidth() - 72, 12, this);
        }
        if(style == SQUARED_ROUNDED){
            g.setColor(new Color(238, 238, 238));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(config.getTheme().getBgColor());
            g.drawRoundRect(2, 2, this.getWidth() - 4, this.getHeight() - 4, 5, 5);
        }
        if(style == TITLED_BORDER){
            g.setColor(new Color(238, 238, 238));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.drawImage((new ImageIcon(getClass().getResource("/miu/fncurvesdrawer/resources/images/arrow.png"))).getImage(), 0, this.getHeight()/2 - 5, 12, 10, this);
            g.drawImage((new ImageIcon(getClass().getResource("/miu/fncurvesdrawer/resources/images/arrow_.png"))).getImage(), this.getWidth() - 12, this.getHeight()/2 - 5, 12, 10, this);
        }
        if(style == SIMPLE){
            g.setColor(simpleColor);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
        }
        if(style == SIMPLE_GRAY){
            g.setColor(new Color(238, 238, 238));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
        }
        if(style == SIMPLE_CHRISTMAS){
            g.setColor(new Color(250, 250, 250));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            DateTime d = new DateTime(new Date());
            if((d.getDayOfMonth() >= 18 && d.getMonthOfYear() == 12) || (d.getDayOfMonth() <= 10 && d.getMonthOfYear() == 1))
                g.drawImage((new ImageIcon(getClass().getResource("/miu/fncurvesdrawer/resources/images/christmas.png"))).getImage(), this.getWidth() - 37, 0, 37, 30, this);
        }
    }

    public Color getSimpleColor() {
        return simpleColor;
    }

    public void setSimpleColor(Color simpleColor) {
        this.simpleColor = simpleColor;
    }
}