package Game;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import General.GameObject;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Obstaculos.Obstaculo;
import TDALista.PositionList;
import Unidades.Enemigo;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;

public class GUI extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;	
	private Juego j;
	private CargadorMapa cm;
	PositionList<Obstaculo> listaObs;
	PositionList<Enemigo> listaEne;
	PositionList<GameObject> listaTodo;
	PositionList<Obstaculo> listaBorde;
	protected KeyListener e;
	protected JPanelConFondo panel;
	protected JPanel panel_1;
	private JLabel lblVidas;
	private JLabel lblEnemigosEliminados;
	private JLabel lblEneActuales;
	JLabel Puntaje;
	JLabel Muertes;
	JLabel Actuales;
	JLabel Vidas;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		e = new KeyInput(this);
		addKeyListener(e);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(105,5,1150,730);
		setBackground(Color.GRAY);
		this.setTitle("Battle City");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.GRAY);
		this.setResizable(false);
		setContentPane(contentPane);		
		//Panel Juego
		panel = new JPanelConFondo("/Recursos/Fondo.gif");
		panel.setBackground(Color.BLACK);
		panel.setBounds(100,25,965, 688);
			
		//Panel Informacion
		panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 960, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(66, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 661, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JLabel lblPuntaje = new JLabel("Puntaje");
		lblPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntaje.setFont(new Font("Arial", Font.PLAIN, 20));
		
		lblVidas = new JLabel("Vidas");
		lblVidas.setHorizontalAlignment(SwingConstants.CENTER);
		lblVidas.setFont(new Font("Arial", Font.PLAIN, 20));
		
		lblEnemigosEliminados = new JLabel("Muertes");
		lblEnemigosEliminados.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnemigosEliminados.setFont(new Font("Arial", Font.PLAIN, 20));
		
		lblEneActuales = new JLabel("Enemigos");
		lblEneActuales.setHorizontalAlignment(SwingConstants.CENTER);
		lblEneActuales.setFont(new Font("Arial", Font.PLAIN, 20));
		
		Puntaje = new JLabel("0");
		Puntaje.setHorizontalAlignment(SwingConstants.CENTER);
		Puntaje.setFont(new Font("Arial", Font.PLAIN, 22));
		
		Vidas = new JLabel("0");
		Vidas.setHorizontalAlignment(SwingConstants.CENTER);
		Vidas.setFont(new Font("Arial", Font.PLAIN, 22));
		
		Muertes = new JLabel("0");
		Muertes.setHorizontalAlignment(SwingConstants.CENTER);
		Muertes.setFont(new Font("Arial", Font.PLAIN, 22));
		
		Actuales = new JLabel("0");
		Actuales.setHorizontalAlignment(SwingConstants.CENTER);
		Actuales.setFont(new Font("Arial", Font.PLAIN, 22));
		JLabel grafico = new JLabel();
		grafico.setIcon(new ImageIcon(this.getClass().getResource("/Recursos/Titulo.jpg")));
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(Puntaje, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
							.addGap(12))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(Muertes, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEnemigosEliminados, Alignment.TRAILING)
								.addComponent(Vidas, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
							.addGap(24))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(grafico)
							.addContainerGap(98, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(7)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(10)
									.addComponent(Actuales, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblEneActuales, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
							.addGap(17))))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(22)
					.addComponent(lblPuntaje, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(117, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(48, Short.MAX_VALUE)
					.addComponent(lblVidas)
					.addGap(37))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(31)
					.addComponent(lblPuntaje, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(Puntaje)
					.addGap(44)
					.addComponent(lblVidas)
					.addGap(18)
					.addComponent(Vidas, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addComponent(lblEnemigosEliminados)
					.addGap(18)
					.addComponent(Muertes, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(lblEneActuales)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(Actuales, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
					.addComponent(grafico)
					.addGap(25))
		);
		panel_1.setLayout(gl_panel_1);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 382, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 628, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		
		//Creo el juego
		cm = new CargadorMapa();
		listaObs = cm.getObs();
		listaEne = cm.getEne();
		listaTodo = cm.getTodo();
		listaBorde = cm.getBorde();
		j = new Juego(this, listaObs, listaEne, listaTodo, listaBorde,cm.getBase());		
		panel.setVisible(true);	
		
	}
	
	public synchronized void actualizar()
	{
		try
		{
			this.repaint();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			e.getMessage();
		}
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP)
		{
			j.mover(0);
			this.actualizar();
		}
		else
			if (key == KeyEvent.VK_DOWN)
			{
				j.mover(1);
				this.actualizar();
			}
			else
				if (key == KeyEvent.VK_LEFT)
				{
					j.mover(2);
					this.actualizar();
				}
				else
					if (key == KeyEvent.VK_RIGHT)
					{
						j.mover(3);
						this.actualizar();
					}	
	}
	
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_SPACE)
		{
			j.moverBalaJugador();
			this.actualizar();
		}
		else
			if (key == KeyEvent.VK_UP)
			{
				j.mover(0);
				this.actualizar();
			}
			else
				if (key == KeyEvent.VK_DOWN)
				{
					j.mover(1);
					this.actualizar();
				}
				else
					if (key == KeyEvent.VK_LEFT)
					{
						j.mover(2);
						this.actualizar();
					}
					else
						if (key == KeyEvent.VK_RIGHT)
						{
							j.mover(3);
							this.actualizar();
						}		
	}
	
	public void eliminarKeyListener()
	{
		this.removeKeyListener(e);
	}	
	
	public JPanel getPanel1()
	{
		return panel;
	}
	
	public JPanel getPanel2()
	{
		return panel_1;
	}
	
	public JLabel getLabelMuertes()
	{
		return Muertes;
	}
	
	public JLabel getLabelVidas()
	{
		return Vidas;
	}
	
	public JLabel getLabelActuales()
	{
		return Actuales;
	}
	
	public JLabel getLabelPuntaje()
	{
		return Puntaje;
	}
	
	public void setLabelMuertes(String s)
	{
		Muertes.setText(s);
	}
	
	public void setLabelVidas(String s)
	{
		Vidas.setText(s);
	}
	
	public void setLabelActuales(String s)
	{
		Actuales.setText(s);
	}
	
	public void setLabelPuntaje(String s)
	{
		Puntaje.setText(s);
	}
}
