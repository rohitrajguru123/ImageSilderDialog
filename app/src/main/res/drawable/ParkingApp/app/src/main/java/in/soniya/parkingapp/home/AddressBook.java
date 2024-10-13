package in.soniya.parkingapp.home;

public class AddressBook {


    public void AddressBook(){

    }

    String Slot, vehicle, Time,phone;

    public AddressBook(String Slot, String vehicle,  String Time,String phone) {
        this.Slot = Slot;
        this.vehicle = vehicle;
        this.Time = Time;
        this.phone = phone;
    }

    public String getSlot() {
        return Slot;
    }

    public void setSlot(String Slot) {
        this.Slot = Slot;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }


    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}