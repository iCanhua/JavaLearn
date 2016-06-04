package com.scut.fan.Practices;

public class Rect {
	Dbl width,height;
	double area;

	public double getWidth() {
		
		return width.getD();
	}

	public void setWidth(Dbl width) {
		if(width.getD()>0)
		this.width = width;
	}

	public double getHeight() {
		return height.getD();
	}

	public void setHeight(Dbl height) {
		if(height.getD()>0)
		this.height = height;
	}

	public double getArea() {
		return area=width.getD()*height.getD();
	}

	public void setArea(double area) {
		this.area = area;
	}
	
	

}
