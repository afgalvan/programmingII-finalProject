package app.views.components.atomic;

import efectos.ElevationEffectCircle;
import efectos.RippleEffect;
import efectos.Roboto;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D.Float;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

public class MaterialButtonCircle extends JButton {

    private Icon icon = new ImageIcon("src/app/views/assets/icons/24x24/diskette.png");
    private ImageIcon imageIcon;
    private Image image;
    private final Image defaultImage;
    private final RippleEffect ripple;
    private final ElevationEffectCircle elevation;
    private MaterialButtonCircle.Type type;
    private boolean isMousePressed;
    private boolean isMouseOver;
    private Color rippleColor;
    private Cursor cursor;

    public MaterialButtonCircle() {
        this.imageIcon = (ImageIcon) this.icon;
        this.image = this.imageIcon.getImage();
        this.defaultImage = this.image;
        this.type = MaterialButtonCircle.Type.DEFAULT;
        this.isMousePressed = false;
        this.isMouseOver = false;
        this.rippleColor = Color.WHITE;
        this.cursor = super.getCursor();
        this.setPreferredSize(new Dimension(100, 100));
        this.setSize(new Dimension(100, 100));
        this.setBackground(new Color(0, 112, 192));
        this.setForeground(Color.WHITE);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.ripple = RippleEffect.applyTo(this);
        this.elevation = ElevationEffectCircle.applyTo(this, 0);
        this.setOpaque(false);
        this.addMouseListener(
                new MouseAdapter() {
                    public void mousePressed(MouseEvent mouseEvent) {
                        MaterialButtonCircle.this.isMousePressed = true;
                    }

                    public void mouseReleased(MouseEvent mouseEvent) {
                        MaterialButtonCircle.this.isMousePressed = false;
                        MaterialButtonCircle.this.repaint();
                    }

                    public void mouseEntered(MouseEvent e) {
                        MaterialButtonCircle.this.isMouseOver = true;
                        MaterialButtonCircle.this.repaint();
                    }

                    public void mouseExited(MouseEvent e) {
                        MaterialButtonCircle.this.isMouseOver = false;
                        MaterialButtonCircle.this.repaint();
                    }
                }
            );
        this.setFont(Roboto.MEDIUM.deriveFont(17.0F));
        this.setUI(
                new BasicButtonUI() {
                    public boolean contains(JComponent c, int x, int y) {
                        return (
                            x > 5 &&
                            y > 5 &&
                            x < MaterialButtonCircle.this.getWidth() - 5 &&
                            y < MaterialButtonCircle.this.getHeight() - 5
                        );
                    }
                }
            );
    }

    public void setIcon(Icon icon) {
        if (icon != null) {
            this.icon = icon;
            this.imageIcon = (ImageIcon) this.icon;
            this.image = this.imageIcon.getImage();
        } else {
            this.image = this.defaultImage;
        }

        this.repaint();
    }

    public MaterialButtonCircle.Type getType() {
        return this.type;
    }

    public void setType(MaterialButtonCircle.Type type) {
        this.type = type;
        this.repaint();
    }

    public Color getRippleColor() {
        return this.rippleColor;
    }

    public void setRippleColor(Color rippleColor) {
        this.rippleColor = rippleColor;
    }

    public void setEnabled(boolean b) {
        super.setEnabled(b);
        this.elevation.setLevel(this.getElevation());
        super.setCursor(
            b ? this.cursor : Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)
        );
    }

    public void setCursor(Cursor cursor) {
        super.setCursor(cursor);
        this.cursor = cursor;
    }

    protected void processFocusEvent(FocusEvent focusEvent) {
        super.processFocusEvent(focusEvent);
        this.elevation.setLevel(this.getElevation());
    }

    protected void processMouseEvent(MouseEvent mouseEvent) {
        super.processMouseEvent(mouseEvent);
        this.elevation.setLevel(this.getElevation());
    }

    private int getElevation() {
        if (this.isMousePressed) {
            return 2;
        } else {
            return (
                    this.type != MaterialButtonCircle.Type.RAISED &&
                    !this.isFocusOwner() &&
                    !this.isMouseOver
                )
                ? 0
                : 1;
        }
    }

    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        );
        g2.setRenderingHint(
            RenderingHints.KEY_TEXT_ANTIALIASING,
            RenderingHints.VALUE_TEXT_ANTIALIAS_ON
        );
        if (this.type != MaterialButtonCircle.Type.FLAT && this.isEnabled()) {
            this.elevation.paint(g);
        }

        g2.translate(5, 5);
        if (this.isEnabled()) {
            g2.setColor(this.getBackground());
            g2.fill(
                new Float(
                    0.0F,
                    0.0F,
                    (float) (this.getWidth() - 10),
                    (float) (this.getHeight() - 10),
                    100.0F,
                    100.0F
                )
            );
            g2.setColor(
                new Color(
                    (float) this.rippleColor.getRed() / 255.0F,
                    (float) this.rippleColor.getBlue() / 255.0F,
                    (float) this.rippleColor.getBlue() / 255.0F,
                    0.12F
                )
            );
            if (
                this.type == MaterialButtonCircle.Type.FLAT &&
                this.isMouseOver ||
                this.isFocusOwner()
            ) {
                g2.fill(
                    new Float(
                        0.0F,
                        0.0F,
                        (float) (this.getWidth() - 10),
                        (float) (this.getHeight() - 10),
                        100.0F,
                        100.0F
                    )
                );
            }
        } else {
            Color bg = this.getBackground();
            g2.setColor(
                new Color(
                    (float) bg.getRed() / 255.0F,
                    (float) bg.getGreen() / 255.0F,
                    (float) bg.getBlue() / 255.0F,
                    0.6F
                )
            );
            g2.fill(
                new Float(
                    0.0F,
                    0.0F,
                    (float) (this.getWidth() - 10),
                    (float) (this.getHeight() - 10),
                    100.0F,
                    100.0F
                )
            );
        }

        FontMetrics metrics = g.getFontMetrics(this.getFont());
        int x =
            (this.getWidth() - 10 - metrics.stringWidth(this.getText().toUpperCase())) /
            2;
        int y = (this.getHeight() - 10 - metrics.getHeight()) / 2 + metrics.getAscent();
        g2.setFont(this.getFont());
        if (this.isEnabled()) {
            g2.setColor(this.getForeground());
        } else {
            Color fg = this.getForeground();
            g2.setColor(
                new Color(
                    (float) fg.getRed() / 255.0F,
                    (float) fg.getGreen() / 255.0F,
                    (float) fg.getBlue() / 255.0F,
                    0.6F
                )
            );
        }

        g2.drawString(this.getText().toUpperCase(), x, y);
        if (this.isEnabled()) {
            g2.setClip(
                new Float(
                    0.0F,
                    0.0F,
                    (float) (this.getWidth() - 10),
                    (float) (this.getHeight() - 10),
                    100.0F,
                    100.0F
                )
            );
            g2.setColor(this.rippleColor);
            this.ripple.paint(g2);
        }

        int width = this.getWidth() / 2;
        int height = this.getHeight() / 2;
        int paddingTop = width / 3;
        int paddingLeft = width / 3;
        g2.drawImage(this.image, paddingLeft, paddingTop, width, height, this);
        g2.dispose();
    }

    public enum Type {
        DEFAULT,
        RAISED,
        FLAT;

        Type() {}
    }
}
