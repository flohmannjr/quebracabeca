package edu.flj.quebracabeca.Alfanumericos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;

public class AlfanumericosPalavras
{
  private AlfanumericosPanelBotoesActionListener aListener;

  public static final char[] TIPO0 = {'A', 'M', 'I', 'G', 'O', 'S',
                                      'B', 'R', 'A', 'S', 'I', 'L',
                                      'Q', 'U', 'E', 'R', 'E', 'R',
                                      'P', 'R', 'A', 'I', 'A', 'S',
                                      'A', 'V', 'I', 'O', 'E', 'S',
                                      'I', 'R', 'M', 'A', 'O'};

  public static final char[] TIPO1 = {'D', 'I', 'G', 'I', 'T', 'A', 'L',
                                      'P', 'O', 'R', 'S', 'C', 'H', 'E',
                                      'C', 'E', 'R', 'V', 'E', 'J', 'A',
                                      'R', 'E', 'G', 'U', 'L', 'A', 'R',
                                      'M', 'E', 'R', 'C', 'A', 'D', 'O',
                                      'F', 'A', 'M', 'I', 'L', 'I', 'A',
                                      'C', 'I', 'N', 'E', 'M', 'A'};

  public AlfanumericosPalavras(AlfanumericosPanelBotoesActionListener aListener)
  {
    this.aListener = aListener;
  }

  public JButton[] getPalavras(int tipo)
  {
    char[] t;
    JButton[] saida;

    if(tipo == 0)
    {
      t     = TIPO0;
      saida = new JButton[35];
    }
    else
    {
      t     = TIPO1;
      saida = new JButton[48];
    }

    for(int q = 0; q < t.length; q++)
    {
      saida[q] = new JButton(Character.toString(t[q]));
      saida[q].addActionListener(aListener);
      saida[q].setActionCommand(Character.toString(t[q]) + q);
      saida[q].setBackground(Color.WHITE);
      saida[q].setFocusPainted(false);
      saida[q].setFont(new Font("Courier New", Font.BOLD, 45));
      saida[q].setMargin(new Insets(0, 0, 0, 0));
      saida[q].setPreferredSize(new Dimension(50, 50));
    }

    return saida;
  }
}