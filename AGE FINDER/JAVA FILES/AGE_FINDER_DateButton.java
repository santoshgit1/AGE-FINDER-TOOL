package project;

import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;

public class AGE_FINDER_DateButton extends JButton 
{
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final TLS2_DateChooser DATE_CHOOSER = new TLS2_DateChooser((JFrame) null, "Select Date");
    private Date date;
//---------------------------------------------------------------
    protected void fireActionPerformed(ActionEvent e) 
    {
        Date newDate = DATE_CHOOSER.select(date);
        if (newDate == null) 
        {
            return;
        }
        setDate(newDate);
    }
//-----------------------------------------
    public AGE_FINDER_DateButton(Date date) 
    {
        super(DATE_FORMAT.format(date));
        this.date = date;
    }
//---------------------------------------
    public AGE_FINDER_DateButton() 
    {
        this(new Date());
    }
//---------------------------------------
    public Date getDate() 
    {
        return date;
    }
//--------------------------------------
    public void setDate(Date date) 
    {
        Date old = this.date;
        this.date = date;
        setText(DATE_FORMAT.format(date));
        firePropertyChange("date", old, date);
    }
}
