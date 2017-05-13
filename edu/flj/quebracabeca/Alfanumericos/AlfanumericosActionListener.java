package edu.flj.quebracabeca.Alfanumericos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class AlfanumericosActionListener implements ActionListener
{
  private Alfanumericos alfa;

  public AlfanumericosActionListener(Alfanumericos alfa)
  {
    this.alfa = alfa;
  }

  public void actionPerformed(ActionEvent e)
  {
    char comando = e.getActionCommand().charAt(0);

    switch(comando)
    {
      case '0':
        alfa.mudarDificuldade(AlfanumericosLayout.INICIANTE_LETRAS);
        break;
      case '1':
        alfa.mudarDificuldade(AlfanumericosLayout.INICIANTE_NUMEROS);
        break;
      case '2':
        alfa.mudarDificuldade(AlfanumericosLayout.FACIL_LETRAS);
        break;
      case '3':
        alfa.mudarDificuldade(AlfanumericosLayout.FACIL_NUMEROS);
        break;
      case '4':
        alfa.mudarDificuldade(AlfanumericosLayout.MEDIO_LETRAS);
        break;
      case '5':
        alfa.mudarDificuldade(AlfanumericosLayout.MEDIO_NUMEROS);
        break;
      case '6':
        alfa.mudarDificuldade(AlfanumericosLayout.DIFICIL_LETRAS);
        break;
      case '7':
        alfa.mudarDificuldade(AlfanumericosLayout.DIFICIL_NUMEROS);
        break;
      case 's':
        if(JOptionPane.showConfirmDialog(alfa,
                                         "Deseja realmente sair do sistema?",
                                         "Sair",
                                         JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
          System.exit(0);
        }

        break;
      case 'm':
        alfa.mostrarManual(true);
        break;
      case 'b':
        alfa.mostrarSobre(true);
        break;
    }
  }
}