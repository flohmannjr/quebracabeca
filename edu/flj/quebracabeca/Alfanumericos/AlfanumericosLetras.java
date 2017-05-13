package edu.flj.quebracabeca.Alfanumericos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;

public class AlfanumericosLetras
{
  private AlfanumericosPanelBotoesActionListener aListener;

  public AlfanumericosLetras(AlfanumericosPanelBotoesActionListener aListener)
  {
    this.aListener = aListener;
  }

  public JButton[] getLetras(int quantidade)
  {
    JButton[] saida = new JButton[quantidade];

    for(int q = 0; q < quantidade; q++)
    {
      saida[q] = new JButton(Character.toString((char)(q + 65)));
      saida[q].addActionListener(aListener);
      saida[q].setActionCommand(Character.toString((char)(q + 65)));
      saida[q].setBackground(Color.WHITE);
      saida[q].setFocusPainted(false);
      saida[q].setFont(new Font("Courier New", Font.BOLD, 45));
      saida[q].setMargin(new Insets(0, 0, 0, 0));
      saida[q].setPreferredSize(new Dimension(50, 50));
    }

    return saida;
  }
}