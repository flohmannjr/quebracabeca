package edu.flj.quebracabeca.Alfanumericos;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class AlfanumericosDialogSobre
{
  private Alfanumericos alfa;
  private JDialog       dialogo;

  public AlfanumericosDialogSobre(Alfanumericos alfa)
  {
    this.alfa = alfa;

    montarDialogo();
  }

  private void montarDialogo()
  {
    dialogo = new JDialog(alfa, "Sobre...", true);
    dialogo.setLocation(100, 100);

    JLabel lblAlfa   = new JLabel("Alfanuméricos");
    JLabel lblVersao = new JLabel("Versão 1.1");
    JLabel lblPor    = new JLabel("Desenvolvido por:");
    JLabel lblFLJ    = new JLabel("Frederico Lohmann Jr.");
    JLabel lblEmail  = new JLabel("flohmannjr@uol.com.br");

    JPanel pnlInterno = new JPanel(new GridLayout(0, 1));
    pnlInterno.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    pnlInterno.add(lblAlfa);
    pnlInterno.add(lblVersao);
    pnlInterno.add(new JLabel());
    pnlInterno.add(lblPor);
    pnlInterno.add(lblFLJ);
    pnlInterno.add(new JLabel());
    pnlInterno.add(lblEmail);

    JPanel pnlExterno = new JPanel(new GridLayout(1, 1));
    pnlExterno.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
    pnlExterno.add(pnlInterno);

    Container cp = dialogo.getContentPane();
    cp.setLayout(new GridLayout(1, 1));

    cp.add(pnlExterno);

    dialogo.pack();
    dialogo.setVisible(false);
    dialogo.setResizable(false);
  }

  public void mostrarDialogo(boolean mostrar)
  {
    dialogo.setVisible(mostrar);
  }
}