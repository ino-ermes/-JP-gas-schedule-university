
package com.mio.GUI.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JPanel;

/**
 *
 * @author Mio
 */
public class GAInforPanel extends JPanel{

    public GAInforPanel() {
        setOpaque(false);
    }

    private int cellW = 60;
    private int cellH = 25;
    private int marginL = 20;
    private int marginT = 10;
    Font f = getFont();
    
    
    private boolean running = false;
    private float fitness = 0f;
    private float averageFitness = 0f;
    private int generationCount = 0;
    private int constraint = 0;
    private int[] constraints = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
    private int crossoverProb = 0;
    private int mutationProb = 0;
    private boolean autoReset = false;
    private float resetPoint = 0;
    private int resetCount = 0;
    
    @Override
    protected void paintComponent(Graphics g) {
        g.setFont(f);
        g.setColor(Color.WHITE);
        
        int fontHeight = g.getFontMetrics().getHeight();
        fontHeight += fontHeight / 2;
        
        int y = marginT + fontHeight;
        int x = marginL;
        
        g.drawString("状態：" + (running ? "実行中" : "停止"), x, y);
        
        y += fontHeight;
        g.drawString("適応度：" + round(fitness, 4), x, y);
        
        y += fontHeight;
        g.drawString("平均値：" + round(averageFitness, 4), x, y);
        
        y += fontHeight;
        g.drawString("世代：" + generationCount, x, y);
        
        y += fontHeight;
        g.drawString("制約を満たしていない：" + constraint, x, y);
        
        y += fontHeight / 2;
        
        for(int i = 0; i != 10; ++i) {
            g.drawLine(marginL, y + cellH * i, marginL + cellW * 2, y + cellH * i);
        }
        for(int i = 0; i != 3; ++i) {
            g.drawLine(marginL + cellW * i, y, marginL + cellW * i, y + cellH * 9);
        }
        
        for(int i = 0; i != 9; ++i) {
            for(int j = 0; j != 2; ++j) {
                Rectangle r = new Rectangle(marginL + j * cellW, y + i * cellH, cellW, cellH);
                if(i == 0) {
                    if(j == 0) {
                        drawCenteredString(g, "タイプ", r, f);
                    } else {
                        drawCenteredString(g, "合計", r, f);
                    }
                } else if(j == 0) {
                    drawCenteredString(g, "" + i, r, f);
                } else {
                    drawCenteredString(g, "" + constraints[i - 1], r, f);
                }
            }
        }
        
        y += cellH * 9;
        
        y += fontHeight;
        g.drawString("交叉率：" + crossoverProb, x, y);
        
        y += fontHeight;
        g.drawString("突然変異率：" + mutationProb, x, y);
        
        y += fontHeight;
        g.drawString("オートリセット：" + (autoReset ? "オン" : "オフ"), x, y);
        
        y += fontHeight;
        g.drawString("リセットポイント：" + resetPoint, x, y);
        
        y += fontHeight;
        g.drawString("リセット数：" + resetCount, x, y);
        
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        super.paintComponent(g);
    }

    public void setInfor(boolean running, float fitness, float averageFitness, int generationCount, int[] constraints, int resetCount) {
        this.running = running;
        this.fitness = fitness;
        this.averageFitness = averageFitness;
        this.generationCount = generationCount;
        this.constraints = constraints;
        this.constraint = 0;
        for(int i = 0; i != 8; ++i) {
            this.constraint += constraints[i];
        }
        this.resetCount = resetCount;
        repaint();
    }
    public void setConfig(int crossoverProb, int mutationProb, boolean autoReset, float resetPoint) {
        this.crossoverProb = crossoverProb;
        this.mutationProb = mutationProb;
        this.autoReset = autoReset;
        this.resetPoint = resetPoint;
        repaint();
    }
    
    private void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        g.setFont(font);
        g.drawString(text, x, y);
    }
    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
