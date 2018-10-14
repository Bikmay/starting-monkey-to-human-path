package RPIS61.Ivliev.wdad.learn.xml;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

public class TestXmlTask {

    public static boolean testSetTariffs(String tarifName,double value) throws JAXBException, IOException {
        Housekeeper housekeeper = Housekeeper.getRoot();

        switch (tarifName){
            case "coldwater":
                return housekeeper.tariffs.coldwater==value;

            case "hotwater":
                return housekeeper.tariffs.hotwater==value;

            case "electricity":
                return housekeeper.tariffs.electricity==value;

            case "gas":
                return housekeeper.tariffs.gas==value;

            default:
                return false;

        }
    }

    public static boolean testAddRegistrartion(String street,int buildingNumber,int flatNumber,int year, int month) throws JAXBException, IOException {
        Housekeeper housekeeper = Housekeeper.getRoot();
        Building building = housekeeper.getBuilding(street,buildingNumber);

        List<Registration> registrations = building.findFlat(flatNumber).registrations;
        for (int i = 0; i < registrations.size(); i++) {
            if(registrations.get(i).month==month && registrations.get(i).year==year){
                return true;
            }
        }
        return false;
    }

    public static boolean testGetBill(double sum, double needSum){
        return sum==needSum;
    }

}
