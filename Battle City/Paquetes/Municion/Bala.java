package Municion;

import java.awt.Rectangle;
import javax.swing.JLabel;
import General.*;
import Unidades.*;

public abstract class Bala extends GameObject 
{
	protected int ancho,largo;
	protected Tanque miTanque;
	protected int direccion;
	protected boolean vive;
	
	public Bala(int x, int y, int n,Tanque t, int dir)
	{
		super(x,y,n);
		miTanque = t;
		direccion = dir;
		vive = true;
		ancho=16;
		largo=16;
	}
	
	protected void cambiarGrafico(int dir)
	{
		if(this.grafico != null)
		{
			this.grafico.setIcon(this.ColeccionDeImagenes[dir]);
			this.grafico.setBounds(this.pos.x, this.pos.y, ancho, largo);
		}
	}
	
	public JLabel getGrafico()
	{
		if(this.grafico == null)
		{
			this.grafico = new JLabel(ColeccionDeImagenes[0]);
			this.grafico.setBounds(this.pos.x, this.pos.y, ancho, largo);
		}		
		return this.grafico;
	}
	
	public Rectangle getRect()
	{
		return new Rectangle(pos.x, pos.y, this.ancho, this.largo);
	}
	
	public boolean vive()
	{
		return vive;
	}
	
	public void mover()
	{	
		switch (direccion) 
		{
			case 0 : //Arriba
				pos.setLocation(pos.x, pos.y - (14 + miTanque.getVelocidadDis()));
				break;
			case 1 : //Abajo
				pos.setLocation(pos.x, pos.y + (14 + miTanque.getVelocidadDis()));
				break;
			case 2 : //Izquierda
				pos.setLocation(pos.x - (14 + miTanque.getVelocidadDis()), pos.y);
				break;
			case 3 : //Derecha
				pos.setLocation(pos.x + (14 + miTanque.getVelocidadDis()), pos.y);
				break;
		}
		cambiarGrafico(0);
	}
	
	public Tanque getTanque()
	{
		return miTanque;
	}
	
	public void setTanque (Tanque v)
	{
		miTanque=v;
	}	
}
