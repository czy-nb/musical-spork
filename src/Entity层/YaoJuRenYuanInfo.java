package Entity��;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class YaoJuRenYuanInfo {
	String ID;//������Ա���
	String zhanghao;//��½�˺�
	String passwords;//��½����
	String name;//����
	public String getID() {
		return ID;
	}
	public String getZhanghao() {
		return zhanghao;
	}
	public String getPasswords() {
		return passwords;
	}
	public String getName() {
		return name;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}
	public void setName(String name) {
		this.name = name;
	}
	}

