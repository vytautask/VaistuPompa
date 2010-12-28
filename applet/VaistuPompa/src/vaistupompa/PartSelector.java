/*
 * PartSelector.java
 *
 * Created on 2010-12-19, 13.25.16
 */
package vaistupompa;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ssharunas
 */
public class PartSelector extends javax.swing.JPanel {

    // <editor-fold defaultstate="collapsed" desc="Internal stuff">
    //NOTE: Magic. do not touch
    
    // <editor-fold defaultstate="collapsed" desc="Arrow classes">
    private abstract class EntryPoint {

        EntryPoint(Point p) {
            point = p;
        }
        private Point point;
        public boolean PreferSpanY = true;

        public Point getPosition() {
            return point;
        }

        public abstract void drawDecorator(Graphics g);

        public EntryPoint getPoint() {
            return new BubblePoint(point);
        }
    }

    private class ArrowPoint extends EntryPoint {

        int shift;

        ArrowPoint(Point p) {
            super(new Point(p.x - 15, p.y));
            shift = 15;
        }

        @Override
        public void drawDecorator(Graphics g) {
            g.drawLine(getPosition().x + 5, getPosition().y - 3, getPosition().x + shift, getPosition().y);
            g.drawLine(getPosition().x, getPosition().y, getPosition().x + shift, getPosition().y);
            g.drawLine(getPosition().x + 5, getPosition().y + 3, getPosition().x + shift, getPosition().y);
        }
    }

    private class LinePoint extends EntryPoint {

        LinePoint(Point p) {
            super(new Point(p.x + 10, p.y));
        }

        @Override
        public void drawDecorator(Graphics g) {
            g.drawLine(getPosition().x, getPosition().y, getPosition().x - 10, getPosition().y);
        }
    }

    private class BubblePoint extends EntryPoint {

        BubblePoint(Point p) {
            super(p);
        }

        @Override
        public void drawDecorator(Graphics g) {
            g.fillOval(getPosition().x - 3, getPosition().y - 3, 6, 6);
        }
    }

    private class EmptyPoint extends EntryPoint {

        EmptyPoint(Point p) {
            super(p);
        }

        EmptyPoint(Point p, boolean isPreferedY) {
            super(p);
            PreferSpanY = isPreferedY;
        }

        @Override
        public void drawDecorator(Graphics g) {
        }
    }

    //</editor-fold>
    private class SuperLine {

        public ArrayList<EntryPoint> points;

        public SuperLine() {
            points = new ArrayList<EntryPoint>();
        }

        public void AddPoint(EntryPoint point) {
            points.add(point);
        }

        public void draw(Graphics g) {
            g.setColor(Color.gray);
            int lastX = 0, lastY = 0;

            if (points.size() > 0) {
                lastX = points.get(0).getPosition().x;
                lastY = points.get(0).getPosition().y;
            }

            for (int i = 0; i < points.size() - 1; i++) {
                EntryPoint p1 = points.get(i);
                EntryPoint p2 = points.get(i + 1);

                int x1 = 0, x2 = 0, y1 = 0, y2 = 0;

//                g.drawString(">> " + lastX + " : " + lastY , 10, 10 * (i + 1));

                x1 = p1.getPosition().x < 0 ? lastX : p1.getPosition().x;
                x2 = p2.getPosition().x < 0 ? lastX : p2.getPosition().x;

                y1 = p1.getPosition().y < 0 ? lastY : p1.getPosition().y;
                y2 = p2.getPosition().y < 0 ? lastY : p2.getPosition().y;

                if (p1.getPosition().x == p2.getPosition().x || p1.getPosition().y == p2.getPosition().y) {
                    g.drawLine(x1, y1, x2, y2);
                } else {
                    if (p1.PreferSpanY) {
                        g.drawLine(x1, y1, x1, y2);
                        g.drawLine(x1, y2, x2, y2);
                    } else {
                        g.drawLine(x1, y1, x2, y1);
                        g.drawLine(x2, y1, x2, y2);
                    }
                }

                lastX = x2;
                lastY = y2;

                p1.drawDecorator(g);
                p2.drawDecorator(g);
            }

            g.setColor(Color.black);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Graphical Elements">
    private abstract class GraphicalElement {

        public Boolean IsSelected = false;
        public Boolean CanSelect = true;

        public abstract void draw(Graphics g);

        public abstract EntryPoint getInPoint(int nr);

        public abstract EntryPoint getOutPoint(int nr);

        public abstract boolean isInside(Point p);
    }

    private class Rect extends GraphicalElement {

        private int x;
        private int y;
        private String[] ins;
        private String[] outs;
        private String name;
        //consts
        private int RECORD_HEIGHT = 15; //px
        private int TEXT_UP = 10; //px
        private int CHAR_SIZE = 7; //px
        private int LEFT_MARGIN = 20; //px
        int totalHeight;
        int totalWidth;

        Rect(int x, int y, String[] ins, String[] outs, String name) {
            this.x = x;
            this.y = y;
            this.ins = ins;
            this.outs = outs;
            this.name = name;

            int maxCount = Math.max(ins.length, outs.length);
            totalHeight = RECORD_HEIGHT * maxCount + TEXT_UP * 3;
            totalWidth = LEFT_MARGIN + name.length() * CHAR_SIZE;
        }

        public EntryPoint getInPoint(int nr) {
            return new ArrowPoint(new Point(x, y + RECORD_HEIGHT * (nr + 1)));
        }

        public EntryPoint getOutPoint(int nr) {
            return new LinePoint(new Point(x + totalWidth, y + RECORD_HEIGHT * (nr + 1)));
        }

        public void draw(Graphics g) {

            if (IsSelected && CanSelect) {
                g.setColor(Color.yellow);
                g.fillRect(x, y, totalWidth, totalHeight);
                g.setColor(Color.black);
            }
            g.drawRect(x, y, totalWidth, totalHeight);

            g.drawString(name, x + LEFT_MARGIN - 3, y + totalHeight - TEXT_UP);

            int h = RECORD_HEIGHT;
            for (int i = 0; i < ins.length; i++) {
                g.drawOval(x + 1, y + h - 3, 8, 8);
                g.drawString(ins[i], x + 8 + 5, y + h + 6);
                h += RECORD_HEIGHT;
            }

            h = RECORD_HEIGHT;
            for (int i = 0; i < outs.length; i++) {
                g.drawOval(x + totalWidth - 8, y + h - 3, 8, 8);
                g.drawString(outs[i], x + totalWidth - 8 - 10, y + h + 6);
                h += RECORD_HEIGHT;
            }
        }

        public boolean isInside(Point p) {
            return p.x > x && p.x < (x + totalWidth)
                    && p.y > y && p.y < (y + totalHeight);
        }
    }

    private class Bubble extends GraphicalElement {

        private int x;
        private int y;
        private String name;
        //consts
        private int RECORD_HEIGHT = 5; //px
        private int CHAR_SIZE = 7; //px
        private int MARGIN = 20; //px
        int totalHeight;
        int totalWidth;

        Bubble(int x, int y, String name) {
            this.x = x;
            this.y = y;
            this.name = name;
            totalHeight = totalWidth = MARGIN + name.length() * CHAR_SIZE;
        }

        public EntryPoint getInPoint(int nr) {
            return getInPoint();
        }

        public EntryPoint getOutPoint(int nr) {
            return getOutPoint();
        }

        public EntryPoint getInPoint() {
            return new ArrowPoint(new Point(x - totalWidth / 2, y));
        }

        public EntryPoint getOutPoint() {
            return new LinePoint(new Point(x + totalWidth / 2, y));
        }

        public void draw(Graphics g) {

            if (IsSelected) {
                g.setColor(Color.yellow);
                g.fillOval(x - totalWidth / 2, y - totalHeight / 2, totalWidth, totalHeight);
                g.setColor(Color.black);
            }
            g.drawOval(x - totalWidth / 2, y - totalHeight / 2, totalWidth, totalHeight);

            int strWidth = 0;
            if (fm != null) {
                strWidth = fm.stringWidth(name);
            }

            g.drawString(name, x - strWidth / 2, y + RECORD_HEIGHT);
        }

        public boolean isInside(Point p) {
            return p.x > (x - totalWidth / 2) && p.x < (x + totalWidth / 2)
                    && p.y > (y - totalHeight / 2) && p.y < (y + totalHeight / 2);
        }
    }
    //</editor-fold>
    static FontMetrics fm = null;
    private GraphicalElement[] agregatai;
    private SuperLine[] superLines;
    //</editor-fold>

    void setDataPKA(ArrayList<DataContainer> data){
        this.data_pka = data;
        OnSeletionChanged();
    }

    void setDataIPKA(ArrayList<DataContainer> data){
        this.data_ipka = data;
        OnSeletionChanged();
    }

    void setTable(JTable table){
        this.table = table;
        OnSeletionChanged();
    }

    void setshowMode(boolean  pka){
        if(pka)
            data = data_pka;
        else
            data = data_ipka;
        
        System.out.print(data);

        OnSeletionChanged();
    }

    JTable table = null;
    ArrayList<DataContainer> data = null;
    ArrayList<DataContainer> data_pka = null;
    ArrayList<DataContainer> data_ipka = null;

    public int SelectedIndex = -1;
    
    /** Creates new form PartSelector */
    public PartSelector() {
        initComponents();
        setBackground(Color.white);
        fm = getFontMetrics(getFont());

        agregatai = new GraphicalElement[9];

        int line_count = 100;
        superLines = new SuperLine[line_count];
        for (int i = 0; i < line_count; i++) {
            superLines[i] = new SuperLine();
        }

        agregatai[0] = new Rect(30, 135, new String[]{"1", "2", "3"},
                new String[]{"1"}, "Skausmo generatorius");

        agregatai[1] = new Rect(350, 20, new String[]{"1", "2", "3", "4", "5"},
                new String[]{"1"}, "     +X1");

        agregatai[2] = new Rect(350, 160, new String[]{"1", "2"},
                new String[]{"1"}, "     +X2");

        agregatai[3] = new Rect(350, 250, new String[]{"1", "2"},
                new String[]{"1"}, "     +X3");

        agregatai[4] = new Rect(590, 20, new String[]{"1", "2"},
                new String[]{"1"}, "     ∫ X1");

        agregatai[5] = new Rect(590, 160, new String[]{"1"},
                new String[]{"1"}, "     ∫ X2");

        agregatai[6] = new Rect(590, 250, new String[]{"1"},
                new String[]{"1"}, "     ∫ X3");

        agregatai[7] = new Bubble(260, 150, "Pompa");

        agregatai[8] = new Bubble(750, 175, "OUT");

        EntryPoint tmp = null;

        superLines[0].AddPoint(agregatai[1].getOutPoint(0));
        superLines[0].AddPoint(agregatai[4].getInPoint(0));

        superLines[1].AddPoint(agregatai[2].getOutPoint(0));
        superLines[1].AddPoint(agregatai[5].getInPoint(0));

        //+X3 -> xX3
        superLines[2].AddPoint(agregatai[3].getOutPoint(0));
        superLines[2].AddPoint(new EmptyPoint(new Point(500, 265)));
        superLines[2].AddPoint(agregatai[6].getInPoint(0));

        //dX3 -> +X3
        superLines[3].AddPoint(agregatai[6].getOutPoint(0));
        superLines[3].AddPoint(new EmptyPoint(new Point(-1, 320), false));
        superLines[3].AddPoint(new EmptyPoint(new Point(300, agregatai[3].getInPoint(1).getPosition().y)));
        superLines[3].AddPoint(agregatai[3].getInPoint(1));

        superLines[4].AddPoint(agregatai[0].getOutPoint(0));
        superLines[4].AddPoint(agregatai[7].getInPoint(0));

        //popma -> dX1
        tmp = agregatai[7].getOutPoint(0);
        tmp.PreferSpanY = false;
        superLines[5].AddPoint(tmp);
        superLines[5].AddPoint(agregatai[4].getInPoint(1));

        //dX1 -> out
//        tmp = agregatai[4].getOutPoint(0);
//        tmp.PreferSpanY = false;
//        superLines[6].AddPoint(tmp);
//        superLines[6].AddPoint(new EmptyPoint(new Point(700, 140), true));
//        superLines[6].AddPoint(agregatai[8].getInPoint(0));

        //dX2 -> out
        superLines[7].AddPoint(agregatai[5].getOutPoint(0));
        superLines[7].AddPoint(agregatai[8].getInPoint(0));

        //dX3 -> out
//        superLines[8].AddPoint(superLines[3].points.get(0).getPoint());
//        superLines[8].AddPoint(new EmptyPoint(new Point(700, -1)));
//        superLines[8].AddPoint(agregatai[8].getInPoint(0));

        //dX2 -> +X2
        superLines[9].AddPoint(superLines[7].points.get(0).getPoint());
        superLines[9].AddPoint(new EmptyPoint(new Point(-1, 240), false));
        superLines[9].AddPoint(new EmptyPoint(new Point(320, agregatai[2].getInPoint(1).getPosition().y)));
        superLines[9].AddPoint(agregatai[2].getInPoint(1));

        //dX2 -> +X1
        superLines[10].AddPoint(superLines[9].points.get(2).getPoint());
        superLines[10].AddPoint(agregatai[1].getInPoint(0));

        //dX3 -> +X1
        superLines[11].AddPoint(superLines[3].points.get(2).getPoint());
        superLines[11].AddPoint(agregatai[1].getInPoint(3));

        //dX1 -> +X1[4]
        tmp = agregatai[4].getOutPoint(0);
        //tmp = superLines[6].points.get(1).getPoint();
        tmp.PreferSpanY = false;
        superLines[12].AddPoint(tmp);
        superLines[12].AddPoint(new EmptyPoint(new Point(700, 140), false));
        tmp = new EmptyPoint(new Point(agregatai[1].getInPoint(4).getPosition().x, tmp.point.y));
        superLines[12].AddPoint(tmp);
        superLines[13].AddPoint(tmp.getPoint());
        superLines[13].AddPoint(agregatai[1].getInPoint(4));

        //dX1 -> +X2
        superLines[14].AddPoint(tmp.getPoint());
        superLines[14].AddPoint(agregatai[2].getInPoint(0));

        //dX1 -> +X3
        superLines[15].AddPoint(superLines[14].points.get(0).getPoint());
        superLines[15].AddPoint(agregatai[3].getInPoint(0));

        //dX1 -> +X1[2]
        superLines[16].AddPoint(superLines[13].points.get(0).getPoint());
        superLines[16].AddPoint(agregatai[1].getInPoint(2));

        //dX1 -> +X1[1]
        superLines[17].AddPoint(superLines[16].points.get(0).getPoint());
        superLines[17].AddPoint(agregatai[1].getInPoint(1));


        //+X1 -> generatorius
        superLines[18].AddPoint(superLines[0].points.get(0).getPoint());
        superLines[18].AddPoint(new EmptyPoint(new Point(-1, 10), false));
        superLines[18].AddPoint(new EmptyPoint(new Point(10, -1), true));
        superLines[18].AddPoint(agregatai[0].getInPoint(0));

        //+X2 -> generatorius
        superLines[19].AddPoint(superLines[1].points.get(0).getPoint());
        superLines[19].AddPoint(new EmptyPoint(new Point(-1, 330), false));
        superLines[19].AddPoint(agregatai[0].getInPoint(2));

        //+X3 -> generatorius
        superLines[20].AddPoint(superLines[2].points.get(1).getPoint());
        superLines[20].AddPoint(new EmptyPoint(new Point(-1, 340), false));
        superLines[20].AddPoint(new EmptyPoint(new Point(10, -1), true));
        superLines[20].AddPoint(agregatai[0].getInPoint(1));

        addMyListeners();
    }

    // <editor-fold defaultstate="collapsed" desc="Internal stuff">
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //!! get Graphics2D object and set anti-aliasing to "on"
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        for (int i = 0; i < agregatai.length; i++) {
            agregatai[i].draw(g);
        }

        for (int i = 0; i < superLines.length; i++) {
            superLines[i].draw(g);
        }

    }

    private void Select(Point p, boolean select) {
        if (!select) {
            SelectedIndex = -1;
            for (int i = 0; i < agregatai.length; i++) {
                agregatai[i].IsSelected = false;
            }
        } else {
            for (int i = 0; i < agregatai.length; i++) {
                if (agregatai[i].CanSelect && agregatai[i].isInside(p)) {
                    SelectedIndex = i;
                    agregatai[i].IsSelected = true;
                    OnSeletionChanged();
                    break;
                }
            }
        }
    }

    public void addMyListeners() {
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg) {
                Select(null, false);
                Point p = arg.getPoint();
                Select(p, true);
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
            }
        });
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="data table setters">
    
    void showGenerator() {
       String [][] values = new String[data.size()][5];
       
       for(int i = 0; i < data.size(); i++){
           values[i][0] = String.format("%d", i);
           values[i][1] = String.format("%.5f", data.get(i).getGenerator_x1());
           values[i][2] = String.format("%.5f", data.get(i).getGenerator_x2());
           values[i][3] = String.format("%.5f", data.get(i).getGenerator_x3());
           values[i][4] = String.format("%.5f", data.get(i).getGenerator_out());
       }

       DefaultTableModel model = new DefaultTableModel(values, new String[]{"t", "1", "2", "3", "out"});
       table.setModel(model);
    }

    void showSum1() {
       String [][] values = new String[data.size()][7];

       for(int i = 0; i < data.size(); i++){
           values[i][0] = String.format("%d", i);
           values[i][1] = String.format("%.5f", data.get(i).getSum1_x1());
           values[i][2] = String.format("%.5f", data.get(i).getSum1_x2());
           values[i][3] = String.format("%.5f", data.get(i).getSum1_x3());
           values[i][4] = String.format("%.5f", data.get(i).getSum1_x4());
           values[i][5] = String.format("%.5f", data.get(i).getSum1_x5());
           values[i][6] = String.format("%.5f", data.get(i).getSum1_out());
       }

       DefaultTableModel model = new DefaultTableModel(values, new String[]{"t", "1", "2", "3", "4", "5", "out"});
       table.setModel(model);
    }

    void showSum2() {
       String [][] values = new String[data.size()][4];

       for(int i = 0; i < data.size(); i++){
           values[i][0] = String.format("%d", i);
           values[i][1] = String.format("%.5f", data.get(i).getSum2_x1());
           values[i][2] = String.format("%.5f", data.get(i).getSum2_x2());
           values[i][3] = String.format("%.5f", data.get(i).getSum2_out());
       }

       DefaultTableModel model = new DefaultTableModel(values, new String[]{"t", "1", "2", "out"});
       table.setModel(model);
    }

    void showSum3() {
       String [][] values = new String[data.size()][4];

       for(int i = 0; i < data.size(); i++){
           values[i][0] = String.format("%d", i);
           values[i][1] = String.format("%.5f", data.get(i).getSum3_x1());
           values[i][2] = String.format("%.5f", data.get(i).getSum3_x2());
           values[i][3] = String.format("%.5f", data.get(i).getSum3_out());
       }

       DefaultTableModel model = new DefaultTableModel(values, new String[]{"t", "1", "2", "out"});
       table.setModel(model);
    }

    void showInteg1() {
       String [][] values = new String[data.size()][4];

       for(int i = 0; i < data.size(); i++){
           values[i][0] = String.format("%d", i);
           values[i][1] = String.format("%.5f", data.get(i).getInteg1_x1());
           values[i][2] = String.format("%.5f", data.get(i).getInteg1_x2());
           values[i][3] = String.format("%.5f", data.get(i).getInteg1_out());
       }

       DefaultTableModel model = new DefaultTableModel(values, new String[]{"t", "1", "2", "out"});
       table.setModel(model);
    }

    void showInteg2() {
       String [][] values = new String[data.size()][3];

       for(int i = 0; i < data.size(); i++){
           values[i][0] = String.format("%d", i);
           values[i][1] = String.format("%.5f", data.get(i).getInteg2_x1());
           values[i][2] = String.format("%.5f", data.get(i).getInteg2_out());
       }

       DefaultTableModel model = new DefaultTableModel(values, new String[]{"t", "1", "out"});
       table.setModel(model);
    }

    void showInteg3() {
       String [][] values = new String[data.size()][3];

       for(int i = 0; i < data.size(); i++){
           values[i][0] = String.format("%d", i);
           values[i][1] = String.format("%.5f", data.get(i).getInteg3_x1());
           values[i][2] = String.format("%.5f", data.get(i).getInteg3_out());
       }

       DefaultTableModel model = new DefaultTableModel(values, new String[]{"t", "1", "out"});
       table.setModel(model);
    }

    void showPump() {
       String [][] values = new String[data.size()][2];

       for(int i = 0; i < data.size(); i++){
           values[i][0] = String.format("%d", i);
           values[i][1] = new Boolean(data.get(i).isPompa_out()).toString();
       }

       DefaultTableModel model = new DefaultTableModel(values, new String[]{"t", "out"});
       table.setModel(model);
    }

    void showOut() {
       String [][] values = new String[data.size()][2];

       for(int i = 0; i < data.size(); i++){
           values[i][0] = String.format("%d", i);
           values[i][1] = String.format("%.5f", data.get(i).getInteg2_out());
       }

       DefaultTableModel model = new DefaultTableModel(values, new String[]{"t", "out"});
       table.setModel(model);
    }

    void OnSeletionChanged(){
        if(table == null)
            return;
        
        table.setModel(new AbstractTableModel() {
            public int getColumnCount() { return 0; }
            public int getRowCount() { return 0;}
            public Object getValueAt(int row, int col) { return 0; }
        });

        if(data == null)
            data = data_pka;

        if(data == null)
            return;

        switch(SelectedIndex){
            case 0: //generatorius
                showGenerator();
                break;
            case 1://+X1
                showSum1();
                break;
            case 2://+X2
                showSum2();
                break;
            case 3://+X3
                showSum3();
                break;
            case 4://dX1
                showInteg1();
                break;
            case 5://dX2
                showInteg2();
                break;
            case 6://dX3
                showInteg3();
                break;
            case 7://pompa
                showPump();
                break;
            case 8://out
                showOut();
                break;
        }
    }

    //</editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
