package edu.flj.quebracabeca.Alfanumericos;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class AlfanumericosInterfaceGrafica extends JPanel
{
  private AlfanumericosPanelBotoes  alfaPBotoes;
  private AlfanumericosPanelSolucao alfaPSolucao;

  public AlfanumericosInterfaceGrafica()
  {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  }

  public void montarAlfanumericos(int layout)
  {
    alfaPBotoes  = new AlfanumericosPanelBotoes(layout);
    alfaPSolucao = new AlfanumericosPanelSolucao(layout);

    removeAll();

    add(alfaPBotoes);
    add(alfaPSolucao);
  }
}