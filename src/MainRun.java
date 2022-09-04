import entity.MonHoc;
import entity.QLBangDiem;
import entity.SinhVien;
import DBEngine.DBEngine;

import java.io.*;
import java.util.Scanner;
import java.util.ServiceLoader;

public class MainRun {

    private static QLBangDiem qlbd;
    private static DBEngine db=new DBEngine();

    private static SinhVien[] SINHVIEN=new SinhVien[100];
    private static MonHoc[] MONHOC=new MonHoc[100];

    private static QLBangDiem[] QLBANGDIEM=new QLBangDiem[100];


    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu(){
        while (true){
            int functionChoice=functionChoice();
            switch (functionChoice){
                case 1:
                    NhapMonhoc();
                    break;
                case 2:
                    HienThiMonHoc();
                    break;
                case 3:
                    NhapSinhVien();
                    break;
                case 4:
                    HienThiSinhVien();
                    break;
                case 5:
                    try {
                        qlbd.InputDiem();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;

            }
        }
    }

    private static int functionChoice(){
        Scanner sc=new Scanner(System.in);
        System.out.println("========= Chương trình quản lý điểm sinh viên ============ ");
        System.out.println("1.Nhập danh sách môn học mới");
        System.out.println("2.Hiển thị danh sách môn học");
        System.out.println("3.Nhập danh sách sinh vien mới");
        System.out.println("4.Hiển thị danh sách sinh vien");
        System.out.println("5.Kê khai giảng dạy");
        System.out.println("6.Bảng kê khai giảng dạy");
        System.out.println("7.Sắp xếp danh sách kê khai theo tên");
        System.out.println("8.Sắp xếp danh sách kê khai theo số tiết");
        System.out.println("9.Bảng tiền công cho giảng viên ");
        System.out.println("10.Thoát");
        System.out.println("Mời bạn chọn: ");
        int choice=-1;
        do {
            choice=sc.nextInt();
            if(choice<9&&choice>=1){
                break;
            }
        }while (choice>9||choice<1);
        return choice;

    }



    private static void NhapMonhoc(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số môn học muốn thêm");
        int slmonhoc=sc.nextInt();
        MonHoc[] monHocArr =  new MonHoc[slmonhoc];
        for (int i = 0; i < slmonhoc; i++) {
            System.out.println("Nhập thông tin môn học thứ "+i+" : ");
            MonHoc monHoc=new MonHoc();
            monHoc.nhapThongTinMonHoc();
            monHocArr[i] = monHoc;
        }
            //lưu thông tin môn học
            try {

                db.LuuFileMonHoc("src/Data/MonHoc.txt",monHocArr);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

    }

    private static void HienThiMonHoc(){
        try {
            db.docFile("src/Data/MonHoc.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void NhapSinhVien(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số lượng sinh viên muốn thêm: ");
        int slsinhvien=sc.nextInt();
        SinhVien[] sinhVienArr =  new SinhVien[slsinhvien];
        for (int i = 0; i < slsinhvien; i++) {
            System.out.println("Nhập thông tin sinh viên thứ "+i+":");
            SinhVien sv=new SinhVien();
            sv.nhapThongTinSV();
            sinhVienArr[i]=sv;

        }
        //Save thông tin sinh viên
        try {
            db.LuuFileSinhVien("src/Data/SinhVien.txt",sinhVienArr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void HienThiSinhVien(){
        try {
            db.docFile("src/Data/SinhVien.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }





//    private static void CreateQLBangDiem(){
//        Scanner sc=new Scanner(System.in);
////        if(!CheckData()){
////            System.out.println("Hiện tại chưa có danh sách, vui lòng thêm dữ liêu");
////            return;
////        }
//        System.out.print("Nhập số lượng sinh viên muốn nhập điểm:");
//        int slnhapdiem=sc.nextInt();
//        QLBangDiem[] qlbd=new QLBangDiem[slnhapdiem];
//        for (int i = 0; i < slnhapdiem; i++) {
//            QLBangDiem qlBangDiem=new QLBangDiem();
//            SinhVien sv=;
//
//            qlkkgd.setGiangVien(gv);
//
//            ChiTietGiangDay[] chiTietGiangDays=CreateChiTietGiangDay();
//            qlkkgd.setChiTietGiangDay(chiTietGiangDays);
//            //lưu kê khai
//
//            SaveQLGD(qlkkgd);
//
//
//        }
//    }
//
//    private static SinhVien nhapSinhVienNhapDiem(int index){
//        Scanner sc=new Scanner(System.in);
//        System.out.print("Nhập mã sinh viên thứ "+(index+1)+"muốn kê khai:");
//        int maSV;
//        SinhVien sinhVien;
//        do {
//            maSV=sc.nextInt();
//            sinhVien=searchGiangVienByID(maGiangVien);
//            if(searchGiangVienByID(maGiangVien)!=null){
//                break;
//            }
//            System.out.println("Không tồn tại mã giảng viên");
//        }while (true);
//
//        return giangVien;
//    }











}
