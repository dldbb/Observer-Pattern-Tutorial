import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ComplementaryColorPanel extends ColorPanel implements PropertyChangeListener {

    public ComplementaryColorPanel(float hue, float saturation, float brightness) {
        super(hue, saturation, brightness);
        DisplayColors.originalColorPanel.addPropertyChangeListener(this);
        /*
        DisplayColors.hueSlider.addChangeListener(this);
        DisplayColors.saturationSlider.addChangeListener(this);
        DisplayColors.brightnessSlider.addChangeListener(this);
        */
    }

    public void propertyChange(PropertyChangeEvent evt) {
        float newHue = DisplayColors.originalColorPanel.getHue() - (float) .5;
        if (newHue < 0){
            newHue += 1;
        }
        Color newColor = Color.getHSBColor(newHue, DisplayColors.originalColorPanel.getSaturation(), DisplayColors.originalColorPanel.getBrightness());
        this.setColor(newColor);
    }
}
