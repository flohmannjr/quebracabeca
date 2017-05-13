package edu.flj.quebracabeca.Alfanumericos;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class AlfanumericosDialogManual
{
  private Alfanumericos alfa;
  private JDialog       dialogo;

  public AlfanumericosDialogManual(Alfanumericos alfa)
  {
    this.alfa = alfa;

    montarDialogo();
  }

  private void montarDialogo()
  {
    dialogo = new JDialog(alfa, "Manual", true);
    dialogo.setLocation(40, 40);

    JTextArea txaManual = new JTextArea();

    txaManual.setColumns(60);
    txaManual.setEditable(false);
    txaManual.setFont(new Font("Courier New", Font.PLAIN, 14));
    txaManual.setRows(22);
    txaManual.setText("Manual Quebra-Cabeça Alfanuméricos" +
                      "\n" +
                      "\nObjetivo:" +
                      "\n" +
                      "\nPosicionar as letras de maneira semelhante à mostrada no" +
                      "\nquadro na parte inferior esquerda da janela." +
                      "\n" +
                      "\nPara Jogar:" +
                      "\n" +
                      "\nClique sobre uma letra para movimentá-la ao espaço vazio ao" +
                      "\nlado. Caso não haja um espaço vazio ao lado da letra esta" +
                      "\nnão será movimentada." +
                      "\n" +
                      "\nPara Selecionar o Nível de Dificuldade:" +
                      "\n" +
                      "\nSelecione a dificuldade a partir do menu 'Alfa->Dificuldade'" +
                      "\ne clique sobre o nível de dificuldade desejado." +
                      "\n" +
                      "\nPara Sair:" +
                      "\n" +
                      "\nSelecione o menu 'Alfa->Sair' para sair do sistema." +
                      "\n");

    JPanel pnlExterno = new JPanel(new GridLayout(1, 1));
    pnlExterno.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
    pnlExterno.add(txaManual);

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