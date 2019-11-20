package Visitantes;

import Municion.*;
import Unidades.*;
import General.*;
import TDALista.*;
import Obstaculos.*;
import PowerUps.*;

import javax.swing.Timer;

import java.awt.event.*;

//import java.util.Timer;
import javax.swing.ImageIcon;

public class ColisionadorBalasJugador extends Visitor
{
	
	protected BalaJugador miBala;
	protected Timer timer;
	
	public ColisionadorBalasJugador(BalaJugador b)
	{
		miBala = b;
	}
	
	public boolean ColisionarParedLadrillo(ParedLadrillo p)
	{
		try
		{
			miBala.destruirBalaJugador();
			miBala.getTanque().getJuego().getGui().actualizar();
			p.setGolpesResis(p.getGolpeResis() - 1);
			if (p.getGolpeResis() == 3)
			{
				p.cambiarGrafico(1);				
			}
			else
				if (p.getGolpeResis() == 2)
				{
					p.cambiarGrafico(2);
				}
				else
					if (p.getGolpeResis() == 1)
					{
						p.cambiarGrafico(3);
					}
					else
						if (p.getGolpeResis() == 0)
						{							
							miBala.getTanque().getJuego().getGui().getPanel1().remove(p.getGrafico());
							boolean encontre= false;
							PositionList<GameObject> todo = miBala.getTanque().getJuego().getTodo();
							PositionList<Obstaculo> obs = miBala.getTanque().getJuego().getObs();
							Position<GameObject> puntero= todo.first();
							Position<Obstaculo> puntero2= obs.first();
							for(int j=0;j<todo.size()&&!encontre;j++){
								encontre=puntero.element()==p;
								if(!encontre)
									puntero=todo.next(puntero);					
							}	
							if(encontre){
								todo.remove(puntero);
								miBala.getTanque().getJuego().setTodo(todo);
							}
							encontre = false;
							for(int j=0;j<obs.size()&&!encontre;j++){
								encontre=puntero2.element()==p;
							if(!encontre)
							puntero2=obs.next(puntero2);					
							}	
							if(encontre){
								obs.remove(puntero2);
								miBala.getTanque().getJuego().setObs(obs);
							}
							p = null;
							miBala.getTanque().getJuego().getGui().actualizar();
							miBala = null;							
						}
		}
		catch (EmptyListException| InvalidPositionException | BoundaryViolationException exc)
		{
			exc.getMessage();
		}
		return true;
	}
	
	public boolean ColisionarParedAcero(ParedAcero pa)
	{
		try
		{
			miBala.destruirBalaJugador();
			miBala.getTanque().getJuego().getGui().actualizar();
			int nivel = miBala.getTanque().getJuego().getJugador().getNumNivel();
			if (nivel == 4)
			{
				pa.setGolpesResis(pa.getGolpeResis() - 1);
				if (pa.getGolpeResis() == 3)
				{
					pa.cambiarGrafico(1);				
				}
				else
					if (pa.getGolpeResis() == 2)
					{
						pa.cambiarGrafico(2);
					}
					else
						if (pa.getGolpeResis() == 1)
						{
							pa.cambiarGrafico(3);
						}
						else
							if (pa.getGolpeResis() == 0)
							{							
								miBala.getTanque().getJuego().getGui().getPanel1().remove(pa.getGrafico());
								boolean encontre= false;
								PositionList<GameObject> todo = miBala.getTanque().getJuego().getTodo();
								PositionList<Obstaculo> obs = miBala.getTanque().getJuego().getObs();
								Position<GameObject> puntero= todo.first();
								Position<Obstaculo> puntero2= obs.first();
								for(int j=0;j<todo.size()&&!encontre;j++){
									encontre=puntero.element()==pa;
									if(!encontre)
										puntero=todo.next(puntero);					
								}	
								if(encontre){
									todo.remove(puntero);
									miBala.getTanque().getJuego().setTodo(todo);
								}
								encontre = false;
								for(int j=0;j<obs.size()&&!encontre;j++){
									encontre=puntero2.element()==pa;
								if(!encontre)
								puntero2=obs.next(puntero2);					
								}	
								if(encontre){
									obs.remove(puntero2);
									miBala.getTanque().getJuego().setObs(obs);
								}
								pa = null;
								miBala.getTanque().getJuego().getGui().actualizar();
								miBala = null;							
							}
			}
		}
		catch (EmptyListException| InvalidPositionException | BoundaryViolationException | IndexOutOfBoundsException exc)
		{
			exc.getMessage();
		}
		return true;
	}
	
	public boolean ColisionarArbol(Arbol a)
	{
		return false;
	}
	
	public boolean ColisionarAgua(Agua a)
	{
		return false;
	}
	
	public boolean ColisionarAguila(Aguila a)
	{
		try
		{
			miBala.getTanque().getJuego().GameOver();
			miBala.destruirBalaJugador();
			miBala.getTanque().getJuego().getGui().actualizar();			
			PositionList<GameObject> todo = miBala.getTanque().getJuego().getTodo();
			PositionList<Obstaculo> obs = miBala.getTanque().getJuego().getObs();
			Position<GameObject> puntero = todo.first();
			Position<Obstaculo> puntero2 = obs.first();
			boolean encontre = false;
			for(int j=0;j<todo.size()&&!encontre;j++){
				encontre=puntero.element()==a;
				if(!encontre)
					puntero=todo.next(puntero);					
			}	
			if(encontre){
				todo.remove(puntero);
				miBala.getTanque().getJuego().setTodo(todo);
			}
			encontre = false;
			for(int j=0;j<obs.size()&&!encontre;j++){
				encontre=puntero2.element()==a;
				if(!encontre)
					puntero2=obs.next(puntero2);					
			}	
			if(encontre){
				obs.remove(puntero2);
				miBala.getTanque().getJuego().setObs(obs);
			}
			miBala.getTanque().getJuego().getGui().getPanel1().remove(a.getGrafico());
			a = null;
			miBala = null;
		}
		catch (EmptyListException | InvalidPositionException | BoundaryViolationException | IndexOutOfBoundsException exc)
		{
			exc.getMessage();
		}
		return true;		
	}
	
	public boolean ColisionarBloqueo(Bloqueo b)
	{
		try
		{
			miBala.destruirBalaJugador();
			miBala.getTanque().getJuego().getGui().actualizar();
			miBala = null;			
		}
		catch(IndexOutOfBoundsException exc)
		{
			exc.getMessage();
		}
		return true;
	}
	
	public boolean ColisionarEstrella(Estrella e)
	{
		return false;
	}
	
	public boolean ColisionarCasco(Casco c)
	{
		return false;
	}
	
	public boolean ColisionarGranada(Granada g)
	{
		return false;
	}
	
	public boolean ColisionarPala(Pala p)
	{
		return false;
	}
	
	public boolean ColisionarTanqueP(TanqueP t)
	{
		return false;
	}
	
	public boolean ColisionarTimerP(TimerP t)
	{
		return false;
	}
	
	public boolean ColisionarTanqueEnemigo(Enemigo t)
	{
		try
		{	
			crearTimer(t);
			miBala.destruirBalaJugador();
			t.setGolpesResis(t.getGolpesResis() - 1);
			if (t.getGolpesResis() == 0)
			{
				miBala.getTanque().getJuego().setEnemigosAct(miBala.getTanque().getJuego().getEnemigosAct() - 1);
				miBala.getTanque().getJuego().getGui().setLabelActuales(miBala.getTanque().getJuego().getEnemigosAct()+"");
				miBala.getTanque().getJuego().setMuertes(miBala.getTanque().getJuego().getMuertes() + 1);
				miBala.getTanque().getJuego().getGui().setLabelMuertes(miBala.getTanque().getJuego().getMuertes()+"");
				if (miBala.getTanque().getJuego().getMuertes() == 16)
				{
					miBala.getTanque().getJuego().ganar();
				}
				else
					if (miBala.getTanque().getJuego().getMuertes() % 4 == 0)
					{
						miBala.getTanque().getJuego().insertarPowerUp();
					}
				cambiarLabel(t);
				miBala.getTanque().getJuego().getGui().actualizar();
				int puntajeViejo = miBala.getTanque().getJuego().getPuntaje();
				miBala.getTanque().getJuego().setPuntaje(miBala.getTanque().getJuego().getPuntaje() + t.getPuntaje());
				int puntajeNuevo = miBala.getTanque().getJuego().getPuntaje();
				if (puntajeViejo < 5000 && puntajeNuevo >= 5000)
				{
					miBala.getTanque().getJuego().getJugador().setVida(miBala.getTanque().getJuego().getJugador().getVida() + 1);
					miBala.getTanque().getJuego().getGui().setLabelVidas(miBala.getTanque().getJuego().getJugador().getVida()+"");
				}
				miBala.getTanque().getJuego().getGui().setLabelPuntaje(miBala.getTanque().getJuego().getPuntaje()+"");
				boolean encontre = false;
				PositionList<GameObject> todo = miBala.getTanque().getJuego().getTodo();
				Position<GameObject> puntero = todo.first();
				for(int j = 0; j < todo.size() && !encontre; j++)
				{
					encontre = puntero.element() == t;
					if(!encontre)
					puntero = todo.next(puntero);					
				}	
				if(encontre)
				{
					todo.remove(puntero);
					miBala.getTanque().getJuego().setTodo(todo);
				}
				encontre = false;
				PositionList<Enemigo> malos = miBala.getTanque().getJuego().getMalos();
				Position<Enemigo> puntero1 = malos.first();
				for(int j = 0; j < malos.size() && !encontre; j++)
				{
					encontre = puntero1.element() == t;
					if(!encontre)
					puntero1 = malos.next(puntero1);					
				}	
				if(encontre)
				{
					malos.remove(puntero1);
					miBala.getTanque().getJuego().setMalos(malos);
				}				
			}
				t = null;					
				miBala = null;			
		}
		catch (EmptyListException| InvalidPositionException | BoundaryViolationException | IndexOutOfBoundsException exc)
		{
			exc.getMessage();
		}
		return true;
	}
	
	public boolean ColisionarTanqueJugador(Jugador j)
	{
		return true;
	}
	
	public boolean ColisionarJugadorInvulnerable(JugadorInvulnerable j){
		return true;
	}
	
	public boolean ColisionarBalaJugador(BalaJugador t)
	{	
		return false;
	}
	
	public boolean ColisionarBalaEnemigo(BalaEnemigo t)
	{
		try
		{
			miBala.destruirBalaJugador();
			t.destruirBalaEnemigo();
			miBala.getTanque().getJuego().getGui().getPanel1().remove(t.getGrafico());
			miBala.getTanque().getJuego().getGui().actualizar();
			miBala = null;
		}
		catch(IndexOutOfBoundsException exc)
		{
			exc.getMessage();
		}
		return true;
	}
	
	private void crearTimer(Enemigo ene) {
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ene.getGrafico().setIcon(null);
			}
		});
		timer.setRepeats(false);
	}
	
	private void cambiarLabel(Enemigo ene) {
		ImageIcon sangre = new ImageIcon(getClass().getResource("/Recursos/Sangre.gif"));
		ene.getGrafico().setIcon(sangre);
		timer.restart();
	}
}
