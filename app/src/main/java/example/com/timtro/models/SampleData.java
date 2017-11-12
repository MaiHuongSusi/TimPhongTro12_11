package example.com.timtro.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 19/10/2017.
 */

public class SampleData {
    public static List<TimNguoiOGhep> getSample() {
        List<TimNguoiOGhep> thongtin = new ArrayList<>();
        TimNguoiOGhep timNguoiOGhep1;
        timNguoiOGhep1 = new TimNguoiOGhep();
        timNguoiOGhep1.setDiachi("K82/95 Nguyễn Lương Bằng-Đà Nẵng");
        timNguoiOGhep1.setGiatien("700k/thang");
        timNguoiOGhep1.setChitiet("Free wifi\n Có khóa cổng\n Cho nấu ăn");
        timNguoiOGhep1.setTen("Huỳnh Thị Hiền");
        timNguoiOGhep1.setTuoi(20);
        timNguoiOGhep1.setGioiTinh("Nữ");
        timNguoiOGhep1.setSdtlienhe("01674859362");
        thongtin.add(timNguoiOGhep1);

        TimNguoiOGhep timNguoiOGhep2 = new TimNguoiOGhep();
        timNguoiOGhep2.setDiachi("K47/95 Nguyễn Lương Bằng-Đà Nẵng");
        timNguoiOGhep2.setGiatien("1000k/tháng");
        timNguoiOGhep2.setChitiet(" Free wifi\n Trọ thoáng mát\n Có khóa cổng\n Cho nấu ăn");
        timNguoiOGhep2.setTen("Ngô Anh Tú");
        timNguoiOGhep2.setTuoi(18);
        timNguoiOGhep2.setGioiTinh("Nam");
        timNguoiOGhep2.setSdtlienhe("01672025385");
        thongtin.add(timNguoiOGhep2);

        TimNguoiOGhep timNguoiOGhep3 = new TimNguoiOGhep();
        timNguoiOGhep3.setDiachi("K2/9 Đồng Kè-Liên Chiểu-Đà Nẵng");
        timNguoiOGhep3.setGiatien("900k/tháng");
        timNguoiOGhep3.setChitiet(" Wifi30k/tháng/người\n Có khóa cổng\n Cho nấu ăn");
        timNguoiOGhep3.setTen("Phan Anh Quang");
        timNguoiOGhep3.setTuoi(20);
        timNguoiOGhep3.setGioiTinh("Nam");
        timNguoiOGhep3.setSdtlienhe("01215674839");
        thongtin.add(timNguoiOGhep3);

        TimNguoiOGhep timNguoiOGhep4 = new TimNguoiOGhep();
        timNguoiOGhep4.setDiachi("95 Ngô Sĩ Liên-Liên Chiểu-Đà Nẵng");
        timNguoiOGhep4.setGiatien("850k/tháng");
        timNguoiOGhep4.setChitiet(" Free wifi\n Có khóa cổng\n Cho nấu ăn\n Chủ dể tính");
        timNguoiOGhep4.setTen("Võ Thị Ánh Tuyết");
        timNguoiOGhep4.setTuoi(20);
        timNguoiOGhep4.setGioiTinh("Nữ");
        timNguoiOGhep4.setSdtlienhe("0898567429");
        thongtin.add(timNguoiOGhep4);

        TimNguoiOGhep timNguoiOGhep5 = new TimNguoiOGhep();
        timNguoiOGhep5.setDiachi("K58/6 Phạm Như Xương-Liên Chiểu-Đà Nẵng");
        timNguoiOGhep5.setGiatien("600k/tháng");
        timNguoiOGhep5.setChitiet(" Free wifi\n Có khóa cổng\n Cho nấu ăn");
        timNguoiOGhep5.setTen("Trần Phú Việt Minh");
        timNguoiOGhep5.setTuoi(19);
        timNguoiOGhep5.setGioiTinh("Nam");
        timNguoiOGhep5.setSdtlienhe("0905673892");
        thongtin.add(timNguoiOGhep5);
        return thongtin;
    }
}
