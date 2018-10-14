package RPIS61.Ivliev.wdad.learn.xml;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "tariffs")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tariffs {
    @XmlElement(name = "coldwater")
    double coldwater;


    public double getColdwater() {
        return coldwater;
    }




    public void setColdwater(double coldwater) {
        this.coldwater = coldwater;
    }

    @XmlElement(name="electricity")
    double electricity;
    public void setElectricity(double electricity) {
        this.electricity = electricity;
    }

    public double getElectricity() {
        return electricity;
    }






    @XmlElement(name="gas")
    double gas;
    public void setGas(double gas) {
        this.gas = gas;
    }
    public double getGas() {
        return gas;
    }

    @XmlElement(name="hotwater")
    double hotwater;
    public void setHotwater(double hotwater) {
        this.hotwater = hotwater;
    }
    public double getHotwater() {
        return hotwater;
    }
}
