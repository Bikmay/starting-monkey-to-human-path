package RPIS61.Ivliev.wdad.learn.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Tariffs {
    @XmlElement(name = "coldwater")
    double coldwater;

    @XmlElement(name="hotwater")
    double hotwater;

    @XmlElement(name="electricity")
    double electricity;

    @XmlElement(name="gas")
    double gas;



    public void setColdwater(double coldwater) {
        this.coldwater = coldwater;
    }

    public void setElectricity(double electricity) {
        this.electricity = electricity;
    }

    public void setGas(double gas) {
        this.gas = gas;
    }

    public void setHotwater(double hotwater) {
        this.hotwater = hotwater;
    }
}
