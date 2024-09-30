import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HospitalManagementSystem {
    static List<String[]> patients = new ArrayList<>();
    static List<String[]> doctors = new ArrayList<>();
    static List<String[]> hos = new ArrayList<>();
    static List<String> hos_dep = new ArrayList<>();
    static List<String> facilities = new ArrayList<>();

    public static void main(String[] args) {
        facilities.add("ICU");
        facilities.add("Operation Theater");
        facilities.add("Emergency Services");
        facilities.add("Lab Testing");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of times you want to test for: ");
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            userChoice(sc);
        }
        sc.close();
    }

    public static void userChoice(Scanner sc) {
        System.out.println("Welcome To My Hospital Management System");
        System.out.println("1.Patient Details\n2.Doctor Details\n3.Hospital Details\n4.Add new Patient");
        System.out.println("5.Add new Doctor\n6.Admin\n7.Add Hospital\n8.Add Department\n9.Available Facilities");
        System.out.print("Enter your choice: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume the newline character
        switch (n) {
            case 1:
                System.out.print("Enter Patient Id: ");
                int patient_id = sc.nextInt();
                patientSearch(patient_id);
                break;
            case 2:
                System.out.print("Enter Doctor Id: ");
                int doctor_id = sc.nextInt();
                doctorSearch(doctor_id);
                break;
            case 3:
                hospitalDetails(sc);
                break;
            case 4:
                addPatient(sc);
                break;
            case 5:
                addDoctor(sc);
                break;
            case 6:
                System.out.print("Enter Username: ");
                String userName = sc.nextLine();
                System.out.print("Enter Password: ");
                String password = sc.nextLine();
                if (userName.equals("admin") && password.equals("2983")) {
                    admin();
                } else {
                    System.out.println("You are not an admin! Access Denied");
                }
                break;
            case 7:
                addHospital(sc);
                break;
            case 8:
                addDepartment(sc);
                break;
            case 9:
                facilityInfo();
                break;
            case 10:
                System.out.print("Enter your choice: ");
                int m = sc.nextInt();
                sc.nextLine(); // consume the newline character
                if (m == 1) {
                    contactDetails();
                } else if (m == 2) {
                    contactService();
                } else {
                    System.out.println("Invalid input! Try Again");
                }
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input! Try Again");
                break;
        }
    }

    public static void patientSearch(int patient_id) {
        if (!patients.isEmpty()) {
            boolean found = false;
            for (String[] patient : patients) {
                if (Integer.parseInt(patient[0]) == patient_id) {
                    System.out.println("Patient ID: " + patient[0]);
                    System.out.println("Patient Name: " + patient[1]);
                    System.out.println("Patient Age: " + patient[2]);
                    System.out.println("Patient Gender: " + patient[3]);
                    System.out.println("Disease: " + patient[4]);
                    System.out.println("Patient Address: " + patient[5]);
                    System.out.println("Patient Mobile Number: " + patient[6]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("No Patient Available");
            }
        } else {
            System.out.println("No Patient Available");
        }
    }

    public static void doctorSearch(int doctor_id) {
        if (!doctors.isEmpty()) {
            boolean found = false;
            for (String[] doctor : doctors) {
                if (Integer.parseInt(doctor[0]) == doctor_id) {
                    System.out.println("Doctor ID: " + doctor[0]);
                    System.out.println("Doctor Name: " + doctor[1]);
                    System.out.println("Specialization: " + doctor[2]);
                    System.out.println("Doctor Age: " + doctor[3]);
                    System.out.println("Doctor Gender: " + doctor[4]);
                    System.out.println("Doctor Address: " + doctor[5]);
                    System.out.println("Doctor Mobile Number: " + doctor[6]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("No Doctor Available");
            }
        } else {
            System.out.println("No Doctor Available");
        }
    }

    public static void addPatient(Scanner sc) {
        System.out.println("Register Here As New Patient");
        System.out.print("Enter Patient Id: ");
        String id = sc.nextLine();
        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Patient Age: ");
        String age = sc.nextLine();
        System.out.print("Enter Patient Gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();
        System.out.print("Enter Patient Address: ");
        String add = sc.nextLine();
        System.out.print("Enter Patient Mobile Number: ");
        String mob = sc.nextLine();
        patients.add(new String[]{id, name, age, gender, disease, add, mob});
        System.out.println("Patient Data Updated!!!");
    }

    public static void addDoctor(Scanner sc) {
        System.out.println("Register Here As New Doctor");
        System.out.print("Enter Doctor Id: ");
        String id = sc.nextLine();
        System.out.print("Enter Doctor Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = sc.nextLine();
        System.out.print("Enter Doctor Age: ");
        String age = sc.nextLine();
        System.out.print("Enter Doctor Gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter Doctor Address: ");
        String add = sc.nextLine();
        System.out.print("Enter Doctor Mobile Number: ");
        String mob = sc.nextLine();
        doctors.add(new String[]{id, name, specialization, age, gender, add, mob});
        System.out.println("Doctor Data Updated!!!");
    }

    public static void hospitalDetails(Scanner sc) {
        System.out.print("Enter Hospital Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Hospital Address: ");
        String add = sc.nextLine();
        System.out.print("Enter Hospital Mobile Number: ");
        String mob = sc.nextLine();
        System.out.print("Enter Department Name: ");
        String dep_name = sc.nextLine();
        String dep_tuple = String.join(",", dep_name.split(","));
        hos.add(new String[]{name, add, mob, dep_tuple});
        System.out.println("Hospital Data Updated!!!");
    }

    public static void addHospital(Scanner sc) {
        System.out.println("Register Here As New Hospital");
        System.out.print("Enter Hospital Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Hospital Address: ");
        String add = sc.nextLine();
        System.out.print("Enter Hospital Mobile Number: ");
        String mob = sc.nextLine();
        System.out.print("Enter Department Name: ");
        String dep_name = sc.nextLine();
        String dep_tuple = String.join(",", dep_name.split(","));
        hos.add(new String[]{name, add, mob, dep_tuple});
        System.out.println("Hospital Data Updated!!!");
    }

    public static void addDepartment(Scanner sc) {
        System.out.println("Enter Department Details");
        System.out.print("Enter Department Name: ");
        String name = sc.nextLine();
        hos_dep.add(name);
        System.out.println("Department Data Updated!!!");
    }

    public static void facilityInfo() {
        System.out.println("List of Available Facilities:");
        for (String facility : facilities) {
            System.out.println(facility);
        }
    }

    public static void admin() {
        System.out.println("Welcome Admin!");
        // Admin-specific functionalities can be added here
    }

    public static void contactDetails() {
        System.out.println("Contact Details: Placeholder for actual contact details.");
    }

    public static void contactService() {
        System.out.println("Contact Service: Placeholder for actual contact service.");
    }
}