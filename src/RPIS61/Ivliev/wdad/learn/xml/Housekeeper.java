package RPIS61.Ivliev.wdad.learn.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;
import java.util.List;

@XmlRootElement(name = "housekeeper")
@XmlAccessorType(XmlAccessType.FIELD)
public class Housekeeper {

    @XmlElement(name = "tariffs")
    Tariffs tariffs;

    @XmlElement(name="building")
    List<Building> buildings;


public Housekeeper(){

}

    public static void main(String[] args) throws JAXBException, IOException {


    }

    public static Housekeeper getRoot() throws JAXBException, IOException {
        JAXBContext jc = JAXBContext.newInstance(Housekeeper.class);
        InputStream is = new FileInputStream("xmlTask.xml");
        Unmarshaller um = jc.createUnmarshaller();
        Housekeeper root=(Housekeeper)um.unmarshal(is);
        is.close();

        return root;
    }

    public double getBill(String street, int buildingNumber,int flatNumber) throws JAXBException, IOException {

        int sum=0;

        Housekeeper root=getRoot();
        Flat flat;
        for (int i = 0; i <root.buildings.size() ; i++) {

                if(root.buildings.get(i).street.equals(street) && root.buildings.get(i).number==buildingNumber){
                    for (int j= 0; j <root.buildings.get(i).flats.size() ; j++) {
                        if(root.buildings.get(i).flats.get(j).number == flatNumber){
                            flat=buildings.get(i).getFlat(j);
                            sum+=flat.getMonthSend("coldwater")*root.tariffs.coldwater;
                            sum+=flat.getMonthSend("electricity")*root.tariffs.electricity;
                            sum+=flat.getMonthSend("gas")*root.tariffs.gas;
                            sum+=flat.getMonthSend("hotwater")*root.tariffs.hotwater;
                            return sum;
                        }
                    }
                }

        }

        return 0;
    }

    public void setTarif(String tarifName, double newValue) throws JAXBException, IOException {

        Housekeeper root = this;
        switch (tarifName){
            case "coldwater":
                root.tariffs.setColdwater(newValue);
                break;
            case "hotwater":
                root.tariffs.setHotwater(newValue);
                break;

            case "electricity":
                root.tariffs.setElectricity(newValue);
                break;
            case "gas":
                root.tariffs.setGas(newValue);
                break;
            default:
                break;
        }
        writer(root);
    }


    public void addRegistration(String street,int buildingNumber,int flatNumber,int year, int month,double coldWater,double hotWater,double electricity,double gas) throws JAXBException, IOException {

        Registration registration = new Registration(coldWater,hotWater,electricity,gas,month,year);
        Housekeeper root = this;
        root.getFlat(street,buildingNumber,flatNumber).setNewRegistration(coldWater,hotWater,electricity,gas,month,year);

        writer(root);

    }

    private void writer(Housekeeper root) throws JAXBException, IOException {
        JAXBContext jc= JAXBContext.newInstance(Housekeeper.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        OutputStream os = new FileOutputStream("xmlTask.xml");
        m.marshal(root,os);
        os.close();
    }

    public Flat getFlat(String street,int buildingNumber,int flatNumber){
        for (Building building : buildings) {
            if (building.street.equals(street) && building.number == buildingNumber) {
                return building.findFlat(flatNumber);
            }
        }
        return null;
    }

    public Building getBuilding(String street, int buildingNumber){
        for (Building building : this.buildings) {
            if (building.number == buildingNumber && building.street.equals(street)) {
                return building;
            }
        }
        return null;
    }

}
