package edu.flj.quebracabeca.Alfanumericos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlfanumericosPanelBotoesActionListener implements ActionListener
{
  private AlfanumericosPanelBotoes alfaPBotoes;

  public AlfanumericosPanelBotoesActionListener(AlfanumericosPanelBotoes alfaPBotoes)
  {
    this.alfaPBotoes = alfaPBotoes;
  }

  public void actionPerformed(ActionEvent e)
  {
    alfaPBotoes.mudaPosicao(e.getActionCommand());
  }
}