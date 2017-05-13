package edu.flj.quebracabeca.Alfanumericos;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class AlfanumericosPanelSolucao extends JPanel
{
  private char[] tipo0 = AlfanumericosPalavras.TIPO0;
  private char[] tipo1 = AlfanumericosPalavras.TIPO1;

  public AlfanumericosPanelSolucao(int layout)
  {
    switch(layout)
    {
      case 0:
        montaPainel(4, 4, 15, 0, 20);
        break;
      case 1:
        montaPainel(4, 4, 15, 1, 14);
        break;
      case 2:
        montaPainel(5, 5, 24, 0, 20);
        break;
      case 3:
        montaPainel(5, 5, 24, 1, 14);
        break;
      case 4:
        montaPainel(6, 6, 35, 2, 20);
        break;
      case 5:
        montaPainel(6, 6, 35, 1, 14);
        break;
      case 6:
        montaPainel(7, 7, 48, 3, 20);
        break;
      case 7:
        montaPainel(7, 7, 48, 1, 14);
        break;
    }
  }

  private void montaPainel(int altura, int largura, int quantidade, int tipo, int tamanho)
  {
    removeAll();

    JPanel solucao = new JPanel(new GridLayout(altura, largura));

    solucao.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));

    for(int l = 0; l < quantidade; l++)
    {
      String s;

      switch(tipo)
      {
        case 0:
          s = Character.toString((char)(l + 65));
          break;
        case 2:
          s = Character.toString(tipo0[l]);
          break;
        case 3:
          s = Character.toString(tipo1[l]);
          break;
        default:
          s = Integer.toString(l + 1);
          break;
      }

      JLabel label = new JLabel(s, SwingConstants.CENTER);

      label.setFont(new Font("Courier New", Font.BOLD, tamanho));
      label.setPreferredSize(new Dimension(20, 20));

      solucao.add(label);
    }

    setLayout(new FlowLayout(FlowLayout.LEFT));

    add(solucao);
  }
}