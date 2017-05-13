package edu.flj.quebracabeca.Alfanumericos;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class Alfanumericos extends JFrame
{
  private AlfanumericosDialogManual     manual;
  private AlfanumericosDialogSobre      sobre;
  private AlfanumericosInterfaceGrafica iG;
  private AlfanumericosWindowListener   wListener;
  private AlfanumericosActionListener   aListener;

  private Container contentPane;
  private JMenuBar  mnbBarra;

  public static void main(String[] args)
  {
    Alfanumericos alfanumericos = new Alfanumericos();
  }

  public Alfanumericos()
  {
    super("Alfanuméricos");

    setIconImage((new ImageIcon("icone_alfa_16.gif")).getImage());
    setLocation(20, 20);

    manual = new AlfanumericosDialogManual(this);
    sobre  = new AlfanumericosDialogSobre(this);

    iG = new AlfanumericosInterfaceGrafica();
    iG.montarAlfanumericos(AlfanumericosLayout.INICIANTE_LETRAS);

    contentPane = getContentPane();
    contentPane.setLayout(new GridLayout(1, 1));
    contentPane.add(iG);

    wListener = new AlfanumericosWindowListener();

    addWindowListener(wListener);

    criarMenu();

    pack();

    setResizable(false);
    setVisible(true);
  }

  private void criarMenu()
  {
    JMenu     mnuAlfa,
              mnuDificuldade,
              mnuAjuda;

    JRadioButtonMenuItem mnrIniLetras,
                         mnrIniNumeros,
                         mnrFacLetras,
                         mnrFacNumeros,
                         mnrMedLetras,
                         mnrMedNumeros,
                         mnrDifLetras,
                         mnrDifNumeros;

    JMenuItem mniSair,
              mniManual,
              mniSobre;

    mnbBarra = new JMenuBar();

    mnuAlfa        = new JMenu("Alfa");
    mnuDificuldade = new JMenu("Dificuldade");
    mnuAjuda       = new JMenu("Ajuda");

    mnrIniLetras  = new JRadioButtonMenuItem("Iniciante - Letras");
    mnrIniNumeros = new JRadioButtonMenuItem("Iniciante - Números");
    mnrFacLetras  = new JRadioButtonMenuItem("Fácil - Letras");
    mnrFacNumeros = new JRadioButtonMenuItem("Fácil - Números");
    mnrMedLetras  = new JRadioButtonMenuItem("Médio - Letras");
    mnrMedNumeros = new JRadioButtonMenuItem("Médio - Números");
    mnrDifLetras  = new JRadioButtonMenuItem("Difícil - Letras");
    mnrDifNumeros = new JRadioButtonMenuItem("Difícil - Números");

    mniSair   = new JMenuItem("Sair");
    mniManual = new JMenuItem("Manual");
    mniSobre  = new JMenuItem("Sobre");

    mnrIniLetras.setActionCommand("0");
    mnrIniNumeros.setActionCommand("1");
    mnrFacLetras.setActionCommand("2");
    mnrFacNumeros.setActionCommand("3");
    mnrMedLetras.setActionCommand("4");
    mnrMedNumeros.setActionCommand("5");
    mnrDifLetras.setActionCommand("6");
    mnrDifNumeros.setActionCommand("7");
    mniSair.setActionCommand("s");
    mniManual.setActionCommand("m");
    mniSobre.setActionCommand("b");

    aListener = new AlfanumericosActionListener(this);

    mnrIniLetras.addActionListener(aListener);
    mnrIniNumeros.addActionListener(aListener);
    mnrFacLetras.addActionListener(aListener);
    mnrFacNumeros.addActionListener(aListener);
    mnrMedLetras.addActionListener(aListener);
    mnrMedNumeros.addActionListener(aListener);
    mnrDifLetras.addActionListener(aListener);
    mnrDifNumeros.addActionListener(aListener);
    mniSair.addActionListener(aListener);
    mniManual.addActionListener(aListener);
    mniSobre.addActionListener(aListener);

    mnrIniLetras.setSelected(true);

    ButtonGroup grupo = new ButtonGroup();

    grupo.add(mnrIniLetras);
    grupo.add(mnrIniNumeros);
    grupo.add(mnrFacLetras);
    grupo.add(mnrFacNumeros);
    grupo.add(mnrMedLetras);
    grupo.add(mnrMedNumeros);
    grupo.add(mnrDifLetras);
    grupo.add(mnrDifNumeros);

    mnuDificuldade.add(mnrIniLetras);
    mnuDificuldade.add(mnrIniNumeros);
    mnuDificuldade.add(mnrFacLetras);
    mnuDificuldade.add(mnrFacNumeros);
    mnuDificuldade.add(mnrMedLetras);
    mnuDificuldade.add(mnrMedNumeros);
    mnuDificuldade.add(mnrDifLetras);
    mnuDificuldade.add(mnrDifNumeros);

    mnuAlfa.add(mnuDificuldade);
    mnuAlfa.addSeparator();
    mnuAlfa.add(mniSair);

    mnuAjuda.add(mniManual);
    mnuAjuda.addSeparator();
    mnuAjuda.add(mniSobre);

    mnbBarra.add(mnuAlfa);
    mnbBarra.add(mnuAjuda);

    setJMenuBar(mnbBarra);
  }

  public void mudarDificuldade(int nivel)
  {
    setVisible(false);
    setResizable(true);

    iG.montarAlfanumericos(nivel);

    contentPane.removeAll();
    contentPane.add(iG);

    setJMenuBar(mnbBarra);

    pack();

    setResizable(false);
    setVisible(true);
  }

  public void mostrarManual(boolean mostrar)
  {
    manual.mostrarDialogo(mostrar);
  }

  public void mostrarSobre(boolean mostrar)
  {
    sobre.mostrarDialogo(mostrar);
  }
}