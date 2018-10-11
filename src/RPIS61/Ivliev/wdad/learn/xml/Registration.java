package RPIS61.Ivliev.wdad.learn.xml;

import javax.xml.bind.annotation.XmlElement;

public class Registration {

    @XmlElement(name = "coldwater")
    int coldwater;

    @XmlElement(name="hotwater")
    int hotwater;

    @XmlElement(name="electricity")
    int electricity;

    @XmlElement(name="gas")
    int gas;



}
