package pojo;

import java.util.Date;

public class Order {
	private int id;
	private String username;
	private String sanpham;
	private Date thoigian;
	private int soluong;
	private int idProduct;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSanpham() {
		return sanpham;
	}
	public void setSanpham(String sanpham) {
		this.sanpham = sanpham;
	}
	public Date getThoigian() {
		return thoigian;
	}
	public void setThoigian(Date thoigian) {
		this.thoigian = thoigian;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public void Order(){
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
}
