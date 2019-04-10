import com.sun.org.apache.xpath.internal.operations.Or;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;


public class DisplayColors{//} implements ChangeListener {

    public static void main(String[] args) {
        SwingFacade.launch(new DisplayColors().mainPanel(), "Compute Complementary Colors");
    }

    protected static ColorPanel originalColorPanel;
    protected ColorPanel complementaryColorPanel;

    protected static JSlider hueSlider;
    protected static JSlider saturationSlider;
    protected static JSlider brightnessSlider;

    protected JLabel hueValueLabel;
    protected JLabel saturationValueLabel;
    protected JLabel brightnessValueLabel;

    protected JPanel colorsPanel() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 2));
        //originalColorPanel = createOriginalColorPanel(Color.getHSBColor(0, (float) .5, (float) .5));
        originalColorPanel =  new OriginalColorPanel(0, (float) .5, (float) .5);
        originalColorPanel.setPreferredSize(new Dimension(300, 200));
        //originalColorPanel.setHue(0);
        //originalColorPanel.setSaturation((float) .5);
        //originalColorPanel.setBrightness((float) .5);
        p.add(SwingFacade.createTitledPanel("Original Color", originalColorPanel));
        //complementaryColorPanel = createComplementaryColorPanel(Color.getHSBColor((float) .5, (float) .5, (float) .5));
        complementaryColorPanel = new ComplementaryColorPanel((float) .5, (float) .5, (float) .5);
        complementaryColorPanel.setPreferredSize(new Dimension(300, 200));
        p.add(SwingFacade.createTitledPanel("Complementary Color", complementaryColorPanel));
        return p;
    }

    protected JPanel mainPanel() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 1));
        JPanel subP = new JPanel();
        subP.setLayout(new GridLayout(3, 1));
        hueSlider = slider();
        subP.add(sliderBox("H", hueSlider, hueValueLabel));
        saturationSlider = slider();
        saturationSlider.setValue(50);
        subP.add(sliderBox("S", saturationSlider, saturationValueLabel));
        brightnessSlider = slider();
        brightnessSlider.setValue(50);
        subP.add(sliderBox("B", brightnessSlider, brightnessValueLabel));
        //Move the order
        JPanel colorsPanel = colorsPanel();

        p.add(subP);
        p.add(colorsPanel);
        return p;
    }

    private JSlider slider() {
        JSlider slider = new JSlider();
        // WHAT GOES HERE?
        // You need to make it possible for the app to get the slider values out.
        slider.setValue(slider.getMinimum());
        //slider.addChangeListener(this);
        return slider;
    }

    private Box sliderBox(String sliderLabel, JSlider slider, JLabel valueLabel) {
        if (valueLabel == null) {
            valueLabel = new JLabel();
            valueLabel.setFont(SwingFacade.getStandardFont());
            valueLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
            valueLabel.setForeground(Color.black);
        }
        Box b = Box.createHorizontalBox();
        JLabel label = new JLabel(sliderLabel);
        label.setFont(SwingFacade.getStandardFont());
        label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        label.setForeground(Color.black);
        b.add(label);
        b.add(valueLabel);
        b.add(slider);
        b.setPreferredSize(new Dimension(600, 50));
        return b;
    }
/*

    protected OriginalColorPanel createOriginalColorPanel(Color initialColor) {
        OriginalColorPanel colorPanel = new OriginalColorPanel(initialColor);
        colorPanel.setPreferredSize(new Dimension(300, 200));
        return colorPanel;
    }
    protected ComplementaryColorPanel createComplementaryColorPanel(Color initialColor) {
        ComplementaryColorPanel colorPanel = new ComplementaryColorPanel(initialColor);
        colorPanel.setPreferredSize(new Dimension(300, 200));
        return colorPanel;
    }*/
/*
    public void update(OriginalColorPanel original, ComplementaryColorPanel complementary){
        original.changed(hueSlider, saturationSlider, brightnessSlider);
        complementary.changed(hueSlider, saturationSlider, brightnessSlider);
    }

    public void stateChanged(ChangeEvent e) {
        update((OriginalColorPanel) originalColorPanel, (ComplementaryColorPanel) complementaryColorPanel);
    }*/
}


    
