package Fabricas;

import java.awt.Point;
import java.util.Random;

import PowerUps.*;

public class FabricaPowerUp implements AbstractFactoryPowerUp {

	private Point [] posibilidades;
	private Random r;
	
	public FabricaPowerUp()
	{
		posibilidades = new Point[5];
		posibilidades[0]= new Point(100,400);
		posibilidades[1]= new Point(460,350);
		posibilidades[2]= new Point(820,400);
		posibilidades[3]= new Point(402,220);
		posibilidades[4]= new Point(522,220);
		r = new Random();
	}
	
	public PowerUp CrearPowerUp1()
	{
		int i = r.nextInt(5);
		PowerUp estrella = new Estrella(posibilidades[i].x,posibilidades[i].y);
		return estrella;
	}
	
	public PowerUp CrearPowerUp2()
	{
		int i = r.nextInt(5);
		PowerUp casco = new Casco(posibilidades[i].x,posibilidades[i].y);
		return casco;
	}

	public PowerUp CrearPowerUp3()
	{
		int i = r.nextInt(5);
		PowerUp pala = new Pala(posibilidades[i].x,posibilidades[i].y);
		return pala;
	}

	public PowerUp CrearPowerUp4()
	{
		int i = r.nextInt(5);
		PowerUp granada = new Granada(posibilidades[i].x,posibilidades[i].y);
		return granada;
	}
	
	public PowerUp CrearPowerUp5()
	{
		int i = r.nextInt(5);
		PowerUp timer = new TimerP(posibilidades[i].x,posibilidades[i].y);
		return timer;
	}
	
	public PowerUp CrearPowerUp6()
	{
		int i = r.nextInt(5);
		PowerUp tanque = new TanqueP(posibilidades[i].x,posibilidades[i].y);
		return tanque;
	}
	
}
