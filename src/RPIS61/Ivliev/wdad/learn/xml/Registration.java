package RPIS61.Ivliev.wdad.learn.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Registration {

    @XmlElement(name = "coldwater")
    double coldwater;

    @XmlElement(name="hotwater")
    double hotwater;

    @XmlElement(name="electricity")
    double electricity;

    @XmlElement(name="gas")
    double gas;

    @XmlAttribute(name = "month")
    int month;

    @XmlAttribute(name = "year")
    int year;

    public Registration(double coldwater,double hotwater,double electricity,double gas, int month,int year){
        this.coldwater=coldwater;
        this.electricity=electricity;
        this.hotwater=hotwater;
        this.gas = gas;

        this.month=month;
        this.year=year;
    }

    public Registration(){

    }


}
