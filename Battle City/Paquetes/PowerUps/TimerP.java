package PowerUps;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import Visitantes.Visitor;

public class TimerP extends PowerUp
{

	public TimerP(int x, int y)
	{
		super(x, y);
		ColeccionDeImagenes[0]=  new ImageIcon(this.getClass().getResource("/Recursos/Timer.gif"));
	}
	
	public void mover(int dir)
	{	
	}
		
	public void setImagen(Icon i , int pos)
	{
		ColeccionDeImagenes[pos] = i;
	}
	
	public boolean colisionarCon(Visitor v) 
	{
		return v.ColisionarTimerP(this);
	}
}
