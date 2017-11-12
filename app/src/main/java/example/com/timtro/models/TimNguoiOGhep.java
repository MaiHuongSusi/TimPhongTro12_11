package example.com.timtro.models;

/**
 * Created by linh on 9/23/2017.
 */

public class TimNguoiOGhep {
    private String id;
    private String diachi;
    private String sdtlienhe;
    private String giatien;
    private String chitiet;
    private String ten;
    private int tuoi;
    private String gioiTinh;

    public TimNguoiOGhep() {
    }

    public TimNguoiOGhep(String id, String diachi, String sdtlienhe, String giatien, String chitiet, String ten, int tuoi, String gioiTinh) {
        this.id = id;
        this.diachi = diachi;
        this.sdtlienhe = sdtlienhe;
        this.giatien = giatien;
        this.chitiet = chitiet;
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdtlienhe() {
        return sdtlienhe;
    }

    public void setSdtlienhe(String sdtlienhe) {
        this.sdtlienhe = sdtlienhe;
    }

    public String getGiatien() {
        return giatien;
    }

    public void setGiatien(String giatien) {
        this.giatien = giatien;
    }

    public String getChitiet() {
        return chitiet;
    }

    public void setChitiet(String chitiet) {
        this.chitiet = chitiet;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

}