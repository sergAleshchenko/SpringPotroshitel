package screensaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @author Sergei Aleshchenko
 * @project SpringPotroshitel
 */
@Component
public abstract class ColorFrame extends JFrame {
    public ColorFrame() {
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(2400), random.nextInt(1000));
        getContentPane().setBackground(getColor());
        repaint();
    }

    protected abstract Color getColor();
}
