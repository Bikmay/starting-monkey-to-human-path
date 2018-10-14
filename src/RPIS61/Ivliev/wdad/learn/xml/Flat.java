package RPIS61.Ivliev.wdad.learn.xml;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.io.IOException;
import java.util.List;

public class Flat {

    @XmlElement(name="registration")
    List<Registration> registrations;

    @XmlAttribute(name="number")
    int number;

    @XmlAttribute(name="personsquantity")
    int personsquantity;

    @XmlAttribute(name="area")
    int area;


    public Registration getRegistration(int index){
        return this.registrations.get(index);
    }

    public Registration getLastRegistration(){
        return this.registrations.get(registrations.size()-1);
    }

    public void setNewRegistration(double coldwater,double hotwater,double electricity,double gas, int month,int year){
        registrations.add(new Registration(coldwater,hotwater,electricity,gas,month,year));
    }

    public int getCountFlats(){
        return this.registrations.size();
    }
    public double getMonthSend(String tarifName) throws JAXBException, IOException {

        Housekeeper root = Housekeeper.getRoot();
        switch (tarifName){
            case "coldwater":
               return this.getLastRegistration().coldwater-this.getRegistration(this.getCountFlats()-2).coldwater;

            case "hotwater":
                return this.getLastRegistration().hotwater-this.getRegistration(this.getCountFlats()-2).hotwater;

            case "electricity":
                return this.getLastRegistration().electricity-this.getRegistration(this.getCountFlats()-2).electricity;
            case "gas":
                return this.getLastRegistration().gas-this.getRegistration(this.getCountFlats()-2 ).gas;
            default:
                break;
        }
        return 0;
    }

}
