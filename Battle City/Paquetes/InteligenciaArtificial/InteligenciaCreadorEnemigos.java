package InteligenciaArtificial;

import Fabricas.AbstractFactoryEnemigo;
import Fabricas.FabricaEnemigoNivelUno;
import Game.Juego;
import java.util.Random;
import Unidades.Enemigo;

public class InteligenciaCreadorEnemigos extends Thread {
	
	private AbstractFactoryEnemigo fabricaEnemigo;
	private Juego miJuego;
	private boolean condicion;
	private int cantidad;
	
	public InteligenciaCreadorEnemigos(Juego j){
		fabricaEnemigo=new FabricaEnemigoNivelUno();
		condicion = true;
		miJuego=j;
		cantidad = miJuego.getMalos().size();
	}
	

	public void actualizarCantidad(){
		cantidad = miJuego.getMalos().size(); 
	}
	
	public Enemigo getEnemigo()
	{
		Random r = new Random();
		int i =r.nextInt(4);
		Enemigo res=null ; 
		switch (i){
		case 0:
			res=fabricaEnemigo.CrearEnemigo1();
			break;
		case 1:
			res=fabricaEnemigo.CrearEnemigo2();
			break;
		case 2:
			res=fabricaEnemigo.CrearEnemigo3();
			break;
		case 3:
			res=fabricaEnemigo.CrearEnemigo4();
			break;
		}
		return res;
	}
	
	public void run() {
		while(condicion)
		{
			try 
			{
				Thread.sleep(5000);
			}
			catch (InterruptedException e) {}
			actualizarCantidad();
			
			if (cantidad <= 3)
			{
				miJuego.agregarMalos(getEnemigo());
			}
		}
	}
	
	public void interrumpir(){
		condicion=false;
	}
}