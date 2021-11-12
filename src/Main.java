import model.Phonebook;
import service.ManagePhonebook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagePhonebook managePhonebook = new ManagePhonebook();
        int choice;
        do {
            System.out.println("1: Thêm danh bạ");
            System.out.println("2: Sửa danh bạ");
            System.out.println("3: Xóa danh bạ");
            System.out.println("4: Xem danh sách danh bạ");
            System.out.println("5: Tìm kiếm danh bạ");
            System.out.println("6: Đọc từ file");
            System.out.println("7: Ghi từ file");
            System.out.println("0: Thoát");

            System.out.println("nhập lựa chọn của bạn");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> managePhonebook.add(input());
                case 2 -> {
                    System.out.println("nhập tên bạn muốn sửa trong danh bạ");
                    String nameUpdate = scanner.nextLine();
                    System.out.println("nhập tên");
                    String nameWantToFix = scanner.nextLine();
                    System.out.println("nhập số điện thoại");
                    String numberWantToFix = scanner.nextLine();
                    System.out.println("nhập nhóm");
                    String groupWantToFix = scanner.nextLine();
                    System.out.println("nhập giới tính");
                    String sexWantToFix = scanner.nextLine();
                    System.out.println("nhập địa chỉ");
                    String addressWantToFix = scanner.nextLine();
                    managePhonebook.update(nameUpdate,new Phonebook(numberWantToFix,groupWantToFix,nameWantToFix,sexWantToFix,addressWantToFix));
                }
                case 3 ->{
                    System.out.println("nhập tên muốn xóa");
                    String deleteName = scanner.nextLine();
                    managePhonebook.delete(deleteName);
                }
                case 4 ->{
                    managePhonebook.display();
                }
                case 5 ->{
                    System.out.println("nhập tên muốn tìm");
                    scanner.nextLine();
                    String nameWantToFind = scanner.nextLine();
                    managePhonebook.findByName(nameWantToFind);
                    System.out.println(managePhonebook.findByName(nameWantToFind));
                }
            }
        } while (choice != 0);
    }

    public static Phonebook input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập số điện thoại");
        String newNumber = scanner.nextLine();
        System.out.println("nhập nhóm ");
        String newGroup = scanner.nextLine();
        System.out.println("nhập tên ");
        String newName = scanner.nextLine();
        System.out.println("nhập giới tính");
        String newSex = scanner.nextLine();
        System.out.println("nhập địa chỉ");
        String newAddress = scanner.nextLine();
        return new Phonebook(newNumber, newGroup, newName, newSex, newAddress);
    }
}
