package edu.flj.quebracabeca.Alfanumericos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;

public class AlfanumericosNumeros
{
  private AlfanumericosPanelBotoesActionListener aListener;

  public AlfanumericosNumeros(AlfanumericosPanelBotoesActionListener aListener)
  {
    this.aListener = aListener;
  }

  public JButton[] getNumeros(int quantidade)
  {
    JButton[] saida = new JButton[quantidade];

    for(int q = 0; q < quantidade; q++)
    {
      saida[q] = new JButton(Integer.toString(q + 1));
      saida[q].addActionListener(aListener);
      saida[q].setActionCommand(Integer.toString(q));
      saida[q].setBackground(Color.WHITE);
      saida[q].setFocusPainted(false);
      saida[q].setFont(new Font("Courier New", Font.BOLD, 35));
      saida[q].setMargin(new Insets(0, 0, 0, 0));
      saida[q].setPreferredSize(new Dimension(50, 50));
    }

    return saida;
  }
}