package Java201Assignment2.Question1;

import java.util.ArrayList;
import java.util.Objects;

public class TheClinic {

    public static void main(String[] args) {
        ArrayList<Billing> theBills = new ArrayList<>();

        Doctor doctor1 = new Doctor("Dr. Rabia", "Pediatrician,", 200);
        Doctor doctor2 = new Doctor("Dr. Bahmed", "General Practitioner", 150);
        Patient patient1 = new Patient("Mr. Gaddour", "1d5vt65");
        Patient patient2 = new Patient("Mr. Addoun Balhadj", "1s8zc55");

        Billing bil1 = new Billing(doctor1, patient1);
        Billing bil2 = new Billing(doctor2, patient2);

        theBills.add(bil1);
        theBills.add(bil2);

        int totalIncome = 0;
        for (Billing b : theBills) {
            b.DisplayAll();
            System.out.println();
            totalIncome+=b.getBillingAmount();
        }
        System.out.println("The total income from the bills is : $"+totalIncome);

    }

}


class Person{
    private String name;

    public Person(){
        name = "No name yet";
    }

    public Person(String initialName){
        name = initialName;
    }

    public void setName(String newName){
        name = newName;
    }
    public String getName(){
        return name;
    }

    public void Display(){
        System.out.println("Name: "+ name);
    }
    public boolean hasSameName(Person otherPerson){
        return this.name.equalsIgnoreCase(otherPerson.name);
    }
}

class Doctor extends Person {

    String specialty;
    double office_visit_fee;

    // Constructors
    public Doctor() {
        super();
        specialty = "Null";
    }
    public Doctor (String aName) {
        super(aName);
        specialty = "Null";
    }
    public Doctor (String aName, double theOfficeFee) {
        super(aName);
        office_visit_fee = theOfficeFee;// AMA specified minimum wage
        specialty = "Null";
    }
    public Doctor (String aName, String theSpecialty) {
        super(aName);
        specialty = theSpecialty;
    }
    public Doctor (double theOfficeFee, String theSpecialty) {
        super();
        office_visit_fee = theOfficeFee;
        specialty = theSpecialty;
    }
    public Doctor (String aName, String theSpecialty, double theOfficeFee) {
        super(aName);
        office_visit_fee = theOfficeFee;
        specialty = theSpecialty;
    }

    // display methods
    public void DisplayAll() {
        displayName();
        displayOfficeFee();
        displaySpecialty();
    }
    public void displayName()
    {
        super.Display();
    }
    public void displayOfficeFee()
    {
        System.out.println("The Office Fee: $" + getOfficeFee());
    }
    public void displaySpecialty()
    {
        System.out.println("The specialty is: " + getSpecialty());
    }

    // setters and getters
    public void setOfficeFee(double newOfficeFee)
    {
        office_visit_fee = newOfficeFee;
    }
    public void setSpecialty(String newSpecialty)
    {
        specialty = newSpecialty;
    }
    public double getOfficeFee()
    {
        return office_visit_fee;
    }
    public String getSpecialty()
    {
        return specialty;
    }


    // Equals method
    public boolean equals(Doctor otherDoctor)
    {
        return( Objects.equals(this.getName(), otherDoctor.getName())
                 && this.getOfficeFee() == otherDoctor.getOfficeFee()
                 && this.getSpecialty().equalsIgnoreCase(otherDoctor.getSpecialty()));
    }
}

class Patient extends Person {

    String identification_number;

    // Constructors
    public Patient() {
        super();
        identification_number = "1454"; //random number
    }
    public Patient(String initialName) {
        super(initialName);
        identification_number = "1454"; //random number
    }
    public Patient(String name, String identification_number) {
        super(name);
        this.identification_number = identification_number;
    }

    public void Display() {
        super.Display();
        displayIdentificationNumber();
    }

    // Display name: we will use DisplayAll() from parent class
    public void displayName()
    {
        super.Display();
    }

    // Display identification number
    public void displayIdentificationNumber() {
        System.out.println("Identification Number #: " + identification_number);
    }

    // setters and getters
    public void   setIdentificationNumber(String identification_number) {
        this.identification_number = identification_number;
    }
    public String getIdentificationNumber()
    {
        return identification_number;
    }

    // Equals method
    public boolean equals(Patient otherPatient) {
        return(Objects.equals(this.getName(), otherPatient.getName())
                && this.identification_number.equalsIgnoreCase(otherPatient.getIdentificationNumber()));
    }
}

class Billing {

    private String doctor;
    private String patient;
    private double billingAmount;

    // Constructors
    public Billing(Doctor theDoctor, Patient thePatient) {
        doctor = theDoctor.getName();
        patient = thePatient.getName();
        billingAmount = theDoctor.getOfficeFee();
    }

    // display methods
    public void DisplayAll() {
        DisplayDoctorName();
        DisplayPatientName();
        DisplayBillingAmount();
    }
    public void DisplayDoctorName()
    {
        System.out.println("Doctor: " + doctor);
    }
    public void DisplayPatientName()
    {
        System.out.println("Patient: " + patient);
    }
    public void DisplayBillingAmount()
    {
        System.out.println("Billing Amount: $" + billingAmount);
    }


    // setters and getters
    public void setDoctorName(String newDoctor)
    {
        doctor = newDoctor;
    }
    public void setPatientName(String newPatient)
    {
        patient = newPatient;
    }
    public void setBillingAmount(double newBillingAmount)
    {
        billingAmount = newBillingAmount;
    }
    public String getDoctorName()
    {
        return doctor;
    }
    public String getPatientName()
    {
        return patient;
    }
    public double getBillingAmount()
    {
        return billingAmount;
    }

    // Equals method
    public boolean equals(Billing otherBilling) {
        return this.doctor.equalsIgnoreCase(otherBilling.getDoctorName())
                && this.patient.equalsIgnoreCase(otherBilling.getPatientName())
                && this.billingAmount == otherBilling.billingAmount;
    }


}
