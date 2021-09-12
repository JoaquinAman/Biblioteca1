package vista;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class JTextFieldPlaceHolder extends JTextField implements FocusListener{

	   // Atributos

	    private String placeHolder ="";
	    private Color colorHit = getForeground();
	    private boolean mostrarHit;
	   
	    /**
	     * Constructor
	     * @param placeHolder el texto que va a ir en el placeHolder
	     */
	    public JTextFieldPlaceHolder(String placeHolder) {
	        super(placeHolder);
	        this.placeHolder = placeHolder;
	        this.mostrarHit = true;
	        this.addFocusListener(this);
	        this.setColorHit(new Color(100, 100, 100));
	        this.setForeground(colorHit);
	    }

	    @Override
	    public void focusGained(FocusEvent e) {
	        if(this.getText().isEmpty()){
	            super.setText("");
	            mostrarHit = false;
	        }
	    }

	     @Override
	    public void focusLost(FocusEvent e) {
	         if(this.getText().isEmpty()){
	                super.setText(placeHolder);
	                mostrarHit = true;
	            }
	    }

	     @Override
	    public String getText() {
	        // TODO Auto-generated method stub
	        return mostrarHit ? "": super.getText();
	    }

	    public String getPlaceHolder() {
	        return placeHolder;
	    }
	   
	    public void setPlaceHolder(String placeHolder) {
	        this.placeHolder = placeHolder;
	    }
	   
	    public Color getColorHit() {
	        return colorHit;
	    }
	   
	   public void setColorHit(Color colorHit) {
	        this.colorHit = colorHit;
	    }
	   
	   public boolean isMostrarHit() {
	        return mostrarHit;
	    }
	   
	    public void setMostrarHit(boolean mostrarHit) {
	        this.mostrarHit = mostrarHit;
	    }

	
	}