package example.com.timtro.models;

/**
 * Created by Administrator on 23/09/2017.
 */

public class PhongTro {
    private  String id;
    private String diachi;
    private String sdtlienhe;
    private String giatien;
    private String chitiet;
    private String dientich;

    public PhongTro() {
    }

    public PhongTro(String diachi, String sdtlienhe, String giatien, String chitiet, String dientich) {
        this.diachi = diachi;
        this.sdtlienhe = sdtlienhe;
        this.giatien = giatien;
        this.chitiet = chitiet;
        this.dientich = dientich;
    }

    public String getDientich() {
        return dientich;
    }

    public void setDientich(String dientich) {
        this.dientich = dientich;
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
}



